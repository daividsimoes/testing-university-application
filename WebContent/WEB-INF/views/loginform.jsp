<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/forms.css" />
		<link rel="stylesheet" type="text/css" href="css/buttons.css" />
		<title>Login Page</title>
	</head>
	<body>
		<div class="form">
			<c:url value="/main?action=Login" var="loginForm" />
			<c:url value="/main?action=CreateAccountForm" var="createAccountForm" />
			<form action="${loginForm}" method="post" class="login-form">
			
			  <div class="imgcontainer">
			    <img src="image/avatar.png" alt="Avatar" class="avatar" />
			  </div>
			  
			  <c:if test="${isLogged eq false}">
			  	<b>Invalid username or password!</b>
			  </c:if>
			  
			  <div class="container">
			    <label for="user-name-login"><b>Username</b></label>
			    <input type="text" placeholder="Enter Username" id="user-name-login" name="user-username">
			
			    <label for="user-name-password"><b>Password</b></label>
			    <input type="password" placeholder="Enter Password" id="user-name-password" name="user-password">
				
			    <button class="green-backgroud-btn large-btn" type="submit">Login</button>
			    
			    <b>OR</b>
			    
			    <button class="red-backgroud-btn large-btn" formaction="${createAccountForm}">Create Account</button>
			  </div>
			</form>
		</div>
	</body>
</html>