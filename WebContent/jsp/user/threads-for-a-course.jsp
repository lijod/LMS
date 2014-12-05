<%@ include file="../common.jsp"%>
<link href="/LMS/css/jquery-te-1.4.0.css" rel="stylesheet">

<script src="/LMS/js/jquery-te-1.4.0.min.js" type="text/javascript"></script>
<html>
<style>

table, td, th {
    border: .1px solid black;
    
}
.spanClass hover {
  text-decoration: underline;
  color: blue;
  cursor: hand;
}

.table-spacing{
   border-spacing:5px;
}

</style>

<body>
	<div class="container">
		<div>
			<select id="course-list" class="form-control">
				
			</select> <br />			
		</div> <br />		
	</div>
	<table  class="table table-striped">
		<tr><th style="width:350px"> Threads Preview</th><th> Thread and Response</th></tr>
		
		<tr style="height:650px;">
		
		<td><table  id="tbl-all-threads" class="table table-striped"></table></td>
		<td><table id="tbl-thread-desc" class="table table-striped"></table></td>
		</tr>

		</table>
</body>
</html>

<script type="text/javascript">

var applicaitonURL = "/LMS/api";
var userServiceURl ;

$(document).ready(function(){	
	refreshCourseList();
});


function refreshCourseList(){
	userServiceURl = applicaitonURL + "/jwsCourseService/findAllCoursesForAUserId";
	$.ajax({
		type : "POST",
		url :  userServiceURl,
		data: "2",
		dataType:"JSON",
		contentType: "application/json",
		success : function (result) {
			console.log(result);
			$.each(result, function(i, val){
				$("#course-list").append(
						"<option id='course-" + val.courseId + "' value='"+val.courseId+"'>" + val.courseName + "</option>");
			});		
			var courseId = $("#course-list").children(":selected").attr("value");
			loadAllThreadsByCourseId(courseId);
		},
		failure : function () {
			console.log("failed");
		}
	});
}


function loadAllThreadsByCourseId(courseId){
console.log(courseId);
userServiceURl =  applicaitonURL + "/jwsThreadService/findThreadsByCourseId";
	$.ajax({
		type : "POST",
		url :  userServiceURl,
		data: JSON.stringify(courseId),
		dataType:"JSON",
		contentType: "application/json",
		success : function (result) {
			$("#tbl-all-threads").children().remove();
			$("#tbl-thread-desc").children().remove();
			if(result.length > 0){	
			$.each(result, function(i, val){				
				$("#tbl-all-threads").append(
						"<tr style='height:120px;'> <td  onClick='clickOnThread("+val.threadId+")'> <span class='spanClass'  id='"+ val.threadId +"'>"+ val.threadContent+ "</span></td></tr>");
			});
			
			var firstThreadIdInList = $("#tbl-all-threads span:first").attr("id");
			loadAThreadAndItsAllPosts(firstThreadIdInList);
		}
			
			
		},
		failure : function () {
			console.log("failed");
		}
	});
}
	


function loadAThreadAndItsAllPosts(threadId){
	console.log("loadAThreadAndItsAllPosts");
	userServiceURl = applicaitonURL + "/jwsThreadService/findAThreadByThreadId";
	$.ajax({
		type : "POST",
		url :  userServiceURl,
		data : JSON.stringify(threadId),
		dataType:"JSON",
		contentType: "application/json",
		success : function (result) {
			$("#tbl-thread-desc").children().remove();	
				 $("#tbl-thread-desc").html(
						"<tr style='height:120px;'> <td> <a href='#' id='thread-" + result.threadId + "'>"+ result.threadContent+ "</a></td></tr>"+
						"<tr style='height:5px;'> <td> <span id='span-" + result.threadId + "'>Created on :"+ result.threadDate+ "</span></td></tr>"		
				 );
				 
				$.each(result.posts, function(i, val){				
				 $("#tbl-thread-desc").append(
						"<tr style='height:120px;'> <td> <a href='#' id='post-" + val.postId + "'>"+ val.postContent +"</a></td></tr><br/>"); 				
			});
				
				 $("#tbl-thread-desc").append(
							"<tr style='height:120px;'><td>"+
							
							
							"<textarea name='textarea' id='txt-replyToThread' style='height: 100%;width:100%'></textarea>"+
							"<input id='btn-submit-post' onClick='submitpost("+threadId+")' class='btn btn-primary' type='submit' value='Post' style='' />"+							
							"</td></tr>"); 		
				
				
		},
		failure : function () {
			console.log("failed");
		}
	});
	
}
	
function clickOnThread(threadId) {
	loadAThreadAndItsAllPosts(threadId);
}

$("#course-list").change(function() {
	var courseId = $(this).children(":selected").attr("value");
	console.log(courseId);
	loadAllThreadsByCourseId(courseId);
});


function submitpost(threadId){
	userServiceURl = applicaitonURL + "/jwsPostService/createPost";

	 
	var postContent=$("#txt-replyToThread").val();
    var userId = 2;
    var threadId=threadId;
    var post={"postContent" : postContent,  "userId" : userId,"threadId" : threadId};
	console.log(post);
	$.ajax({
		type : "POST",
		url :  userServiceURl,
		data : JSON.stringify(post),
		dataType:"JSON",
		contentType: "application/json",
		success : function (result) {
			console.log(result);				
				
		},
		failure : function () {
			console.log("failed");
		}
	});
	
}



</script>