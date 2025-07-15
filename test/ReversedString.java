//Section A 2Q

package com.aaslin.java.assignments.test;

import java.util.Scanner;

public class ReversedString {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string to reverse: ");
		String string = scanner.nextLine();
		String reversedString = "";
		for(int index= string.length()-1 ; index>=0 ; index--) {
			reversedString += string.charAt(index) + "";
		}
		
		System.out.print(reversedString);
	}

}
