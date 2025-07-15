package com.aaslin.java.assignments.assignment_8_2;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentSummary {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		File file = new File("students.txt");
		
		String name = null;
		String department = null;
		int age = 0;
		double gpa = 0;
		
		System.out.println("Enter student details: ");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			}			
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
	}

}
