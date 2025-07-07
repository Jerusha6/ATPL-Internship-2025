import java.util.Scanner;
import java.lang.ArithmeticException;
class ArithmeticExc {
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter the worth of property in INR: ");
int prop = sc.nextInt();
System.out.println("Enter how many members to share the property equally: ");
int mem = sc.nextInt();
try{
int share = prop/mem;
System.out.println("After dividing the proprtty equal share per person is: "+share);
}catch(ArithmeticException ae){
    System.out.println("Members cannot be zero add atleast 1");
}
sc.close();
}    
}
