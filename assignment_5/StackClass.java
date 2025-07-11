// Write a Java program to:
// ○ Create a Stack of Integers.
// ○ Push 5 numbers onto the stack.
// ○ Pop 2 elements.
// ○ Print the remaining elements.
package com.aaslin.java.assignments.assignment_5;
import java.util.Stack;
import java.util.Scanner;
class StackClass {
public static void main(String[] args){
    Stack<Integer> stack = new Stack<>();
    
    try(Scanner scanner = new Scanner(System.in)){
        System.out.println("Enter any 5 elements to push into stack: ");
        for(int iteration=0;iteration<5;iteration++){
            stack.push(scanner.nextInt());
        }
        System.out.println("Here are the five elements you pushed into stack: ");
        System.out.println("Stack: " + stack); 
        stack.pop();
        stack.pop();
        System.out.println("\nHere is the updated list after applying pop operation to remove 2 elements from the stack: ");
        System.out.println("Stack: " + stack);  
    }
}
}
