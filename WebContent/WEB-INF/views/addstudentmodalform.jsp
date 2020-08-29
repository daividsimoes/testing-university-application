<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="add-student-modal" class="w3-modal">
	<div class="w3-modal-content">
		<div class="modal-header">
		    <h2 align="center">Add New Student</h2>
 	    </div>
		<div class="w3-container">
			<span
				onclick="document.getElementById('add-student-modal').style.display='none'"
				class="w3-button w3-display-topright">&times;</span>
			<c:url value="/main?action=AddStudent" var="addstudent" />

			<form action="${addstudent}" class="container border-style-none" method="post">
				<label for="addsname">Student Name</label> 
				<input type="text" pattern="[A-za-z ]+" id="addsname" name="sname" 
				oninvalid="this.setCustomValidity('Enter a valid name')"
    			oninput="this.setCustomValidity('')" placeholder="Enter name" required> 
				
				<label for="addstudentage">Student Age</label> 
				<input type="text" pattern="[1-9]+" id="addstudentage" name="sage" 
				oninvalid="this.setCustomValidity('Enter a valid age')"
    			oninput="this.setCustomValidity('')" placeholder="Enter age" required>

				<div>
					<label class="container">Male 
					 	<input value="MALE" name="gender" type="radio" checked >
					 </label> 
					 
					 <label class="container">Female 
					 	<input value="FEMALE" name="gender" type="radio">
					</label> 
					
					<label class="container">Other 
					 	<input value="OTHER" name="gender" type="radio">
					</label>
				</div>
				<input type="submit" value="Submit">
			</form>
		</div>
	</div>
</div>