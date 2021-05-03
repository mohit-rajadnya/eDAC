<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!String message = "Hello!";//message : instance variable: implicitly private%>
<body>

<%
	int counter=100;//Counter : method local variable : _jspservice
	//add a page scope attr
	pageContext.setAttribute("attr1", 12345);
%>
<%-- Include test5.jsp --%>
<%@ include file="test5.jsp" %>
</body>
</html>