package org.itis.portal.service;

import org.itis.portal.entity.FileInfo;
import org.itis.portal.repository.FileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ainur on 15.04.2017.
 */
@Service
public class FileInfoService {

    @Autowired
    FileInfoRepository fileInfoRepository;

    public void add(FileInfo fileInfo) {
        fileInfoRepository.save(fileInfo);
    }
}
