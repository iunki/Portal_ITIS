package org.itis.portal.controller;

import org.itis.portal.entity.Laboratory;
import org.itis.portal.service.LabsService;
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
public class LabsRestController {
    @Autowired
    LabsService labsService;
    @GetMapping("/laboratoriesByCourse")
    @ResponseStatus(value = HttpStatus.OK)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<Laboratory> timeTableByGroup(@RequestParam String course) {

        return labsService.laboratoriesByCourse(course);

    }
}
