package com.aaslin.servlets;

import com.aaslin.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
	
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false); 
		String createdBy = (String) session.getAttribute("username");
		
		
		String name = request.getParameter("EmpName");
		String email = request.getParameter("EmpEmail");
		String designation = request.getParameter("Designation");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		String DOB = request.getParameter("EmpDOB");
		LocalDate dateOfBirth = LocalDate.parse(DOB);
	
		
		String insertEmpData = "insert into EmployeesInfo_jerusha(employee_name, employee_email, employee_designation, employee_contact, employee_password, date_of_birth, created_by, updated_by) values(?,?,?,?,?,?,?,?);";	
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement addEmp = conn.prepareStatement(insertEmpData, Statement.RETURN_GENERATED_KEYS);	
					){
			
						
			addEmp.setString(1,name);
			addEmp.setString(2,email);
			addEmp.setString(3,designation);
			addEmp.setString(4, contact);
			addEmp.setString(5, password);
			addEmp.setDate(6, java.sql.Date.valueOf(dateOfBirth));
			addEmp.setString(7, createdBy);
			addEmp.setString(8, createdBy);
			
			addEmp.executeUpdate();
			
			
			response.setContentType("text/html");

			out.println("<html><body>");
			out.println("<h3>Employee added successfully!</h3>");

			ResultSet generatedKeys = addEmp.getGeneratedKeys();
			int Id;
			if (generatedKeys.next()) {
			    Id = generatedKeys.getInt(1);
			    request.setAttribute("empID",Id);
			    RequestDispatcher rd = request.getRequestDispatcher("UpdateSalary.jsp");
			    rd.forward(request, response);
			    out.println("<p>Generated Employee ID: <strong>" + Id + "</strong></p>");
			}
			

			out.println("</body></html>");
			generatedKeys.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}	
}
}