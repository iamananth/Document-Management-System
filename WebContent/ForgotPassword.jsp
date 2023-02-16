<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
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
	<nav id="navbar" class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">DMS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
</nav>
	<img class="logo" src="images/logo.jpg">
	<form action="ForgotPass" method="post">
		<div class="form-container">
		<%
			String SuccessPass = (String) request.getAttribute("SuccessPass");
			if (SuccessPass != null) {
		%>
		<br>
  		<div class="alert alert-success" role="alert">
    		<%= SuccessPass %>
  		</div>
  		
		<%
  			}
		%>
		<br>
			<h4 class="text-center">Reset Password</h4>
			<label>User ID</label>
			<input class="form-control form-control-sm" type="text" name="userid" id="userid" placeholder="Enter Userid"> 
			<br>
			<label>New Password</label>
			<input class="form-control form-control-sm" type="password" name="password" id="pass" placeholder="Enter new password"> 
			<br>
			<label>Retype New password</label>
			<input class="form-control form-control-sm" type="password" name="repassword" id="repass" placeholder="Retype new password"> 
			<br>
			<div class="text-center">
				<input class="btn" id="btn-yellow" type="submit" onClick="clear()" value="Clear">
				<input class="btn" id="btn-yellow" type="submit" onClick="register()" value="Reset">
				<br><br>
				<a href="UserLogin.jsp" id="text-yellow">Login</a>
			</div>
		</div>
	</form>
	<script src="js/script.js"></script>
</body>
<div class="footer">
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</html>