// Write a Java program to:
// ○ Create a LinkedList of Integers.
// ○ Add numbers 10, 20, 30, 40, 50.
// ○ Add 5 at the beginning and 60 at the end.
// ○ Remove the element at index 2.
// ○ Print all elements.
package com.aaslin.java.assignments.assignment_5;
import java.util.LinkedList;
public class LinkedListClass {
    public static void show(LinkedList<Integer> list){
    for(int element:list){
                System.out.print(element+" ");
            }
    }
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        for(int index=10;index<=50;index+=10){
            list.add(index);
        }
        System.out.println("List Before update");
        show(list);
        list.add(0,5);
        list.add((list.size()),60);
        list.remove(2);
        System.out.println("\nList after update");
        show(list);
        
    }
}
