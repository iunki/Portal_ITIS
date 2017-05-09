package org.itis.portal.repository;

import org.itis.portal.entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer> {
    List<Laboratory> findByCourseNumber(Integer courseNumber);

}
