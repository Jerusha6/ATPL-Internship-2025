package com.aaslin.EmployeeManagementSystemUsingSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.EmployeeManagementSystemUsingSpringBoot.model.Payroll;
import com.aaslin.EmployeeManagementSystemUsingSpringBoot.repository.PayrollRepository;

@Service
public class PayrollService {

	@Autowired
	PayrollRepository payrollRepo;
	public List<Payroll> fetchALlPayroll() {
		return payrollRepo.findAll();
	}
	
	public List<Payroll> fetchPayrollById(String empId) {
		return payrollRepo.fetchPayrollById(empId);
	}
	
	public Payroll editPayroll(int id, Payroll payroll) {	
	  
	    Payroll existingPayroll = payrollRepo.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));
	    existingPayroll.setBaseSalary(payroll.getBaseSalary());
	    existingPayroll.setBonus(payroll.getBonus());
	    existingPayroll.setLeaveCount(payroll.getLeaveCount());
	    existingPayroll.setNetPay(payroll.getNetPay());
	    existingPayroll.setPaidDate(payroll.getPaidDate());
	    existingPayroll.setPayrollMonth(payroll.getPayrollMonth());
	    existingPayroll.setUpdatedBy(payroll.getUpdatedBy());
	    
	    return payrollRepo.save(existingPayroll);
	}

	public Payroll savePayroll(Payroll payroll, String currentUser) {
        payroll.setUpdatedBy(currentUser);
        double netPay = payroll.getBaseSalary() + payroll.getBonus();
        
        netPay -= payroll.getLeaveCount() * 500;

        payroll.setNetPay(netPay);

        return payrollRepo.save(payroll);
    }


}
