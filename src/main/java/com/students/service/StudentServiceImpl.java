package com.students.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.students.dao.StudentDao;
import com.students.entity.Student;
import com.students.exceptionhandling.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao sd;

	public List<Student> getAllStudent() {
		List<Student>list = sd.getAllStudent();
		return list;
	}

	@Override
	public boolean saveStudent(Student std) {
		boolean isAdded = sd.saveStudent(std);
		return isAdded;
	}

	@Override
	public Student getStudent(int id) {
		Student std = sd.getStudent(id);
		return std;
	}

	@Override
	public boolean deleteStudent(int id) {
		boolean isDeleted=sd.deleteStudent(id);
		return isDeleted;
	}
}
