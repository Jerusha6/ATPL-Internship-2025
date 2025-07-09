// Write a Java program to:
// ● Create a Vector of Double values.
// ● Add 4 decimal numbers.
// ● Iterate using an Enumeration.
// ● Print all values

import java.util.Vector;
import java.util.Scanner;
import java.util.Enumeration;
class VectorClass {
public static void main(String[] args){
    Vector<Double> vector = new Vector<>();
    
    try(Scanner sc = new Scanner(System.in)){
        System.out.println("Enter any 4 elements to add to vector: ");
        for(int iteration=0;iteration<4;iteration++){
            vector.addElement(sc.nextDouble());
        }
        System.out.println("Here are the 4 elements you add to vector: ");
        System.out.println("Vector: " + vector); 
        
        System.out.println("Iteration using Enumeration.");

        Enumeration<Double> enumeration = vector.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}
}
