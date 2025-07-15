package com.aaslin.java.assignments.assignment_8_2;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class StudentData{
	private String name;
	private String department;
	private int age;
	private double gpa;
	public StudentData(String name, String department, int age, double gpa) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
		this.gpa = gpa;
	}
	
	public String toString() {
		return name+" "+department+" "+age+" "+gpa;
	}
}
public class PrintWriterDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		List<StudentData> students = new ArrayList<StudentData>();
		
		String name = null;
		String department = null;
		int age = 0;
		double gpa = 0;
		
		System.out.println("Enter student details: ");
		
		for(int iterator=0;iterator<5;iterator++) {
			System.out.println("Enter student "+(iterator+1)+" details: ");
			System.out.println("Enter name: ");
			name = scanner.nextLine();			
			System.out.println("Enter department: ");
			department = scanner.nextLine();
			System.out.println("Enter age: ");
			age = scanner.nextInt();
			System.out.println("Enter gpa: ");
			gpa = scanner.nextDouble();
			students.add( new StudentData(name,department,age,gpa));
		}
		
		File file = new File("students.txt");
        int count=0;
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(file));
			printWriter.printf("Student %d [name=%s, age= %d, department= %s, gpa=%.2f]",(++count),name,age,department,gpa);
            printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		for(StudentData student : students) {
			System.out.println(student);
		}
		scanner.close();
	}

}
