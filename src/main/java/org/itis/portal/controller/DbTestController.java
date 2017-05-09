package org.itis.portal.controller;

import org.itis.portal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mars on 08.05.2017.
 */
@Controller
class DbTestController {
    @Autowired
    private CourseService courseService;


    @RequestMapping("/DbTestCreate")
    public String index() {
        courseService.addTestData();
        return "index";
    }
}
