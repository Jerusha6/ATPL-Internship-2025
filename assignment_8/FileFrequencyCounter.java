import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileFrequencyCounter {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");

            // Write to input.txt
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write("Aaslin Technologies is a product based company, which is located in Visakhapatnam."
                        + " Currently I'm working in Aaslin technologies as a junior software developer."
                        + " This is one of the best places on Visakhapatnam for one can learn a technology in deeper.");
            }

            // Read and count word frequencies
            Map<String, Integer> wordFreq = new HashMap<>();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    String word = scanner.next().toLowerCase().replaceAll("[^a-z']", ""); // remove punctuation
                    if (!word.isEmpty()) {
                        wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Converting map to list and sort entries by frequency (descending)
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordFreq.entrySet());

            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    return e2.getValue() - e1.getValue(); // descending
                }
            });

            // Writing to word_frequencies.txt
            file = new File("word_frequencies.txt");
            try (FileWriter fileWriter = new FileWriter(file)) {
                for (Map.Entry<String, Integer> entry : entryList) {
                    fileWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }

        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }
}
