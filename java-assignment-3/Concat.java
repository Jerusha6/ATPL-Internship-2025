import java.util.Scanner;
public class Concat {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first String:");
        String str1 = sc.nextLine();
        System.out.println("Enter second String:");
        String str2 = sc.nextLine();
        StringBuffer sb = new StringBuffer(str1);
        StringBuilder sd = new StringBuilder(str1);
       //concatenating using + operator
       System.out.println("After concatenating the Strings using + operator: "+(str1+" "+str2));
       //concatenating using StringBuffer.append
       System.out.println("After concatenating the Strings using StringBuffer.append: "+(sb.append(str2)));
       //concatenating using StringBuilder.append
       System.out.println("After concatenating the Strings using StringBuilder.append: "+(sd.append(str2)));

    }
}
