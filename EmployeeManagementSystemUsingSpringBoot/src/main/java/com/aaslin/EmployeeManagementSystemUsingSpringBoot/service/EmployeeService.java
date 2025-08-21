package com.aaslin.EmployeeManagementSystemUsingSpringBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.dto.EmployeeDTO;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.exception.EmployeeNotFoundException;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Employee;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.repository.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<EmployeeDTO> empIdList = new ArrayList<>();	
	
	public List<EmployeeDTO> getEmployees() {
		List<Employee> employeeList =  employeeRepo.findAll();
		
		List<EmployeeDTO> employees = employeeList.stream() 
				.filter(employee->!employee.getIsDeleted())
				.map(e-> new EmployeeDTO(
						e.getEmployeeId(),
						e.getEmployeeName(),
						e.getEmployeeEmail(),
						e.getEmployeeDesignation(),
						e.getContact(),
						e.getDateOfBirth(),
						e.getCreatedAt(),
						e.getCreatedBy(),
						e.getUpdatedAt(),
						e.getUpdatedBy()
						))
				.collect(Collectors.toList());
		return employees;
	}

	public EmployeeDTO getEmployeeById(String id) {
		Employee emp = employeeRepo.findByEmployeeId(id);
		if(emp.equals(null) || emp.getIsDeleted()) {
			 throw new EmployeeNotFoundException("Employee not found/deleted");
		}
//		Employee emp = employee.get();

	    EmployeeDTO employeeDto = new EmployeeDTO(
	        emp.getEmployeeId(),
	        emp.getEmployeeName(),
	        emp.getEmployeeEmail(),
	        emp.getEmployeeDesignation(),
	        emp.getContact(),
	        emp.getDateOfBirth(),
	        emp.getCreatedAt(),
	        emp.getCreatedBy(),
	        emp.getUpdatedAt(),
	        emp.getUpdatedBy()
	    );
	    return employeeDto;
	}

	public List<EmployeeDTO> getAllTerminatedEmployees() {
List<Employee> employeeList =  employeeRepo.findAll();
		
		List<EmployeeDTO> employees = employeeList.stream() 
				.filter(employee->employee.getIsDeleted())
				.map(e-> new EmployeeDTO(
						e.getEmployeeId(),
						e.getEmployeeName(),
						e.getEmployeeEmail(),
						e.getEmployeeDesignation(),
						e.getContact(),
						e.getDateOfBirth(),
						e.getCreatedAt(),
						e.getCreatedBy(),
						e.getUpdatedAt(),
						e.getUpdatedBy()
						))
				.collect(Collectors.toList());
		return employees;
	}

	public void addEmployee(@ModelAttribute Employee employee, HttpSession session, Model model) {
        String currentUser = (String) session.getAttribute("username");

        employee.setCreatedBy(currentUser);
        employee.setUpdatedBy(currentUser);

        Employee savedEmployee = employeeRepo.save(employee);

        model.addAttribute("employee", savedEmployee);
    }

	public Employee updateEmployee(String id, Employee employee) {
		employee.setEmployeeId(id);
		Employee emp = employeeRepo.findByEmployeeId(id);
		if (emp == null) {
	        throw new RuntimeException("Employee not found");
	    }
		employee.setEmployeePassword(emp.getEmployeePassword());
	    return employeeRepo.save(employee);
	}

	public void updatePassword(String id, String password) {
		employeeRepo.updatePassword(id, password);
	}

	public void terminateEmployee(String id) {
		employeeRepo.terminateEmployee(id);
	}

	public Employee authenticate(String empId, String password) {
        Employee employee = employeeRepo.findByEmployeeId(empId);
        if (employee != null && employee.getEmployeePassword().equals(password)) {
            return employee;
        }
        return null;
    }
}
