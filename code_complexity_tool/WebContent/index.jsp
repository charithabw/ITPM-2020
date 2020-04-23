<!DOCTYPE html>
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
		
		
		<div class = "textarea" style="margin-top: 90px; margin-left: 10px; width: 90%; text-align: left ;">
		
			<form action= "codeServlet" >
			<textarea  name = "code" rows = "15" cols="100" placeholder="COPPY YOUR CIDE HERE"></textarea>
			
			
			<div class ="btnsize" style  = "width : 50%; float: left;">
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Size" style = "height: 50px; width: 100px">
						
			</div>
			
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Method" style = "height: 50px; width: 100px; float: left;">
			
			
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Variable" style = "height: 50px; width: 100px; float: left;">
				
			
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Inheritance"  style = "height: 100px; width: 200px; float: left;">
			
			<input class = "btn btn-primary" type = "submit" name = "button" value = "ControlStructure" style = "height: 100px; width: 200px ; float: left;'">
			<div id = bottom>
			<input class = "btn btn-primary" type = "submit" name = "button" value = "Coupling" style = "height: 100px; width: 200px ; float: left;">
			</div>
			
			
			
			
			</form>
			
			</div>
		
		<!--  
		<div class = "fileUpload">
					<form action="" name ="" method="">
						<input type ="File" accept="">
					
					</form>
		</div>
		<div class = "btnCode" id = "bottom">
			<button class = "btn btn-primary" type = "submit" onclick = "window.location.href = 'http://localhost:8090/testweb/seletingPage.html';">SUBMIT</button>
		</div>
		-->
	
</body>
</html>