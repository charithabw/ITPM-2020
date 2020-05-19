






<!DOCTYPE html>
<%@page import="com.javaClass.Coupling"%>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  
<title>home</title>
  
  <link href = "stylesheet/stylesheet.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body>

	  <header>
		<div class= "row" style="background-image: url(images/banner.jpg)">
		<ul class= "main-nav">
				<li class="active"><a href = "#">HOME</a></li>
				<li><a href = "#">ABOUT</a></li>
				<li><a href = "#">CONTACT</a></li>
				<li><a href = "#">NEWS</a></li>
		</ul>
		<div class = "header2">
			<h1>CODE COMPLEXITY</h1>
		
	
		
			<div class = "button">
				  <a href = "#bottom" class = "btn1">Start Here</a>
				
			</div>
		</div>
		</div>
		<style>
			html{
				scroll-behavior: smooth;
			}
		
		</style>
		</header>
		
		
		<div>
			<form action= "codeServlet" method  = POST>
		<div class = "textarea" style="margin-top: 90px; margin-left: 50px; width: 90%; text-align: left ;">
			<textarea  name = "code" rows = "15" cols="100" placeholder="COPPY YOUR CIDE HERE"    >${tb}</textarea>
			</div>
			
			<div style = " margin-left: 50px">
			<div class="btn-group">
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Size" style = "height: 50px; width: 100px">
						</div>
			
			<div class="btn-group">
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Method" style = "height: 50px; width: 100px; float: left;">
			</div>
			<div class="btn-group">
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Variable" style = "height: 50px; width: 100px; float: left;">
			</div>	
			<div class="btn-group">
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Inheritance"  style = "height: 50px; width: 100px; float: left;">
			</div>
			<div class="btn-group">
			<input class = "btn btn-primary" type = "submit" name = "button" value = "ControlStructure" style = "height: 50px; width: 100px ; float: left;'">
			</div>
			<div class="btn-group">
			<input class = "btn btn-primary"  type = "submit" name = "button" value = "Coupling" style = "height: 50px; width: 100px ; float: left;">
			</div>
			<div class="btn-group">
			<input class="btn btn-outline-primary" type = "submit" name = "button" value = "All-Factors" style = "height: 75px; width: 100px ; float: left; color:#094C71; font-weight: bold;">
			</div>
			</div>
			
			
			
			
			</form>
		 	</div>
		<div class = "fileUpload" style="margin-top: 30px; margin-left: 800px;">
		
      
		<h5>upload A ZIP file or normal fileS here...</h5>
					<form action= "FileUploadServlet" method="post" enctype="multipart/form-data" id = bottom>
						<input class="btn btn-link" type ="file" name ="file" multiple/>
						<input class="btn btn-outline-secondary"  type = "submit" value = "file-upload" style = "font-weight: bold "/>
					</form>
					
					
		</div>
			
		  
		
		
	
</body>
</html>