<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style2.css"> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"><font color="green">Class Maintenance</font></h2>

<div class="right_nav"><a href="logout.jsp" color="red"><font color="red">logout</font></a></div>
<hr>

<form action="ClassController" method="post">
<table>
<tr>
<td>
Class Std:</td><td><input type="number" name="classid"></td>
</tr>
<tr>
<td>
Class Time:</td><td><input type="text" name="classtime"></td>
</tr>
<tr>
<td>
Teacher ID:</td><td><input type="number" name="teacherid"></td>
</tr>
<tr>
<td>
Subject ID:</td><td><input type="number" name="subjectid"></td>
</tr>

<tr>
<td>
<input type="submit" value="Insert Class" name="insertclass">
<input type="hidden" value="insert" type="text" name="functionbutton"/>
</td></tr>
</table>
</form>

<table>
<tr>
<td>
<form action="ClassController" method="post">
Class Std:<input type="number" name="classid">
<input type="hidden" value="viewallclass" type="text" name="functionbutton"/>
<input type="submit"  value="View Class info"/><br>
</form></td>
</tr></table>

<table>
<tr><td>
<form action="ClassController" method="post">
Class Std:<input type="number" name="classid">
<br>
Teacher Id:<input type="number" name="teacherid">
<input type="hidden" value="deletesession" type="text" name="functionbutton"/>
<input type="submit"  value="Delete teacher session"/>
</form></td></tr>
</table>
</body>
</html>