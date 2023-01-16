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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
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
	
	<h4>Project Details</h4>
	<form action="UserLogout" method="post"><button class="btn btn-danger" style="margin-left: 937px; margin-top: -62px;">Logout</button></form>
	<a href="UserDashboard.jsp"><button class="btn btn-info" style="margin-left: 868px; margin-top: -111px;">Back</button></a>
	<table class="table table-borderless">
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
      <form action="ViewPdfServlet" method="get"><input type="hidden" value="${row.fileName}" /><button type="submit" class="btn btn-warning" style="margin-left: 104px; margin-top: -117px;">View</button></form>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	<script src="js/script.js"></script>
</body>
</html>