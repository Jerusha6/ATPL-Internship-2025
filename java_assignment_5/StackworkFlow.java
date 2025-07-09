// Explain with an example how Stack follows LIFO (Last In First Out)
// principle.


import java.util.Stack;
import java.util.Scanner;
class StackWorkFlow {
public static void main(String[] args){
    Stack<String> stack = new Stack<>();
    
    try(Scanner scanner = new Scanner(System.in)){
        System.out.println("Stack follows LIFO(Last In First Out), means whatever we push first, that will be the last one to pop. Here is the example..");
        System.out.println("Enter any 5 names to push into stack: ");
<<<<<<< HEAD
        for(int iteration=0;iteration<5;iteration++){
            stack.push(scanner.nextLine());
=======
        for(int i=0;i<5;i++){
            stack.push(sc.nextLine());
>>>>>>> 7c6f44e7e3170a52712c70a9eaab6f34d11f6c69
        }
        System.out.println("Here are the five names that you pushed into stack: ");
        System.out.println("Stack: " + stack); 
        stack.pop();
        stack.pop();
        System.out.println("\nHere is the updated stack after applying pop operation to remove 2 names from the stack: ");
        System.out.println("Stack: " + stack);  
        System.out.println("\nHere last entered names popped");
    }
}
}
