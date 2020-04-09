<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>coupling</title>

  <link href = "stylesheet/stylesheet.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
</head>
<body>
		<div class = "cplnTable">
		
		<table class = " table " border="2" style = "width: 75%; float: right; margin-top: 100px">
			<tr style = "color: blue;">
					<th>CODE</th>
			
					<th>Nr</th>
															
					<th>Nmcms</th>
					
					<th>Nmcmd </th>
					
					<th>Nmcrms </th>
					
					<th>Nmcrmd </th>
					
					<th>Nrmcrms </th>
					
					<th>Nrmcrmd </th>
					
					<th>Nrmcms </th>
					
					<th>Nrmcmd </th>
					
					<th>Nmrgvs </th>
					
					<th>Nmrgvd </th>
									
					<th>Nrmrgvd 	</th>	
					
					</tr>
					<tbody>
						<tr>
							
							<td ><c:forEach items = "${codelines}" var = "lines"><br>${lines}</br></c:forEach></td>
							<td><c:forEach items = "${score}" var = "score"><br>${score}</br></c:forEach></td>
							
							
						</tr>
						
					</tbody>
					
					
					
		</table>
			
		
		
	 
       
  
  	
		</div>	
		
</body>
</html>