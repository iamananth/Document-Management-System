<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="js/Heartbeat.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            startHeartbeat();
        });
    </script>
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>
<body>
<%

		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader ("Expires", 0);
 			if(session.getAttribute("user")==null){
    			response.sendRedirect(request.getContextPath() + "/UserLogin.jsp");

			}
	%>
<!-- <!-- Modal -->
<!-- 	<div class="modal fade" id="exampleModalCenter" tabindex="-1" -->
<!-- 		role="dialog" aria-labelledby="exampleModalCenterTitle" -->
<!-- 		aria-hidden="true"> -->
<!-- 		<div class="modal-dialog modal-dialog-centered" role="document"> -->
<!-- 			<div class="modal-content"> -->
<!-- 				<div class="modal-header"> -->
<!-- 					<h5 class="modal-title" id="exampleModalLongTitle">Add New -->
<!-- 						User</h5> -->
<!-- 					<button type="button" class="close" data-dismiss="modal" -->
<!-- 						aria-label="Close"> -->
<!-- 						<span aria-hidden="true">&times;</span> -->
<!-- 					</button> -->
<!-- 				</div> -->
<!-- 				<div class="modal-body"> -->
<!-- 				<form method="post" action="URegister" onSubmit="return register()"> -->
<!-- 					<label>User Name</label>  -->
<!-- 					<input class="form-control form-control-sm" type="text" name="uname" id="uname" placeholder="Enter Username"> <br>  -->
<!-- 					<label>Password</label>  -->
<!-- 					<input class="form-control form-control-sm" type="password" name="pass" id="pass" placeholder="Enter password"> <br>  -->
<!-- 					<label>Department</label> -->
<!-- 					<input class="form-control form-control-sm" type="text" name="dept" id="dept" placeholder="Enter Department"><br> -->
<!-- 					<label>Phone Number</label> -->
<!-- 					<input class="form-control form-control-sm" type="text" name="ph" id="ph" placeholder="Enter Phone Number"><br> -->
<!-- 					<div class="modal-footer"> -->
<!-- 					<button type="button" class="btn btn-secondary" -->
<!-- 						data-dismiss="modal">Close</button> -->
<!-- 					<input type="submit" class="btn" id="btn-yellow" value="Save Changes"/> -->
<!-- 				</div> -->
<!-- 				</form> -->
					
<!-- 				</div> -->
				
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="AdminDashboard.jsp">DMS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="AdminDashboard.jsp">Admin Dashboard</a>
      </li>
<!--       <li class="nav-item active"> -->
<!--         <a class="nav-link" href="UserManage.jsp">Manage Users</a> -->
<!--       </li> -->
<!--       <li class="nav-item active"> -->
<!-- 		<a class="nav-link" href="FileUpload.jsp">View Users</a> -->
<!--       </li> -->
	 <li class="nav-item active">
		<svg xmlns="http://www.w3.org/2000/svg" fill="white" class="bi bi-person-circle" height="35" width="35" viewBox="0 0 20 12" style="position: relative;left: 1075px;">
  			<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"></path>
  			<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" style="margin-left: 335px;"></path>
		</svg>
      </li>
      <li class="nav-item active">
		<a class="nav-link" style="position: relative;left: 1070px;">${user.username}</a>
      </li>
      <li class="nav-item active">
        <form action="UserLogout" method="post"><button class="btn btn-danger my-2 my-sm-0" style="margin-left: 1090px;">Logout</button></form>
      </li>
    </ul>
  </div>
</nav>
	<div class="container-lg">
		<div class="alert" style="background-color: #b9a246;" role="alert">
			Welcome, <c:out value="${user.username}" /> <br>Last login: ${loginTime}
		</div>
<!-- 		<form action="UserLogout" method="post"><button class="btn btn-danger" style="margin-left: 937px; margin-top: -62px;">Logout</button></form> -->
 		<div class="card text-bg-dark mb-3">
		<h5 class="card-header">Manage Users</h5>
  			<div class="card-body">
    			<h5 class="card-title">Add Users</h5>
    			<form action="AddUser.jsp"><input type="submit" class="btn" id="btn-yellow" value="Add" /></form>
  			</div>
  			<div class="card-body">
    			<h5 class="card-title">View Users</h5>
<!--     			<p class="card-text">With supporting text below as a natural lead-in to additional content.</p> -->
    			<form action="UserDetails" method="get"><button type="submit" class="btn" id="btn-yellow">View</button></form>
  			</div>
		</div><br>
		<div class="card text-bg-dark mb-3">
		<h5 class="card-header">Manage Projects</h5>
  			<div class="card-body">
    			<h5 class="card-title">All Projects</h5>
    			<form action="ViewProjectUser" method="get"><button type="submit" class="btn" id="btn-yellow">View</button></form>
  			</div>
		</div><br>
<!-- 		<div class="card"> -->
<!--   			<div class="card-body"> -->
<!--     			<h5 class="card-title">Project Document Upload</h5> -->
<%--     			<p class="card-text">With supporting text below as a natural lead-in to additional content.</p> --%>
<!--     			<a href="FileUpload.jsp" class="btn btn-primary">Upload</a> -->
<!--   			</div> -->
<!-- 		</div><br> -->
<!-- 		<div class="card"> -->
<!--   			<div class="card-body"> -->
<!--     			<h5 class="card-title">Add Project Details</h5> -->
<%--     			<p class="card-text">With supporting text below as a natural lead-in to additional content.</p> --%>
<!--     			<a href="ProjectEntry.jsp" class="btn btn-primary">Add</a> -->
<!--   			</div> -->
<!--  		</div><br> -->
	</div>
	<script src="js/script.js"></script>
</body>
<div class="footer">
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</html>
