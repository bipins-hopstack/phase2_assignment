<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style2.css"> 
</head>
<! this is comment!>
<body>
<h2 align="center"><font color="green">Subject Maintenance</font></h2>

<div class="right_nav"><a href="logout.jsp" color="red"><font color="red">logout</font></a></div>
<hr>

<form action="SubjectController" method="post">
<table>
<tr>
<td>
Subject ID:</td><td><input type="text" maxlength="3" name="subjectid"></td>
</tr>
<tr>
<td>
Subject Name:</td><td><input type="text" name="subjectname"></td>
</tr>
<tr><td>
<input type="submit" value="Insert Subject" name="insertsubject">
<input type="hidden" value="false" type="text" name="functionbutton"/>
</td></tr>
</table>
</form>

<table>
<tr><td>
<form action="SubjectController" method="post">
<input type="hidden" value="viewallsubjects" type="text" name="functionbutton"/>
<input type="submit"  value="View All Subjects"/><br>
</form>
</td></tr></table>

<table>
<tr><td>
<form action="SubjectController" method="post">
Subject ID:<input type="text" maxlength="3" name="subjectid">
<input type="hidden" value="deletetsubject" type="text" name="functionbutton"/>
<input type="submit"  value="Delete Subject"/>
</form>
</td></tr>
</table>

</body>
</html>