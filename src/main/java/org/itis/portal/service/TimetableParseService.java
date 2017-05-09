package org.itis.portal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.itis.portal.entity.AcademicGroup;
import org.itis.portal.entity.Schedule;
import org.itis.portal.entity.Subject;
import org.itis.portal.entity.Teacher;
import org.itis.portal.entity.timetable.Cell;
import org.itis.portal.entity.timetable.DayEnum;
import org.itis.portal.entity.timetable.Merge;
import org.itis.portal.entity.timetable.Properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by thefp on 09.04.2017.
 */
public class TimetableParseService {
    /** Application name. */
    private static final String APPLICATION_NAME =
            "Parse ITIS Timetable";

    public static final String SPREADSHEET_ID="1DHir9K8KO8a2AX3AfPiE422HXgf_7AKgSOSS-UOMt_A";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
            JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static final List<String> SCOPES =
            Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public static Credential authorize() throws IOException {
        // Load client secrets.
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream in = classloader.getResourceAsStream("client_id.json");
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static List<Merge> getMergedCells(){
        Sheets service;
        ObjectMapper mapper = new ObjectMapper();
        String range = "A1:AL44";
        List<Merge> mergeList = new ArrayList<Merge>();
        List<List<Object>> values = null;
        try {
            service = getSheetsService();
            Sheets.Spreadsheets.Get request = service.spreadsheets().get(SPREADSHEET_ID);
            request.setRanges(new ArrayList<>());
            Spreadsheet response = request.execute();
            Properties properties = mapper.readValue(response.toString(),Properties.class);
            ArrayList<LinkedHashMap<String,Object>> sheets = (ArrayList<LinkedHashMap<String, Object>>) properties.getAdditionalProperties().get("sheets");
            LinkedHashMap<String,Object> value = sheets.get(0);
            ArrayList<Merge> value1=(ArrayList<Merge>) value.get("merges");
            for(Object value2 : value1)
            {
                Merge merge = mapper.readValue(mapper.writeValueAsString(value2),Merge.class);
                mergeList.add(merge);
            }
            return mergeList;
        }catch (IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

//    public static List<Schedule> getTimeTableByTime(Date date, String time){
//        List<Merge> mergeCells = getMergedCells();
//        List<Schedule> schedules = new ArrayList<>();
//        Cell[][] mergeMap = getMergeMap(mergeCells);
//        List<List<Object>> values = getTimeTable();
//        DayEnum dayEnum = convertDateToDay(date);
//        if (values == null || values.size() == 0) {
//            return null;
//        } else {
//            for(int i=dayEnum.getStartRow();i<dayEnum.getEndRow();i++){
//                String period = (String) values.get(i).get(dayEnum.getTimeColumn());
//                if(period.contains(time)){
//                    List<Object> row = values.get(i);
//                    for (int j=dayEnum.getTimeColumn()+1;j<row.size()-1;j++){
//                        Cell cell = mergeMap[i][j];
//                        if (cell != null) {
//                            schedules.add(createSchedule((String)row.get(cell.getColumn()),(String) row.get(dayEnum.getTimeColumn())));
//                        } else {
//                            schedules.add(createSchedule((String)row.get(j),(String) row.get(dayEnum.getTimeColumn())));
//                        }
//                    }
//                    return schedules;
//                }
//            }
//        }
//        return null;
//    }

    public static HashMap<String,AcademicGroup> getAllGroups(){
        List<List<Object>> values = getTimeTable();
        List<Object> row = values.get(1);
        HashMap<String,AcademicGroup> academicGroupList = new HashMap<>();
        for(int i=0;i<row.size();i++){
            String valueString = (String) row.get(i);
            if(!valueString.equals("")){
                AcademicGroup academicGroup = new AcademicGroup();
                academicGroup.setGroupNumber(valueString);
                academicGroupList.put(valueString,academicGroup);
            }
        }
        return academicGroupList;
    }

    public static List<Schedule> getAllTimeTable(HashMap<String,AcademicGroup> groups){
        List<Merge> mergeCells = getMergedCells();
        List<Schedule> schedules = new ArrayList<>();
        Cell[][] mergeMap = getMergeMap(mergeCells);
        List<List<Object>> values = getTimeTable();
        if (values == null || values.size() == 0) {
            return null;
        } else {
            List<Object> row = values.get(1);
            for(int i=0;i<row.size();i++){
                String valueString = (String) row.get(i);
                if(!valueString.equals("")) {
                    for (int j = DayEnum.Monday.getStartRow(); j < DayEnum.Saturday.getEndRow(); j++) {
                        Cell cell = mergeMap[j][i];
                        if (cell != null) {
                            schedules.add(createSchedule((String) values.get(cell.getRow()).get(cell.getColumn()),
                                    (String) values.get(j).get(DayEnum.Monday.getTimeColumn()),
                                    getEnumId(j),groups.get(valueString)));
                        } else {
                            schedules.add(createSchedule((String) values.get(j).get(i),
                                    (String) values.get(j).get(DayEnum.Monday.getTimeColumn()),
                                    getEnumId(j),groups.get(valueString)));
                        }
                    }
                }
            }
            return schedules;
        }
    }

    public static Schedule createSchedule(String subjectName, String timePeriod,int day, AcademicGroup academicGroup){
        List<HashMap<String, String>> bigResult = TimeTableParseCellService.getResults(subjectName);
        List<Subject> subjects = new ArrayList<>();
        Schedule schedule = new Schedule();
        schedule.setGroup(academicGroup);
        schedule.setDay(day);
        String[] parseTime = timePeriod.split("-");
        schedule.setStartDate(parseTime[0]);
        schedule.setEndDate(parseTime[1]);
        for(HashMap<String, String> results:bigResult) {
            Subject subject = new Subject();
            subject.setSubjectName(results.get("Предмет"));
            subject.setRoom(results.get("Аудитория"));
            subject.setTeacher(results.get("Преподаватели"));
            subject.setInfo(results.get("Дополнительно"));
            subjects.add(subject);
        }
        schedule.setSubjects(subjects);
        return schedule;
    }

    public static DayEnum convertDateToDay(String date){
        Date data = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            data = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case 1:
                return null;
            case 2:
                return DayEnum.Monday;
            case 3:
                return DayEnum.Tuesday;
            case 4:
                return DayEnum.Wednesday;
            case 5:
                return DayEnum.Thursday;
            case 6:
                return DayEnum.Friday;
            case 7:
                return DayEnum.Saturday;
            default:
                return null;
        }
    }

    public static Integer getEnumId(int day){
        if(day>=DayEnum.Monday.getStartRow()&&day<DayEnum.Monday.getEndRow()){
            return DayEnum.Monday.getValue();
        } else if(day>=DayEnum.Tuesday.getStartRow()&&day<DayEnum.Tuesday.getEndRow()){
            return DayEnum.Tuesday.getValue();
        } else if(day>=DayEnum.Thursday.getStartRow()&&day<DayEnum.Thursday.getEndRow()){
            return DayEnum.Thursday.getValue();
        } else if(day>=DayEnum.Wednesday.getStartRow()&&day<DayEnum.Wednesday.getEndRow()){
            return DayEnum.Wednesday.getValue();
        } else if(day>=DayEnum.Friday.getStartRow()&&day<DayEnum.Friday.getEndRow()){
            return DayEnum.Friday.getValue();
        } else {
            return DayEnum.Saturday.getValue();
        }
    }

    public static List<List<Object>> getTimeTable(){
        Sheets service;
        String range = "A1:AL44";
        List<List<Object>> values = null;
        try {
            service = getSheetsService();
            ValueRange response = service.spreadsheets().values()
                    .get(SPREADSHEET_ID, range)
                    .execute();
            values = response.getValues();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        if (values == null || values.size() == 0) {
            return null;
        } else {
            return values;
        }
    }
    //Row start from 1 and column start from 0 in merged cells query
    //Row start from 0 and column start from 0 in values from table
    //size 44*38
    public static Cell[][] getMergeMap(List<Merge> merges){
        Cell[][] mergeMap = new Cell[100][100];
        for(Merge merge : merges){
            for(int row=merge.getStartRowIndex();row<merge.getEndRowIndex();row++){
                for(int column=merge.getStartColumnIndex();column<merge.getEndColumnIndex();column++){
                    mergeMap[row][column]= new Cell(merge.getStartRowIndex(),merge.getStartColumnIndex());
                }
            }
        }
        return mergeMap;
    }
}
