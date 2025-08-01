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

public class AllUserInfo extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	response.setContentType("text/html; charset=UTF-8");
        
        String sql = "select * from userInfo_jerusha;";
        try {
        	
        	Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet set = ps.executeQuery();
            response.getWriter().println("<h2>Here is your Data: </h2>");
            
            while (set.next()) { 
            	response.getWriter().print("<html>"
                        + "<body>"
                        + "<table border='1'>"
                        + "<tr>"
                        + "<th>ID</th>"
                        + "<th>NAME</th>"
                        + "<th>ROLE</th>"
                        + "<th>AGE</th>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>" + set.getInt(1) + "</td>"
                        + "<td>" + set.getString(2) + "</td>"
                        + "<td>" + set.getString(3) + "</td>"
                        + "<td>" + set.getInt(4) + "</td>"
                        + "</tr>"
                        + "</table>"
                        + "</body>"
                        + "</html>");
            }

            
            ps.close();
            con.close();
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

}