package com.aaslin.servlets;

import com.aaslin.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminAccess extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	PrintWriter out = response.getWriter();
  	
    	String sql = "Select * from adminInfo_jerusha;";
    	
        try {
        	
        	Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet set = ps.executeQuery();
            out.println("Here is your Data: ");
            
            while (set.next()) { 
            	out.print(set.getInt(1)+" ");
            	out.print(set.getString(2)+" ");
            	out.print(set.getString(3)+" ");
            	out.print(set.getInt(4)+" ");
            	out.print(set.getString(5)+" ");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

}