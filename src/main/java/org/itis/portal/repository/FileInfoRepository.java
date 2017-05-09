package org.itis.portal.repository;

import org.itis.portal.entity.FileInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ainur on 15.04.2017.
 */
@Repository
public interface FileInfoRepository extends CrudRepository<FileInfo, Long>{
}
