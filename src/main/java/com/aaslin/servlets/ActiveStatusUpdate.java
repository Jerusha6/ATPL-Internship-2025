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

public class ActiveStatusUpdate extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	       
	        response.setContentType("text/html;");
	        PrintWriter out = response.getWriter();
	        out.println("<html>"
	                + "<body>"
	                + "<form method='POST' action='activeStatusUpdate'>"
	                + "<label>Enter your adminID: </label>"
	                + "<input type='number' name='id' required><br><br>"
	                + "<label>Enter your name: </label>"
	                + "<input type='text' name='name' required><br><br>"
	                + "<label>Enter active status(0/1): </label>"
	                + "<input type='number' name='activeStatus' min='0' max='1' required><br><br>"+ "<input type='submit'>"
	                + "</form>"
	                + "</body>"
	                + "</html>");
	        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	                throws ServletException, IOException { 
    	
    	
    	response.setContentType("text/html;");
	        try {
				Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("Update adminInfo_jerusha set isActive = ? where adminID = ? and name = ?");
				
			
				ps.setInt(1,Integer.parseInt(request.getParameter("activeStatus")));
				ps.setInt(2, Integer.parseInt(request.getParameter("id")));
				ps.setString(3, request.getParameter("name"));
				ps.executeUpdate();
				response.getWriter().println("Status updated successfully");
				
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				response.getWriter().println("Error: " + e.getMessage());
			}
	        
	        
	    	   
	}
}
