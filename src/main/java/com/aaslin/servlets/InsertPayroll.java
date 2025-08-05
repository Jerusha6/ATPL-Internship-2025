package com.aaslin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaslin.util.DBConnection;


@WebServlet("/insertPayrollToDB")
public class InsertPayroll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String updatedBy = (String) session.getAttribute("username");
//		out.print(" admin "+updatedBy);
		
		int empID = Integer.parseInt(request.getParameter("empID"));
//		out.print(" empID "+empID);
		String payrollDate = request.getParameter("payrollDate");
		LocalDate payrollMon = LocalDate.parse(payrollDate);
//		out.print(" payrollMon "+java.sql.Date.valueOf(payrollMon));
		double bonus=0; 
		String ifBonus = request.getParameter("bonus");
		if(ifBonus!=null && !ifBonus.isEmpty()) {
			bonus = Double.parseDouble(ifBonus);
		}
//		out.print(" bonus "+bonus);
		String leave_count = request.getParameter("leaveCount");
		int leaves =0;
		if(leave_count!=null && !leave_count.isEmpty()) {
			leaves = Integer.parseInt(leave_count);
		}
//		out.print(" leaves "+leaves);
		
		String paidDate = request.getParameter("paidDate");
		LocalDate paidDates = LocalDate.parse(paidDate);
		
//		out.print(" paidDates "+java.sql.Date.valueOf(paidDates));
		
		double netPay = 0;
		double baseSalary = 0;
		String base_salary = "select s.salary_amount from salaryHistory_jerusha s inner join EmployeesInfo_jerusha e on s.employee_id = e.employee_id where e.is_deleted=false and s.employee_id = ?;";
		String insert = "insert into payrollInfo_jerusha(employee_id,payroll_month,base_salary,bonus,leave_count,net_pay,paid_date,updated_by) values(?,?,?,?,?,?,?,?);";
		try (Connection conn = DBConnection.getConnection();
		         PreparedStatement baseSal = conn.prepareStatement(base_salary);
				 PreparedStatement insertTo = conn.prepareStatement(insert)){
					baseSal.setInt(1, empID);
		        	  ResultSet rs = baseSal.executeQuery();
		              if (rs.next()) {
		                  baseSalary = rs.getDouble("salary_amount");
		                  netPay = baseSalary - (leaves*(baseSalary)/30)+bonus;
		                  }
//		              out.print(" baseSalary "+baseSalary);
//		              out.print(" netPay "+netPay);
		              insertTo.setInt(1,empID);
		              insertTo.setDate(2, java.sql.Date.valueOf(payrollMon));
		              insertTo.setDouble(3, baseSalary);
		              insertTo.setDouble(4, bonus);
		              insertTo.setInt(5,leaves);
		              insertTo.setDouble(6,netPay);
		              insertTo.setDate(7, java.sql.Date.valueOf(paidDates));
		              insertTo.setString(8, updatedBy);
		              
		              insertTo.executeUpdate();
		              
		              out.print("Inserted successfully");
		              out.print("<html><body><br><a href='AdminView.html'>Go Back</a></body></html>");
		              rs.close();
		         } catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

}
