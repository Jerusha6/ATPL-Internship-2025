<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Student Form</title>
</head>
<body>
    <h1>Update Student Information</h1>
    
    <h2>Update Student with ID: ${studentId}</h2>

    <form action="update" method="post">
        <input type="hidden" name="studentId" value="${studentId}" />
       	<label>Enter student name</label>
		<input type = "text" name="studentName" value="${student.studentName}"><br><br>
		<label>Enter student email</label>
		<input type = "text" name="email" value="${student.email}"><br><br>
		<label>Enter student age</label>
		<input type = "number" name="age" value="${student.age}"><br><br>
        <input type="submit" value="Update Student" />
    </form>

</body>
</html>
