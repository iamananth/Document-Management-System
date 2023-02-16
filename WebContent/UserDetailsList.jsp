<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Manage Users</title>
<link rel="stylesheet" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="js/Heartbeat.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
</head>
<body>
<nav id="navbar" class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
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
		<svg xmlns="http://www.w3.org/2000/svg" fill="white" class="bi bi-person-circle" height="35" width="35" viewBox="0 0 20 12" style="position: relative;left: 938px;">
  			<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"></path>
  			<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" style="margin-left: 335px;"></path>
		</svg>
      </li>
      <li class="nav-item active">
		<a class="nav-link" style="position: relative;left: 933px;">${user.username}</a>
      </li>
      <li class="nav-item active">
        <form action="UserLogout" method="post"><button class="btn btn-danger my-2 my-sm-0" style="margin-left: 950px;">Logout</button></form>
      </li>
    </ul>
  </div>
</nav>
<div class="container-lg">
<h5>User Details</h5>
<form action="EditUser" method="get"><input type="hidden" id="id" name="id" /><button type="submit" class="btn btn-success">Edit</button></form>
<form action="DeleteUser" method="get"><input type="hidden" id="id1" name="id1" /><button style="margin-left: 61px;margin-top: -38px;" type="submit" onclick="return confirm('Are you sure you want to delete? This Cannot be undone.')" class="btn btn-danger add-new">Delete</button></form><br>
<table class="table table-bordered table-sm" id="myTable">
  <thead>
    <tr>
      <th></th>
      <th scope="col">User ID</th>
      <th scope="col">Username</th>
      <th scope="col">Department</th>
      <th scope="col">Phone Number</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="row">
    <tr>
    <td><input type="radio" id="radioButton" onclick="selectRow(this)" name="choice" /></td>
	 <th id="userid" scope="row">${row.id}</th>
      <td id="uname">${row.username}</td>
      <td id="dept">${row.department}</td>
      <td id="ph">${row.phone_number}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<!-- <form action="DownloadServlet" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="fname" name="fname" /><button type="submit" class="btn btn-info">Download</button></form><br> -->
<!-- <form action="ViewPdfServlet" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="fname1" name="fname" /><button type="submit" class="btn btn-warning" style="margin-left: 107px;margin-top: -59px;">View</button></form> -->

</div>
<script type="text/javascript">
$(document).ready( function () {
    $('#myTable').DataTable();
} );
</script>
	<script src="js/script.js"></script>
	<script type="text/javascript">
	function selectRow(radio) {
	    var row = radio.parentNode.parentNode;
	    var id = row.getElementsByTagName("th")[0].innerHTML;
	    document.getElementById("id").value = id;
	    document.getElementById("id1").value = id;
	    var rows = document.getElementById("myTable").getElementsByTagName("tr");
	    
	    for (var i = 0; i < rows.length; i++) {
	      rows[i].classList.remove("selected");
	    }
	    row.classList.add("selected");
	  }
	</script>
</body>
<br><br><br>
<div class="footer">
  <p style="text-align: center;">Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</html>