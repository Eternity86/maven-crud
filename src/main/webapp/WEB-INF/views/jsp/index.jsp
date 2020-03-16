<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC CRUD Demo</title>
</head>
<body>
	<img width="24" height="24" border="0"
		src="<c:url value="/resources/img/add_user_male.png" />" alt="" /> 
	<a href="empform">Add Employee</a>
	&nbsp;
	<img width="24" height="24" border="0"
		src="<c:url value="/resources/img/find_user_male.png" />" alt="" /> 
	<a href="viewemp">View Employees</a>
</body>
</html>