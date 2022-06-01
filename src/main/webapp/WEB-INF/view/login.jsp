<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="/static/css/forms.css">
</head>
<body>

	<div class="card">
		<form:form class="box">
			<h1>Login</h1>
			<input type="text" name="username" placeholder="Username">
			<input type="password" name="password" placeholder="Password">
			<button type="Submit">Submit</button>
			<a href="/signup">Don't have an
				account?</a>
		</form:form>
	</div>
	<c:if test="${param.error!=null}">
		<i>Invalid username or password</i>
	</c:if>

</body>
</html>