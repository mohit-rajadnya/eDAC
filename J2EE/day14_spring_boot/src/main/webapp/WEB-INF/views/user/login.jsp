<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5 align="center">${requestScope.message}</h5>
	<form method="post">
		<table>
			<tr>
				<td>User Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>User Password</td>
				<td><input type="password" name="pass" /></td>
				<td><input type="hidden" name="cmd" value="login" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>

</body>
</html>