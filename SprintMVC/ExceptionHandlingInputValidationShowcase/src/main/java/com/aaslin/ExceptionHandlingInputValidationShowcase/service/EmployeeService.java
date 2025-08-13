package com.aaslin.ExceptionHandlingInputValidationShowcase.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.ExceptionHandlingInputValidationShowcase.Exceptions.NotFoundException;
import com.aaslin.ExceptionHandlingInputValidationShowcase.model.Employee;

@Service 
public class EmployeeService {
	
	@Autowired 
	Employee employee;
	List<Employee> employeeList = new ArrayList<>(Arrays.asList(
					new Employee(1, "Jerusha","jerusha@gmail.com", 15000.00)
			));
	
	// To fetch all employees
	public List<Employee> getEmployees() {
		return employeeList;
	}
	
	// To fetch single Employee by ID
	public Employee getEmployee(int employeeId) {
		
		if(employeeList.contains(employee.getEmployeeID())) {
			
			return employeeList.stream()
                .filter(p -> p.getEmployeeID() == employeeId)
                .findFirst()
                .orElse(null);
			}
		else throw new NotFoundException("Employee with ID: "+employeeId+" is not found!");
		
	    
	}
	
	// To add Employee into the list
	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	// To update Employee 
	public void updateEmployee(int employeeId, Employee updateEmployee) {
		 for(int i=0;i<employeeList.size();i++) {
			 if(employeeList.get(i).getEmployeeID()==employeeId) {
				 employeeList.set(i, updateEmployee);
				 break;
			 }
		 }
	}
	
	// To delete all employees
	public void deleteEmployees() {
		employeeList.removeAll(employeeList);
	}
	
	// To delete Employee by ID
	public void deleteEmployeeById(int employeeId) {
		 for(int i=0;i<employeeList.size();i++) {
			 if(employeeList.get(i).getEmployeeID()==employeeId) {
				 employeeList.remove(i);
				 break;
			 }
		 }
	}
}