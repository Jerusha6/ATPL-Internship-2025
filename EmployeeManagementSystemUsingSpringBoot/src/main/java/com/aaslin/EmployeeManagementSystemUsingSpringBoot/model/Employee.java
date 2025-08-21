package com.aaslin.EmployeeManagementSystemUsingSpringBoot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="Employee_Jerusha")
public class Employee {
	
	@Id
	@Column(unique=true)
	private String employeeId;
	
	@PrePersist
	public void generateId() {			
		  String currentId = String.format("ATPL%04d",System.currentTimeMillis()%10000); //for unique Id everytime
		  this.employeeId=currentId;
	}
		
	@Column(nullable=false)
	private String employeeName;
	
	@Column(nullable=false, unique=true)
	@Email
	private String employeeEmail;
	
	@Column(nullable=false)
	private String employeeDesignation;
	
	@Column(nullable=false, unique=true)
	private String contact;
	
	@Column(nullable=false)
	private String employeePassword;
	
	@Column(nullable=false)
	private LocalDate dateOfBirth;	
	
	private boolean isDeleted;
	
	@Column(nullable=false)
	private String createdBy;
	
	@CreationTimestamp //hibernate automatically updates this whenever a new employee creates
	@Column(updatable=false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp //hibernate automatically updates this whenever a new employee creates
	private LocalDateTime updatedAt;
	
	@Column(nullable=false)
	private String updatedBy;
	
	@OneToOne(mappedBy="employee", cascade=CascadeType.ALL)
	private SalaryInfo salaryInfo;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private List<Payroll> payrolls;
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
