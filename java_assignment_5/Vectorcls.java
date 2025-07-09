import java.util.Vector;
import java.util.Scanner;
import java.util.Enumeration;
class Vectorcls {
public static void main(String[] args){
    Vector<Double> vector = new Vector<>();
    
    try(Scanner sc = new Scanner(System.in)){
        System.out.println("Enter any 4 elements to add to vector: ");
        for(int i=0;i<4;i++){
            vector.addElement(sc.nextDouble());
        }
        System.out.println("Here are the 4 elements you add to vector: ");
        System.out.println("Vector: " + vector); 
        
        System.out.println("Iteration using Enumeration.");

        Enumeration<Double> en = vector.elements();
        while(en.hasMoreElements()){
            System.out.println(en.nextElement());
        }
    }
}
}
