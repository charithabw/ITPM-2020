<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Method</title>
<link href = "stylesheet/pageStyleSheet.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
</head>
<body>
<header>
		
		<ul class= "main-nav" >
				<li><a href = "index.jsp">HOME</a></li>
				<li class="active"><a href = "#">Variable</a></li>
				<li><a href = "WeightMethod.jsp">Change Weight</a></li>
				<li><a href = "ChartMethod.jsp">Graphic View</a></li>
				<li><a href = "fileUpload.jsp">Uploaded File</a></li>
				
		</ul>
		
		</header>
		<div>
 ${tb}
 </div>
</body>
</html>