<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/w3.css" />
		<link rel="stylesheet" type="text/css" href="css/forms.css" />
		<link rel="stylesheet" type="text/css" href="css/buttons.css" />
<link rel="stylesheet" type="text/css" href="css/modal.css" />
<title>Courses</title>
</head>
<body bgcolor="">

	<h1 align="center">${course.name}</h1>
	<div class="container">
		
		<h1 align="center">Sorry, this course already contains ${course.studentNumber} students</h1>
		<c:import url="logout.jsp"></c:import>
		
		<c:url value="/main?action=StudentList" var="studentlist" />
		<button class="go-back w3-button w3-tiny" 
			onclick="location.href='${studentlist}&courseId=${course.id}'">Go Back</button>
	</div>
</body>
</html>