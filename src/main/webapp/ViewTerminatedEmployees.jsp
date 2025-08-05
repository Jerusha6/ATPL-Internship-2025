<%@ page import="java.sql.*" %>
<%@ page import="com.aaslin.util.DBConnection" %>
<%@ page contentType="text/html;" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Terminated Employees</title>
</head>
<body>

<h2>Terminated Employee Details</h2>

<%
    String fetch = "SELECT employee_id, employee_name, employee_email, employee_designation, employee_contact, date_of_birth, created_at, created_by, updated_at, updated_by FROM EmployeesInfo_jerusha WHERE is_deleted = true";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(fetch);
        ResultSet rs = stmt.executeQuery();
    ) {
%>
    <table border=1>
        <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Employee Email</th>
            <th>Employee Designation</th>
            <th>Employee Contact</th>
            <th>Date of Birth</th>
            <th>Created At</th>
            <th>Created By</th>
            <th>Updated At</th>
            <th>Updated By</th>
        </tr>
<%
        while (rs.next()) {
%>
        <tr>
            <td><%= rs.getInt("employee_id") %></td>
            <td><%= rs.getString("employee_name") %></td>
            <td><%= rs.getString("employee_email") %></td>
            <td><%= rs.getString("employee_designation") %></td>
            <td><%= rs.getString("employee_contact") %></td>
            <td><%= rs.getDate("date_of_birth") %></td>
            <td><%= rs.getDate("created_at") %></td>
            <td><%= rs.getString("created_by") %></td>
            <td><%= rs.getDate("updated_at") %></td>
            <td><%= rs.getString("updated_by") %></td>
        </tr>
<%
        }
    } catch (Exception e) {
        out.println("<p>Error: " + e.getMessage() + "</p>");
        e.printStackTrace();
    }
%>
    </table>

    <br>
    <a href="ViewEmployeePayroll.jsp">View PayRoll</a>
	<br>
	<a href="AdminView.html">Go back</a>
	<br><br><a href='logout'>Logout</a>
</body>
</html>
