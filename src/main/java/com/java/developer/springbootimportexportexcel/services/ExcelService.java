package com.java.developer.springbootimportexportexcel.services;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.java.developer.springbootimportexportexcel.io.entities.Tutorial;

public interface ExcelService {

    void save(MultipartFile file);

    List<Tutorial> getAllTutorials();

    InputStream load();
    
}
