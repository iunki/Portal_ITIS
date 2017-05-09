package org.itis.portal.repository;

import org.itis.portal.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ainur on 15.04.2017.
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findByCourseNumber(Integer courseNumber);
}
