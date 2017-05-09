package org.itis.portal.controller;

import org.itis.portal.entity.Student;
import org.itis.portal.repository.StudentRepository;
import org.itis.portal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ainur on 04.04.2017.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    @ResponseBody
    public List<Student> students() {
        return studentRepository.findAll();
    }

    @GetMapping("/updateAverageScore")
    @ResponseBody
    public void updateAverageScore(@RequestParam Integer id, @RequestParam Double averageScore) {
        studentRepository.updateAverageScore(id, averageScore);
    }
}
