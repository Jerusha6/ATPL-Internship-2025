package com.aaslin.java.assignments.assignment_2;

class Cls1{
    void PI(){
        final double PI=3.14;
    }
}
class Cls2 extends Cls1{
//    @Override
//    void PI(){
//        PI = 3.01;
//    }
}
class Final_Demo2 {
public static void main(String[] args){
    Cls1 ob = new Cls1();
    ob.PI();
}    
}
