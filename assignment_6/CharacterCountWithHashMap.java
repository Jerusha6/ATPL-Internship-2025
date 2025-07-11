// Character Count
// Given a string, count the occurrences of each character using a
// HashMap<Character, Integer>.
package com.aaslin.java.assignments.assignment_6;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class CharacterCountWithHashMap {
    
    public static void countOccurances(String string) {
        
        char[] charArray = string.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int iterator = 0; iterator < charArray.length; iterator++) {
            map.put(charArray[iterator], map.getOrDefault(charArray[iterator],0) + 1);
        }
            
        System.out.println("Key->Value");
            
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }

    public static void main(String args[]) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = scanner.nextLine();
        countOccurances(string);
        scanner.close();
        
    }
}