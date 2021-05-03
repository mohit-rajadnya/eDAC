<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- import spring supplied jsp tag library for url rewriting --%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome to Spring MVC!</h4>
	<h5><a href="<spring:url value='/user/login'/>">User Login</a></h5>
</body>