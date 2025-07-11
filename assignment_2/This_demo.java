package com.aaslin.java.assignments.assignment_2;

class Demo{
    String name;
    int age;
    Demo(String name, int age){
        this.name=name;
        this.age=age;
    }
    void showMsg(){
        System.out.println("Name: "+name+" ,age: "+age);
    }
}
class This_demo{
    public static void main(String[] args) {
        Demo demo = new Demo("Jerusha", 20);
        demo.showMsg(); 
    }
}