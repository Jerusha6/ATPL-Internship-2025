package com.aaslin.java.assignments.assignment_7;

public class WrapperConversion {
    public static void main(String[] args) {
        // Primitive types
        int integerValue = 10;
        double doubleValue = 20.5;
        char charValue = 'A';
        boolean booleanValue = true;

        // Convert to wrapper classes using autoboxing
        Integer integerObj = integerValue;
        Double doubleObj = doubleValue;
        Character charObj = charValue;
        Boolean booleanObj = booleanValue;

        System.out.println("Integer wrapper class: " + integerObj.getClass().getName());
        System.out.println("Double wrapper class: " + doubleObj.getClass().getName());
        System.out.println("Character wrapper class: " + charObj.getClass().getName());
        System.out.println("Boolean wrapper class: " + booleanObj.getClass().getName());
    }
}
