// Write a Java program that reads a text file named "input.txt" and reverses the order of characters in each line. 
// Write the modified text to another file named "reversed.txt". 
// Ensure that your program handles file IO exceptions and empty lines gracefully.

package com.aaslin.java.assignments.assignment_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReversedFile {

    public static void main(String[] args) {

        File inputFile = new File("input.txt");
        File outputFile = new File("reversed.txt");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                // If the line is empty, just write an empty line to output
                if (line.trim().isEmpty()) {
                    writer.newLine(); // Write a blank line
                    continue; // Skip rest of the loop
                }

                // Reverse the characters in the line
                String reversedLine = new StringBuilder(line).reverse().toString();

                // Write the reversed line to the output file
                writer.write(reversedLine);
                writer.newLine(); // Move to the next line
            }

            System.out.println("Reversed lines written to 'reversed.txt' successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while processing the files: " + e.getMessage());
        }
    }
}
