<%@ include file="../common.jsp"%>
<% 
String errorMessage=(String) request.getAttribute("errorMessage");

%>
<html>
<%=
errorMessage
%>
<body>
<form id="form-user-login" action="/LMS/UserLoginServlet" method="post">

<div class="radio">

<label><input id="id-rb-admin" name="user-type" type="radio"  value="Admin"  />Admin</label>
<label><input id="id-rb-ta" name="user-type" type="radio"  value="TA"  />TA</label>
<label><input id="id-rb-prof" name="user-type" type="radio"  value="PROFESSOR"  />Professor</label>
<label><input id="id-rb-student" name="user-type" type="radio" value="Student"  />Student</label>
</div>

<input id="user-name" name="user-name" type="text" class="form-control" placeholder="USER NAME" />
<input id="password" name="password" type="text" class="form-control" placeholder="PASSWORD" />
<button id="btn-login" class="btn btn-default">LOGIN</button>
</form>
</body>
</html>

           





<script type="text/javascript">

/* $("#btn-login").click(function(){
	
	$( "#form-user-login" ).submit();
	
	
})


$( "#form-user-login" ).submit(function( event ) {
	HttpServletResponse.sendRedirect("../your/new/location.jsp")
}); */
</script>