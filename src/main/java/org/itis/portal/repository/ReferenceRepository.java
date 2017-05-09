package org.itis.portal.repository;

import org.itis.portal.entity.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by thefp on 02.05.2017.
 */
@Repository
public interface ReferenceRepository extends JpaRepository<Reference,Long> {

    @Query("select ref from Reference ref where ref.issued=false")
    List<Reference> findAllWithOutIssued();

    @Query("update Reference set issued=true where id=:id")
    void updateStatus(@Param("id") Integer id);

}
