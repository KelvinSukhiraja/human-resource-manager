<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notice</title>
<link rel="stylesheet"
	href="/human-resource-management/static/css/fillform.css">
</head>
<body>
	<nav>
		<a href="/human-resource-management/" class="logo">Human-Resource</a>
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
			<button type="submit" value="logout"
				onclick="if(!(confirm('Are you sure?'))) return false">Logout</button>
		</form:form>
	</nav>
	<div class="card">
		<form:form class="box" action="saveNotice" modelAttribute="notice"
			method="POST">
			<h1>Notice Form</h1>
			<form:hidden path="idnotices" />
			<form:input type="text" path="notice_name"
				placeholder="Notice Name" />
			<form:textarea path = "notice_content" rows = "5" cols = "30" placeholder="Content (280 Characters)" /> 
			
			<form:hidden path="notice_publisher" />
			<button type="submit" value="Submit">Submit</button>
		</form:form>
	</div>


</body>
</html>