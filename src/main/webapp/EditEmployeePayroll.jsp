<%@ page import="java.sql.*" %>
<%@ page import="com.aaslin.util.DBConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee Payroll</title>
</head>
<body>
<%   
    int empID = Integer.parseInt(request.getParameter("empID"));
    String admin = (String) session.getAttribute("username");
    out.println("<h3>Employee ID: "+empID+"</h3>");
    String fetchQuery = "select s.salary_amount from salaryHistory_jerusha s inner join EmployeesInfo_jerusha e on s.employee_id = e.employee_id where e.is_deleted=false and s.employee_id = ?;";
    String deletedCheckQuery = "SELECT employee_id FROM EmployeesInfo_jerusha WHERE employee_id = ? AND is_deleted = true";

    double baseSalary = 0;

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(fetchQuery);
        		 PreparedStatement deletedStmt = conn.prepareStatement(deletedCheckQuery)) {

        pstmt.setInt(1, empID);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            baseSalary = rs.getDouble("salary_amount");
            out.println("<h2>Employee base salary: " + baseSalary + "</h2>");
            %>
            
<form action="insertPayrollToDB" method="post">
  
    <input type="hidden" name="empID" value="<%= empID %>">

    <label>Enter payroll month:</label>
    <input type="date" name="payrollDate" required><br><br>

    <label>Enter bonus if any (optional):</label>
    <input type="number" name="bonus" step="any"><br><br>

    <label>Increment leave if any (optional):</label>
    <input type="number" name="leaveCount"><br><br>

    <label>Enter salary paid date:</label>
    <input type="date" name="paidDate" required><br><br>

    <input type="submit" value="Submit Payroll">
</form>
            <%
        }else {
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
    }
%>
<a href="AdminView.html">Go back</a>
<br><br><a href='logout'>Logout</a>
</body>
</html>
