package com.aaslin.java.assignments.assignment_8_2;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PrintWriterDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String name = null;
		String department = null;
		int age = 0;
		double gpa = 0;
		
		System.out.println("Enter student details: ");
		
		for(int iterator=0;iterator<1;iterator++) {
			System.out.println("Enter student"+(iterator+1)+" details: ");
			System.out.println("Enter name: ");
			name = scanner.nextLine();			
			System.out.println("Enter department: ");
			department = scanner.nextLine();
			System.out.println("Enter age: ");
			age = scanner.nextInt();
			System.out.println("Enter gpa: ");
			gpa = scanner.nextDouble();
		}
		
		File file = new File("students.txt");
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(file));
			printWriter.printf("Student[name=%s, age= %d, department= %s, gpa=%fd]",name,age,department,gpa);
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
	}

}
