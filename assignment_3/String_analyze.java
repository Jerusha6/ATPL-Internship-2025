package com.aaslin.java.assignments.assignment_3;
class String_analyze{
    public static void main(String[] args) {
        String str= "Learning Java is fun and interesting";
        System.out.println("Given sentence: "+str);
        String[] arr = str.split(" ");
        int len = arr.length;
        System.out.println("Count of words in the given sentence: "+len);
        int first = str.indexOf('i');
        System.out.println("First occurance of i is at: "+first);
        int last = str.lastIndexOf('i');
        System.out.println("First occurance of i is at: "+last);
        System.out.println("String starts with \"Learn\""+str.startsWith("Learn"));
        System.out.println("String starts with \"ing\""+str.endsWith("ing"));
    }
}