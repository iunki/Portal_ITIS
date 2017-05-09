package org.itis.portal.repository;

import org.itis.portal.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by thefp on 22.04.2017.
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
