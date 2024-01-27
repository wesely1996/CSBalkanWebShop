<!-- /src/main/resources/templates/login.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Login - Web Shop</title>
<style>
body {
	text-align: center;
	font-family: Arial, sans-serif;
}

#loginForm {
	margin-top: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 80vh;
	margin: 0;
	flex-direction: column;
}

#registerLink {
	margin-top: 10px;
	display: block;
}

table {
	border-collapse: collapse;
	width: 80%;
	margin: 0 auto;
	border:0px solid transparent;
}

th, td {
	border: 0px solid transparent;
	padding: 8px;
	text-align: left;
}
</style>
</head>
<body>

	<img src="${pageContext.request.contextPath}/images/CSBalkanLogo.png"
		alt="Web Shop Logo" width="50" height="50">
	<h1>CS Balkan Web Shop</h1>

	<div id="loginForm">
		<c:if test="${!empty errorMessage}">
			<h4 style="color: red">${errorMessage}</h4>
		</c:if>
		<form:form action="/CSBalkanWebShop/user/logIn"
			method="post" modelAttribute="user">
			<table>
				<tr>
					<th><label for="username">Username:</label></th>
					<th><input type="text" id="username" name="username" required></th>
				</tr>
				<tr>
					<th><label for="password">Password:</label></th>
					<th><input type="password" id="password" name="password" required></th>
				</tr>
			</table>
			<input type="submit" value="Login">
		</form:form>
		<br>
		<a id="registerLink" href="/CSBalkanWebShop/user/register">Don't have an account? Register here.</a>
	</div>

</body>
</html>
