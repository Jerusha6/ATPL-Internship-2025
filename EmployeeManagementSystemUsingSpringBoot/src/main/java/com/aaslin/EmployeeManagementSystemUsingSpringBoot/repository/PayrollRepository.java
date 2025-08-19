package com.aaslin.EmployeeManagementSystemUsingSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Integer>{
	
	@Query("Select p from Payroll p WHERE p.employee.employeeId= :employeeId")
	public List<Payroll> fetchPayrollById(@Param("employeeId") int employeeId);
}
