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
<title>Notice View</title>
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
		<form action="addNotice">
			
			<button class="add-button">Add</button>
		</form>
	
		<table class="styled-table">
			<thead>
				<tr>
					<td>Name</td>
					<td>Content</td>
					<td>Creation Time</td>
					<td>Publisher</td>
					<sec:authorize access='hasAuthority("ADMIN")'>
						<th></th>
						<th></th>
					</sec:authorize>
				</tr>
			</thead>
			<c:forEach var="notice" items="${notices}">
				<tr>
					<td>${notice.notice_name}</td>
					<td>${notice.notice_content}</td>
					<td>${notice.notice_creation_time}</td>
					<td>${notice.notice_publisher}</td>
					<sec:authorize access='hasAuthority("ADMIN")'>
						<td><a
							href="/updateNotice?noticeId=${notice.idnotices}">Update</a></td>
						<td><a
							href="/deleteNotice?noticeId=${notice.idnotices}"
							onclick="if(!(confirm('Are you sure?'))) return false">Delete</a></td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>