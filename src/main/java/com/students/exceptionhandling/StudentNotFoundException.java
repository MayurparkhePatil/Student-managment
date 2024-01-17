package com.students.exceptionhandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentNotFoundException extends Exception{
	
	public StudentNotFoundException(String msg) {
		super(msg);
	}
	public StudentNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	

}
