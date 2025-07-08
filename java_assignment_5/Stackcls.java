import java.util.Stack;
import java.util.Scanner;
class Stackcls {
public static void main(String[] args){
    Stack<Integer> st = new Stack<>();
    
    try(Scanner sc = new Scanner(System.in)){
        System.out.println("Enter any 5 elements to push into stack: ");
        for(int i=0;i<5;i++){
            st.push(sc.nextInt());
        }
        System.out.println("Here are the five elements you pushed into stack: ");
        System.out.println("Stack: " + st); 
        st.pop();
        st.pop();
        System.out.println("\nHere is the updated list after applying pop operation to remove 2 elements from the stack: ");
        System.out.println("Stack: " + st);  
    }
}
}
