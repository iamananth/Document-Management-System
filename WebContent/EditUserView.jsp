<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="js/Heartbeat.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	<nav id="navbar" class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
  <a class="navbar-brand" href="UserDashboard.jsp">DMS</a>
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
        <form action="UserLogout" method="post"><button class="btn btn-danger my-2 my-sm-0" style="margin-left: 950px;">Logout</button></form>
      </li>
    </ul>
  </div>
</nav>
<div class="container-lg">
	<h4>Edit User Details</h4>
	<form action="UpdateUser" method="post">
	<c:forEach items="${details}" var="row">
  		<div class="row mb-4">
    		<div class="col">
      			<div class="form-outline">
      				<label class="form-label" for="id">User ID</label>
       				<input type="text" name="id" id="id" value="${row.id}" class="form-control" />
      			</div>
    	   </div>
  		</div>
  		<div class="col">
      		<div class="form-outline">
      			<label class="form-label" for="uname">Username</label>
        		<input type="text" name="uname" id="uname" value="${row.username}" class="form-control" />
      		</div><br>
      		<div class="form-outline">
      			<label class="form-label" for="dept">Department</label>
    			<input type="text" name="dept" id="dept" value="${row.department}" class="form-control" /><br>
  			</div>
    	</div>
  		<div class="form-outline mb-4">
  			<label class="form-label" for="ph">Phone number</label>
    		<input type="text" name="ph" id="ph" value="${row.phone_number}" class="form-control" />
    	</div>
    	<button type="reset" class="btn btn-secondary">Reset</button>
  		<button type="submit" class="btn btn-primary">Submit</button>
  		</c:forEach>
    	</form>
	</div>
<div class="footer">
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</body>
</html>