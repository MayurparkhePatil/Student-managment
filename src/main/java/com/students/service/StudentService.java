package com.students.service;

import java.util.List;

import com.students.entity.Student;

public interface StudentService {

	List<Student> getAllStudent();

	boolean saveStudent(Student std);

	Student getStudent(int id);

	boolean deleteStudent(int id);

}
