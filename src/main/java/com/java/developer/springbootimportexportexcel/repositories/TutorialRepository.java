package com.java.developer.springbootimportexportexcel.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.developer.springbootimportexportexcel.io.entities.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, UUID> {
    
}
