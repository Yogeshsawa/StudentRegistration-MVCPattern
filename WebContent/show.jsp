<%@page import="com.Dao.StudentDao"%>
<%@page import="com.bean.StudentBean"%>
<%@page import="java.util.List"%>
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
	List<StudentBean> list=StudentDao.getAll();
%>
<table border="1">
<tr>
<th>ID</th>
<th>firstname</th>
<th>lastname</th>
<th>email</th>
<th>password</th>
<th>DOB</th>
<th>gender</th>
<th>address</th>
</tr>
<%
	for(StudentBean s1:list)
	{
%>
<tr>
	<td><%=s1.getId() %></td>
	<td><%=s1.getFirstname() %></td>
	<td><%=s1.getLastname() %></td>
	<td><%=s1.getEmail() %></td>
	<td><%=s1.getUpass() %></td>
	<td><%=s1.getDOB()%></td>
	<td><%=s1.getGender() %></td>
	<td><%=s1.getUadd() %></td>
	<td>
	<form name="edit" method="post" action="StudentController">
      <input type="hidden" name="id" value="<%=s1.getId()%>">
      <input type="submit" name="action" value="edit">
      </form>
    </td>
      <td>
      <form name="delete" method="post" action="StudentController">
                   
				<input type="hidden" name="id" value="<%=s1.getId()%>">
				<input type="submit" name="action" value="Delete" class="fa-solid fa-trash">
	 </form>
      </td>
	
</tr>
<%
	}
%>
</table>
<a href="index.jsp">Add new Student</a>
</body>
</html>