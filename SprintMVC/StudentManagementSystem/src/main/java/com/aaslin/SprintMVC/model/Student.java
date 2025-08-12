package com.aaslin.SprintMVC.model;

import org.springframework.stereotype.Component;

@Component 
public class Student {
	
	private String studentId;
	private String studentName;
	private String email;
	private int age;
	
	public Student(String studentId, String studentName, String email, int age) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.age = age;
	}

	public Student() {}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStudentId() {
		return studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getAge() {
		return age;
	}
	
}
