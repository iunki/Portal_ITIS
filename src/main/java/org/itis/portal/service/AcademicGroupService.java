package org.itis.portal.service;

import org.itis.portal.entity.AcademicGroup;
import org.itis.portal.repository.AcademicGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by thefp on 23.04.2017.
 */
@Service
public class AcademicGroupService {
    @Autowired
    private AcademicGroupRepository academicGroupRepository;

    public HashMap<String,AcademicGroup> addAllGroupsToDb(){
        HashMap<String,AcademicGroup> groupHashMap = TimetableParseService.getAllGroups();
        HashMap<String, AcademicGroup> groups = new HashMap<>();
        List<AcademicGroup> academicGroups = null;
        Long count = academicGroupRepository.count();
        if(count==0){
            for(AcademicGroup academicGroup : groupHashMap.values()){
                academicGroupRepository.save(academicGroup);
            }
            academicGroups = academicGroupRepository.findAll();
            for(AcademicGroup academicGroup : academicGroups){
                groups.put(academicGroup.getGroupNumber(),academicGroup);
            }
            return groups;
        } else {
            academicGroups = academicGroupRepository.findAll();
            for(AcademicGroup academicGroup : academicGroups){
                groups.put(academicGroup.getGroupNumber(),academicGroup);
            }
            return groups;
        }
    }
    public List<AcademicGroup> findAll() {
        return (List<AcademicGroup>) academicGroupRepository.findAll();
    }
}
