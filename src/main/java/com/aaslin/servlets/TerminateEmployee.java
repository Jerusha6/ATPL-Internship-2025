package com.aaslin.servlets;

import com.aaslin.util.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/terminateEmployee")
public class TerminateEmployee extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String terminateQuery = "update EmployeesInfo_jerusha set is_deleted = true where employee_id = ?";

        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement terminateStmt = conn.prepareStatement(terminateQuery)) {

            int empID = Integer.parseInt(request.getParameter("empID"));
            terminateStmt.setInt(1, empID);

           terminateStmt.executeUpdate();
           out.print("Employee with ID "+empID+" is terminated");
           
           out.print("<a href='AdminView.html'>Go Back</a>");

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error while processing the request");
        }
    }
}
