// Duplicate Remover
// Given a list of integers, remove all duplicates using a Set<Integer>
package com.aaslin.java.assignments.assignment6;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
class DuplicateRemover{
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements you desire to push into set: ");
        int count = scanner.nextInt();
        int[] elementList = new int[count];
        System.out.println("Enter elements to put into set: ");
        for(int iterator=0;iterator<count;iterator++){
            elementList[iterator]=scanner.nextInt();
        }
        for(int element:elementList){
            set.add(element);
        }
        System.out.println("Here is the set without duplicates: "+set);
    }
}