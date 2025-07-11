package com.aaslin.java.assignments.assignment_3;
import java.util.Scanner;
class String_input{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Your name is "+name);
        String name1="";
        for(int i=name.length()-1;i>=0;i--){
            name1+=""+name.charAt(i);
        }
        System.out.println("After reversing the String with loop: "+name1);
        StringBuffer sb = new StringBuffer(name);
        sb.reverse();
        System.out.println("After reversing the String with StringBuilder: "+sb.toString());
        StringBuilder sd = new StringBuilder(name);
        sd.reverse();
        System.out.println("After reversing the String with StringBuffer: "+sd.toString());
        sc.close();
    }
}