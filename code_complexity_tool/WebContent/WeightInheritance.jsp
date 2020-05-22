<%@page import="com.javaClass.Inheritance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change weight Inheritance</title>
<link href = "stylesheet/pageStyleSheet.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<header>
		
		<ul class= "main-nav" >
				<li><a href = "index.jsp">HOME</a></li>					
				<li class="active"><a href = "WeightInheritance.jsp">Weights</a></li>
				
		</ul>
		
		</header>
		<h2>If you want to change default WEIGHTS,change here....</h2>
	<form action = "WeightInheirtanceServlet" method= POST>
	<div style = "width : 50%; float : left;">
	<table class="table table-hover" border="1">
			<tr><th bgcolor= '#839192'>Inherited Pattern</th><th bgcolor= '#839192'>Weight</th></tr>
			<tr><td >A class with no inheritance (direct or indirect)</td><td ><input type="text" name = "ziro" value = 0> </td></tr>
			<tr><td >A class inheriting (directly or indirectly) from one user-defined class </td><td ><input type="text" name = "one" value = 1> </td></tr>
			<tr><td >A class inheriting (directly or indirectly) from two user-defined classes </td><td ><input type="text" name = "two" value = 2> </td></tr>
			<tr><td >A class inheriting (directly or indirectly) from three user-defined classes</td><td ><input type="text" name = "three" value = 3> </td></tr>
			<tr><td >A class inheriting (directly or indirectly) from more than three user-defined classes</td><td ><input type="text" name = "four" value = 4> </td></tr>
<tr><td></td><td></td></tr>
			
			</table>
			</div>
			<div style = "width : 50% ;margin-top: 200px; float : right; text-align: center;">
			<input class="btn btn-info btn-arrow-right" type = "submit" name = "submit" value = "save" style = "width: 200px;height: 50px">
			</div>

			
</form>
</body>
</html>