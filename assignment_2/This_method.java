package com.aaslin.java.assignments.assignment_2;

class Class1{
    Class1(){
        System.out.println("Defualt Constructor");
    }
    Class1(int a){
        this();
        System.out.println("Parameterized constructor");

    }

}

class This_method {
    public static void main(String[] args){
        Class1 ob = new Class1(5);
    }
}
