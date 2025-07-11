package com.aaslin.java.assignments.assignment_4;
import java.util.Scanner;
class ThrowExceptionDemo{

    public static void checkPositive(int input){
        try{
            if(input<0){
                throw new IllegalArgumentException("You have entered a negative value..!");
            }
            else if(input>80 || input<50){
                System.out.println("Unfortunately, You are not eligible for this role..");
            }
            else System.out.println("You are eligible..");
        }catch(IllegalArgumentException IAE){
            System.out.println("Number cannot be negative "+IAE.getMessage());

        }
            
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your weight to check whether you fit for police: ");
        int input = sc.nextInt();
        checkPositive(input);

        sc.close();
       
    }
}