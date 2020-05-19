<!DOCTYPE html>
<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>inheritance</title>
</head>
<body>
<!-- Dinithi Anupama -->
		<table>
		<thead>
			<tr>
				<th>Line No</th>
				<th>Class Name</th>
				<th>No of Direct Inheritance</th>
				<th>No of Indirect Inheritance</th>
				<th>Total Inheritance</th>
				<th>Ci</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="inheritanceList" items="${inheritanceList}">
				<tr>
					<td>${inheritanceList.getCount()}</td>
					<td>${inheritanceList.getClassName()}</td>
					<td>${inheritanceList.getNo_of_direct_inheritances()}</td>
					<td>${inheritanceList.getNo_of_indirect_inheritances()}</td>
					<td>${inheritanceList.getTotal_inheritances()}</td>
					<td>${inheritanceList.getCi()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>