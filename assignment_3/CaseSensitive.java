package com.aaslin.java.assignments.assignment_3;

public class CaseSensitive {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = "java";
        System.out.println("str1: "+str1);
        System.out.println("str2: "+str2);
        System.out.println("str1.equals(str2): "+str1.equals(str2));
        System.out.println("str1.equalsIgnoreCase(str2): "+str1.equalsIgnoreCase(str2));
        System.out.println("str1.compareTo(str2): "+str1.compareTo(str2));
    }
}
