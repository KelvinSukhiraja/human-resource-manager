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
<title>Department View</title>
<link rel="stylesheet"
	href="/static/css/viewtable.css">
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

	<div class="div-table">
	<sec:authorize access='hasAuthority("ADMIN")'>
		<form action="addDept">
			
			<button class="add-button">Add</button>
		</form>
	</sec:authorize>
		<table class="styled-table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Details</th>
					<sec:authorize access='hasAuthority("ADMIN")'>
						<th></th>
						<th></th>
					</sec:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dept" items="${depts}">
					<tr>
						<td>${dept.dept_name}</td>
						<td>${dept.dept_details}</td>
						<sec:authorize access='hasAuthority("ADMIN")'>
							<td><a
								href="/updateDept?deptId=${dept.id}">Update</a></td>
							<td><a
								href="/deleteDept?deptId=${dept.id}"
								onclick="if(!(confirm('Are you sure?'))) return false">Delete</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>