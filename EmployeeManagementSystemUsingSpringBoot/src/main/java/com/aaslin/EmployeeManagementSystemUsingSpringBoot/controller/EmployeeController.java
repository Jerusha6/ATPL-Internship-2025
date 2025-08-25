package com.aaslin.EmployeeManagementSystemUsingSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.dto.EmployeeDTO;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/addEmployee")
	public String showAddEmployeePage(Model model) {
	    model.addAttribute("employee", new Employee());
	    return "AddEmployee"; 
	}
	
	@GetMapping("/adminView")
	public String adminView() {
		return "AdminView";
	}

	
	@GetMapping("/admin/terminateEmployeePage")
	public String terminateEmployeePage() {
	    return "terminateEmployee";
	}
	
	@PostMapping("/fetchEmployee")
    public String viewEmployeeDetails(@RequestParam String empID, Model model) {
        try {
            EmployeeDTO employee = employeeService.getEmployeeById(empID);
            model.addAttribute("employee", employee);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "EmployeeDetails";
    }
	
	@GetMapping("/admin")
	public String getEmployees(Model model) {
	    List<EmployeeDTO> employees = employeeService.getEmployees();
	    model.addAttribute("employees", employees);
	    return "Employees"; 
	}
	
	
	@GetMapping("/admin/terminated")
	public String getAllTerminatedEmployees(Model model) {
	    List<EmployeeDTO> terminatedEmployees = employeeService.getAllTerminatedEmployees();
	    model.addAttribute("terminatedEmployees", terminatedEmployees);
	    return "TerminatedEmployees";
	}

	
	@PostMapping("/admin/add")
	public String addEmployee(@ModelAttribute Employee employee, HttpSession session, Model model) {	
		employeeService.addEmployee(employee, session, model);
		 return "EmployeeSuccess";
	}
	
	@PutMapping("/admin/updateEmployee/{id}")
	@ResponseBody
	public boolean updateEmployee(@PathVariable String id, @RequestBody Employee employee) {		
		employeeService.updateEmployee(id, employee);
		return true;
	}
	
	@PutMapping("/updatePassword/{id}")
	@ResponseBody
	public boolean updatePassword(@PathVariable String id, @RequestBody String password) {		
		employeeService.updatePassword(id, password);
		return true;
	}
	
	@PostMapping("/admin/terminateEmployee")
	public String terminateEmployeeById(@RequestParam String employeeId, Model model) {
	    try {
	        employeeService.terminateEmployee(employeeId);
	        model.addAttribute("message", "Employee with ID " + employeeId + " has been terminated successfully.");
	        model.addAttribute("success", true);
	    } catch (Exception e) {
	        model.addAttribute("message", "Failed to terminate employee: " + e.getMessage());
	        model.addAttribute("success", false);
	    }
	    return "terminatedStatus";
	}

	
}
