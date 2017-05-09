package org.itis.portal.controller;

import org.itis.portal.service.AcademicGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yunki on 07.05.2017.
 */
@Controller
public class ScheduleController {

    @Autowired
    AcademicGroupService groupService;

    @RequestMapping(value = "/schedule/group", method = RequestMethod.GET)
    public String courses(ModelMap map) {
        map.put("groups", groupService.findAll());
        return "schedule/group";
    }
}
