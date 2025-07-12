import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureFinder {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean keepSearching = true;

        while (keepSearching) {
            List<Treasure> treasures = new ArrayList<>();

            try {
                File file = new File("treasures.txt");
                Scanner fileReader = new Scanner(file);

                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    String[] parts = line.split(" ");

                    // TODO: Convert parts[0] and parts[1] to integers
                    // TODO: Create a Treasure object and add it to the list

                }

                fileReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("Map file not found.");
                return;
            }

            System.out.print("Enter your current X coordinate: ");
            int currentX = input.nextInt();

            System.out.print("Enter your current Y coordinate: ");
            int currentY = input.nextInt();

            // TODO: Calculate distance from current location for each treasure

            // TODO: Sort the treasures based on distance

            System.out.println("\nTreasure distances (nearest to farthest):");

            // TODO: Print each treasure's coordinates and distance

            System.out.print("\nDo you want to search again? (yes/no): ");
            String answer = input.next();

            if (!answer.equalsIgnoreCase("yes")) {
                keepSearching = false;
                System.out.println("Happy hunting! Goodbye.");
            }
        }

        input.close();
    }
}

// TODO: Create a Treasure class with x, y, and distance variables
//       Include methods to calculate distance and compare treasures
