// Here there are 2 classes StudentData which is used to initialize and show details of studen
// and NullPointer class which is the main class, where I have created object for StudentData but initialized with null so it is throwing nullpointerException
// That exception handled in the main class only which prevents from crashing the program
package com.aaslin.java.assignments.assignment_4;
class StudentData{
    String name;
    int roll;
    StudentData(String name, int roll){
        this.roll=roll;
        this.name=name;
    }
    void show(){
        System.out.println("Name: "+name+" roll number: "+roll);
    }
}
class NullPointer {
public static void main(String[] args){
    StudentData ob=null;
    try{
        ob.show();
    }catch(NullPointerException npe){
        System.out.println("This is thrown because StudentData object is referring to the null pointer ");
    }
}
}
