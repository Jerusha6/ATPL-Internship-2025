package com.aaslin.EmployeeManagementSystemUsingSpringBoot.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String employeeEmail;
    private String employeeDesignation;
    private String contact;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

public EmployeeDTO(int employeeId, String employeeName, String employeeEmail, String employeeDesignation,
			String contact, LocalDate dateOfBirth, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt,
			String updatedBy) {
	
    	this.employeeId=employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeDesignation = employeeDesignation;
        this.contact = contact;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }
	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public String getContact() {
		return contact;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

    
}
