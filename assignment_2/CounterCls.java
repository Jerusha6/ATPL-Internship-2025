package com.aaslin.java.assignments.assignment_2;

class Counter {
    static int count=0;
    Counter(){
    count++;
    }
    void display(){
        System.out.println("Object count "+count);
    }
}

public class CounterCls {
    public static void main(String[] args) {
       Counter co1 = new Counter();
       Counter co2 = new Counter();
       Counter co3 = new Counter();
       Counter co4 = new Counter();
       co4.display();
    }
}
