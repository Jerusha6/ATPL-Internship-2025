import java.util.Scanner;
public class StringBuffer_demo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String:");
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        System.out.println("After reversing the String you provided: "+sb.toString());
    }
}
