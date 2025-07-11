//Palindrome Checker Using Deque
//Use Deque<Character> to check if a word is a palindrome

package com.aaslin.java.assignments.assignment_6;
import java.util.Deque;
import java.util.Scanner;
import java.util.ArrayDeque;
public class PalindromeChecker {
	public static boolean checkPalindrome(String word) {
		Deque<Character> deque = new ArrayDeque<>();
		char[] charArray = word.toCharArray();
		for(int iterator = 0; iterator<charArray.length; iterator++){
			deque.offer(charArray[iterator]);
		}
		boolean result=true;
		for(int iterator = 0; iterator<deque.size(); iterator++){

			// checking from first to middle and last to middle

			if(!(deque.peekFirst().equals(deque.peekLast()))){
				result=false;
				break;
			}

			// if the both values are same(first and last) then remove them from queue

			else {
				deque.pollFirst();
				deque.pollLast();
			}
		}
		return result;
	}
	public static void main(String[] args) {	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter a word to check for palindrome");
	String word = scanner.nextLine();
	boolean result = checkPalindrome(word);
	if(result) {
		System.out.println(word+ " is palindrome");
	}
	else {
		System.out.println(word+ " is not palindrome");
	}
}
}
