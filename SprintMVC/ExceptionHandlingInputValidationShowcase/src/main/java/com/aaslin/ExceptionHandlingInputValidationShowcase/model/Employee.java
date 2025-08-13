package com.aaslin.ExceptionHandlingInputValidationShowcase.model;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Component 
public class Employee {
	
	@Min(value = 1, message = "Employee id should be greater than 0")
	private int EmployeeID;
	@NotBlank(message="Employee name cannot be null")
	private String name;
	@NotNull(message="Employee price cannot be null")
	@Email(message="Email format is invalid")
	private String email;
	@Positive(message="Salary should be greater than 0")
	private double Salary;
	
	public Employee() {}
	
	public Employee( int employeeID, String name, String email, double salary) {
		super();
		EmployeeID = employeeID;
		this.name = name;
		this.email = email;
		Salary = salary;
	}
	public int getEmployeeID() {
		return EmployeeID;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public double getSalary() {
		return Salary;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	
	
}
