package com.aaslin.java.assignments.assignment_2;

class DemoCls1{
    final void PI_value(){
        double PI_value=3.14;
    }
}
class DemoCls2 extends DemoCls1{
//    @Override
//    void PI_value(){
//        PI_value = 3.01;
//    }
}
class Final_Demo1 {
public static void main(String[] args){
    DemoCls1 ob = new DemoCls1();
    ob.PI_value();
}    
}
