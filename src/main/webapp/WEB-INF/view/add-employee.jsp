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
<title>Add Employee</title>
<link rel="stylesheet"
	href="/static/css/fillform.css">
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
			<button type="submit" value="logout"
				onclick="if(!(confirm('Are you sure?'))) return false">Logout</button>
		</form:form>
	</nav>

	<div class="card">
		<form:form class="box" action="saveEmployee" modelAttribute="employee"
			method="POST">
			<h1>Employee Form</h1>
			<form:hidden path="employee_id" />
			<form:input type="text" path="employee_name"
				placeholder="Employee's Name" />
			<form:textarea path = "employee_address" rows = "5" cols = "30" placeholder="Address" /> 
			
			<div class="droplist">Education:
			<form:select path="employee_education"> 
			
				 <form:option value="High School" label="High School"/>  
				 <form:option value="Diploma" label="Diploma"/> 
				 <form:option value="Bachelor" label="Bachelor"/> 
				 <form:option value="Masters" label="Masters"/> 
				 <form:option value="Doctorate" label="Doctorate"/> 
				 <form:option value="Other" label="Other"/> 
			</form:select>
			</div>
			
			<div class="rad">
				<label for="male" class="">Male <form:radiobutton id="radio"
						path="employee_gender" value="male" />
				</label> <label for="male" class="">Female <form:radiobutton
						id="radio" path="employee_gender" value="female" /></label> <label
					for="male" class="">Other <form:radiobutton id="radio"
						path="employee_gender" value="other" /></label>
			</div>
			
			<form:input type="text" path="employee_job" placeholder="Job" />
			<form:input type="email" path="employee_email" placeholder="E-mail" />
			<form:input type="text" path="employee_dept" placeholder="Department" />
			<form:input type="text" path="employee_phone"
				placeholder="Phone Number" />
			<button type="submit" value="Submit">Submit</button>
		</form:form>
	</div>

</body>
</html>