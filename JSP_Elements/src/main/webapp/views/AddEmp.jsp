<%@ page language="java" import= "com.java.wipro.pojo.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Employee JSP</h1>
	
	<jsp:useBean id="e1" class="com.java.wipro.pojo.Employee" scope="session"></jsp:useBean>
	
	<%-- <jsp:setProperty property="empno" name="e1" param="empno"/>
	<jsp:setProperty property="ename" name="e1" param="ename"/>
	<jsp:setProperty property="sal" name="e1" param="sal"/> --%>
	
	<jsp:setProperty property="*" name="e1" />
	
	<jsp:include page="success.jsp"></jsp:include>
	
</body>
</html>