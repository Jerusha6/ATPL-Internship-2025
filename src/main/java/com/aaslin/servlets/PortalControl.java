package com.aaslin.servlets;

import com.aaslin.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/portalControl")
public class PortalControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter();

    	RequestDispatcher requestDispatcher;

        int empID = Integer.parseInt(request.getParameter("EmpID"));
        String searchPassword = "select employee_password, employee_name ,employee_designation from EmployeesInfo_jerusha where employee_id = ?;";

        
        String password = request.getParameter("password");

        try {
	        Connection conn = DBConnection.getConnection();
	        PreparedStatement searchEmp = conn.prepareStatement(searchPassword);
	        	
        	//out.print("db connected");
        	searchEmp.setInt(1, empID);

            ResultSet rs = searchEmp.executeQuery();
            

            if (rs.next()) {
            	
                String dbPassword = rs.getString("employee_password");
                String empName = rs.getString("employee_name");
                String designation = rs.getString("employee_designation");

                if (dbPassword.equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", empName);

                    if ("admin".equalsIgnoreCase(designation)) {
                        requestDispatcher = request.getRequestDispatcher("AdminView.html");
                    } else {
                        requestDispatcher = request.getRequestDispatcher("EmployeeView.jsp");
                    }
                    requestDispatcher.forward(request, response);
                } else {
                    response.sendRedirect("index.jsp?message=Incorrect+password");
                }
            } else {
                response.sendRedirect("index.jsp?message=Employee+not+found!");
            }
            searchEmp.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
