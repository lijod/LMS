<%@ page import="com.lms.model.User" %>
<%@ page import="com.lms.util.ImageUtil" %>

<% 
	User user = (User) request.getAttribute("user");
	int userId = 0; 
	if(user == null) 
		response.sendRedirect("../user/user-login.jsp");
	else
		userId = user.getUserId();
%>

<div style="width: 100%; height: 50px;">
	<img style="float: right; width: 40px; height: 50px;" src="<%= ImageUtil.getBase64ImageFromByte(user.getUserImage()) %>" alt="No image" /> &nbsp;
	<span style="float: right;"><b>You are logged in as: <%= user.getUserName() %></b></span>
	<a href="/LMS/jsp/user/user-login.jsp">LOGOUT</a>
</div>

<script type="text/javascript">
	
	function navigate(path){
		console.log("Navigating to: " + path);
		var form = $('<form>', {
		    "html":  '<input type="hidden" name="userId" value="<%= userId %>" />'
		    + 
		    		'<input type="hidden" name="path" value="' + path + '" />',
		    "action": '<%= applicationContext %>/Navigator',
		    "method": 'post'
		});
		form.appendTo("body").submit();
	}
	
</script>