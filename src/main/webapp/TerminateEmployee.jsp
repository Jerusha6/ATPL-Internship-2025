<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Terminate Employee</title>
</head>
<body>
<h2>Terminate Employee</h2>
<form action="terminateEmployee" method="post">
<label>Enter Employee ID</label>
<input type="number" name="empID"><br><br>
<input type="submit" value="Terminate">
</form>
<br><br><a href='AdminView.html'>Go back</a>
<br><br><a href='logout'>Logout</a>
</body>
</html>