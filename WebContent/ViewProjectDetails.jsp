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
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
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
<!-- 	<form action="UserLogout" method="post"><button class="btn btn-danger" style="margin-left: 937px; margin-top: -62px;">Logout</button></form> -->
<!-- 	<a href="UserDashboard.jsp"><button class="btn btn-info" style="margin-left: 868px; margin-top: -111px;">Back</button></a> -->
	<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Project Code</th>
      <th scope="col">Start Date</th>
      <th scope="col">End Date</th>
      <th scope="col">Project Type</th>
      <th scope="col">File Name</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${details}" var="row">
    <tr>
	 <th scope="row">${row.pcode}</th>
      <td>${row.startDate}</td>
      <td>${row.endDate}</td>
      <td>${row.ptype}</td>
      <td>${row.fileName}</td>
      <td>
      <form action="DownloadServlet" method="get"><input type="hidden" name="fname" value="${row.fileName}" /><button type="submit" class="btn btn-info">Download</button></form><br>
      <form action="ViewPdfServlet" method="get"><input type="hidden" id="fname" name="fname" value="${row.fileName}" /><button type="submit" class="btn btn-warning" style="margin-left: 104px; margin-top: -117px;">View</button></form>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
	<script src="js/script.js"></script>
</body>
</html>