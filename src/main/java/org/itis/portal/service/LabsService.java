package org.itis.portal.service;

import org.itis.portal.entity.Laboratory;
import org.itis.portal.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mars on 08.05.2017.
 */
@Service
public class LabsService {
    @Autowired
    LaboratoryRepository laboratoryRepository;
    public List<Laboratory> laboratoriesByCourse (String course) {return laboratoryRepository.findByCourseNumber(Integer.valueOf(course));}
}
