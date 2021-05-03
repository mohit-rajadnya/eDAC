<%@page import="pojos.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5>From details page</h5>
<h5>Validated User Details :- ${requestScope.user_details}</h5>
<%
	User u = (User)request.getAttribute("user_details");
	session.setAttribute("User", u);	
%>


<h5>Click <a href='logout.jsp'> here</a> to log out!</h5>
 
 
</body>
</html>