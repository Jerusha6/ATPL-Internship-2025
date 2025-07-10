// Phone Directory
// Implement a phone book using Map<String, String> where key = name, value =
// phone number.
// Provide:
// ● Add contact
// ● Search contact
// ● Remove contact

package com.aaslin.java.assignments.assignment6;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
class PhoneBook {
    Map<String, String> map = new HashMap<>();
    public void addContact(String name, String mobileNumber) {
        map.put(name, mobileNumber);   
        System.out.println(name+" - "+mobileNumber+" added.");
    }
    public void removeContact(String name){
        if(map.containsKey(name)){
            System.out.println(name+"->"+map.get(name)+" removed.");
            map.remove(name,map.get(name));
        }
        else if(map.containsValue(name)) {
        	for(Map.Entry<String, String> entry:map.entrySet()) {
        		if((entry.getValue()).equals(name)) {
        			System.out.println(entry.getKey()+"-"+name+" removed");
                    map.remove(entry.getKey(),name);
        		}
        	}
        }
        else{
            System.out.println("There is no such contact with "+name);
        }
    }
    public void searchContact(String name){
        if(map.containsKey(name)){
            System.out.println(name+"->"+map.get(name));   
        }
        else if(map.containsValue(name)) {
        	for(Map.Entry<String, String> entry:map.entrySet()) {
        		if((entry.getValue()).equals(name)) {
        			System.out.println(entry.getKey()+"-"+name);
        		}
        	}
        }
        else{
            System.out.println("There is no such contact with "+name);
        }
           
    }
    public void getContacts(){
        if(map.size()!=0){
            for(Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey()+"-"+entry.getValue());
                }
        }
        else{
            System.out.println("No Contacts in phone book");
        }
       
    }
}
class PhoneBookMap{
	public static void main(String args[]) {
	    PhoneBook phoneBook = new PhoneBook();
	    Scanner scanner = new Scanner(System.in);
	    boolean exit=true;
	    int choice=0;
	    while(exit){
		    System.out.println("Enter your choice: ");
		    System.out.println("1. Add contact\n2. Delete contact\n3. Search contact\n4. Show contacts\n5. Exit");
		    choice = scanner.nextInt();
		    scanner.nextLine();
		    switch(choice){
		        case 1: {
		        	System.out.println("Enter name: ");
		            String name = scanner.nextLine();
		            System.out.println("Enter mobile number: ");
		            String mobileNumber = scanner.nextLine();
		            if(mobileNumber.length()==10) {		            	
		            	phoneBook.addContact(name,mobileNumber);
		            }
		            else {
		            	while(mobileNumber.length()!=10) {
		            		System.out.println("Number should be 10 digits, try again!");
		            		mobileNumber = scanner.nextLine();
		            	}
		            	phoneBook.addContact(name,mobileNumber);
		            }
		            break;
		        }
		        case 2: {
		        	System.out.println("Enter contact name/Mobile number to remove from contact list: ");
		        	phoneBook.removeContact(scanner.nextLine());
		            break;
		        }
		        case 3:{
		        	System.out.println("Enter name/Mobile number to search: ");
		            phoneBook.searchContact(scanner.nextLine());
		            break;
		        }
		        case 4:{
		        	phoneBook.getContacts();
		            break;
		        }
		        case 5:{
		            exit=false;
		            break;
		        }
		        default:{
		            System.out.println("Please enter a valid number..");
		            break;
		        }
		    } 
	    }
	    scanner.close();
	}
}