<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet"
	href="/static/css/forms.css">
</head>
<body>
<div class="card">
        <form:form class ="box" action="process-signup" modelAttribute="signup" method="POST">
            <h1>Sign Up</h1>
            <input type="text" name="name" placeholder="Name">
            <input type="text" name="username" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <button type="Submit">Submit</button>
        </form:form>
    </div>
</body>
</html>