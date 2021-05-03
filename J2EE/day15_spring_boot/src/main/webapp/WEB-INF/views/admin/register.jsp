<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	 <!-- import for the form binding tech , spring supplied form tag lib -->
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5 align="center">${requestScope.message}</h5>

<!-- step 2 of data binding using spring lib -->
	<form:form method="post" modelAttribute="vendor_details">
		<table margin: auto;>
			<tr>
				<td>Enter User Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Enter User Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Enter User Password</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td>Enter User Reg Amount</td>
				<td><form:input path="regAmount" type="number" /></td>
			</tr>
			<tr>
				<td>Enter Reg Date</td>
				<td><form:input path="regDate" type="date" /></td>
			</tr>
			<tr>
				<td>Choose Payment Mode</td>
				<td><form:radiobuttons path="details.mode" items="${requestScope.payment_modes}"/></td>			
			</tr>
			<tr>
				<td>Enter Payment Amount</td>
				<td><form:input path="details.amount" type="number" /></td>
			</tr>
			<tr>
				<td>Enter Payment Date</td>
				<td><form:input path="details.paymentDate" type="date" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>