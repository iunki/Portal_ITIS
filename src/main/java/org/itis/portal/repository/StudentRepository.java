package org.itis.portal.repository;

import org.itis.portal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ainur on 04.04.2017.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("update Student s set s.averageScore=:averageScore where s.id=:id")
    void updateAverageScore(@Param("id") Integer id,@Param("averageScore") Double averageScore);

}
