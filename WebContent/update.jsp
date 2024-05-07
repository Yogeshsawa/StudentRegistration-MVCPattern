<%@page import="com.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		StudentBean s1 = (StudentBean) request.getAttribute("s");
	%>
	<form name="frm" action="StudentController" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="id" value="<%=s1.getId()%>"></td>
			</tr>
			<tr>
				<td><label>First Name:</label></td>
				<td><input type="text" name="firstname"
					value="<%=s1.getFirstname()%>">
			</tr>
			<tr>
				<td><label>Last Name:</label></td>
				<td><input type="text" name="lastname"
					value="<%=s1.getLastname()%>">
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="<%=s1.getEmail()%>">
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="upass" value="<%=s1.getUpass()%>" />
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="DOB" value="<%=s1.getDOB()%>"/>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="<%=s1.getGender()%>"> />male <input
					type="radio" name="gender" value="female" />female <input
					type="radio" name="gender" value="other" />other</td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea rows="4" cols="20" name="uadd" value="<%=s1.getUadd()%>"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="update" />
			</tr>
		</table>
	</form>

</body>
</html>