package com.aaslin.SpringJDBC.model;

public class Student {
	private int Id;
	private String name;
	private String email;
	private String department;
	
	public Student() {}
	
	public Student(int id, String name, String email, String department) {
		Id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}
	public int getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getDepartment() {
		return department;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
