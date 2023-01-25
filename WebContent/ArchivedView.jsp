<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Archived Projects</title>
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
	<h4>Archived Project Details</h4><br>
<!-- 	<form action="UserLogout" method="post"><button class="btn btn-danger" style="margin-left: 937px; margin-top: -62px;">Logout</button></form> -->
<!-- 	<a href="UserDashboard.jsp"><button class="btn btn-info" style="margin-left: 868px; margin-top: -111px;">Back</button></a> -->
	<table class="table table-bordered table-sm" id="myTable">
  <thead>
    <tr>
      <th></th>
      <th scope="col">Project Code</th>
      <th scope="col">Start Date</th>
      <th scope="col">End Date</th>
      <th scope="col">Project Type</th>
      <th scope="col">File Name</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${details}" var="row">
    <tr>
    <td><input type="radio" id="radioButton" onclick="selectRow(this)" name="choice" /></td>
	 <th id="pcode" scope="row">${row.pcode}</th>
      <td id="pstart">${row.startDate}</td>
      <td id="pend">${row.endDate}</td>
      <td id="ptype">${row.ptype}</td>
      <td id="filename">${row.fileName}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<form action="DownloadServlet" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="fname" name="fname" /><button type="submit" class="btn btn-info">Download</button></form><br>
<form action="ViewPdfServlet" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="fname1" name="fname" /><button type="submit" class="btn btn-warning" style="margin-left: 107px;margin-top: -59px;">View</button></form>
<form action="EditProject" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="ppcode1" name="pcode" /><button type="submit" class="btn btn-success" style="margin-left: 177px;margin-top: -77px;">Edit</button></form>
<form action="DeleteProjectServlet" method="get" style="height: 0px;margin-bottom: 9px;"><input type="hidden" id="fname2" name="fname" /><input type="hidden" id="ppcode2" name="pcode"/><button type="submit" onclick="return confirm('Are you sure you want to delete? This Cannot be undone.')" class="btn btn-danger add-new" style="margin-left: 240px;margin-top: -94px;">Delete</button></form>
</div>
	<script src="js/script.js"></script>
	<script type="text/javascript">
	function selectRow(radio) {
	    var row = radio.parentNode.parentNode;
	    var pcode = row.getElementsByTagName("th")[0].innerHTML;
	    document.getElementById("fname").value = pcode+".pdf";
	    document.getElementById("fname1").value = pcode+".pdf";
	    document.getElementById("fname2").value = pcode+".pdf";
	    document.getElementById("ppcode1").value = pcode;
	    document.getElementById("ppcode2").value = pcode;
	    var rows = document.getElementById("myTable").getElementsByTagName("tr");
	    
	    for (var i = 0; i < rows.length; i++) {
	      rows[i].classList.remove("selected");
	    }
	    row.classList.add("selected");
	    
	    
	  }
	</script>
</body>
<div class="footer">
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</div>
</html>