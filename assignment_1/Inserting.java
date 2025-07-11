package com.aaslin.java.assignments.assignment_1;

import java.util.Scanner;
class Inserting {
     public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        //to enter the size of array
        System.out.println("size:");
        int n=sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n+1];  
        System.out.println("elements");     
        for(int i=0;i<n;i++){
            //to enter the elements
            arr1[i]=sc.nextInt();
            arr2[i]=arr1[i];
        }
        System.out.println("insert");
        int ele=sc.nextInt();
        System.out.println("at");
        int pos=sc.nextInt();
        arr2[pos]=ele;
        
        for(int i=pos;i<n;i++){
            arr2[++pos]=arr1[i];
            
        }
        for(int i:arr2) System.out.print(i+" ");
        sc.close();
    }
}
