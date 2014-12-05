<%@ include file="../common.jsp"%>
<%@ include file="../check-login.jsp"%>

<link href="/LMS/css/jquery-te-1.4.0.css" rel="stylesheet">

<script src="/LMS/js/jquery-te-1.4.0.min.js" type="text/javascript"></script>

<body>

<div class="container" id="create-thread-form">
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

<script>
	var applicaitonURL = "/LMS/api";
	var threadService = applicaitonURL + "/jwsThreadService";
	var tagService = applicaitonURL + "/jwsTagService";
	
	$("document").ready(function(){ 
		$('#thread-content').jqte();
		loadTags();
	});
	
	function createThread(){
		$.ajax({
			type : "post",
			url : threadService + "/createThread",
			data : JSON.stringify(getThreadData()),
			dataType:"JSON",
			contentType: "application/json",
			success : function(result){
				console.log(result);
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
			"courseId" : "1",
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
	
</script>

</body>