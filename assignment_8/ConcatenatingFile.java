// Create a Java program that concatenates the contents of two text files, "file1.txt" and "file2.txt", 
// into a new file named "concatenated.txt". 
// Make sure to handle file not found exceptions and any other relevant IO exceptions.

// package com.aaslin.java.assignments.assignment_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConcatenatingFile{
    public static void main(String[] args) {
        File file1 = new File("input.txt");
        File file2 = new File("word_frequencies.txt");
        File combinedFile = new File("concatenated.txt");

        try (
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(combinedFile))
        ) {
            String line;

            // Read and write file1
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // Read and write file2
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files concatenated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 