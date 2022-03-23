<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style2.css"> 
</head>
<body>
<h2 align="center"><font color="green">Student Registration Form</font></h2>

<div class="right_nav"><a href="logout.jsp" color="red"><font color="red">logout</font></a></div>
<hr>


<form action="StudentController" method="post">
<table>
<tr>
<td>
Unique RegNo:</td><td><input type="number" name="regno"></td>
</tr>
<tr>
<td>
Student Name</td><td><input type="text" name="stuname"></td>
</tr>
<tr>
<td>
Gender</td><td><input type="text" name="gender"></td>
</tr>
<tr>
<td>
Class</td><td><input type="number" name="classstd"></td>
</tr>
<tr>
<td>
<input type="submit" value="Insert Student" name="register"/>
</td></tr>
</table>
</form>
<%  if(request.getParameter("register")!=null){ %>
<jsp:useBean id="student" class="com.learnearsacad.admin.bean.SubjectBean"></jsp:useBean>
<%} %>
</body>
</html>