<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" href="/static/css/homepage.css"> 
</head>
<body>

		<nav>
			<a href="/" class="logo">Human-Resource</a>
			<ul>
				<sec:authorize access='hasAuthority("ADMIN")'>
					<li><a href="showUser">User</a></li>
				</sec:authorize>
				<li><a href="showDept">Department</a></li>
				<li><a href="showJob">Job</a></li>
				<li><a href="showEmployee">Employee</a></li>
				<li><a href="showNotice">Notice</a></li>
			</ul>
			<form:form action="logout" method="POST" class="button">
				<button type="submit" value="logout" onclick="if(!(confirm('Are you sure?'))) return false">Logout</button>
			</form:form>
		</nav>
	
	<div class="welcome-text">
		<h1>Hello, ${username}</h1>
		<h3>Role: ${role}</h3>
	</div>

</body>
</html>