package com.aaslin.EmployeeManagementSystemUsingSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.service.EmployeeService;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.dto.EmployeeDTO;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/admin")
	@ResponseBody
	public List<EmployeeDTO> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public EmployeeDTO getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/admin/terminated")
	@ResponseBody
	public List<EmployeeDTO> getAllTerminatedEmployees(){
		return employeeService.getAllTerminatedEmployees();
	}
	
	@PostMapping("/admin/addEmployee")
	@ResponseBody
	public boolean addEmployee(@RequestBody Employee employee) {
		 employeeService.addEmployee(employee);
		 return true;
	}
	
	@PutMapping("/admin/updateEmployee/{id}")
	@ResponseBody
	public boolean updateEmployee(@PathVariable int id, @RequestBody Employee employee) {		
		employeeService.updateEmployee(id, employee);
		return true;
	}
	
	@PutMapping("/updatePassword/{id}")
	@ResponseBody
	public boolean updatePassword(@PathVariable int id, @RequestBody String password) {		
		employeeService.updatePassword(id, password);
		return true;
	}
	
	@PutMapping("/admin/terminateEmployee/{id}")
	@ResponseBody
	public String terminateEmployee(@PathVariable int id) {
		employeeService.terminateEmployee(id);
		return "Employee terminated";
	}
	
}
