//Section A 1Q

package com.aaslin.java.assignments.test;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyCount {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a line to count character sequence: ");
		String line = scanner.nextLine();
		line = line.replace(" ", "");
		char[] characters = line.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(char character : characters) {
			map.put(character, map.getOrDefault(character, 0)+1);
		}
		for(Map.Entry<Character,Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" -> "+entry.getValue());
		}

	}

}
