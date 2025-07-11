package com.aaslin.java.assignments.assignment_1;

import java.util.*;

class FrequencyCount  {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
        //to enter the size of array
        int n=sc.nextInt();
        int c=0,j=1;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            //to enter the elements
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
       while(j!=n-1){
        for(int i=j-1;arr[i]==arr[j];i++){
            c++;
        }
        j+=c;
       System.out.println("Occurances of "+arr[j]+" is: "+c);
       c=0;
       }
        sc.close();
}
}
