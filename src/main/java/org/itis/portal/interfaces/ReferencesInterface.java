package org.itis.portal.interfaces;

public interface ReferencesInterface {
    void booking(int studentID); //запрос на получение справки
    void sendNotification(int studentID); //уведомление о готовности
}