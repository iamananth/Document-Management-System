<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-bg-primary p-3">Document Management System</h1>
	<img class="logo" src="images/logo.jpg">
	<form action="UserRegister" method="post" onSubmit="return register()">
		<div class="form-container">
		<br>
			<h4 class="text-center">Register</h4>
			<label>User Name</label>
			<input class="form-control form-control-sm" type="text" name="username" id="uname" placeholder="Enter Your Username" > 
			<br>
			<label>Department</label>
			<input class="form-control form-control-sm" type="text" name="dept" id="dept" placeholder="Enter Your Department" > 
			<br>
			<label>Phone Number</label>
			<input class="form-control form-control-sm" type="text" name="ph" id="ph" placeholder="Enter Your Phone Number" > 
			<br>
			<label>Password</label>
			<input class="form-control form-control-sm" type="password" name="password" id="pass" placeholder="Enter password" > 
			<br>
			<label>Retype password</label>
			<input class="form-control form-control-sm" type="password" name="repassword" id="repass" placeholder="Retype password" > 
			<br>
			<div class="text-center">
				<input class="btn btn-primary" type="submit" value="Register">
				<br><br>
				<a href="UserLogin.jsp">Already Registered? Login Here!</a>
			</div>
		</div>
	</form>
	<script src="js/script.js"></script>
</body>
<div class="position-absolute bottom-0 start-50 translate-middle-x">
<footer>
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</footer>
</div>
</html>