package org.itis.portal.repository;

import org.itis.portal.entity.AcademicGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by thefp on 23.04.2017.
 */
@Repository
public interface AcademicGroupRepository extends JpaRepository<AcademicGroup, Long> {
}
