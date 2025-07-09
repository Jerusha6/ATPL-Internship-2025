// Word Frequency Counter
// Input a paragraph and count the frequency of each word using Map<String,
// Integer>.

package com.aaslin.java.assignments.assignment6;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class WordFrequencyCount {
public static void countWordOccurances(String paragraph) {
String[] stringArray = paragraph.split(" ");
HashMap<String, Integer> map = new HashMap<>();
    for (int iterator = 0; iterator < stringArray.length; iterator++) {
        map.put(stringArray[iterator], map.getOrDefault(stringArray[iterator],0) + 1);
    }
    System.out.println("Key->Value");
    for(Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey()+"->"+entry.getValue());
    }
}

public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a paragraph: ");
    String paragraph = scanner.nextLine();
    countWordOccurances(paragraph);
    scanner.close();
}
}