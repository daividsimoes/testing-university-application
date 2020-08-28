<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/main?action=Logout" var="logout" />
<form class="border-style-none" name="logout-form" method="post" action="${logout}">
	<label class="logout w3-button w3-tiny"> <input name="logout"
		type="submit" id="logout" value="log out">
	</label>
</form>