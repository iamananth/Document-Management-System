<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Dashboard</title>
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
	<%

		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader ("Expires", 0);
 			if(session.getAttribute("user")==null){
    			response.sendRedirect(request.getContextPath() + "/UserLogin.jsp");

			}
	%>
	<h1 class="text-bg-primary p-3">Document Management System</h1>
	<div class="container-lg">
		<div class="alert alert-success" style="margin-right: 251px;" role="alert">
			Welcome, <c:out value="${user.username}" />
		</div>
		<form action="UserLogout" method="post"><button class="btn btn-danger" style="margin-left: 937px; margin-top: -62px;">Logout</button></form>
		<div class="card">
  			<h5 class="card-header">Featured</h5>
  			<div class="card-body">
    			<h5 class="card-title">Add Project Details</h5>
    			<%-- <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>--%>
    			<a href="ProjectEntry.jsp" class="btn btn-primary">Add</a>
  			</div>
		</div><br>
		<div class="card">
  			<div class="card-body">
    			<h5 class="card-title">Project Document Upload</h5>
    			<%-- <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>--%>
    			<a href="FileUpload.jsp" class="btn btn-primary">Upload</a>
  			</div>
		</div><br>
	</div>
</body>
</html>
