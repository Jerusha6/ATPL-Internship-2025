//section b 2Q

package com.aaslin.java.assignments.test;

interface Payment{	
	abstract void pay();	
}

class UPIPayment implements Payment{
	
	@Override	
	public void pay() {
		System.out.println("UPI payment is successful");
	}
}

class CardPayment implements Payment{
	
	@Override	
	public void pay() {
		System.out.println("CardPayment is successful");
	}
}

class CashOnDelivery implements Payment{
	
	@Override	
	public void pay() {
		System.out.println("Cash On Delivery is successful");
	}
}


public class EcommercePaymentInterface {
	public static void main(String[] args) {
		
		UPIPayment upi = new UPIPayment();
		upi.pay();
		
		CardPayment cardPay = new CardPayment();
		cardPay.pay();
		
		CashOnDelivery cod = new CashOnDelivery();
		cod.pay();
		
		
	}
}
