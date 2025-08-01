package com.aaslin.servlets;

import com.aaslin.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sql = "INSERT INTO userInfo_Jerusha VALUES (?, ?, ?, ?);";
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        int age = Integer.parseInt(request.getParameter("age"));
        response.setContentType("text/html");

        try {
        	
        	Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, role);
            ps.setInt(4, age);
            ps.executeUpdate();
            response.getWriter().println("<h2>Data inserted successfully!</h2>");
            ps.close();
            con.close();
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>"
                + "<body>"
                + "<form method='post' action='toDB'>"
                + "<label>Enter your userID: </label>"
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
}