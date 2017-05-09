package org.itis.portal.support.web;

import org.itis.portal.entity.AcademicGroup;
import org.itis.portal.service.AcademicGroupService;
import org.itis.portal.service.TimeTableService;
import org.itis.portal.service.TimetableParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by thefp on 22.04.2017.
 */
public class TimeTableTask {

    @Autowired
    TimeTableService timeTableService;

    @Autowired
    AcademicGroupService academicGroupService;

    @Scheduled(fixedRate = 3600000)
    private void updateTable(){
        timeTableService.updateTimeTable(TimetableParseService.getAllTimeTable(academicGroupService.addAllGroupsToDb()));
    }

}
