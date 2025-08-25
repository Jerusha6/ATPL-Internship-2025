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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payroll_jerusha")
public class Payroll {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int payrollId;
	
	@ManyToOne
	@JoinColumn(name="employeeId", nullable=false)
	private Employee employee;
	
	@Column(nullable=false)
	private Date PayrollMonth;
	
	@Column(nullable=false)
	private double baseSalary;
	
	@Column(nullable=false)
	private double bonus=0;
	
	@Column(nullable=false)
	private int leaveCount=0;
	
	@Column(nullable=false)
	private double netPay;
	
	@Column(nullable=false)
	private Date paidDate;
	
	@Column(nullable=false)
	private String updatedBy;
	
	@UpdateTimestamp //hibernate automatically updates this whenever a new employee creates
	private LocalDateTime updatedAt;

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}
	
	public LocalDateTime getUpdatedAt() {
	    return updatedAt;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getPayrollMonth() {
		return PayrollMonth;
	}

	public void setPayrollMonth(Date payrollMonth) {
		PayrollMonth = payrollMonth;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}
