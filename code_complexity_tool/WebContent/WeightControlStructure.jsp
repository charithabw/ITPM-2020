<%@page import="com.javaClass.ControllStructure"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change weight of Control Structures</title>
<link href = "stylesheet/pageStyleSheet.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<header>
		
		<ul class= "main-nav" >
				<li><a href = "index.jsp">HOME</a></li>					
				<li class="active"><a href = "WeightControlStructure.jsp">Weights</a></li>
				
		</ul>
		
		</header>


	<h2>If you want to change default WEIGHTS change here....</h2>
	<form action = "WeightControlStructureServlet" method= POST>
	<div style = "width : 50%; float : left;">
			<table class="table table-hover" border="1">
			<tr><th bgcolor= '#839192'> Control Structure Type</th><th bgcolor= '#839192'>Weight</th></tr>
			<tr><td >A conditional control structure such as an 'if' or 'else-if' condition and 'switch' statement in a 'switch-case' control structure</td><td ><input type="text" name = "weightIf" value = 2> </td></tr>
			<tr><td>Each 'case' statement in a 'switch-case' control structure</td><td><input type="text" name = "weightCase" value = 1> </td></tr>
			<tr><td>An iterative control structure such as a 'for', 'while', or 'do-while' loop </td><td><input type="text" name = "weightFor" value = 3> </td></tr>
			<tr><td></td><td></td></tr>
			
			</table>
			
			</div>
			<div style = "width : 50% ;margin-top: 200px; float : right; text-align: center;">
			<input class="btn btn-info btn-arrow-right" type = "submit" name = "submit" value = "save" style = "width: 200px;height: 50px">
			</div>
</form>
</body>
</html>