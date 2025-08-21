package com.aaslin.EmployeeManagementSystemUsingSpringBoot.controller;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Employee;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PortalController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/signin")
    public String signInPage() {
        return "signIn"; 
    }

    @PostMapping("/portalControl")
    public String portalControl(@RequestParam String empID,
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {

        Employee employee = employeeService.authenticate(empID, password);

        if (employee != null) {
            session.setAttribute("username", employee.getEmployeeName());

            if ("admin".equalsIgnoreCase(employee.getEmployeeDesignation())) {
                return "AdminView"; 
            } else {
                model.addAttribute("employee", employee);
                return "EmployeeDetails";
            }
        } else {
            model.addAttribute("error", "Invalid Employee ID or Password!");
            return "signin";
        }
    }
}
