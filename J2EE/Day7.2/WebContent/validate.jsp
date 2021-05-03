<%@page import="pojos.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!
	private String uname;
	private String password;
	
	public void jspInit()
	{
		uname = "abc";
		password = "1234";
	}
	
%>
<body>

<%
		if(request.getParameter("em").equals(uname) && request.getParameter("pass").equals(password))
		{
			
			session.setAttribute("user_details", new User(uname , password));
			response.sendRedirect(response.encodeRedirectURL("details.jsp"));

			
		}
		else{		
%>
		<h5 style="color:red;">Failed to login..., Please <a href="login.jsp">retry</a></h5>
<%
		}
%>
</body>
</html>