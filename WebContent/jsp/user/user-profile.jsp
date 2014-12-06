<%@ include file="../common.jsp"%>
<%@ include file="../check-login.jsp"%>

</html>
<body>
	<a href="javascript:void(0)" onClick="navigate('/jsp/user/threads-for-a-course.jsp')">VIEW ALL THREADS</a>
	<a href="javascript:void(0)" onClick="navigate('/jsp/admin/add-prof.jsp')">ADD PROFESSOR</a>
	<a href="javascript:void(0)" onClick="navigate('/jsp/user/threads-for-a-course.jsp')">ADD/VIEW THREAD</a>
	<a href="javascript:void(0)" onClick="navigate('/jsp/professor/add-ta.jsp')">ADD TA</a>
	<input type="button" id="btn-set-follower" value="follow" class="btn btn-warning" style="float:left;" />
	<input type="text" id="tb-user-id">
	<input type="button" id="btn-Un-set-follower" value="Unfollow" class="btn btn-warning" style="float:left;" />
</body>
</html>


<script type="text/javascript">

var applicaitonURL = "/LMS/api";
var userServiceURl ;

$("#btn-set-follower").click(function(){
	console.log({"followerUserId" : "<%= userId %>",  "followedUserId" :"10"});
	console.log(JSON.stringify({"followerUserId" : <%= userId %>,  "followedUserId" :10}));
	userServiceURl =  applicaitonURL + "/jwsUserService/UserFollowsAnotherUser";
	$.ajax({
		type : "POST",
		url : userServiceURl,
		data : "9",
		dataType:"JSON",
		contentType: "application/json",
		success : function(user){
			console.log(user);
		},
		failure : function(){
			console.log("Error while Following a User...");
		}
	});

})


$("#btn-Un-set-follower").click(function(){
	console.log({"followerUserId" : "<%= userId %>",  "followedUserId" :"10"});
	console.log(JSON.stringify({"followerUserId" : <%= userId %>,  "followedUserId" :10}));
	userServiceURl =  applicaitonURL + "/jwsUserService/UserUnFollowsAnotherUser";
	$.ajax({
		type : "POST",
		url : userServiceURl,
		data : {"followerUserId" : <%= userId %>, "followedUserId" : 5},
		dataType:"JSON",
		contentType: "application/json",
		success : function(user){
			console.log(user);
		},
		failure : function(){
			console.log("Error while Following a User...");
		}
	});

})


</script>