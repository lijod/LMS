<%@ include file="../common.jsp"%>
<%@ include file="../check-login.jsp"%>
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
		
		<td><table  id="tbl-all-threads" class="table table-striped">
			
		</table></td>
		<td><table id="tbl-thread-desc" class="table table-striped"></table>
			<div class="container" id="create-thread-form" style="display:none;">
				<h3>START YOUR THREAD</h3>
				<form action="" method="post" class="well">
					<div id="tag-container" class="container">
						<div id="tags"></div>
						<div id="create-tag-container" style="display:none;">
							<input type="text" value="" id="tag-text" class="form-control" style="width: 15%;"/>
							<input type="button" value="ADD" class="btn btn-success" onClick="createTag()" style="float:left;" />
							<input type="button" value="CANCEL" class="btn btn-warning" onClick="hideCreateTagContainer()" style="float:left;" />
						</div>
						<a href="javascript:void(0)" id="add-tag-btn" onClick="showCreateTagContainer()">ADD TAG</a>
					</div>
					<input type="text" value="" class="form-control" id="thread-title" placeholder="THREAD TITLE"/>
					<textarea name="textarea" id="thread-content" style="height: 100px;"></textarea>
					<input class="form-control" type="button" value="SUBMIT THREAD" style="" onClick="createThread()"/>
				</form>
			</div>
		</td>
		</tr>

		</table>
</body>
</html>

<script type="text/javascript">

var applicaitonURL = "/LMS/api";
var userServiceURl ;
var threadService = applicaitonURL + "/jwsThreadService";
var tagService = applicaitonURL + "/jwsTagService";

$(document).ready(function(){	
	refreshCourseList();
	$('#thread-content').jqte();
	loadTags();
});


function refreshCourseList(){
	userServiceURl = applicaitonURL + "/jwsCourseService/findAllCoursesForAUserId";
	$.ajax({
		type : "POST",
		url :  userServiceURl,
		data: "<%= userId %>",
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
			$("#tbl-all-threads").append(getNewPostBtn());
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

function showNewPostContainer(){
	$("#tbl-thread-desc").hide();
	$("#create-thread-form").show();
}

function hideNewPostContainer(){
	$("#tbl-thread-desc").show();
	$("#create-thread-form").hide();
}

function createThread(){
	$.ajax({
		type : "post",
		url : threadService + "/createThread",
		data : JSON.stringify(getThreadData()),
		dataType:"JSON",
		contentType: "application/json",
		success : function(result){
			console.log(result);
			hideNewPostContainer();
			loadAllThreadsByCourseId(result.courseId)
		},
		failure : function(){
			console.log("Error while saving Thread...");
		}
	});
}

function createTag(){
	$.ajax({
		type : "post",
		url : tagService + "/createTag",
		data : JSON.stringify(getTagData()),
		dataType:"JSON",
		contentType: "application/json",
		success : function(tag){
			appendTag(tag.tagId, tag.tagText);
			hideCreateTagContainer();
		},
		failure : function(){
			console.log("Error while saving Tag...");
		}
	});
}

function loadTags(){
	$.ajax({
		type : "get",
		url : tagService + "/findAllTags",
		dataType:"JSON",
		success : function(tags){
			$("#tags").html("");
			$.each(tags, function(i, tag){
				appendTag(tag.tagId, tag.tagText);
			});
		},
		failure : function(){
			console.log("Error while loading Tag...");
		}
	});
}

function appendTag(tagId, tagText){
	$("#tags").append("<span class='tagClass'>&nbsp" + 
						"<input type='checkbox' value='" +tagId + "_" + tagText + "' class='form-field' />" + tagText  
						+ "&nbsp</span> |")
	if($("#tags").find(".tagClass").length % 10 == 0)
		$("#tags").append("<br/>");
	}

function getTagData(){
	return {
				"tagText" : $("#tag-text").val()
			}
}

function getThreadData(){
	return {
		"userId" : "<%= userId %>",
		"courseId" : $("#course-list").children(":selected").attr("value"),
		"threadTitle" : $('#thread-title').val(),
		"threadContent" : $('#thread-content').val(),
		"tags" : getTags()
		}
}

function showCreateTagContainer(){
	$("#create-tag-container").show();
	$("#add-tag-btn").hide();
}

function hideCreateTagContainer(){
	$("#create-tag-container").hide();
	$("#add-tag-btn").show();
}

function getTags(){
	var tags = [];
	$.each($("#tags :checked"), function (i, tag){
		var s = tag.value.split("_");
		tags.push({ "tagId" : s[0], "tagText" : s[1]});
		s = [];
	});
	return tags;
}

function getNewPostBtn(){
	return '<tr> <td> <input type="button" value="NEW POST" class="btn btn-success" onClick="showNewPostContainer()" /> </td> </tr>';	
}

</script>