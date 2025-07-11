package com.aaslin.java.assignments.assignment_3;
class PoolVsNonpool {
public static void main(String[] args){
    String s1="Java";
    String s2="Java";
    String s3= new String("Java");
    System.err.println("s1(string non pool) = "+s1);
    System.err.println("s2(string non pool) = "+s2);
    System.err.println("s3(string pool) = "+s3);
    // here s1 and s2 are referring to same address so == compares address and returns true if there is match found else false
    System.out.println("this is to demonstrate == operator between two non-pooled strings(s1 and s2): "+(s1==s2));   
    System.out.println("this is to demonstrate == operator between non-pooled string and pooled string(s1 and s3): "+(s1==s3));   
    // here equal() checks whether the original content in the given argument is same or not if yes returns true else false 
    System.out.println( "this is to demonstrate s1.equals(s2) between two non-pooled strings(s1 and s2): "+s1.equals(s2));
    System.out.println( "this is to demonstrate s1.equals(s3) between non-pooled string and pooled string(s1 and s3): "+s1.equals(s3));
}    
}
