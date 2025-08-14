package com.aaslin.DispatcherServletFlowTracing.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
 
public class Student {
	
	@NotNull(message="Student id cannot be null")
	private String studentId;
	
	@NotNull(message="Student name cannot be null")
	private String studentName;
	
	@NotNull(message="Student email cannot be null")
	@Email(message="email format is invalid")
	private String email;
	
	@NotNull(message="Student age cannot be null")
	@Min(value = 6, message = "Age must be a positive number and minimum 6")
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
