package com.aaslin.java.assignments.assignment_3;

public class Immutability {
    public static void main(String[] args){
        String str1 = "Hello";
        System.out.println("String 1 before modification "+str1);
        String str2 = str1;
        System.out.println("String 2 before modification "+str2);
        str1=str1.concat("World");
        System.out.println("String 1 after modification "+str1);
        System.out.println("String 2 after modification "+str2);
        //here actual string is not changing
    }
}
