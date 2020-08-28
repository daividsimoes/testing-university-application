<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="edit-course-modal" class="w3-modal">
	<div class="w3-modal-content">
	    <div class="modal-header">
		    <h2 align="center">Edit Course Information</h2>
 	    </div>
		<div class="w3-container">
			<span
				onclick="document.getElementById('edit-course-modal').style.display='none'"
				class="w3-button w3-display-topright">&times;</span>
			<c:url value="main?action=EditCourseInformation&courseId=${course.id}" 
				var="editCourse" />

			<form action="${editCourse}" class="container border-style-none" method="post">
				<label for="edit-course-name">Course Name</label> 
				<input type="text" pattern="[A-za-z ]+" id="edit-course-name" name="course-name" 
					oninvalid="this.setCustomValidity('Enter a valid name')"
	    			oninput="this.setCustomValidity('')" placeholder="Enter name" required> 
				
				<label for="edit-course-max-students">Number of Students</label> 
				<input type="text" pattern="[1-9]+" id="edit-course-max-students" name="course-max-students" 
					oninvalid="this.setCustomValidity('Enter a valid number of students')"
	    			oninput="this.setCustomValidity('')" placeholder="Enter number of students" required>
    			
    			<label for="edit-course-load">Course Duration</label> 
				<select id="edit-course-load" name="course-load">
					<option value="1">1 Year</option>
					<option value="2">2 Years</option>
					<option value="3">3 Years</option>
					<option value="4">4 Years</option>
					<option value="5">5 Years</option>
				</select>
				<input type="submit" value="Submit">
			</form>
		</div>
	</div>
</div>