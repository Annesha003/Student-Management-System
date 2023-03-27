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
	<h1>Students List</h1>
	<table border="2" width="70%" cellpadding="2" >
		<tr>
			<th>Roll No</th>
			<th>Student Name</th>
			<th>Standard</th>
			<th>Marks</th>
		</tr>
		<c:forEach var="student" items="${list}" >
		<tr>
			<td>${student.rollno}</td>
			<td>${student.studentname}</td>
			<td>${student.standard}</td>
			<td>${student.marks}</td>
			<td><a href="editstudentform/${student.rollno}">Update Student</a> </td>
			<td><a href="deletestudent/${student.rollno}">Delete Student</a> </td>
			
			
		</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="showstdform">Add Student</a>
</body>
</html>