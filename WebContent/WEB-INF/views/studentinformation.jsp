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
	
		<h1 align="center">Student Information</h1>
		<div class="container">
			
			<div>
				<label for="student-info-name">Student Name </label> 
				<input type="text" id="student-info-name" name="student-name" value="${student.name}" readonly /> 
				<br /> 
				<br />
				<label for="student-info-age">Student Age </label> 
				<input type="text" id="student-info-age" name="student-age" value="${student.age}" readonly /> 
				<br /> 
				<br />
				<label for="student-info-gender">Student Gender </label> 
				<input type="text" id="student-info-gender" name="student-gender" value="${student.gender}" readonly />
				<br /> 
				<br /> 
				<label for="student-info-email">Student Email </label> 
				<input type="text" id="student-info-email" name="student-email" value="${student.email}" readonly /> 
				<br /> 
				<br /> 
				<label for="student-info-registration-number">Student Registration Number </label> 
				<input type="text" id="student-info-registration-number" name="student-registration-number" value="${student.registrationNumber}" readonly />
			</div>
	
			<c:import url="logout.jsp" />
			
			<c:url value="/main?action=StudentList" var="studentlist" />
			<button class="go-back w3-button w3-tiny" 
				onclick="location.href='${studentlist}&courseId=${course.id}'">Go Back</button>
			
			<c:import url="editstudentmodalform.jsp" />
			<button class="w3-button w3-tiny large-btn green-backgroud-btn edit-info-btn" 
				onclick="document.getElementById('edit-student-modal').style.display='block'">Edit</button>
		</div>
	</body>
</html>