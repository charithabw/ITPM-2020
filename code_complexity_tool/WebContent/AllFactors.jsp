<%@page import="com.javaClass.Coupling"%>
<%@page import="com.servlet.codeServlet"%>
<%@page import="com.javaClass.AllFactors"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Factors</title>
<link href = "stylesheet/pageStyleSheet.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

<header>
		
		<ul class= "main-nav" >
				<li><a href = "index.jsp">HOME</a></li>
				<li class="active"><a href = "AllFactors.jsp">Table View</a></li>				
				<li><a href = "ChartAlFactors.jsp">Graphic View</a></li>
				<li><a href = "fileUpload.jsp">Uploaded File</a></li>
				
		</ul>
		
		</header>

<%
	codeServlet cs = new codeServlet();
	String code = cs.returnCode();	
	AllFactors af = new AllFactors();
	af.setCode(code);
	out.print(af.gettable());
%>

</body>
</html>