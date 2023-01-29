<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>
<body>
	<h1 class="text-bg-dark p-3">Document Management System</h1>
	<img class="logo" src="images/logo.png">
	<form action="UserLogin" method="post">
		<div class="form-container">
		<%
			String errorMessage = (String) request.getAttribute("errorMessage");
			if (errorMessage != null) {
		%>
		<br>
  		<div class="alert alert-danger" role="alert">
    		<%= errorMessage %>
  		</div>

		<%
  			}
		%>
		<br>
			<h4 class="text-center">Login</h4>
			<label>Enter Your User ID</label>
			<input class="form-control form-control-sm" type="text" name="userid" id="uid" placeholder="Enter User ID" >
			<br>
			<label>Enter your Password</label>
			<input class="form-control form-control-sm" type="password" name="password" id="pass" placeholder="Enter password" >
			<input type="checkbox" onclick="showPass()"> Show Password
			<br>
			<div class="text-center">
			<a href="ForgotPassword.jsp" style="color: #b9a246;">Forgot Password?</a>
			<br><br>
			<input class="btn" id="btn-yellow" type="submit" onClick="login()" value="Login">
			<br><br>
			<a href="UserRegister.jsp" style="color: #b9a246;">New User? Register Here!</a>
			</div>
		</div>
	</form>
	<script src="js/script.js"></script>
</body>
<div class="footer">
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</html>