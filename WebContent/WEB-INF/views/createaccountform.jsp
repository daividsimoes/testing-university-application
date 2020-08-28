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
		
		<title>Create Account</title>
	</head>
	<body bgcolor="">
		<h1 align="center">Create new account</h1>
		<div class="container">
			<div>
				<c:url value="/main?action=CreateAccount" var="createAccount" />
				<form action="${createAccount}" class="container border-style-none" method="post">
					<label for="add-account-username">Username</label> 
					<input type="text" pattern="[0-9A-za-z ]+" id="add-account-username" name="add-username" 
						oninvalid="this.setCustomValidity('Enter a valid username')"
	    				oninput="this.setCustomValidity('')" placeholder="Enter username" required> 
					
					<label for="add-account-password">Password</label> 
					<input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
						id="add-account-password" name="add-password" 
						oninvalid="this.setCustomValidity('Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters')"
	    				oninput="this.setCustomValidity('')" placeholder="Enter password" required>
	    			
					<input type="submit" value="Submit">
				</form>
			</div>
			<c:url value="/main?action=LoginForm" var="loginForm"/>
			<button class="go-back w3-button w3-tiny" onclick="location.href='${loginForm}'">Go Back</button>
		</div>
	</body>
</html>