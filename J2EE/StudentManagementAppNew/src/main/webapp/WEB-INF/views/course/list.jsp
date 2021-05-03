<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Display Courses</title>
</head>
<body class="container-fluid">
	 <div class="alert alert-success text-center" >
	    ${requestScope.message}
	</div>
	<div class="row">
		 <div class="col-lg-4"></div>
		  <div class="col-lg-4">
			<table class="table table-striped">
				<tr>
					<th>Name</th>
				</tr>
				<c:forEach var="c" items="${requestScope.course_list}">
					<tr>
						<td>${c.name}</td> 
						<td><a href="<s:url value='/course/delete?cid=${c.id}'/>">Delete</a></td>
						<td><a href="<s:url value='/student/admit?cid=${c.id}'/>">Admit Student</a></td>
					</tr>
					
				</c:forEach>
				
			</table>
		</div>
	</div>
</body>
</html>