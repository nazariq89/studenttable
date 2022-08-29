package com.zariqmattproject.studenttable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories

public class StudenttableApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudenttableApplication.class, args);
	}

}
