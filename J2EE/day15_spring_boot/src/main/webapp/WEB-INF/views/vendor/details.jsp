<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 style="color:green;" align="center">${sessionScope.message} </h4>
	<h5 align="center">${sessionScope.user_details}</h5>
	<h5 align="center"><a href="<spring:url value='/user/logout'/>">LogOut</a></h5>
</body>
</html>