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
<title>User View</title>
<link rel="stylesheet"
	href="/human-resource-management/static/css/viewtable.css">
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
			<button type="submit" value="logout" onclick="if(!(confirm('Are you sure?'))) return false">Logout</button>
		</form:form>
	</nav>

	<div class="div-table">
		<table class="styled-table">
			<thead>
				<tr>
					<td>Name</td>
					<td>Username</td>
					<td>Password</td>
					<td>Creation Time</td>
				</tr>
			</thead>
			<c:forEach var="user" items="${user}">
				<tr>
					<td>${user.name}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.created_date}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>