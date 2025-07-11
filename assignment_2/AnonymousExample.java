package com.aaslin.java.assignments.assignment_2;

interface Greeting {
    void sayHello();
}

public class AnonymousExample {
    public static void main(String[] args) {
        Greeting greet= new Greeting() {
        public void sayHello() {
            System.out.println("Hello!!");
        }
    };  
        greet.sayHello();
    }
}
