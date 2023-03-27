<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title>
</head>
<body>
	<h1>Add New Student</h1>
	<form:form method="post" action="save">
		<table>
			<tr>
				<td>Roll No.:</td>
				<td><form:input path="rollno" /></td>
			</tr>
			<tr>
				<td>Student Name:</td>
				<td><form:input path="studentname" /></td>
			</tr>
			<tr>
				<td>Standard:</td>
				<td><form:input path="standard" /></td>
			</tr>
			<tr>
				<td>Marks:</td>
				<td><form:input path="marks" /></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<input type="submit" value="Save" >
			</tr>
		</table>
	</form:form>
	<br/>
	<a href="viewstudent">View Students</a>
</body>
</html>