package com.aaslin.EmployeeManagementSystemUsingSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query("SELECT e FROM Employee e WHERE e.isDeleted = true")
	public List<Employee> findEmployeeByIsDeletedTrue();
	
	@Modifying
	@Transactional
	@Query("UPDATE Employee e SET e.employeePassword = :password WHERE e.employeeId = :employeeId")
	public void updatePassword(@Param("employeeId") int employeeId, @Param("password") String password);

	@Modifying
	@Transactional
	@Query("UPDATE Employee e SET e.isDeleted = true WHERE e.employeeId = :employeeId")
	 public void terminateEmployee(@Param("employeeId")int employeeId);
	
	

}
