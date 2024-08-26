<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="logout">Logout</a></h1>
	<table border="2">
	
	<tr>
	<th>ROLLNO</th>
	<th>NAME</th>
	<th>USERNAME</th>
	<th>PASSWORD</th>
	<th>Action</th>
	</tr>
	<c:forEach items="${data}" var="s">
	
	<tr>
	<td>${s.rollno}</td>
	<td>${s.name}</td>
	<td>${s.username}</td>
	<td>${s.password}</td>
	<td><a href="delete?rollno=${s.rollno}">DELETE</a>||<a href="editdata?rollno=${s.rollno}">EDIT</a></td>
	
	</tr>
	</c:forEach>
</body>
</html>