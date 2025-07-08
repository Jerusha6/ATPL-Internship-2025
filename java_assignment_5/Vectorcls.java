import java.util.Vector;
import java.util.Scanner;
class Vectorcls {
public static void main(String[] args){
    Vector<Double> v = new Vector<>();
    
    try(Scanner sc = new Scanner(System.in)){
        System.out.println("Enter any 4 elements to add to vector: ");
        for(int i=0;i<4;i++){
            v.addElement(sc.nextDouble());
        }
        System.out.println("Here are the 4 elements you add to vector: ");
        System.out.println("Vector: " + v); 
        
        System.out.println("\nHere is the updated list after applying pop operation to remove 2 elements from the stack: ");
        System.out.println("Vector: " + v);  
    }
}
}
