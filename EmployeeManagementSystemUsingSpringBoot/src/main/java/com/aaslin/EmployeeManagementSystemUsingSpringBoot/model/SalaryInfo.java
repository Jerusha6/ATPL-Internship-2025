package com.aaslin.EmployeeManagementSystemUsingSpringBoot.model;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="salary_jerusha")
public class SalaryInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int salaryId;
	
	@Column(nullable=false)
	private double baseSalary;
	
	@Column(nullable=false)
	private Date SalaryStartDate;
	
	@UpdateTimestamp //hibernate automatically updates this whenever a new employee creates
	private LocalDateTime updatedAt;
	
	@Column(nullable=false)
	private String updatedBy;
	
	@OneToOne
	@JoinColumn(name="employeeId", nullable=false, unique=true)
	private Employee employee;

	public int getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Date getSalaryStartDate() {
		return SalaryStartDate;
	}

	public void setSalaryStartDate(Date salaryStartDate) {
		SalaryStartDate = salaryStartDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
