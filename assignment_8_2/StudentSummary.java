// Generate a summary for each student using MessageFormat, like:
// "Student {0} from {1} department has secured a GPA of {2}."

// package com.aaslin.java.assignments.assignment_8_2;
import java.util.Scanner;
import java.text.MessageFormat;

public class StudentSummary {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
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
				String format = "Student {0} from {1} department has secured a GPA of {2}.";
				String formatted = MessageFormat.format(format, name, department, gpa);
				System.out.println(formatted);
				scanner.nextLine();	
			}
		scanner.close();
	}

}
