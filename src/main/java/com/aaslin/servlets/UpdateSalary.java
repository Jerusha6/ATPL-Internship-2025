package com.aaslin.servlets;

import com.aaslin.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateSalary")
public class UpdateSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false); 
		String createdBy = (String) session.getAttribute("username");
	
		int empID = Integer.parseInt(request.getParameter("empID"));
		
		double salaryAmount = Double.parseDouble(request.getParameter("empSalary"));
		String salaryDate = request.getParameter("empSalaryDate");
		LocalDate salaryStartDate = LocalDate.parse(salaryDate);
		
		String insertEmpSalaryData = "insert into salaryHistory_jerusha(employee_id, salary_amount, salary_start_date, updated_by) values(?, ?, ?, ?);";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement addEmpSalary = conn.prepareStatement(insertEmpSalaryData, Statement.RETURN_GENERATED_KEYS);	
				){
			
			response.setContentType("text/html");

					
			
			addEmpSalary.setInt(1, empID);
			addEmpSalary.setDouble(2, salaryAmount);
			addEmpSalary.setDate(3, java.sql.Date.valueOf(salaryStartDate));
			addEmpSalary.setString(4, createdBy);
			
			addEmpSalary.executeUpdate();
			
			out.println("<html><body>");
			out.println("<h3>Salary updated successfully!</h3>");

			out.println("<a href='AdminView.html'>Go back</a>");

			out.println("</body></html>");
		
		} catch (SQLException e) {
		e.printStackTrace();
		}
}
}