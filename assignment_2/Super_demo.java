package com.aaslin.java.assignments.assignment_2;

class baseClass {
void message() {
System.out.println("This is base class");
}
}

class definedClass extends baseClass {
void message() {
super.message();
System.out.println("This is defined class");
}
}
public class Super_demo {
public static void main(String args[]) {
definedClass dc = new definedClass();
dc.message();
}
}