<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="prod" class="beans.ProductBean" scope="application"/>

<body>
<!--  
<h5>Product List: ${applicationScope.prod.products}</h5>
-->
		<table style="background-color: cyan; margin: auto;">
			<caption>Product List</caption>
			<tr>
				<th>Product ID</th>
				<th>Name</th>
				<th>Price</th>				
			</tr>
			<c:forEach var="p" items="${applicationScope.prod.products}">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>