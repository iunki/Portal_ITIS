package org.itis.portal.controller;

import org.itis.portal.entity.Course;
import org.itis.portal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ainur on 15.04.2017.
 */
@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String courses(ModelMap map) {
        map.put("courses", courseService.findAll());
        return "course/courses";
    }




}
