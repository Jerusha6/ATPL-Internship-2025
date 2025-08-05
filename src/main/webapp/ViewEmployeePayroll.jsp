<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employee Payroll</title>
</head>
<body>
<form action="FetchPayroll" method="get">
<label>Enter Employee ID</label>
<input type="number" name="empID"><br><br>
<input type="submit" value="Fetch Payroll">
</form>
<br><br><a href='logout'>Logout</a>
</body>
</html>