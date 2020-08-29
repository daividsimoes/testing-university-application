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
<link rel="stylesheet" type="text/css" href="css/icons.css" />
<link rel="stylesheet" type="text/css" href="css/tooltip.css" />
<title>Students</title>
</head>
<body bgcolor="">

	<h1 align="center">${course.name}</h1>
	<div class="container">

		<c:url value="/main?action=StudentInformation" var="studentInfo" />
		<c:url value="/main?action=DeleteStudent" var="deleteStudent" />

		<c:if test="${not empty studentList}">

			<c:if test="${isFull eq true}">
					<b>Max number of student for this course!</b>
				</c:if>

			<c:import url="editstudentmodalform.jsp" />
			<ul class="w3-ul w3-hoverable">
				<c:forEach items="${studentList}" var="student">
					<li>${student.name}

						<button class="float-right black-letter-btn margin-left-10px"
								onclick="location.href='${deleteStudent}&courseId=${course.id}&studentRegistrationNumber=${student.registrationNumber}'">
							<i class="gg-trash tooltip"> 
								<span class="tooltiptext">Delete</span>
							</i>
						</button>

						<button class="float-right black-letter-btn margin-left-10px"
								onclick="document.getElementById('edit-student-modal').style.display='block'">
							<i class="gg-erase tooltip"> 
								<span class="tooltiptext">Edit</span>
							</i>
						</button>

						<button class="float-right black-letter-btn margin-left-10px"
								onclick="location.href='${studentInfo}&courseId=${course.id}&studentRegistrationNumber=${student.registrationNumber}'">
							<i class="gg-info tooltip"> 
								<span class="tooltiptext">Info</span>
							</i>
						</button>
					</li>
				</c:forEach>
			</ul>
		</c:if>
		
		<c:if test="${empty studentList}">
			<h5 align="left">There is no student in this course</h5>
		</c:if>

		<c:import url="addstudentmodalform.jsp" />

		<button class="w3-button w3-circle add-btn green-backgroud-btn float-right"
			onclick="document.getElementById('add-student-modal').style.display='block'">+</button>

		<c:import url="logout.jsp"></c:import>

		<c:url value="/main?action=CourseList" var="courseList" />
		<button class="go-back w3-button w3-tiny"
			onclick="location.href='${courseList}'">Go Back</button>
	</div>
</body>
</html>