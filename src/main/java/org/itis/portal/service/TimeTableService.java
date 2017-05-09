package org.itis.portal.service;

import org.itis.portal.entity.Schedule;
import org.itis.portal.entity.Subject;
import org.itis.portal.entity.Teacher;
import org.itis.portal.repository.SubjectRepository;
import org.itis.portal.repository.TeacherRepository;
import org.itis.portal.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thefp on 22.04.2017.
 */
@Service
public class TimeTableService {

    @Autowired
    private TimeTableRepository timeTableRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public void updateTimeTable(List<Schedule> scheduleList){
        teacherRepository.deleteAll();
        subjectRepository.deleteAll();
        timeTableRepository.deleteAll();
        timeTableRepository.flush();
        for(Schedule schedule : scheduleList) {
            List<Subject> subjects = schedule.getSubjects();
            Schedule scheduleWithId=timeTableRepository.save(schedule);
            timeTableRepository.flush();
            for(Subject subject : subjects){
                subject.setSchedule(scheduleWithId);
                subjectRepository.save(subject);
                subjectRepository.flush();
            }
        }
    }

}
