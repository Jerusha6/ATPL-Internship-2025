//section b 4Q


package com.aaslin.java.assignments.test;

class NegativeMoneyException extends Throwable{	
	public NegativeMoneyException(String string) {			
			System.out.print("The entered money is in negative ");
		}	
}

class InsufficientBalanceException extends Throwable{	
	public InsufficientBalanceException(String string) {			
			System.out.print("Insufficient Fund ");
		}	
}

class BankAccount{
	
	private double balance;
	
	BankAccount(double balance){
		this.balance = balance;
	}
	
	public void deposit(double money) throws NegativeMoneyException {
		if(money<0) {
			throw new NegativeMoneyException("Money value connot be negative\n");
		}
		else {
			balance = balance + money;
			System.out.print("Deposit success");
		}
		
	}
	public void withdraw(double money) throws InsufficientBalanceException {
		if(money>balance) {
			throw new InsufficientBalanceException("There is no much amount in your account\n");
		}
		else {
			balance = balance - money;
			System.out.print("Withdrawl success");
		}
		
	}
}

public class BankATMSimulation {

	public static void main(String[] args) {
		
		BankAccount bank = new BankAccount(30000);
		try {
			bank.deposit(3000);
			bank.deposit(-3000);
		}catch(NegativeMoneyException ne) {
			System.out.print(ne.getMessage());
		}
		try {
			bank.withdraw(1300000);
		}catch(InsufficientBalanceException ibe) {
			System.out.print(ibe.getMessage());
		}

	}

}
