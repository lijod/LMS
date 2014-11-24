<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/lms/css/bootstrap/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
	<div class="container">
		<select>
			<option>Prof1</option>
			<option>Prof2</option>
		</select>
		<button id="edit-prof">EDIT</button>
		<button id="delete-prof">DELETE</button>
		<button id="add-prof">ADD NEW</button>
		
		<div>
			<label for="first-name">FIRST NAME</label>
			<input id="first-name" name="first-name" type=text/>
			<label for="last-name">LAST NAME</label>
			<input id="last-name" name="last-name" type=text/>
			<label for="user-name">USER NAME</label>
			<input id="user-name" name="user-name" type=text/>
			<label for="password">PASSWORD</label>
			<input id="password" name="password" type=text/>
			<label for="eamil">E-MAIL ADDRESS</label>
			<input id="eamil" name="eamil" type=text/>
			<label for="dob">DATE OF BIRTH</label>
			<input id="dob" name="dob" type=text/>
		</div>
	</div>
</body>
</html>