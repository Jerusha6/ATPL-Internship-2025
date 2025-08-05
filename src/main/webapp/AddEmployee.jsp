<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>
<h1>Add Employee</h1>

<form action="addEmployee" method="post">

<label>Enter employee name</label>
<input type = "text" name="EmpName"><br><br>
<label>Enter employee email</label>
<input type = "email" name="EmpEmail"><br><br>
<label>Enter employee designation</label>
<select name = "Designation">
<option value="HR">HR</option>
<option value="SDE Intern">SDE Intern</option>
<option value="SDE">SDE</option>
<option value="Senior Developer">Senior Developer</option>
<option value="IT Manager">IT Manager</option>
<option value="Database administrator">Database administrator</option>
<option value="Admin">Admin</option>
</select><br><br>
<label>Enter employee contact</label>
<input type = "text" name="contact"><br><br>
<label>Set employee default password</label>
<input type="password" name="password"><br><br>
<label>Enter employee Date of birth</label>
<input type = "date" name="EmpDOB"><br><br>
<input type="submit" value="Add and Generate Employee ID"><br><br>

</form>
<a href="AdminView.html">Go back</a><br><br>
<a href='logout'>Logout</a>
</body>
</html>