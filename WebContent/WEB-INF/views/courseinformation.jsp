<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/w3.css" />
		<link rel="stylesheet" type="text/css" href="css/forms.css" />
		<link rel="stylesheet" type="text/css" href="css/buttons.css" />
		<link rel="stylesheet" type="text/css" href="css/modal.css" />
		<title>Course Information</title>
	</head>
	<body bgcolor="">
		<h1 align="center">Course Information</h1>
		<div class="container">
			<div>
				<label for="course-info-name">Course Name </label> 
				<input type="text" id="course-info-name" name="course-name" value="${course.name}" readonly /> 
				<br /> 
				<br />
				<label for="course-info-num-students">Number of Students in this Course </label> 
				<input type="text" id="course-info-num-students" name="course-num-students" value="${fn:length(course.students)}" readonly /> 
				<br /> 
				<br />
				<label for="course-info-max-students">Max Number of Students </label>
				<input type="text" id="course-info-max-students" name="course-max-students" value="${course.studentNumber}" readonly /> 
				<br /> 
				<br />
				<label for="course-info-load">Course Duration </label> 
				<input type="text" id="course-info-load" name="course-load" value="${course.courseLoad}" readonly />
			</div>
	
			<c:import url="logout.jsp" />
			
			<c:url value="/main?action=CourseList" var="courseList"/>
			<button class="go-back w3-button w3-tiny" onclick="location.href='${courseList}'">Go Back</button>
			
			<c:import url="editcoursemodalform.jsp" />
			<button class="w3-button w3-tiny large-btn green-backgroud-btn edit-info-btn" 
				onclick="document.getElementById('edit-course-modal').style.display='block'">Edit</button>
		</div>
	</body>
</html>