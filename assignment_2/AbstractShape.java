package com.aaslin.java.assignments.assignment_2;

abstract class Shape{
    abstract void draw();
}
class AbstractShape{
    public static void main(String[] args){
        Shape sh = new Shape() {
            void draw(){
                System.out.println("Circle shape is being draw");
            }
        };
        sh.draw();
    }
}