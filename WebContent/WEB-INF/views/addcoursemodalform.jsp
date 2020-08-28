<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="add-course-modal" class="w3-modal">
	<div class="w3-modal-content">
		<div class="modal-header">
		    <h2 align="center">Add New Course</h2>
 	    </div>
		<div class="w3-container">
			<span onclick="document.getElementById('add-course-modal').style.display='none'"
				class="w3-button w3-display-topright">&times;</span>
			<c:url value="/main?action=AddCourse" var="addCourse"/>
			
			<form action="${addCourse}" class="container border-style-none" method="post">
				<label for="add-course-name">Course Name</label> 
				<input type="text" pattern="[A-za-z ]+" id="add-course-name" name="course-name" 
					oninvalid="this.setCustomValidity('Enter a valid name')"
	    			oninput="this.setCustomValidity('')" placeholder="Enter name" required>

				<label for="add-course-max-students">Number of Students</label> 
				<input type="text" pattern="[1-9]+" id="add-course-max-students" name="couse-max-students" 
					oninvalid="this.setCustomValidity('Enter a valid number of students')"
	    			oninput="this.setCustomValidity('')" placeholder="Enter number" required> 
				
				<label for="add-course-load">Course Duration</label> 
				<select id="add-course-load" name="course-load">
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