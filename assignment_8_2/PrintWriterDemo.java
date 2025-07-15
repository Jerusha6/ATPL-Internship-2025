// package com.aaslin.java.assignments.assignment_8_2;
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

		File file = new File("students.txt");
		
		String name = null;
		String department = null;
		int age = 0;
		double gpa = 0;
		
		System.out.println("Enter student details: ");
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(file));
			int count=0;	
			for(int iterator=0;iterator<2;iterator++) {
				System.out.println("Enter student "+(iterator+1)+" details: ");
				System.out.println("Enter name: ");
				name = scanner.nextLine();			
				System.out.println("Enter department: ");
				department = scanner.nextLine();
				System.out.println("Enter age: ");
				age = scanner.nextInt();
				System.out.println("Enter gpa: ");
				gpa = scanner.nextDouble();
				scanner.nextLine();
				// printing to file students.txt
				printWriter.printf("Student %d [name=%s, age= %d, department= %s, gpa=%.2f]%n",++count, name,age,department,gpa);
			}			
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
	}

}
