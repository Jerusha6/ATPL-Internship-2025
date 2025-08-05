<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="com.aaslin.util.DBConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>
<%
    

        String fetch = "SELECT employee_id, employee_name, employee_email, employee_designation, "
                     + "employee_contact, date_of_birth, created_at, created_by, updated_at, updated_by "
                     + "FROM EmployeesInfo_jerusha where is_deleted=false;";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(fetch)) {
            ResultSet rs = pstmt.executeQuery();
%>

	<h1>Hello! Here is your data</h1>

    <table border="1">
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
            rs.close();
        } catch (Exception e) {
%>
    <p>Error: <%= e.getMessage() %></p>
<%
        }
%>

</table>

<br>
<a href="ViewTerminatedEmployees.jsp">View terminated employees</a><br><br>
<a href="AdminView.html">Go Back</a>
<br><br><a href='logout'>Logout</a>

</body>
</html>