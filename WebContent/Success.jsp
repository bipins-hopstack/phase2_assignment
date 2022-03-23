<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style2.css"> 
</head>
<body>
<h2 align="center"><font color="green">Learners Academy Admin Home Page</font></h2>

<div class="right_nav"><a href="Logout.jsp" color="red"><font color="red"> logout </font><%= new Date() %></a></div>
<hr>
<h3>Admin Panel</h3>
<table>
<tr><td>
<br>
<a href="Student.jsp">Student Maintenance</a>
<br>
</td></tr>
<tr><td>
<a href="Teacher.jsp">Teachers Maintenance</a>
<br></td></tr>
<tr><td>
<a href="Subject.jsp">Subject Maintenance</a>
<br></td></tr>
<tr><td>
<a href="ClassStd.jsp">Classes Maintenance</a>
<br></td></tr></table>
<div class="footer"><font color="blue">Copy Right 2022</font></div>
</body>
</html>