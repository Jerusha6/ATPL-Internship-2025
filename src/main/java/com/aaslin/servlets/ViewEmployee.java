package com.aaslin.servlets;

import com.aaslin.util.DBConnection;
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

@WebServlet("/viewEmployee")
public class ViewEmployee extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fetchQuery = "SELECT employee_id, employee_name, employee_email, employee_designation, "
                + "employee_contact, date_of_birth, created_at, created_by, updated_at, updated_by "
                + "FROM EmployeesInfo_jerusha WHERE employee_id = ? AND is_deleted = false";

        String deletedCheckQuery = "SELECT employee_id FROM EmployeesInfo_jerusha WHERE employee_id = ? AND is_deleted = true";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement fetchStmt = conn.prepareStatement(fetchQuery);
             PreparedStatement deletedStmt = conn.prepareStatement(deletedCheckQuery)) {

            int empID = Integer.parseInt(request.getParameter("empID"));
            HttpSession session = request.getSession();
            
            
            fetchStmt.setInt(1, empID);

            ResultSet rs = fetchStmt.executeQuery();
                if (rs.next()) {
                    out.println("<html><body>");
                    out.println("<h2>Employee Details</h2>");
                    out.println("<table border='1'>");
                    out.println("<tr><th>Employee ID</th><th>Employee Name</th><th>Employee Email</th>"
                            + "<th>Employee Designation</th><th>Employee Contact</th><th>Date of Birth</th>"
                            + "<th>Created At</th><th>Created By</th><th>Updated At</th><th>Updated By</th></tr>");

                    do {
                        out.println("<tr>");
                        out.println("<td>" + rs.getInt("employee_id") + "</td>");
                        out.println("<td>" + rs.getString("employee_name") + "</td>");
                        out.println("<td>" + rs.getString("employee_email") + "</td>");
                        out.println("<td>" + rs.getString("employee_designation") + "</td>");
                        out.println("<td>" + rs.getString("employee_contact") + "</td>");
                        out.println("<td>" + rs.getDate("date_of_birth") + "</td>");
                        out.println("<td>" + rs.getTimestamp("created_at") + "</td>");
                        out.println("<td>" + rs.getString("created_by") + "</td>");
                        out.println("<td>" + rs.getTimestamp("updated_at") + "</td>");
                        out.println("<td>" + rs.getString("updated_by") + "</td>");
                        out.println("</tr>");
                    } while (rs.next());

                    out.println("</table>");              
                    out.println("<br><form action='FetchPayroll' method='get'><input type=hidden name='empID' value="+empID+"><input type='submit' value='Fetch Payroll details'></form>");
                    out.println("<br><form action='EditEmployeePayroll.jsp' method='get'><input type=hidden name='empID' value="+empID+"><input type='submit' value='Edit Payroll'></form>");
                    out.print("<a href='AdminView.html'>Go back</a>");
                    out.print("<a href='logout'>Logout</a>");
                    out.println("</body></html>");
                } else {
                    deletedStmt.setInt(1, empID);
                    try (ResultSet deletedRS = deletedStmt.executeQuery()) {
                        out.println("<html><body>");
                        if (deletedRS.next()) {
                            out.println("<h3>Employee with ID " + empID + " is terminated</h3>");
                        } else {
                            out.println("<h3>No such employee found</h3>");
                        }
                        out.println("</body></html>");
                    }
                }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error while processing the request");
        }
    }
}
