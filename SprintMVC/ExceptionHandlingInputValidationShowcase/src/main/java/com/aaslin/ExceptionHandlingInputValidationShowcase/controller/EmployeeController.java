package com.aaslin.ExceptionHandlingInputValidationShowcase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.ExceptionHandlingInputValidationShowcase.model.Employee;
import com.aaslin.ExceptionHandlingInputValidationShowcase.service.EmployeeService;

import jakarta.validation.Valid;


@RestController 
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> show(){
		return service.getEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		return service.getEmployee(employeeId);
	}
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody @Valid Employee employee) {
		 service.addEmployee(employee);
	}
	
	//To update
	@PutMapping("/employees/{employeeId}")
	public void updateEmployee(@PathVariable int employeeId,@Valid @RequestBody Employee employee) {
		service.updateEmployee(employeeId, employee);
	}
	
	//	To delete all the employees
	@DeleteMapping("/employees")
	public void deleteEmployees() {
		service.deleteEmployees();
	}
	
	// To delete by Id
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployeeById(@PathVariable int employeeId) {
		service.deleteEmployeeById(employeeId);
	}
	
}
