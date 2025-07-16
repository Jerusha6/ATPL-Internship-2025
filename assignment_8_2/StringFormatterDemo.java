package com.aaslin.java.assignments.assignment_8_2;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StringFormatterDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File file = new File("students.txt");

        String[] names = new String[5];
        String[] departments = new String[5];
        int[] ages = new int[5];
        double[] gpas = new double[5];

        int nameColWidth = 20;
        int deptColWidth = 20;
		
        for (int iterator = 0; iterator < 5; i++) {
            System.out.println("Enter student " + (iterator + 1) + " details: ");

            System.out.print("Enter name: ");
            names[iterator] = scanner.nextLine();
            nameColWidth = Math.max(nameColWidth, names[iterator].length() + 2);

            System.out.print("Enter department: ");
            departments[iterator] = scanner.nextLine();
            deptColWidth = Math.max(deptColWidth, departments[iterator].length() + 2);

            System.out.print("Enter age: ");
            ages[iterator] = scanner.nextInt();

            System.out.print("Enter GPA: ");
            gpas[iterator] = scanner.nextDouble();
            scanner.nextLine();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {

            // Write header with dynamic column widths
            String header = String.format("%-" + nameColWidth + "s%-10s%-" + deptColWidth + "s%-10s%n","Name", "Age", "Department", "GPA");
            writer.print(header);

            // Write student data
            for (int index = 0; index < 5; index++) {
                String line = String.format("%-" + nameColWidth + "s%-10d%-" + deptColWidth + "s%-10.2f%n", names[index], ages[index], departments[index], gpas[index]);
                writer.print(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}