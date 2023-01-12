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
	<h4>Project Document Upload</h4>
	<form action="FileUploadServlet" method="post" enctype="multipart/form-data"> 
  		<div class="row mb-4">
    		<div class="col">
      			<div class="form-outline">
      				<label class="form-label" for="pcode">Project Code</label>
       				<input type="text" name="pcode" id="pcode" class="form-control" />
      			</div>
    	   </div>
  		</div>
  		
    		<label for="formFile" class="form-label">Upload Documents</label>
			<input class="form-control" name="fileName" type="file" id="formFile" /><br>
    	<button type="submit" class="btn btn-primary btn-block mb-4">Upload</button>
    	</form>
	</div>
	<script src="js/script.js"></script>
</body>
</html>