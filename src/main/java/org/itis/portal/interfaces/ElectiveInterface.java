package org.itis.portal.interfaces;

import java.util.List;

public interface ElectiveInterface {
    List getAllElectives(); //список
    void enroll(int studentID, int electiveID); //запись
    Object getElectiveInfo(int electiveID); //посмотреть курс
    void createElective(String name); ///создать курс , TODO остальные параметры позже
    void editElective(int electiveID); //редактировать курс
    void deleteElective(int electiveID); //удалить курс
    List getStudentsInElective(int electiveID); //кто записался на курс (список)
}