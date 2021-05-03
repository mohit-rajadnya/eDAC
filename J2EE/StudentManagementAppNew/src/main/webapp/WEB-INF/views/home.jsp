<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
    .jumbotron{background-color: lightseagreen;}
    body{background-color: lightblue;}
</style>
<title>Home Page</title>
</head>
<body class="container">
    <div class="jumbotron">
        <h1 align="center">Student Management App Welcomes You</h1>
    </div>
    <div class="text-center">
	<a href= "<s:url value='/course/list'/>" class="btn btn-primary btn-lg" >Choose Course</a><br><br><br>
	
	</div>
</body>
</html>