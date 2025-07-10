// Phone Directory
// Implement a phone book using Map<String, String> where key = name, value =
// phone number.
// Provide:
// ● Add contact
// ● Search contact
// ● Remove contact

// package com.aaslin.java.assignments.assignment6;
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
        else{
            System.out.println("There is no such contact with "+name);
        }
    }
    public void searchContact(String name){
        if(map.containsKey(name)){
            System.out.println(name+"->"+map.get(name));   
        }
        else{
            System.out.println("There is no such contact with "+name);
        }
           
    }
    public void getContacts(){
        System.out.println("Key->Value");
        if(map.size()!=0){
            for(Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey()+"->"+entry.getValue());
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
    System.out.println("Enter your name: ");
    String name = scanner.nextLine();
    System.out.println("Enter your mobile number: ");
    String mobileNumber = scanner.nextLine();
    phoneBook.addContact(name,mobileNumber);
    phoneBook.removeContact(name);
    System.out.println("Enter name to search: ");
    phoneBook.searchContact(scanner.nextLine());
    phoneBook.getContacts();
    scanner.close();
}
}