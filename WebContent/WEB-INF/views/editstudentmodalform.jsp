<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="edit-student-modal" class="w3-modal">
	<div class="w3-modal-content">
	    <div class="modal-header">
		    <h2 align="center">Edit Student Information</h2>
 	    </div>
		<div class="w3-container">
			<span
				onclick="document.getElementById('edit-student-modal').style.display='none'"
				class="w3-button w3-display-topright">&times;</span>
			<c:url value="main?action=EditStudentInformation&registrationNumber=${student.registrationNumber}" 
				var="editStudent" />

			<form action="${editStudent}" class="container border-style-none" method="post">
				<label for="edit-student-name">Student Name</label> 
				<input type="text" pattern="[A-za-z ]+" id="edit-student-name" name="student-name" 
					oninvalid="this.setCustomValidity('Enter a valid name')"
    				oninput="this.setCustomValidity('')" placeholder="Enter name" required> 
				
				<label for="edit-student-age">Student Age</label> 
				<input type="text" pattern="[1-9]+" id="edit-student-age" name="student-age" 
					oninvalid="this.setCustomValidity('Enter a valid age')"
    				oninput="this.setCustomValidity('')" placeholder="Enter age" required>
    			
    			<label for="edit-student-email">Student Email</label> 
				<input type="text" pattern="[A-za-z0-9._%+-]+@[A-za-z0-9._%+-]+"
					id="edit-student-email" name="student-email" 
					oninvalid="this.setCustomValidity('Enter a valid email')"
    				oninput="this.setCustomValidity('')" placeholder="Enter email" required>

				<div>
					<label for="edit-student-gender-male" class="container">Male 
					 	<input id="edit-student-gender-male" value="MALE" name="student-gender" type="radio" checked >
					 </label> 
					 
					 <label for="edit-student-gender-female" class="container">Female 
					 	<input id="edit-student-gender-female" value="FEMALE" name="student-gender" type="radio">
					</label> 
					
					<label for="edit-student-gender-other" class="container">Other 
					 	<input id="edit-student-gender-other" value="OTHER" name="student-gender" type="radio">
					</label>
				</div>
				<input type="submit" value="Submit">
			</form>
		</div>
	</div>
</div>