 package com.aaslin.java.assignments.assignment_8_2;

import java.io.Serializable;

public class Student implements Serializable{

    private int id;
    private String name;
    private int age;
    private String department; 
    private double gpa;
	public Student(int id, String name, int age, String department, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
		this.gpa = gpa;
	}
      
}
