//Use Map<String, Integer> to store student names and marks.
//● Add at least 5 students.
//● Find the student with the highest and lowest marks
package com.aaslin.java.assignments.assignment_6;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class StudentMarksRecord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> map= new HashMap<String, Integer>();
		map.put("jerusha", 77);
		map.put("Elisha", 67);
		map.put("Bharani", 97);
		map.put("Sachit", 87);
		map.put("Sai", 57);
		System.out.println("Here is the list of students along with their marks: "+map);
		int highestScore = Collections.max(map.values());
		System.out.println("Highest score: "+highestScore);
		int lowestScore = Collections.min(map.values());
		System.out.println("Lowest score: "+lowestScore);
		scanner.close();
	}

}
