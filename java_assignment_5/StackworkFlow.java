import java.util.Stack;
import java.util.Scanner;
class StackworkFlow {
public static void main(String[] args){
    Stack<String> st = new Stack<>();
    
    try(Scanner sc = new Scanner(System.in)){
        System.out.println("Stack follows LIFO(Last In First Out), means whatever we push first, that will be the last one to pop. Here is the example..");
        System.out.println("Enter any 5 names to push into stack: ");
        for(int i=0;i<5;i++){
            st.push(sc.nextLine());
        }
        System.out.println("Here are the five names that you pushed into stack: ");
        System.out.println("Stack: " + st); 
        st.pop();
        st.pop();
        System.out.println("\nHere is the updated stack after applying pop operation to remove 2 names from the stack: ");
        System.out.println("Stack: " + st);  
        System.out.println("\nHere last entered names popped");
    }
}
}
