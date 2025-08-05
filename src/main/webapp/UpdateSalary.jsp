<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    int empID = (Integer) request.getAttribute("empID");
%>
<html>
<body>
<h3>Employee added successfully!</h3>
<p>Generated Employee ID: <strong><%= empID %></strong></p>

<form action="UpdateSalary" method="post">
    <input type="hidden" name="empID" value="<%= empID %>">
    <label>Enter employee salary amount</label>
    <input type="text" name="empSalary"><br><br>
    <label>Enter employee salary start date</label>
    <input type="date" name="empSalaryDate"><br><br>
    <input type="submit" value="Update"><br><br>
</form>

<a href='AdminView.html'>Go back</a>
<br><br><a href='logout'>Logout</a>
</body>
</html>
