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
<title>Employee View</title>
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
			<form action="addEmployee">

				<button class="add-button">Add</button>

			</form>
		</sec:authorize>
		<table class="styled-table">

			<thead>
				<tr>
					<td>Name</td>
					<td>Address</td>
					<td>Education</td>
					<td>Gender</td>
					<td>Job</td>
					<td>Created Date</td>
					<td>E-mail</td>
					<td>Department</td>
					<td>Phone</td>
					<sec:authorize access='hasAuthority("ADMIN")'>
						<th></th>
						<th></th>
					</sec:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${employees}">
					<tr>
						<td>${employee.employee_name}</td>
						<td>${employee.employee_address}</td>
						<td>${employee.employee_education}</td>
						<td>${employee.employee_gender}</td>
						<td>${employee.employee_job}</td>
						<td>${employee.employee_created_date}</td>
						<td>${employee.employee_email}</td>
						<td>${employee.employee_dept}</td>
						<td>${employee.employee_phone}</td>

						<sec:authorize access='hasAuthority("ADMIN")'>
							<td><a
								href="/updateEmployee?employeeId=${employee.employee_id}">Update</a></td>
							<td><a
								href="/deleteEmployee?employeeId=${employee.employee_id}"
								onclick="if(!(confirm('Are you sure?'))) return false">Delete</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>