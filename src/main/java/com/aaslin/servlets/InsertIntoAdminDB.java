package com.aaslin.servlets;

import com.aaslin.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertIntoAdminDB extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	       
	        response.setContentType("text/html;");
	        PrintWriter out = response.getWriter();
	        out.println("<html>"
	                + "<body>"
	                + "<form method='post' action='insertIntoAdminDB'>"
	                + "<label>Enter your adminID: </label>"
	                + "<input type='number' name='id' required><br><br>"
	                + "<label>Enter your name: </label>"
	                + "<input type='text' name='name' required><br><br>"
	                + "<label>Enter your role: </label>"
	                + "<input type='text' name='role' required><br><br>"
	                + "<label>Enter your age: </label>"
	                + "<input type='number' name='age' required><br><br>"
	                + "<input type='submit'>"
	                + "</form>"
	                + "</body>"
	                + "</html>");
	        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException { 
    	
    	response.setContentType("text/html;");
	        try {
				Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into adminInfo_jerusha values(?,?,?,?)");
				ps.setInt(1, Integer.parseInt(request.getParameter("id")));
				ps.setString(2, request.getParameter("name"));
				ps.setString(3, request.getParameter("role"));
				ps.setInt(4, Integer.parseInt(request.getParameter("age")));
				ps.executeUpdate();
				response.getWriter().println("Data inserted successfully");
				
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				response.getWriter().println("Error: " + e.getMessage());
			}
	        
	        
	    	   
	}
}
