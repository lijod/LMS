<%@ include file="../common.jsp"%>
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
				<option class="form-control">Select</option>
			</select> <br />			
		</div> <br />		
	</div>
	<table  class="table table-striped">
		<tr><th style="width:350px"> Threads Preview</th><th> Thread and Response</th></tr>
		
		<tr style="height:650px;">
		
		<td><table  id="tbl-all-threads" class="table table-striped"></table></td>
		<td><table id="tbl-thread-desc" class="table table-striped"></table></td>
		</tr>
	    
		<!-- <tr style="height:150px;">
		<td><a href="#">Thread1</a></td>
		</tr>
			<tr>
		<td>Thread1</td>
		</tr> -->
		</table>
</body>
</html>

<script type="text/javascript">

var applicaitonURL = "/LMS/api";
var userServiceURl ;

$(document).ready(function(){	
	refreshCourseList();
	loadAllThreads();
	loadAThreadAndItsAllPosts();
});
	
function refreshCourseList(){
	userServiceURl = applicaitonURL + "/jwsCourseService/findAllCourses";
	$.ajax({
		type : "GET",
		url :  userServiceURl,
		dataType:"JSON",
		success : function (result) {
			//console.log(result);
			$.each(result, function(i, val){
				$("#course-list").append(
						"<option id='course-" + val.courseId + "' value='"+val.courseId+"'>" + val.courseName + "</option>");
			});			

		},
		failure : function () {
			console.log("failed");
		}
	});
}

function loadAllThreads(){
	console.log("loadallthreads");
	userServiceURl =  applicaitonURL + "/jwsThreadService/findAllThreads";
	$.ajax({
		type : "POST",
		url :  userServiceURl,
		dataType:"JSON",
		contentType: "application/json",
		success : function (result) {
			//console.log(result);
			$.each(result, function(i, val){				
				$("#tbl-all-threads").append(
						"<tr style='height:120px;'> <td  onClick='clickOnThread("+val.threadId+")'> <span class='spanClass'  id='thread-" + val.threadId + "'>"+ val.threadTitle+ "</span></td></tr>");
			});
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
			console.log(result.posts);
			console.log("hi");
			$("#tbl-thread-desc").children().remove();
			//$.each(result, function(i, val){				
				 $("#tbl-thread-desc").html(
						"<tr style='height:120px;'> <td> <a href='#' id='thread-" + result.threadId + "'>"+ result.threadTitle+ "</a></td></tr>"+
						"<tr style='height:5px;'> <td> <span id='span-" + result.threadId + "'>Created on :"+ result.threadDate+ "</span></td></tr>"		
				 ); 
				 
				$.each(result.posts, function(i, val){				
				 $("#tbl-thread-desc").append(
						"<tr style='height:120px;'> <td> <a href='#' id='post-" + val.postId + "'> Dummy Post-Content</a></td></tr>"); 
				
			});		
				

		},
		failure : function () {
			console.log("failed");
		}
	});
	
}
	
function clickOnThread(threadId) {
	loadAThreadAndItsAllPosts(threadId);
}


</script>