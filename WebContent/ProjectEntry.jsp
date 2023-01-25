<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Details</title>
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
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">DMS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="UserDashboard.jsp">User Dashboard</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="ProjectEntry.jsp">Add Project</a>
      </li>
      <li class="nav-item active">
		<a class="nav-link" href="FileUpload.jsp">Upload Documents</a>
      </li>
      <li class="nav-item active">
        <form action="UserLogout" method="post"><button class="btn btn-danger my-2 my-sm-0" style="margin-left: 950px;">Logout</button></form>
      </li>
    </ul>
  </div>
</nav>
	<div class="container-lg">
	<h4>Project Details</h4>
	<form action="ProjectServlet" method="post">
  		<div class="row mb-4">
    		<div class="col">
      			<div class="form-outline">
      			<input type="hidden" name="uid" id="uid" value="${user.id}"/>
      				<label class="form-label" for="pcode">Project Code</label>
       				<input type="text" name="pcode" id="pcode" class="form-control" />
      			</div>
    	   </div>
  		</div>
  		<div class="col">
      		<div class="form-outline">
      			<label class="form-label" for="pstart">Project Start Date</label>
        		<input type="date" name="pstart" id="pstart" class="form-control" />
      		</div><br>
      		<div class="form-outline">
      			<label class="form-label" for="pend">Project End Date</label>
    			<input type="date" name="pend" id="pend" class="form-control" /><br>
  			</div>
    	</div>
  		<div class="form-outline mb-4">
  			<label class="form-label" for="ptype">Project Type</label>
    		<input type="text" name="ptype" id="ptype" class="form-control" />
    	</div>
    	<button type="reset" class="btn" id="btn-yellow">Reset</button>
  		<button type="submit" class="btn" id="btn-yellow">Submit</button>
    	</form>
	</div>
	<script src="js/script.js"></script>
</body>
<div class="footer">
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</div>
</html>