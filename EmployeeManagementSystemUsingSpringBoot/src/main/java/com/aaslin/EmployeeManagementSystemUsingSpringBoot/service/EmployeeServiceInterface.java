package com.aaslin.EmployeeManagementSystemUsingSpringBoot.service;

import java.util.List;

import org.springframework.ui.Model;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.dto.EmployeeDTO;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Employee;

import jakarta.servlet.http.HttpSession;

public interface EmployeeServiceInterface {
	
	public List<EmployeeDTO> getEmployees();
	
	public EmployeeDTO getEmployeeById(String id);
	
	public List<EmployeeDTO> getAllTerminatedEmployees();
	
	public void addEmployee(Employee employee, HttpSession session, Model model);
	
	public Employee updateEmployee(String id, Employee employee);
	
	public void updatePassword(String id, String password);
	
	public void terminateEmployee(String id);
	
}
