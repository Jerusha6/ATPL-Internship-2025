package com.aaslin.java.assignments.assignment_3;
public class String_methods {
    public static void main(String[] args){
        String str  = "  Java Programming  ";
        System.out.println("Input string "+str);
        str = str.trim();
        System.out.println("Input string after trim:"+str);
        str = str.toLowerCase();
        System.out.println("Input string after toLowerCase() method"+str);
        str = str.toUpperCase();
        System.out.println("Input string after toUpperCase() method"+str);
        str=str.replace(" ","-");
        System.out.println("Input string after replace() method"+str);
        str=str.substring(0,4);
        System.out.println("Input string after substring(0,4) method"+str);
        int a=str.indexOf('A');
        System.out.println("Input string after indexOf(A) method"+a);


    }
}
