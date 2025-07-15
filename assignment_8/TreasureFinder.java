package com.aaslin.java.assignments.assignment_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TreasureFinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean keepSearching = true; 

        while (keepSearching) {
            List<Treasure> treasures = new ArrayList<>();

            try {
                File file = new File("treasures.txt");
                Scanner fileReader = new Scanner(file);

                // Read each line from the file
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();      
                    String[] parts = line.split(" ");        

                    int x = Integer.parseInt(parts[0]);     
                    int y = Integer.parseInt(parts[1]);   

                    // Create a new Treasure object and add it to the list
                    treasures.add(new Treasure(x, y));
                }

                fileReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("Map file not found.");
                return;
            }

            System.out.print("Enter your current X coordinate: ");
            int currentX = scanner.nextInt();

            System.out.print("Enter your current Y coordinate: ");
            int currentY = scanner.nextInt();

            // Calculate distance from user's location to each treasure
            for (Treasure t : treasures) {
                t.calculateDistance(currentX, currentY);
            }

            // Sort the treasures by distance (nearest first)
            Collections.sort(treasures);

            // Print sorted treasure locations with their distances
            System.out.println("\nTreasure distances (nearest to farthest):");
            for (Treasure t : treasures) {
                System.out.println("Treasure at (" + t.x + ", " + t.y + ") - Distance: " + t.distance);
            }

            System.out.print("\nDo you want to search again? (yes/no): ");
            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("yes")) {
                keepSearching = false;
                System.out.println("Happy hunting! Goodbye.");
            }
        }

        scanner.close(); 
    }
}

// Class to represent a treasure's position and distance
class Treasure implements Comparable<Treasure> {
    int x, y;           
    double distance; 
    Treasure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Method to calculate distance from user's current location
    void calculateDistance(int currentX, int currentY) {
        int dx = x - currentX;           
        int dy = y - currentY;          
        distance = Math.sqrt(dx * dx + dy * dy);  // Distance formula
    }

    // Method to compare treasures by distance (used for sorting)
    public int compareTo(Treasure other) {
        return Double.compare(this.distance, other.distance);
    }
}