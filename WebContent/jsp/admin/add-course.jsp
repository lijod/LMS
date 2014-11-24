<%@ include file="../common.jsp"%>
<html>

<body>
	<div class="container">
		<div>
			<select id="course-list" class="form-control">
				<option class="form-control">Select</option>

			</select>
			 <br />
			<button id="edit-course" class="btn btn-default">EDIT</button>
			<button id="delete-course" class="btn btn-default">DELETE</button>
			<button id="add-course" class="btn btn-default" onClick="createCourse()">ADD NEW</button>
		</div>

		<div>
				<input id="course-name" name="course-name" class="form-control" type="text"  placeholder="COURSE NAME" />
			 	<input id="section-number" name="section-number" type="text" class="form-control" placeholder="SECTION NUMBER" />
			 	
			 		<div>
			  			<input id="course-location" name="course-location" class="form-control"  type="text" placeholder="COURSE LOCATION" />
			  			<select id="course-day" name="course-day" class="form-control">
			  				<option value="monday">Monday</option>
					  		<option value="tuesday">Tuesday</option>
					  		<option value="wednesday">Wednesday</option>
					  		<option value="thursday">Thursday</option>
					  		<option value="friday">Friday</option>
					  		<option value="saturday">Saturday</option>
					  		<option value="sunday">Sunday</option>			  	
					  	</select>
					  	<input id="course-start-time" name="course-start-time" class="form-control" type="text"  placeholder="COURSE START TIME (hh:mm)" />
					  	<input id="course-end-time" name="course-end-time" class="form-control" type="text"  placeholder="COURSE END TIME(hh:mm)" />					  		
			  	</div>
			  	<button id="new-schedule" class="btn btn-default">NEXT CLASS</button>
			  	
		</div>
	</div>
</body>

<script type="text/javascript">

var applicaitonURL = "/LMS/api";
var userServiceURl = applicaitonURL + "/jwsCourseService/findAlleCourses";

$(document).ready(
	function(){
		$.ajax({
			type : "GET",
			url :  userServiceURl,
			dataType:"JSON",
			success : function (result) {
				console.log(result);
				$.each(result, function(i, val){
					$("#course-list").append(
							"<option id='course-" + val.courseId + "'>" + val.courseName + "</option>");
				});
			},
			failure : function () {
				console.log("failed");
			}
		});
		
		
	});
	


function createCourse(){
	$.ajax({
		type : "GET",
		url :  userServiceURl + getCourseQueryString(),
		dataType:"JSON",
		success : function (result) {
			console.log(result);
		},
		failure : function () {
			console.log("failed");
		}
	});
}

function getCourseQueryString(){
	return "/" + 
	$("#course-name").val() + 
	"/" + 
	$("#section-number").val() + 
	"/"+
	$("#course-location").val() + 
	"/" + 
	$("#course-start-time").val() +
	"/" + 
	$("#course-end-time").val() + 
	"/" + 
	$( "#course-day" ).val()
}
</script>
</html>