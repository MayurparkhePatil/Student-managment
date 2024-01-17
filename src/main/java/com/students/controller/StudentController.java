package com.students.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.entity.Student;
import com.students.service.StudentService;

// perform crud operation

@RestController
public class StudentController {
	@Autowired
	private StudentService studService;

	//Save student
	@PostMapping("/savestudent")
	public ResponseEntity<Boolean> saveStudent(@RequestBody Student std) {
		boolean isAdded = studService.saveStudent(std);
		if (std!=null) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.NOT_MODIFIED);
		}
	}

	//get all student 
	@GetMapping("/getallstudent")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> list = studService.getAllStudent();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Student>>(list, HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<List<Student>>(list, HttpStatus.NOT_FOUND);
		}
	}
	
   //	get student by id
	@GetMapping("/getstudentby/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student std=studService.getStudent(id);
		if (std!=null) {
			return new ResponseEntity<Student>(std, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Student>(std, HttpStatus.NOT_FOUND);
		}
	}
	
	// delete student by id
	@DeleteMapping("/deletestudentby/{id}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable int id){
		boolean isDeleted = studService.deleteStudent(id);
		if (isDeleted) {
			return  new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}else {
			return  new ResponseEntity<Boolean>(isDeleted, HttpStatus.NOT_FOUND);
		}
		
		
	}
}
