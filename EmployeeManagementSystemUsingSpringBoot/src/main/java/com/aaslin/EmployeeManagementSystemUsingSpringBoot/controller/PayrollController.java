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

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.service.PayrollService;

import jakarta.servlet.http.HttpSession;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Employee;
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
	
	 @GetMapping("/payroll/add")
	 public String showPayrollForm(@RequestParam("employeeId") String employeeId, Model model) {
	     Payroll payroll = new Payroll();

	     Employee emp = new Employee();
	     emp.setEmployeeId(employeeId);
	     payroll.setEmployee(emp);

	     model.addAttribute("payroll", payroll);
	     return "AddPayroll";
	 }
	
	@GetMapping("/employeePayroll")
    public String fetchPayrollById(@RequestParam("id") String id, Model model) {
        List<Payroll> payrollList = service.fetchPayrollById(id);
        model.addAttribute("payrollList", payrollList);
        return "payrollReport"; 
    }
	
	@GetMapping("/payrollSearch")
    public String searchPayrollForm() {
        return "payrollSearch"; 
    }
	
	@PostMapping("/payroll/add")
    public String addPayroll(@ModelAttribute Payroll payroll, HttpSession session) {
        String currentUser = (String) session.getAttribute("username");

        service.savePayroll(payroll, currentUser);

        return "PayrollSuccess";
    }
	
	@PutMapping("/admin/editPayroll/{id}")
	@ResponseBody
	public Payroll editPayroll(@PathVariable int id, @RequestBody Payroll payroll) {
		return service.editPayroll(id, payroll);
	}
	
}
