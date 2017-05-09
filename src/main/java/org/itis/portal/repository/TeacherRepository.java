package org.itis.portal.repository;

import org.itis.portal.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by thefp on 24.04.2017.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByFullNameContaining(String fullName);
}
