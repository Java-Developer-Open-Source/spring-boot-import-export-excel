package com.java.developer.springbootimportexportexcel.services.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.developer.springbootimportexportexcel.helper.ExcelHelper;
import com.java.developer.springbootimportexportexcel.io.entities.Tutorial;
import com.java.developer.springbootimportexportexcel.repositories.TutorialRepository;
import com.java.developer.springbootimportexportexcel.services.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private TutorialRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = repository.findAll();

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }

    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }

}
