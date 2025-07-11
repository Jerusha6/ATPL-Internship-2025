package com.aaslin.java.assignments.assignment_2;

class Payment{
    void processPayment(){
        System.out.println("Processing Payment..");
    }
}
class CreditCardPayment extends Payment {
    @Override
    void processPayment(){
        System.out.println("Credit card payment is in Processing...");
    }
}
class UpiPayment extends Payment {
    @Override
    void processPayment(){
        System.out.println("UPI payment is in Processing...");
    }
}
class NetBankingPayment extends Payment {
    @Override
    void processPayment(){
        System.out.println("Net banking payment is in Processing...");
    }
}
  

class PaymentCls {
    public static void main(String[] args) {
        Payment ob = new Payment();
        ob.processPayment();
        CreditCardPayment ob1 = new CreditCardPayment();
        ob1.processPayment();
        UpiPayment ob2 = new UpiPayment();
        ob2.processPayment();
        NetBankingPayment ob3 = new NetBankingPayment();
        ob3.processPayment();
    }
}