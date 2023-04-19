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
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
$(document).ready( function () {
    $('#myTable').DataTable();
} );
</script>
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
		<svg xmlns="http://www.w3.org/2000/svg" fill="white" class="bi bi-person-circle" height="35" width="35" viewBox="0 0 20 12" style="position: relative;left: 1075px;">
  			<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"></path>
  			<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" style="margin-left: 335px;"></path>
		</svg>
      </li>
      <li class="nav-item active">
		<a class="nav-link"  style="position: relative;left: 1070px;">${user.username}</a>
      </li>
      <li class="nav-item active">
        <form action="UserLogout" method="post"><button class="btn btn-danger my-2 my-sm-0" style="margin-left: 1090px;">Logout</button></form>
      </li>
    </ul>
  </div>
</nav>
<!-- <!-- Modal -->
<!-- 	<div class="modal fade" id="exampleModalCenter" tabindex="-1" -->
<!-- 		role="dialog" aria-labelledby="exampleModalCenterTitle" -->
<!-- 		aria-hidden="true"> -->
<!-- 		<div class="modal-dialog modal-dialog-centered" role="document"> -->
<!-- 			<div class="modal-content"> -->
<!-- 				<div class="modal-header"> -->
<!-- 					<button type="button" class="close" data-dismiss="modal" -->
<!-- 						aria-label="Close"> -->
<!-- 						<span aria-hidden="true">&times;</span> -->
<!-- 					</button> -->
<!-- 				</div> -->
<!-- 				<div class="modal-body"> -->
<!-- 					Are you sure? This cannot be undone. -->
<!-- 					<div class="modal-footer"> -->
<!-- 					<button type="button" class="btn btn-secondary" -->
<!-- 						data-dismiss="modal">Close</button> -->
<!-- 					<input type="submit" class="btn btn-danger" value="Delete"/> -->
<!-- 				</div>				 -->
<!-- 				</div> -->
				
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<div class="container-lg">
	<h4>Project Details</h4><br>
<!-- 	<form action="UserLogout" method="post"><button class="btn btn-danger" style="margin-left: 937px; margin-top: -62px;">Logout</button></form> -->
<!-- 	<a href="UserDashboard.jsp"><button class="btn btn-info" style="margin-left: 868px; margin-top: -111px;">Back</button></a> -->
	<table class="table table-bordered table-sm" id="myTable">
  <thead>
    <tr>
      <th></th>
      <th scope="col">GUID</th>
      <th scope="col">Project Code</th>
      <th scope="col">Start Date</th>
      <th scope="col">End Date</th>
      <th scope="col">Project Type</th>
      <th scope="col">File Name</th>
      <th scope="col">Username</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${details}" var="row">
    <tr>
    <td><input type="radio" id="radioButton" onclick="selectRow(this)" name="choice" /></td>
    <th id="guid" scope="row">${row.guid}</th>
	  <td id="pcode">${row.pcode}</td>
      <td id="pstart">${row.startDate}</td>
      <td id="pend">${row.endDate}</td>
      <td id="ptype">${row.ptype}</td>
      <td id="filename">${row.fileName}</td>
      <td id="id">${row.user.username}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<form action="DownloadServlet" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="fname" name="fname" /><button type="submit" class="btn btn-info">Download</button></form><br>
<form action="ViewPdfServlet" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="fname1" name="fname" /><!-- <input type="hidden" id="ppcode" name="ppcode" /> --><button type="submit" class="btn btn-warning" style="margin-left: 107px;margin-top: -59px;">View</button></form>
<form action="EditProject" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="guid1" name="guid1" /><button type="submit" class="btn btn-success" style="margin-left: 177px;margin-top: -77px;">Edit</button></form>
<form action="DeleteProjectServlet" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="fname2" name="fname" /><input type="hidden" id="guid2" name="guid"/><button type="submit" onclick="return confirm('Are you sure you want to delete? This Cannot be undone.')" class="btn btn-danger add-new" style="margin-left: 240px;margin-top: -94px;">Delete</button></form>
</div>
	<script type="text/javascript">
	window.onscroll = function() {myFunction()};

	// Get the navbar
	var navbar = document.getElementById("navbar");

	// Get the offset position of the navbar
	var sticky = navbar.offsetTop;

	// Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position
	function myFunction() {
	  if (window.pageYOffset >= sticky) {
	    navbar.classList.add("sticky");
	  } else {
	    navbar.classList.remove("sticky");
	  }
	}
	</script>
	<script src="js/script.js"></script>
	<script type="text/javascript">
	function selectRow(radio) {
	    var row = radio.parentNode.parentNode;
	    var guid = row.getElementsByTagName("th")[0].innerHTML;
	    var pcode = row.getElementsByTagName("td")[1].innerHTML;
	    var fn = row.getElementsByTagName("td")[5].innerHTML;
	    document.getElementById("fname").value = fn;
	    document.getElementById("fname1").value = fn;
	    document.getElementById("fname2").value = fn;
	    document.getElementById("guid1").value = guid;
	    document.getElementById("guid2").value = guid;
	    var rows = document.getElementById("myTable").getElementsByTagName("tr");
	    
	    for (var i = 0; i < rows.length; i++) {
	      rows[i].classList.remove("selected");
	    }
	    row.classList.add("selected");
	    
	    
	  }
	</script>
</body>
<br><br><br><br><br>
<div class="footer">
  <p style="text-align: center;">Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</html>