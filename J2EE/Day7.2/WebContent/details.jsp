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
<h5>Validated User Details :- ${sessionScope.user_details}</h5>
<%
	String url = response.encodeRedirectURL("logout.jsp");
%>

<h5>Click <a href='<%= url%>'> here</a> to log out!</h5>
 
 
</body>
</html>