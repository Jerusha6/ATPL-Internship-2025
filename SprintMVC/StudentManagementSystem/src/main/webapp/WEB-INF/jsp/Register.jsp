<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<h1>Hello, Please register here!</h1>

<form action="add" method="post">
<!-- These name attribute values should match with the instance variables in the Student POJO, so that ModelAttribute could work-->	
	<label>Enter student ID</label>		
	<input type="text" name="studentId">
	<label>Enter student name</label>
	<input type = "text" name="studentName" required ><br><br>
	<label>Enter student email</label>
	<input type = "text" name="email" required ><br><br>
	<label>Enter student age</label>
	<input type = "number" name="age" required ><br><br>
	<input type="submit">
</form>
</body>
</html>