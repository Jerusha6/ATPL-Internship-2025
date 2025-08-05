package com.aaslin.servlets;

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

import com.aaslin.util.DBConnection;

@WebServlet("/FetchPayroll")
public class FetchPayroll extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String fetch = "SELECT * FROM payrollInfo_jerusha WHERE employee_id=?";
        
        try {
            int empID = Integer.parseInt(request.getParameter("empID"));

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement fetchStmt = conn.prepareStatement(fetch)) {

                fetchStmt.setInt(1, empID);
                ResultSet rs = fetchStmt.executeQuery();

                if (!rs.isBeforeFirst()) {
                    out.println("<h2>No data found for Employee ID: " + empID + "</h2>");
                } else {
                    out.println("<h1>Hello! Here is your data</h1>");
                    out.println("<table border='1'>");
                    out.println("<tr>");
                    out.println("<th>Payroll ID</th>");
                    out.println("<th>Employee ID</th>");
                    out.println("<th>Payroll Month</th>");
                    out.println("<th>Base Salary</th>");
                    out.println("<th>Bonus</th>");
                    out.println("<th>Leaves</th>");
                    out.println("<th>Net Pay</th>");
                    out.println("<th>Paid Date</th>");
                    out.println("<th>Updated By</th>");
                    out.println("</tr>");

                    while (rs.next()) {
                        out.println("<tr>");
                        out.println("<td>" + rs.getInt("payroll_id") + "</td>");
                        out.println("<td>" + rs.getInt("employee_id") + "</td>");
                        out.println("<td>" + rs.getDate("payroll_month") + "</td>");
                        out.println("<td>" + rs.getDouble("base_salary") + "</td>");
                        out.println("<td>" + rs.getDouble("bonus") + "</td>");
                        out.println("<td>" + rs.getInt("leave_count") + "</td>");
                        out.println("<td>" + rs.getDouble("net_pay") + "</td>");
                        out.println("<td>" + rs.getDate("paid_date") + "</td>");
                        out.println("<td>" + rs.getString("updated_by") + "</td>");
                        out.println("</tr>");
                    }

                    out.println("</table>");
                    out.println("<a href='AdminView.html'>Go back</a>");
                    out.println("<a href='logout'>Logout</a>");
                }

                rs.close();
            }
        } catch (NumberFormatException e) {
            out.println("<h2>Invalid Employee ID format.</h2>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>Database error occurred.</h2>");
        }
    }
}