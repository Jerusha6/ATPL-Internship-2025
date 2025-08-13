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
	@NotNull(message="Product price cannot be null")
	@Positive(message="Salary should be greater than 0")
	private double Salary;
	
	public Employee() {}
	
	public Employee(int EmployeeID, String name, String email) {
		super();
		this.EmployeeID = EmployeeID;
		this.name = name;
		this.email = email;
	}
	public int getProductId() {
		return EmployeeID;
	}
	public String getName() {
		return name;
	}
	public String getPrice() {
		return email;
	}
}
