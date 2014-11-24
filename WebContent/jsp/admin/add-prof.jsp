<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learning Management System</title>
<link href="/LMS/css/bootstrap/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="/LMS/js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<select class="form-control">
				<option class="form-control">SELECT</option>
				<option class="form-control">Prof1</option>
				<option class="form-control">Prof2</option>
			</select>
			<br/>
			<button id="edit-prof" class="btn btn-default">EDIT</button>
			<button id="delete-prof" class="btn btn-default">DELETE</button>
			<button id="add-prof" class="btn btn-default" onClick="createProfessor()">ADD NEW</button>
		</div>
		
		<div>
			<!-- label for="first-name">FIRST NAME</label-->
			<input id="first-name" name="first-name" type=text class="form-control" placeholder="FIRST NAME"/>
			<!-- label for="last-name">LAST NAME</label-->
			<input id="last-name" name="last-name" type=text class="form-control" placeholder="LAST NAME"/>
			<!-- label for="user-name">USER NAME</label-->
			<input id="user-name" name="user-name" type=text class="form-control" placeholder="USER NAME"/>
			<!-- label for="password">PASSWORD</label-->
			<input id="password" name="password" type=text class="form-control" placeholder="PASSWORD"/>
			<!-- label for="email">E-MAIL ADDRESS</label-->
			<input id="email" name="email" type=text class="form-control" placeholder="E-MAIL ADDRESS"/>
			<!-- label for="dob">DATE OF BIRTH</label-->
			<input id="dob" name="dob" type=text class="form-control" placeholder="DATE OF BIRTH"/>
		</div>
	</div>
</body>

<script type="text/javascript">
	var applicaitonURL = "/LMS/api";
	var userServiceURl = applicaitonURL + "/jwsUserService/createUser";
	function createProfessor(){
		$.ajax({
			type : "GET",
			url :  userServiceURl + getProfessorQueryString(),
			success : function (result) {
				console.log(result);
			},
			failure : function () {
				console.log("failed");
			}
		});
	}
	
	function getProfessorQueryString(){
		return "/" + 
		$("#user-name").val() + 
		"/" + 
		$("#password").val() + 
		"/"+
		$("#first-name").val() + 
		"/" + 
		$("#last-name").val() +
		"/" + 
		$("#email").val() + 
		"/" + 
		$("#dob").val()
	}
</script>
</html>