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
		
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter student " + (i + 1) + " details: ");

            System.out.print("Enter name: ");
            names[i] = scanner.nextLine();
            nameColWidth = Math.max(nameColWidth, names[i].length() + 2);

            System.out.print("Enter department: ");
            departments[i] = scanner.nextLine();
            deptColWidth = Math.max(deptColWidth, departments[i].length() + 2);

            System.out.print("Enter age: ");
            ages[i] = scanner.nextInt();

            System.out.print("Enter GPA: ");
            gpas[i] = scanner.nextDouble();
            scanner.nextLine();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {

            // Write header with dynamic column widths
            String header = String.format("%-" + nameColWidth + "s%-10s%-" + deptColWidth + "s%-10s%n","Name", "Age", "Department", "GPA");
            writer.print(header);

            // Write student data
            for (int i = 0; i < 5; i++) {
                String line = String.format("%-" + nameColWidth + "s%-10d%-" + deptColWidth + "s%-10.2f%n", names[i], ages[i], departments[i], gpas[i]);
                writer.print(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}