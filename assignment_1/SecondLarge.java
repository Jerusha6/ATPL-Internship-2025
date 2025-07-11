package com.aaslin.java.assignments.assignment_1;

import java.util.*;

class SecondLarge{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //to enter the size of array
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            //to enter the elements
            arr[i]=sc.nextInt();
        }
        int Large=Integer.MIN_VALUE;
        int SecLarge=Integer.MIN_VALUE;
        for(int i:arr)
        {
            if(i>Large){
                SecLarge=Large;
                Large=i;
            }
            if(i>SecLarge && i<Large){
                SecLarge=i;
            }
        }
        System.out.println("Second Largest element is:"+SecLarge);
        sc.close();
}
}