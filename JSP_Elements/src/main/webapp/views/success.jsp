<%@page import="com.java.wipro.pojo.Employee"%>
<%@ page language="java"  isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Success JSP Page</h1>
	
	JSP Scriplet
	------------- 
	
	<br>
	
	<% 
		Employee emp = (Employee) session.getAttribute("e1");
		out.print(emp);
		
		//jdbc insert code from servlet
	%>
	
	<br>
	
	JSP Expression
	---------------
	
	<br>
	
	<%= session.getAttribute("e1") %>
	
	<br>
	
	JSP Action Tag
	---------------
	
	<br>
	
	<jsp:useBean id="e1" class="com.java.wipro.pojo.Employee" scope="session"></jsp:useBean>
	
	<jsp:getProperty property="empno" name="e1"/>
	<jsp:getProperty property="ename" name="e1"/>
	<jsp:getProperty property="al" name="e1"/>
	
	<br>
	
	
	EL - Expression
	----------------
	 <br> 
	 
	${ e1 }
	
	
	
	
	
</body>
</html>