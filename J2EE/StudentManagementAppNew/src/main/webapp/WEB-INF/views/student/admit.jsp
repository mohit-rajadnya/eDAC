<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Admit Student</title>
</head>
<body>
	 <div class="alert alert-danger text-center" >
	    ${requestScope.message}
	</div>
	<h3 style="text-align: center;">Enter student details : </h3>
	<form:form method="post" modelAttribute="students" class="form">
		<div class="row">
            <div class="col-lg-4"></div>
            <div class="form-group col-lg-4">
                <label>Enter your Name</label>
                <form:input path="name" class="form-control" />
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="form-group col-lg-4">
                <label>Enter address</label>
                <form:input path="address" class="form-control" />
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="form-group col-lg-4">
                <label>Enter DOB</label>
                <form:input type="date" path="DOB" class="form-control" />
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="form-group col-lg-4">
                <label>Enter CGPA</label>
                <form:input type="number" path="CGPA" class="form-control" />
            </div>
        </div>
        <div class="text-center">
        <button type="submit" class="btn btn-primary" >Admit</button>
        </div>
        
	</form:form>
</body>
</html>
 