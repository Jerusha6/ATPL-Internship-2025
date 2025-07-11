package com.aaslin.java.assignments.assignment_2;

class StudentDemo {
    int id;
    String name;
	public static String schoolName;

    StudentDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", School: " + schoolName);
    }
}

public class StudentCls {
    public static void main(String[] args) {
        StudentDemo s1 = new StudentDemo(1, "Anand");
        StudentDemo.schoolName = "Oxford University";
        StudentDemo s2 = new StudentDemo(2, "Roja");
        System.out.println("Before changing school name:");
        s1.display();
        s2.display();
        StudentDemo.schoolName = "Delhi public school";
        System.out.println("\nAfter changing school name:");
        s1.display();
        s2.display();
    }
}
