<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Manage Users</title>
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
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Add New
						User</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<form method="post" action="URegister">
					<label>User Name</label> 
					<input class="form-control form-control-sm" type="text" name="uname" id="uname" placeholder="Enter Username"> <br> 
					<label>Password</label> 
					<input class="form-control form-control-sm" type="password" name="pass" id="pass" placeholder="Enter password"> <br> 
					<label>Department</label>
					<input class="form-control form-control-sm" type="text" name="dept" id="dept" placeholder="Enter Department"><br>
					<label>Phone Number</label>
					<input class="form-control form-control-sm" type="text" name="ph" id="ph" placeholder="Enter Phone Number"><br>
					<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Save Changes"/>
				</div>
				</form>
					
				</div>
				
			</div>
		</div>
	</div>
	<h1 class="text-bg-primary p-3">Document Management System</h1>
	<div class="container-lg">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-8">
						<h2>User Details</h2>
					</div>
					<div class="col-sm-4">
						<button type="button" data-toggle="modal"
							data-target="#exampleModalCenter" class="btn btn-primary add-new">Add
							New</button>
					</div>
					<form action="UserDetails" method="get"><button type="submit" class="btn btn-primary add-new">View</button></form>
				</div>
			</div>
		</div>
	</div>
</body>
<div class="footer">
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</html>