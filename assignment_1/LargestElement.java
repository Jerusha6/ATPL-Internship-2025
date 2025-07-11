package com.aaslin.java.assignments.assignment_1;

import java.util.*;
class LargestElement{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //to enter the size of array
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            //to enter the elements
            arr[i]=sc.nextInt();
        }
        int temp=Integer.MIN_VALUE;
        for(int i:arr)
        {
            if(i>temp){
                temp=i;
            }
        }
        System.out.println("Largest element is:"+temp);
        sc.close();
}
}