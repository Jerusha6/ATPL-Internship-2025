package com.aaslin.java.assignments.assignment6;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class CustomerServices{
	Queue<String> queue = new LinkedList<>();
	public void addCustomer(String name) {
		if(queue.contains(name)) {
			System.out.println("Customer already exist, please enter different name or mobile number");
		}
		else {
			queue.offer(name);
			System.out.println("Customer added. \nCheck details here: "+name);
		}
		
	}
	public void serveCustomer() {
		if(queue.peek()!=null)
		{
			System.out.println("Dear "+queue.peek()+" You are served. You may go now!");
			queue.poll();
		}
		else
			System.out.println("Cannot serve. No one in the queue!");			
	}
	public void nextCustomer() {
		if(queue.peek()!=null)
			System.out.println(queue.peek()+" ready to be served");
		else
			System.out.println("No one in the queue!");
	}
	public void customerInQueue() {
		if(queue.size()!=0)
			System.out.println("Customers in waiting list: "+queue);
		else 
			System.out.println("No one in the queue!");
	}
	
}
public class CustomerServiceSimulation {
	
	public static void main(String[] args) {
		CustomerServices service = new CustomerServices();
		Scanner scanner = new Scanner(System.in);
		String name, mobileNumber;
		int choice=0;
		boolean exit=true;
		while(exit) {
			System.out.println("Dear customer enter your choice: ");
			System.out.println("1. Add customer into the queue");
			System.out.println("2. Serve next customer");
			System.out.println("3. See the next customer");
			System.out.println("4. See the customers in the queue");
			System.out.println("5. Exit");
			choice=scanner.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Welcome! Please enter your name:");
				scanner.nextLine();
				name=scanner.nextLine();
				System.out.println("Please enter your mobile number: ");
				mobileNumber=scanner.nextLine();
				name=name+"-"+mobileNumber;
				service.addCustomer(name);	
				break;
			}
			case 2:{
				service.serveCustomer();
				break;
			}
			case 3:{
				service.nextCustomer();
				break;
			}
			case 4:{
				service.customerInQueue();
				break;
			}
			case 5:{
				System.out.println("Thank you! Visit again");
				exit=false;
				break;
			}
			default:{
				System.out.println("Please choose correct option between 1-4");
				break;
			}
			}
		}
}

}
