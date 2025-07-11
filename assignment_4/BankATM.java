package com.aaslin.java.assignments.assignment_4;
import java.util.Scanner;

class InsufficientBalanceException extends Exception{
   
public InsufficientBalanceException(String msg){
    super(msg);   
}

}
class BankATM {
    public static double amount=0;

    public static void deposit(double depo){
        amount+=depo;
        
        }
    public static void withdraw(double with) throws InsufficientBalanceException{
        if(amount>=with){
            amount-=with;
        }else{
            throw new InsufficientBalanceException("Insuffiecient Bank Balance!");
        }
        }
    public static void getBalance(){
        System.out.println("Your balance is: "+amount);
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean exit=true;
    int choice=0;
    while(exit){
    System.out.println("Enter your choice: ");
    System.out.println("1. Deposit\n 2. Withdraw\n 3. Balance\n 4. Exit");
    choice = sc.nextInt();
    switch(choice){
        case 1: {
            System.out.println("Enter amount to deposit: ");
            double depo = sc.nextDouble();
            deposit(depo);
            break;
        }
        case 2: {
            System.out.println("Enter amount to withdraw: ");
            double with = sc.nextDouble();
            try{
            withdraw(with);
            break;
            }catch(InsufficientBalanceException ie){
                System.out.println(ie.getMessage()+" You do not have sufficient funds in your bank");
            }
        }
        case 3:{
            getBalance();
            break;
        }
        case 4:{
            exit=false;
            break;
        }
        default:{
            System.out.println("Please enter a valid number..");
            break;
        }
    }
    }         
    }
}