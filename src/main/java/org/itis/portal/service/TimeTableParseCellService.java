package org.itis.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thefp on 23.04.2017.
 */
public class TimeTableParseCellService {

    private static void deleteTabs(String info) {
        Pattern p = Pattern.compile("(\\t)+");
        Matcher m = p.matcher(info);

        if (m.find()) {
            String del = m.group();
            info = info.replace(del, "");
        }
    }


    private static boolean checkPE(String info, HashMap<String, String> results) {
        Pattern p = Pattern.compile("У[Нн][Ии][Кк][Сс]");
        Matcher m = p.matcher(info);
        if (m.find()) {
            results.put("Предмет", "Физическая культура");
            results.put("Аудитория", "УНИКС");
            Pattern tp = Pattern.compile("[0-9]{1,2}\\.[0-9]{2}-[0-9]{1,2}\\.[0-9]{2}");
            Matcher tm = tp.matcher(info);
            if (tm.find())
                results.put("Дополнительно", tm.group());
            return true;
        }
        return false;
    }


    private static void findAdditionalInfo(String info, HashMap<String, String> results) {
        Pattern p = Pattern.compile("(\\().+(\\))");
        Matcher m = p.matcher(info);
        if (m.find()) {
            String addInfo = m.group();
            info = info.replace(addInfo, "");
            addInfo = addInfo.substring(1, addInfo.length() - 1);
            results.put("Дополнительно", addInfo);
        }
    }

    private static void findMainInfo(String info, HashMap<String, String> results) {
        Pattern checkOnEmpty = Pattern.compile("[0-9a-zA-Zа-яА-Я]");
        Matcher resultCheck = checkOnEmpty.matcher(info);
        Pattern cp = Pattern.compile("[А-Я]");
        Matcher cm;
        int i = 1;
        boolean lessonIsFound = false;
        if(!resultCheck.find()) {
        } else if(info.toLowerCase().contains("проектный практикум")) {
            results.put("Предмет",info);
        } else {
            while (!lessonIsFound) {
                cm = cp.matcher(info.charAt(i) + "");
                if (cm.find()) {
                    results.put("Предмет", info.substring(0, i - 1));
                    info = info.substring(i);
                    lessonIsFound = true;
                }
                i++;
            }

            Pattern p = Pattern.compile("(в )?[0-9]{4}|в (ауд.)?108 к.2|333 на Межлаука|на Сибирском тр.34|в 112 ф.ф.|(ауд.|в )109 к.2");
            Matcher m = p.matcher(info);
            if (m.find()) {
                String classroom = m.group();
                results.put("Аудитория", classroom);
                info = info.replace(classroom, "");
            }
            results.put("Преподаватели", info);
        }
    }

    public static ArrayList<HashMap<String, String>> getResults(String value) {
        HashMap<String, String> results = new HashMap<>();
        ArrayList<HashMap<String, String>> resList = new ArrayList<>();

        Pattern engp = Pattern.compile("Иностранный язык \\(английский язык\\) (\\n)?");
        Pattern coup = Pattern.compile("Курс по выбору: ");
        Pattern ncoup = Pattern.compile(",[\\s]{4}");
        Matcher engm = engp.matcher(value);
        Matcher coum = coup.matcher(value);
        Matcher ncoum = ncoup.matcher(value);

        boolean isEng = engm.find();
        boolean isCourses = coum.find();
        boolean isNCourses = ncoum.find();

        if (isEng) {
            String del = engm.group();
            value = value.replace(del, "");
            Pattern p = Pattern.compile("\\(.*,.*\\)");
            Matcher m = p.matcher(value);
            while(m.find()){
                String temp = m.group().replace(",", ";");
                value = value.replace(m.group(), temp);
            }
            String[] strArr = value.split(",");
            for (String item : strArr) {
                item = "английский язык " + item;
                resList.add(parse(item));
            }
        } else if (isCourses) {
            String del = coum.group();
            value = value.replace(del, "");
            Pattern tp = Pattern.compile(",( )?([А-я]+ ([А-я]\\.){1,2})");
            Matcher tm = tp.matcher(value);
            while (tm.find()) {
                String rep = tm.group();
                rep = rep.replace(",", " | ");
                value = value.replace(tm.group(), rep);
            }


            String[] strArr = value.split(",");
            for (String item : strArr) {
                if (item.contains("|")) {
                    int i = item.indexOf('|');
                    String temp = item.substring(i);
                    item = item.substring(0, i);
                    HashMap<String, String> tempMap = parse(item);
                    temp = temp.replace("|", tempMap.get("Предмет"));
                    resList.add(tempMap);
                    resList.add(parse(temp));
                } else {
                    resList.add(parse(item));
                }
            }
        } else if (isNCourses) {
            String spl = ncoum.group();
            String[] strArr = value.split(spl);
            for (String item : strArr) {
                results = parse(item);
                resList.add(results);
            }
        } else {
            results = parse(value);
            resList.add(results);
        }
        return resList;
    }

    private static HashMap<String, String> parse(String value) {
        HashMap<String, String> results = new HashMap<>();
        deleteTabs(value);
        if (checkPE(value, results)) {
            return results;
        } else {
            findAdditionalInfo(value, results);
            findMainInfo(value, results);
            return results;
        }
    }
}
