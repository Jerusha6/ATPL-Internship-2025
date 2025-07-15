//Section B 3Q

package com.aaslin.java.assignments.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
	private String name;
	private int age;
	private double marks;
	public Student(String name, int age, double marks) {
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
		
	}
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getMarks() {
		return marks;
	}
	
	public String toString() {
		return name+" "+age+" "+marks+" ";
	}
	
}

public class StudentGradeSystem {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		list.add(new Student("Jerusha", 21, 99));
		list.add(new Student("Elisha", 22, 88));
		list.add(new Student("Roja", 41, 98));
		list.add(new Student("Anand", 21, 99));
		
		Comparator<Student> chainComparator = Comparator 
				.comparing(Student :: getMarks).reversed()
				.thenComparing(Student :: getName) 
				.thenComparing(Student :: getAge);
		
		Collections.sort(list, chainComparator);
		
		for(Student student : list) {
			System.out.println(student);
		}

	}

}
