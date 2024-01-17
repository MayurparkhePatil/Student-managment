package com.students.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@javax.persistence.Entity
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int StudentId;
	private String StudentName;
	private String StudentDepartment;
	private String StudentBloodGroup;
	
}
