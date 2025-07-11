package com.aaslin.java.assignments.assignment6;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 
class EmployeeData{
	
	Map<String, String> map = new HashMap<>();
	
	public void addEmployee(String name, String skill) {
        map.put(name, skill);   
        System.out.println(name+" - "+skill+" added.");
    }
	
	public void searchEmployeeSkill(String employeeName){
        System.out.println(employeeName+" - "+map.get(employeeName));        
    }
	
	public void getEmployeeData(){
        if(map.size()!=0){
            for(Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey()+"-"+entry.getValue());
                }
        }
        else{
            System.out.println("No employee details registered");
        }      
    }
	
}
public class EmployeeSkillTracker {

	public static void main(String[] args) {

		EmployeeData employeeData = new EmployeeData();
	    Scanner scanner = new Scanner(System.in);
	    boolean exit=true;
	    int choice=0;
	    
	    while(exit){
		    System.out.println("Enter your choice: ");
		    System.out.println("1. Register Employee\n\n2. Search employee\n3. Show employee data\n4. Exit");
		    choice = scanner.nextInt();
		    
		    //to consume the leftover newline character in the input buffer
		    scanner.nextLine();
		    
		    switch(choice){
		        case 1: {
		        	System.out.println("Enter name: ");
		            String name = scanner.nextLine();
		            
		            System.out.println("Enter skill: ");
		            String skill = scanner.nextLine();
		            
		            employeeData.addEmployee(name, skill);
		            break;
		        }
		        case 2:{
		        	System.out.println("Enter employee name to get their skill: ");
		            employeeData.searchEmployeeSkill(scanner.nextLine());
		            break;
		        }
		        case 3:{
		        	employeeData.getEmployeeData();
		            break;
		        }
		        case 4:{
		            exit=false;
		            break;
		        }
		        default:{
		            System.out.println("Please enter a valid choice..");
		            break;
		        }
		    } 
	    }
	    
	    scanner.close();
	}
}
