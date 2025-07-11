package com.aaslin.java.assignments.assignment_2;

interface Movable{
    void move();
}
class Car implements Movable{
    public void move(){
        System.out.println("Car is running");
    }
}
class Robot implements Movable{
    public void move(){
        System.out.println("Robot started walking");
    }
}
class Drone implements Movable{
    public void move(){
        System.out.println("Droen is flying");
    }
}
class MovableInterface {
    public static void main(String[] args) {
        Car ob1 = new Car();
        ob1.move();
        Robot ob2 = new Robot();
        ob2.move();
        Drone ob3 = new Drone();
        ob3.move();
    }
}
