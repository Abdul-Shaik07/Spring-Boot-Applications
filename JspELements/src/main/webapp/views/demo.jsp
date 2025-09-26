<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to jsp</h1>
	Hello friends <br>
	<% int x = 99;
	out.write("x value is "+x);
	%>
	<br>
	X value is in Expression: <%= x %>
</body>
</html>