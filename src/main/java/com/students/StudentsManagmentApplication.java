package com.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.students.controller.StudentController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

public class StudentsManagmentApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(StudentsManagmentApplication.class, args);
		
	}
}
