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
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js" integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<h1 class="text-bg-primary p-3">Document Management System</h1>
	<div class="container-lg">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-8">
						<h2>User Details</h2>
					</div>
				</div>
			</div>
			<table id="example" class="table table-striped" style="width:100%">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Department</th>
						<th>Phone Number</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${users}" var="row">
					<tr>
						<td>${row.id}</td>
						<td>${row.username}</td>
						<td>${row.department}</td>
						<td>${row.phone_number}</td>
						<td>
							<div class="row">
   								<div class="col-xs-6 text-center">
       								<button type="button" data-toggle="modal" data-target="#exampleModalCenter" class="btn btn-info btn-md center-block" Style="width: 100px;">Edit</button><br>
       							</div>
       							<div class="col-xs-6 text-center">
       								<form><button type="submit" class="btn btn-danger btn-md center-block" Style="width: 100px;">Delete</button></form>
     							</div>
							</div>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<%--Edit Modal --%>
			<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  				<div class="modal-dialog modal-dialog-centered" role="document">
    				<div class="modal-content">
      					<div class="modal-header">
        					<h5 class="modal-title" id="exampleModalLongTitle">Edit User</h5>
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          							<span aria-hidden="true">&times;</span>
        						</button>
      					</div>
      					<div class="modal-body">
        					<%
								String id = request.getParameter("id");
								String sql = "SELECT * FROM users WHERE id = ?";
								Class.forName("oracle.jdbc.driver.OracleDriver");  
					        	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","root"); 
								PreparedStatement statement = connection.prepareStatement(sql);
								statement.setString(1, id);
								ResultSet result = statement.executeQuery();

								if (result.next()) {
									String name = result.getString("username");
									String pass = result.getString("password");
									String dept = result.getString("department");
									String ph = result.getString("phone_number");
							%>

  							<form>
    							<input class="form-control form-control-sm" type="hidden" name="id" value="<%= id %>">
    							<label>User Name</label> 
								<input class="form-control form-control-sm" type="text" name="uname" id="uname" value="<%= name %>"> <br> 
								<label>Password</label> 
								<input class="form-control form-control-sm" type="password" name="pass" id="pass" value="<%= pass %>"> <br> 
								<label>Department</label>
								<input class="form-control form-control-sm" type="text" name="dept" id="dept" value="<%= dept %>"><br>
								<label>Phone Number</label>
								<input class="form-control form-control-sm" type="text" name="ph" id="ph" value="<%= ph %>"><br>
  							
						<%
  							}
						%>
      							<div class="modal-footer">
        							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        							<button type="button" class="btn btn-primary">Save changes</button>
      							</div>
      					</form>
    				</div>
  				</div>
			</div>
		</div>
	</div>
</body>
<div class="position-absolute bottom-0 start-50 translate-middle-x">
<footer>
  <p>Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved.</p>
</footer>
</div>
</html>