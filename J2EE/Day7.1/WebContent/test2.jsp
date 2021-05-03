<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--display values of 4 different attributes : using EL syntax--%>
	<h5>Page Scoped Attribute : ${pageScope.attr1}</h5>
	<h5>Request Scoped Attribute : ${requestScope.attr2}</h5>
	<h5>Session Scoped Attribute : ${sessionScope.attr3}</h5>
	<h5>Application Scoped Attribute : ${applicationScope.attr4}</h5>

</body>
</html>