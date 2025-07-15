// package com.aaslin.java.assignments.assignment_8_2;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StringFormatterDemo {

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
			
			String writeLine=String.format("%s%14s%15s%9s%n","Name","Age","Department","GPA");
			printWriter.printf(writeLine);
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
				writeLine = String.format("%s%10d%10s%15.2f%n",name,age,department,gpa);
				printWriter.printf(writeLine);
			}			
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
	}

}
