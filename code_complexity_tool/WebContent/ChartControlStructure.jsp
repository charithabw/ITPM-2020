<%@page import="com.javaClass.ControllStructure"%>

<%@page import="com.servlet.codeServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href = "stylesheet/pageStyleSheet.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src = "https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>

</head>
<body>
<header>
		
		<ul class= "main-nav" >
				<li><a href = "index.jsp">HOME</a></li>				
				<li class="active"><a href = "controll_structures.jsp">Graphic View</a></li>
				<li><a href = "fileUpload.jsp">Uploaded File</a></li>
				
		</ul>
		
		</header>

<%
codeServlet cs = new codeServlet();
String code = cs.returnCode();
ControllStructure c = new ControllStructure();
c.setCode(code);
int[] tot = c.gettotalValue();
int a = tot[0];
int b = tot[1];
int e = tot[2];
%>
	
	<canvas id="myChart" width="800" height="300"></canvas>
<script>
var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Wtcs', 'Nc', 'Ccspps'],
        datasets: [{
            label: '# of weights',
            data: [<%=a%>, <%=b%>, <%=e%>],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)'
                
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)'
                
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
</script>
		

</body>
</html>