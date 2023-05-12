package com.java.developer.springbootimportexportexcel;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.java.developer.springbootimportexportexcel.io.entities.Tutorial;
import com.java.developer.springbootimportexportexcel.repositories.TutorialRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootImportExcelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootImportExcelApplication.class, args);
	}

	@Autowired
	private TutorialRepository tutorialRepository;

	@Value("${spring.jpa.properties.hibernate.jdbc.batch-size}")
	private int batchSize;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {

		int totalObjects = 10 + batchSize;
		log.info("Inserting ..........");

		for (int i = 0; i < totalObjects; i++) {
			tutorialRepository.save(Tutorial.builder().title("Tutorial: " + UUID.randomUUID())
					.description(UUID.randomUUID().toString()).published(true).build());
		}

		log.info("Finished inserting " + totalObjects + " objects");
	}

}
