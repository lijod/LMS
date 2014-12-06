<%@ page import="com.lms.model.User" %>

<% 
	User user = (User) request.getAttribute("user");
	int userId = 0; 
	if(user == null) 
		response.sendRedirect("../user/user-login.jsp");
	else
		userId = user.getUserId();
%>

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