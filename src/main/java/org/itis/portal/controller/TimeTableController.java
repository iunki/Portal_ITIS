package org.itis.portal.controller;

import org.itis.portal.entity.Course;
import org.itis.portal.entity.Schedule;
import org.itis.portal.repository.TimeTableRepository;
import org.itis.portal.service.CourseService;
import org.itis.portal.service.TimetableParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by thefp on 19.04.2017.
 */
@RestController
public class TimeTableController {
    @Autowired
    private TimeTableRepository timeTableRepository;



    @GetMapping("/timetablebygroup")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<Schedule> timeTableByGroup(@RequestParam String date,@RequestParam String group, @RequestParam Boolean week) {
        if(week){
            return timeTableRepository.findAllByGroupOnWeek(group);
        } else {
            return timeTableRepository.findAllByGroupOnDay(group, TimetableParseService.convertDateToDay(date).getValue());
        }
    }

    @GetMapping(value = "/timetablebyroom")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<Schedule> timeTableByRoom(@RequestParam String room, @RequestParam String date,@RequestParam Boolean week) {
        if(week){
            return timeTableRepository.findAllByRoomOnWeek(room);
        } else {
            return timeTableRepository.findAllByRoomOnDay(room, TimetableParseService.convertDateToDay(date).getValue());
        }
    }

    @GetMapping(value = "/timetablebyteacher")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<Schedule> timeTableByTeacher(@RequestParam String teacher, @RequestParam String date,@RequestParam Boolean week) {
        if(week) {
            return timeTableRepository.findAllByTeacherOnWeek(teacher);
        } else {
            return timeTableRepository.findAllByTeacherOnDay(teacher,TimetableParseService.convertDateToDay(date).getValue());
        }
    }

    @GetMapping(value = "/timetablebytime")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<Schedule> timeTableByTime(@RequestParam String time, @RequestParam String date,@RequestParam Boolean week) {
        if(week) {
            return timeTableRepository.findAllByTimeOnWeek(time);
        } else {
            return timeTableRepository.findAllByTimeOnDay(time,TimetableParseService.convertDateToDay(date).getValue());
        }
    }


}
