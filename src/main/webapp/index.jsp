<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>

<%
String msg = request.getParameter("message");
if(msg!=null)
response.getWriter().println(msg);
%>

<h1>Welcome to AASLIN! Sign In</h1>
<form action="portalControl" method="post">
<label>Enter your employee ID</label>
<input type = "number" name="EmpID" REQUIRED><br><br>
<label>Enter your password</label>
<input type="password" name="password" REQUIRED><br><br>
<input type="submit" value="Sign In"><br><br>
</form>
</body>
</html>