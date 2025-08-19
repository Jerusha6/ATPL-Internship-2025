package com.aaslin.EmployeeManagementSystemUsingSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.service.PayrollService;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Payroll;

@Controller
@RequestMapping("/employees")
public class PayrollController {
	
	@Autowired
	PayrollService service;
	
	@GetMapping("/admin/allPayroll")
	@ResponseBody
	public List<Payroll> fetchAllPayroll(){
		return service.fetchALlPayroll();
	}
	
	@GetMapping("/employeePayroll/{id}")
	@ResponseBody
	public List<Payroll> fetchPayrollById(@PathVariable int id ){
		return service.fetchPayrollById(id);
	}
	
	@PutMapping("/admin/editPayroll/{id}")
	@ResponseBody
	public Payroll editPayroll(@PathVariable int id, @RequestBody Payroll payroll) {
		return service.editPayroll(id, payroll);
	}
	
}
