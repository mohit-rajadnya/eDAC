<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%-- import spring supplied jsp tag lib --%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="align:centre;">
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
		<td><a href="<spring:url value='/admin/update?v.id=${v.id}'/>">Update</a></td>
		<td><a href="">Delete</a></td>
		
	
	</tr>
	</c:forEach>
</table>
</body>
</html>