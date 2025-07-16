// Generate a summary for each student using MessageFormat, like:
// "Student {0} from {1} department has secured a GPA of {2}."

package com.aaslin.java.assignments.assignment_8_2;
import java.util.Scanner;
import java.text.MessageFormat;

public class StudentSummary {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] names = new String[5];
        String[] departments = new String[5];
        int[] ages = new int[5];
        double[] gpas = new double[5];
		
		for (int iterator = 0; iterator < 5; iterator++) {
            System.out.println("Enter student " + (iterator + 1) + " details: ");

            System.out.print("Enter name: ");
            names[iterator] = scanner.nextLine();

            System.out.print("Enter department: ");
            departments[iterator] = scanner.nextLine();

            System.out.print("Enter age: ");
            ages[iterator] = scanner.nextInt();

            System.out.print("Enter GPA: ");
            gpas[iterator] = scanner.nextDouble();
            scanner.nextLine();
        }

		for (int index = 0; index < 5; index++) {  
			String format = MessageFormat.format("Student {0} from {1} department has secured a GPA of {2}.", names[index], departments[index], gpas[index]);
			System.out.println(format);
            }
		scanner.close();
	}

}
