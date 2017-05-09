package org.itis.portal.controller;

import org.itis.portal.entity.Course;
import org.itis.portal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mars on 08.05.2017.
 */
@RestController
public class CourseRestController {
    @Autowired
    CourseService courseService;
    @GetMapping("/coursesByCourse")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<Course> timeTableByGroup(@RequestParam String course) {

        return courseService.coursesByCourse(course);

    }
}
