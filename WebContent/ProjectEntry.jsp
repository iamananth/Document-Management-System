<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1 class="text-bg-primary p-3">Document Management System</h1>
	<div class="container-lg">
	<h4>Project Details</h4>
	<form action="ProjectServlet" method="post">
  		<div class="row mb-4">
    		<div class="col">
      			<div class="form-outline">
      			<input type="hidden" name="uid" id="uid" value="${user.id}"/>
      				<label class="form-label" for="pcode">Project Code</label>
       				<input type="number" name="pcode" id="pcode" class="form-control" />
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
    	<button type="reset" class="btn btn-secondary btn-block mb-4">Reset</button>
  		<button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
    	</form>
<!--  	<form action="FileUploadServlet" method="post" enctype="multipart/form-data">  -->
<!--     	<div> -->
<!--     		<label for="formFile" class="form-label">Upload Documents</label> -->
<!-- 			<input class="form-control" name="fileName" type="file" id="formFile" /><br> -->
<!--     	</div> -->
<!--     	<button type="submit" class="btn btn-primary btn-block mb-4">Submit</button> -->
<!-- 	</form> -->
	</div>
	<script src="js/script.js"></script>
</body>
</html>