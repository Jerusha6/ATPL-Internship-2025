package com.aaslin.EmployeeManagementSystemUsingSpringBoot.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payroll_jerusha")
public class Payroll {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int payrollId;
	
	@OneToOne
	@JoinColumn(name="employeeId", nullable=false, unique=true)
	private Employee employee;
	
	@Column(nullable=false)
	private Date Payroll_month;
	
	@Column(nullable=false)
	private double baseSalary;
	
	@Column(nullable=false)
	private double bonus;
	
	@Column(nullable=false)
	private int leaveCount;
	
	@Column(nullable=false)
	private double netPay;
	
	@Column(nullable=false)
	private Date paidDate;
	
	@Column(nullable=false)
	private String updatedBy;

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getPayroll_month() {
		return Payroll_month;
	}

	public void setPayroll_month(Date payroll_month) {
		Payroll_month = payroll_month;
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
