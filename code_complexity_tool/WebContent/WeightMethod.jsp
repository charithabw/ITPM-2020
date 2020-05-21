<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<h2>If you want to change default WEIGHTS change here....</h2>
	<form action = "WeightMethodsServlet" method= POST>
	<div style = "width : 50%; float : left;">
			<table class="table table-hover" border="1">
			<tr><th bgcolor= '#839192'>Program Component</th><th bgcolor= '#839192'>Weight</th></tr>
			<tr><td >Method with a primitive return type</td><td ><input type="text" name = "WmrtP" value = 1> </td></tr>
			<tr><td>Method with a composite return type</td><td><input type="text" name = "WmrtC" value = 2> </td></tr>
			<tr><td>Method with a void return type</td><td><input type="text" name = "WmrtV" value = 0> </td></tr>
			<tr><td>Primitive data type parameter</td><td><input type="text" name = "Wpdtp" value = 1> </td></tr>
			<tr><td>Composite data type parameter</td><td> <input type="text" name = "Wcdtp" value = 2></td></tr>
				
			</table>
			
			</div>
			<div style = "width : 50% ;margin-top: 200px; float : right; text-align: center;">
			<input class="btn btn-info btn-arrow-right" type = "submit" name = "submit" value = "save" style = "width: 200px;height: 50px">
			</div>
</form>

</body>
</html>