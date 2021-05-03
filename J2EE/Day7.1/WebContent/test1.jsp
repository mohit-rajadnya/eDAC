<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--add/store/set 4 different attributes under 4 different scopes --%>
	<%
		pageContext.setAttribute("attr1", 1234);
	request.setAttribute("attr2", 1235);
	session.setAttribute("attr3", 1236);
	application.setAttribute("attr4", 1237);
	//navigate the clnt to the next page (test2.jsp) in the SAME request : server pull : forward
	/*RequestDispatcher rd=request.getRequestDispatcher("test2.jsp");
	rd.forward(request, response);	*/
	response.sendRedirect("test2.jsp");
	%>
</body>
</html>