<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher</title>
<link rel="stylesheet" type="text/css" href="css/style2.css"> 
</head>
<body>
<h2 align="center"><font color="green">Teacher Maintenance</font></h2>

<div class="right_nav"><a href="logout.jsp" color="red"><font color="red">logout</font></a></div>
<hr>

<form action="TeacherController" method="post">
<table>
<tr>
<td>
Teacher ID:</td><td><input type="number" name="teacherid"></td>
</tr>
<tr>
<td>
Teacher Name:</td><td><input type="text" name="teachername"></td>
</tr>
<tr>
<td>
<input type="submit" value="Insert Teacher" name="insertteacher"/>
<input type="hidden" value="false" type="text" name="functionbutton"/><br>
</td></tr>
</table>
</form>

<table>
<tr>
<td>
<form action="TeacherController" method="post">
<input type="hidden" value="viewallteachers" type="text" name="functionbutton"/>
<input type="submit"  value="View All Teachers"/><br>
</form>
</tr>
</table>

<table>
<tr><td>
<form action="TeacherController" method="post">
Teacher ID:<input type="number" name="teacherid">
<input type="hidden" value="deleteteacher" type="text" name="functionbutton"/>
<input type="submit"  value="Delete Teacher"/>
</form></td></tr>
</table>
</body>
</html>