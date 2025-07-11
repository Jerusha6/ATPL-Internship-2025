package com.aaslin.java.assignments.assignment_2;

class Display {
    void show(int a, int b){
        System.out.println("Method to show integer values: a = "+a+", b = "+b);
    }
    void show(String a, String b){
        System.out.println("Method is saying "+a+" "+b);
    }
    void show(int[] a, int[] b){
        System.out.println("Method to show array values at position 0: a[0] = "+a[0]+", b[0] = "+b[0]);
    }
}
class DisplayCls{
public static void main(String[] argg){
Display di = new Display();
di.show(5,6);
di.show("hello","everyone");
int[] a={15,6,7};
int[] b={500,6,7};
di.show(a,b);
}
}