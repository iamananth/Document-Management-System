<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
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
  <a class="navbar-brand" href="UserDashboard.jsp">DMS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="UserDashboard.jsp">User Dashboard</a>
      </li>
      <li class="nav-item active">
        <form id="GG" action="GuidGen" method="post"><a class="nav-link" href="#" onClick="document.getElementById('GG').submit();">Add Project</a></form>
      </li>
      <li class="nav-item active">
		<svg xmlns="http://www.w3.org/2000/svg" fill="white" class="bi bi-person-circle" height="35" width="35" viewBox="0 0 20 12" style="position: relative;left: 776px;">
  			<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"></path>
  			<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" style="margin-left: 335px;"></path>
		</svg>
      </li>
      <li class="nav-item active">
		<a class="nav-link" style="position: relative;left: 771px;">${user.username}</a>
      </li>
      <li class="nav-item active">
        <form action="UserLogout" method="post"><button class="btn btn-danger my-2 my-sm-0" style="margin-left: 783px;">Logout</button></form>
      </li>
    </ul>
  </div>
</nav>
	<div class="container-lg">
	<h4>Edit Project Details</h4>
	<form action="UpdateProject" method="post">
	<c:forEach items="${details}" var="row">
  		<div class="row mb-4">
  		<div class="col">
      		<div class="form-outline">
      			<label class="form-label" for="guid">Project GUID</label>
        		<input type="text" name="guid" id="guid" value="${row.guid}" class="form-control" readonly/>
      		</div><br>
      		</div>
      		</div>
    		<div class="col">
      			<div class="form-outline">
      			<input type="hidden" name="uid" id="uid" value="${user.username}"/>
      				<label class="form-label" for="pcode">Project Code</label>
       				<input type="text" name="pcode" id="pcode" value="${row.pcode}" class="form-control" />
      			</div>
    	   </div>
  		<div class="col">
      		<div class="form-outline">
      			<label class="form-label" for="pstart">Project Start Date</label>
        		<input type="date" name="pstart" id="pstart" value="${row.startDate}" class="form-control" />
      		</div><br>
      		<div class="form-outline">
      			<label class="form-label" for="pend">Project End Date</label>
    			<input type="date" name="pend" id="pend" value="${row.endDate}" class="form-control" /><br>
  			</div>
    	</div>
  		<div class="form-outline mb-4">
  			<label class="form-label" for="ptype">Project Type</label>
    		<input type="text" name="ptype" id="ptype" value="${row.ptype}" class="form-control" />
    	</div>
    	<button type="reset" class="btn btn-secondary">Reset</button>
  		<button type="submit" class="btn" id="btn-yellow">Submit</button>
  		</c:forEach>
    	</form>
	</div>
	<script src="js/script.js"></script>
</body>
<div class="footer">
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</html>