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
		<title>Courses</title>
	</head>
	<body bgcolor="">
		<h1 align="center">Welcome to Testing University</h1>
		<div class="container">
			<c:url value="/main?action=CourseInformation" var="courseInfo" />
			<c:url value="/main?action=EditCourseInformation" var="editCourseInfo" />
			<c:url value="/main?action=StudentList" var="studentList" />
			<c:url value="/main?action=DeleteCourse" var="deleteCourse" />
			
			<c:if test="${not empty courseList}">
				<c:import url="editcoursemodalform.jsp" />
				<ul class="w3-ul w3-hoverable">
					<c:forEach items="${courseList}" var="course">
						<li>${course.name}
							<button class="float-right black-letter-btn margin-left-10px" 
									onclick="location.href='${deleteCourse}&courseId=${course.id}'">
								<i class="gg-trash tooltip">
									<span class="tooltiptext">Delete</span>
								</i>
							</button>
							
							<button class="float-right black-letter-btn margin-left-10px"
									onclick="location.href='${studentList}&courseId=${course.id}'">
								<i class="gg-user-list tooltip">
									<span class="tooltiptext">Students</span>
								</i>
							</button>
							
							<button class="float-right black-letter-btn margin-left-10px"
									onclick="document.getElementById('edit-course-modal').style.display='block'">
								<i class="gg-erase tooltip">
									<span class="tooltiptext">Edit</span>
								</i>
							</button>
							
							<button class="float-right black-letter-btn margin-left-10px"
									onclick="location.href='${courseInfo}&courseId=${course.id}'">
								<i class="gg-info tooltip">
									<span class="tooltiptext">Info</span>
								</i>
							</button>
						</li> 
					</c:forEach>
				</ul>
			</c:if>
			
			<c:if test="${empty courseList}">
				<h5 align="left">There is no course in the system</h5>
			</c:if>
			
			<c:import url="addcoursemodalform.jsp" />
			<button class="w3-button w3-circle add-btn green-backgroud-btn float-right"
				onclick="document.getElementById('add-course-modal').style.display='block'">+</button>
	
			<c:import url="logout.jsp"></c:import>
		</div>
	</body>
</html>