<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employee</title>
</head>
<body>
<form action="viewEmployee" method="get">
<label>Enter employee ID</label>
<input type="text" name="empID"><br><br>
<input type="submit" value="Fetch details">
<br><br><a href='logout'>Logout</a>
</form>
</body>
</html>