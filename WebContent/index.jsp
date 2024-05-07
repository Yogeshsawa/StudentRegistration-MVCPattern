<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="CSS/index.css">
</head>
<body>
<h1>Student Registration Form</h1>
<form action="StudentController" method="post">
<table>
<tr>
<td><label>First Name:</label></td>
<td><input type="text" name="firstname" placeholder="First Name"/>
</tr>
<tr>
<td><label>Last Name:</label></td>
<td><input type="text" name="lastname" placeholder="last Name"/>
</tr>
<tr>
<td>Email:</td>
<td><input type="text" name="email" placeholder="Email"/>
</tr>
<tr>
<td>password</td>
<td><input type="password" name="upass" placeholder="Enter password"/>
</tr>
<tr>
<td>Date of Birth</td>
<td><input type="date" name="DOB"/>
</tr>
<tr>
<td>Gender</td>
<td><input type="radio" name="gender" value="male"/>male
<input type="radio" name="gender" value="female"/>female
<input type="radio" name="gender" value="other"/>other</td>
</tr>
<tr>
<td>Address</td>
<td><textarea rows="4" cols="20" name="uadd"></textarea></td>
</tr>
<tr>
<td><input type="submit" name="action" value="insert"/>
</tr>
</table>
</form>
</body>
</html>