function register() {
	var userid = document.getElementById("userid").value;
	var pass = document.getElementById("pass").value;
	var repass = document.getElementById("repass").value;
	var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;

	if (userid == '') {
		alert("Please enter your user name");
		return false;
	}
	else if (pass == '') {
		alert("Please enter your password");
		return false;
	}
	else if (repass == '') {
		alert("Please re enter your password");
		return false;
	}
	else if (pass != repass) {
		alert("Passwords not matches");
		return false;
	}
	if (!pass.match(decimal)) {
		alert("Password should be between 8 to 15 characters which contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character.");
		return false;
	}

}

function login(){
	var uname = document.getElementById("uname").value;
	var pass = document.getElementById("pass").value;
	if(uname == ''){
		alert("Please enter your user name");
		return false;
	}
	else if(pass == ''){
		alert("Please enter your password");
		return false;
	}
}

function clear(){
	document.getElementById("userid").value = "";
	document.getElementById("pass").value = "";
	document.getElementById("repass").value = "";
}

function showPass() {
	var x = document.getElementById("pass");
	  if (x.type === "password") {
		  x.type = "text";
	  } else {
	    x.type = "password";
	  }
	} 

$(document).ready( function () {
    $('#example').DataTable( {
    	paging: true
    });
} );

function selectRow(radio) {
    var row = radio.parentNode.parentNode;
    var rows = document.getElementById("myTable").getElementsByTagName("tr");
    
    for (var i = 0; i < rows.length; i++) {
      rows[i].classList.remove("selected");
    }
    row.classList.add("selected");
  }

function downProject(fname) {
	  var xhr = new XMLHttpRequest();
	  xhr.open("GET", "DownloadServlet/?fname=" + fname, true);
	  xhr.send();
	}