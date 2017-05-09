package org.itis.portal.interfaces;

import java.util.List;

public interface RatingInterface {
    double getStudentRating(int studentID); //рейтинг студента
    List getOverallRating(); //общий рейтинг
}