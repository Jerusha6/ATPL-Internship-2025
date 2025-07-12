// Implement a simple encryption and decryption program in Java. 
// Prompt the user to enter a message, then encrypt the message using a simple substitution cipher, and write the encrypted message to a text file named "encrypted.txt". 
// Provide a decryption program that reads the encrypted message from "encrypted.txt", decrypts it, and prints the original message to the console. 
// Make sure to handle IO exceptions and invalid input gracefully.

package com.aaslin.java.assignments.assignment_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ToEncryption {

    // How much to shift each letter or digit
    private static final int SHIFT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to type a message
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        // Change the message to an encrypted form
        String encrypted = encrypt(message);

        // Save the encrypted message to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted.txt"))) {
            writer.write(encrypted);
            System.out.println("Encrypted message saved in 'encrypted.txt'");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read the encrypted message from the file
        String encryptedFromFile = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("encrypted.txt"))) {
            encryptedFromFile = reader.readLine(); 
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        // Changing the encrypted message back to original
        String decrypted = decrypt(encryptedFromFile);

        System.out.println("Decrypted message: " + decrypted);

        scanner.close();
    }

    // This method shifts letters and digits forward by SHIFT
    private static String encrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            // Only change letters and digits
            if (Character.isLetterOrDigit(ch)) {
                result.append((char)(ch + SHIFT));
            } else {
                // Leave spaces and symbols unchanged
                result.append(ch);
            }
        }

        return result.toString();
    }

    // This method shifts letters and digits backward by SHIFT
    private static String decrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append((char)(ch - SHIFT));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
