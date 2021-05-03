<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%-- import spring supplied jsp tag lib --%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor List</title>
</head>
<body>
<h5>Last Action Status : ${requestScope.message}</h5>
<table style="align:centre;" border=1>
	<caption>Vendor list</caption>
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Reg Amount</th>
		<th>Reg Date</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="v" items="${requestScope.vList}">
	<tr>
		<td>${v.name}</td>
		<td>${v.email}</td>
		<td>${v.regAmount}</td>
		<td>${v.regDate}</td>
		<td><a href="<spring:url value='/admin/update?vid=${v.id}'/>">Update</a></td>
		<td><a href="<spring:url value='/admin/delete?vid=${v.id}'/>">Delete</a></td>
		
	
	</tr>
	</c:forEach>
</table>
	<h4 align="center">
		<a href="<spring:url value='/admin/register'/>">Add a Vendor!!</a>
	</h4>
	<h4 align="center">
		<a href="<spring:url value='/user/logout'/>">Logout!!</a>
	</h4>
</body>
</html>