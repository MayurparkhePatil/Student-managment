package com.students.dao;

import java.util.List;

import com.students.entity.Student;

public interface StudentDao {

	List<Student> getAllStudent();

	boolean saveStudent(Student std);

	Student getStudent(int id);

	boolean deleteStudent(int id);

}
