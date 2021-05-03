<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>

<h5>from log out page</h5>
<h5>Session id : ${pageContext.session.id}</h5>
<h5>Hello , ${sessionScope.user_details.uname}</h5>
<%
	session.invalidate();
%>

<h5>Go to <a href='login.jsp'> login page</a></h5>
</body>
</html>