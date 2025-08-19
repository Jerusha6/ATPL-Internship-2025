package com.aaslin.EmployeeManagementSystemUsingSpringBoot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.dto.EmployeeDTO;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.exception.EmployeeNotFoundException;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Employee;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<EmployeeDTO> getEmployees() {
		List<Employee> employeeList =  employeeRepo.findAll();
		
		List<EmployeeDTO> employees = employeeList.stream() 
				.filter(employee->!employee.getIsDeleted())
				.map(e-> new EmployeeDTO(e.getEmployeeId(), e.getEmployeeName(), e.getEmployeeEmail(),e.getEmployeeDesignation(),e.getContact(),e.getDateOfBirth(),e.getCreatedAt(), e.getCreatedBy(),e.getUpdatedAt(),e.getUpdatedBy()))
				.collect(Collectors.toList());
		return employees;
	}

	public EmployeeDTO getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isEmpty() || employee.get().getIsDeleted()) {
			 throw new EmployeeNotFoundException("Employee not found/deleted");
		}
		Employee emp = employee.get();

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
				.map(e-> new EmployeeDTO(e.getEmployeeId(), e.getEmployeeName(), e.getEmployeeEmail(),e.getEmployeeDesignation(),e.getContact(),e.getDateOfBirth(),e.getCreatedAt(), e.getCreatedBy(),e.getUpdatedAt(),e.getUpdatedBy()))
				.collect(Collectors.toList());
		return employees;
	}


	public void addEmployee(Employee employee) {
		 employeeRepo.save(employee);
	}

	public Employee updateEmployee(int id, Employee employee) {
		employee.setEmployeeId(id);
		Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
		employee.setEmployeePassword(emp.getEmployeePassword());
	    return employeeRepo.save(employee);
	}

	public void updatePassword(int id, String password) {
		employeeRepo.updatePassword(id, password);
	}

	public void terminateEmployee(int id) {
		employeeRepo.terminateEmployee(id);
	}

}
