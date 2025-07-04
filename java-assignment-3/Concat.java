import java.util.Scanner;
public class Concat {
    public static void main(String[] args){
         //before execution
        long startingTime = System.nanoTime();
        System.out.println("Before execution:"+startingTime+" NanoSeconds");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first String:");
        String str1 = sc.nextLine();
        System.out.println("Enter second String:");
        String str2 = sc.nextLine();
        System.out.println("Enter third String:");
        String str3 = sc.nextLine();
        StringBuffer sb = new StringBuffer(str1);
        StringBuilder sd = new StringBuilder(str1);
       //concatenating using + operator
       System.out.println("After concatenating the Strings using + operator: "+(str1+" "+str2+" "+str3));
       //concatenating using StringBuffer.append
       System.out.println("After concatenating the Strings using StringBuffer.append: "+(sb.append(str2).append(str3)));
       //concatenating using StringBuilder.append
       System.out.println("After concatenating the Strings using StringBuilder.append: "+(sd.append(str2).append(str3)));
        //after execution
        long endingTime = System.nanoTime();
        System.out.println("After execution:"+startingTime+" NanoSeconds");

        long executionTime=endingTime-startingTime;

        System.out.println("Execution TIme is "+executionTime+" NanoSeconds");
        sc.close();

    }
}
