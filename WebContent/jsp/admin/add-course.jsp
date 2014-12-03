<%@ include file="../common.jsp"%>
<html>

<body>
	<div class="container">
		<div>
			<select id="course-list" class="form-control">
				<option class="form-control">Select</option>

			</select> <br />
			<button id="edit-course" value="edit" class="btn btn-default">EDIT</button>
			<button id="delete-course" class="btn btn-default">DELETE</button>
			<button id="add-course" class="btn btn-default" onClick="addNewCourse()">ADD NEW</button>
			<button id="save-course" class="btn btn-default" onClick="createCourse()">SAVE COURSE</button>
		</div>

		<div id="course-details">
<!-- 			<input id="course-name" name="course-name" class="form-control" type="text" placeholder="COURSE NAME" />
			<input id="section-number" name="section-number" type="text" class="form-control" placeholder="SECTION NUMBER" /> -->

		
		</div>
		
			<button id="new-schedule1" class="btn btn-default" onClick="addNewSchedule()">NEXT CLASS</button>
		
	</div>
</body>

<script type="text/javascript">



var noofclassesinaweek =1;

var applicaitonURL = "/LMS/api";
var userServiceURl ;


$("#edit-course").click(function(){
	 userServiceURl = userServiceURl = applicaitonURL + "/jwsCourseService/updateCourse";
	id=$("#course-list").children(":selected").attr("value");
	var queryArr=[];
	var courseScheduleArray = [];  
	var count=0;
	$("#course-details div.course-schedule").each(function(){	
		count=count+1;
		//alert($("#course-location"+ count).val());
		courseScheduleArray.push({
			    "id" : $("#course-schedule-id"+count).val(),
				"courseEndDate": $("#course-end-date"+count).val(),
				"courseEndTime": $("#course-end-time"+count).val(),
				"courseId" : id ,
				"courseLocation" : $("#course-location"+ count).val(),
				"courseStartDate": $("#course-start-date"+count).val(),
				"courseStartTime": $("#course-start-time"+count).val(),
				"day" : $("#course-day"+count+" option:selected" ).val()})			
			});
	
		queryArr.push({
			"courseId" : id ,
			"courseName":$("#course-name").val(),
			"sectionNumber":$("#section-number").val(),
			"courseScheduleList":courseScheduleArray})
			queryArr=JSON.stringify(queryArr[0]);
		
		$.ajax({
			type : "POST",
			url :  userServiceURl,
			data:queryArr,
			dataType:"JSON",
			contentType: "application/json",
			success : function (result) {
				console.log(result);				
			},
			failure : function () {
				console.log("failed");
			}
		});
	})
	





$(document).ready(function(){	
	refreshCourseList();		
	});
	
function addNewCourse(){
	
	location.reload();
}

function refreshCourseList(){
		 userServiceURl = userServiceURl = applicaitonURL + "/jwsCourseService/findAllCourses";
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
				
				$("#course-details").html(
						"<input id='course-name' name='course-name' class='form-control' type='text' placeholder='COURSE NAME' />"+
						"<input id='section-number' name='section-number' type='text' class='form-control' placeholder='SECTION NUMBER' />"+
						"<div class='course-schedule'>"+
			  			"<input id='course-location1' name='course-location' class='form-control'  type='text' placeholder='COURSE LOCATION' />"+
			  			"<select id='course-day1' name='course-day' class='form-control'>"+
			  				"<option value='monday'>Monday</option>"+
					  		"<option value='tuesday'>Tuesday</option>"+
					  		"<option value='wednesday'>Wednesday</option>"+
					  		"<option value='thursday'>Thursday</option>"+
					  		"<option value='friday'>Friday</option>"+
					  		"<option value='saturday'>Saturday</option>"+
					  		"<option value='sunday'>Sunday</option>	"+	  	
					  	"</select>"+
					  	"<input id='course-start-time1' name='course-start-time' class='form-control' type='text'  placeholder='COURSE START TIME (hh:mm)' />"+
					  	"<input id='course-end-time1' name='course-end-time' class='form-control' type='text'  placeholder='COURSE END TIME(hh:mm)' />" +
					  	"<input id='course-start-date1' name='course-start-date' class='form-control' type='text'  placeholder='COURSE START DATE (MM/DD/YYYY)' />"+
					  	"<input id='course-end-date1' name='course-end-date' class='form-control' type='text'  placeholder='COURSE END DATE(MM/DD/YYY)' />" +
			  	"</div>");
			},
			failure : function () {
				console.log("failed");
			}
		});
	
}
	
	$("#delete-course").click(function(){
		userServiceURl = applicaitonURL + "/jwsCourseService/deleteCourseById";
		var id = $("#course-list").children(":selected").attr("value");
			$.ajax({
				type: "DELETE",
					url :  userServiceURl ,				
					data : id,
					dataType:"json",
					contentType: "application/json",
					success : function (result) {
						location.reload();
						console.log(result);
					},
					failure : function () {
						console.log("failed");
					}			
			});
			
	})
	
	
function createCourse(){

	userServiceURl = applicaitonURL + "/jwsCourseService/createCourse";
	var queryArr=[];
	var courseScheduleArray = [];  
	var count=0;
	$("#course-details div.course-schedule").each(function(){	
		count=count+1;
		//alert($("#course-location"+ count).val());
		courseScheduleArray.push({
				"courseEndDate": $("#course-end-date"+count).val(),
				"courseEndTime": $("#course-end-time"+count).val(),
				"courseLocation" : $("#course-location"+ count).val(),
				"courseStartDate": $("#course-start-date"+count).val(),
				"courseStartTime": $("#course-start-time"+count).val(),
				"day" : $("#course-day"+count+" option:selected" ).val()})			
			});
	
		queryArr.push({
			"courseName":$("#course-name").val(),
			"sectionNumber":$("#section-number").val(),
			"courseScheduleList":courseScheduleArray})
			
			
			$.ajax({
				type : "POST",
				url :  userServiceURl ,
				
				data : JSON.stringify(queryArr[0]),
				dataType:"json",
				contentType: "application/json",
				success : function (result) {
					console.log(result);
				},
				failure : function () {
					console.log("failed");
				}
			});								
				
			
	}
	


function addNewSchedule(){	
	noofclassesinaweek =noofclassesinaweek+1;
	$("#course-details").append(
			"<div class='course-schedule'>"+
  			"<input id='course-location"+ noofclassesinaweek+"' name='course-location' class='form-control'  type='text' placeholder='COURSE LOCATION' />"+
  			"<select id='course-day"+ noofclassesinaweek+"' name='course-day' class='form-control'>"+
  				"<option value='monday'>Monday</option>"+
		  		"<option value='tuesday'>Tuesday</option>"+
		  		"<option value='wednesday'>Wednesday</option>"+
		  		"<option value='thursday'>Thursday</option>"+
		  		"<option value='friday'>Friday</option>"+
		  		"<option value='saturday'>Saturday</option>"+
		  		"<option value='sunday'>Sunday</option>	"+	  	
		  	"</select>"+
		  	"<input id='course-start-time"+ noofclassesinaweek+"' name='course-start-time' class='form-control' type='text'  placeholder='COURSE START TIME (hh:mm)' />"+
		  	"<input id='course-end-time"+ noofclassesinaweek+"' name='course-end-time' class='form-control' type='text'  placeholder='COURSE END TIME(hh:mm)' />" +
		  	"<input id='course-start-date"+ noofclassesinaweek+"' name='course-start-date' class='form-control' type='text'  placeholder='COURSE START DATE (MM/DD/YYYY)' />"+
		  	"<input id='course-end-date"+ noofclassesinaweek+"' name='course-end-date' class='form-control' type='text'  placeholder='COURSE END DATE(MM/DD/YYY)' />" +
  	"</div>");
}

$("#course-list" ).change(function() {
	noofclassesinaweek =1;	
	var id = $(this).children(":selected").attr("value");
	//$(".course-schedule").remove();
	userServiceURl = applicaitonURL + "/jwsCourseService/findCourseById";
	$.ajax({
		type : "GET",
		url :  userServiceURl + "/" + id,
		dataType:"JSON",
		success : function (result) {
			console.log(result);
			//console.log(result.courseScheduleList.length);
			
			//$(".course-schedule").html.remove();
			
			if(result.courseScheduleList.length==0){
				
				$("#course-details").html(
						"<input id='course-name' name='course-name' class='form-control' type='text' placeholder='COURSE NAME' />"+
						"<input id='section-number' name='section-number' type='text' class='form-control' placeholder='SECTION NUMBER' />"+
						"<div class='course-schedule'>"+
						"<input type='hidden' value="+val.id+ " id='course-schedule-id1'/>"+
			  			"<input id='course-location1' name='course-location' class='form-control'  type='text' placeholder='COURSE LOCATION' />"+
			  			"<select id='course-day1' name='course-day' class='form-control'>"+
			  				"<option value='monday'>Monday</option>"+
					  		"<option value='tuesday'>Tuesday</option>"+
					  		"<option value='wednesday'>Wednesday</option>"+
					  		"<option value='thursday'>Thursday</option>"+
					  		"<option value='friday'>Friday</option>"+
					  		"<option value='saturday'>Saturday</option>"+
					  		"<option value='sunday'>Sunday</option>	"+	  	
					  	"</select>"+
					  	"<input id='course-start-time1' name='course-start-time' class='form-control' type='text'  placeholder='COURSE START TIME (hh:mm)' />"+
					  	"<input id='course-end-time1' name='course-end-time' class='form-control' type='text'  placeholder='COURSE END TIME(hh:mm)' />" +
					  	"<input id='course-start-date1' name='course-start-date' class='form-control' type='text'  placeholder='COURSE START DATE (MM/DD/YYYY)' />"+
					  	"<input id='course-end-date1' name='course-end-date' class='form-control' type='text'  placeholder='COURSE END DATE(MM/DD/YYY)' />" +
			  	"</div>");				
			}
			else
			{
			
				$("#course-details").html(
						"<input id='course-name' name='course-name' class='form-control' type='text' placeholder='COURSE NAME' />"+
						"<input id='section-number' name='section-number' type='text' class='form-control' placeholder='SECTION NUMBER' />")
			}
			
			$("#course-name").val(result.courseName);
			$("#section-number").val(result.sectionNumber);
			
			$.each(result.courseScheduleList, function(i, val){
			
				noofclassesinaweek=i+1;
				
			$("#course-details").append(
					
					"<div class='course-schedule'>"+
					"<input type='hidden' value="+val.id+ " id='course-schedule-id"+ noofclassesinaweek+"'/>"+
		  			"<input value="+ val.courseLocation+ " id='course-location"+ noofclassesinaweek+"' name='course-location' class='form-control'  type='text' placeholder='COURSE LOCATION' />"+
		  			"<select id='course-day"+ noofclassesinaweek+"' name='course-day' class='form-control'>"+
		  				"<option value='monday'>Monday</option>"+
				  		"<option value='tuesday'>Tuesday</option>"+
				  		"<option value='wednesday'>Wednesday</option>"+
				  		"<option value='thursday'>Thursday</option>"+
				  		"<option value='friday'>Friday</option>"+
				  		"<option value='saturday'>Saturday</option>"+
				  		"<option value='sunday'>Sunday</option>	"+	  	
				  	"</select>"+
				  	"<input value="+val.courseStartTime+ " id='course-start-time"+ noofclassesinaweek+"' name='course-start-time' class='form-control' type='text'  placeholder='COURSE START TIME (hh:mm)' />"+
				  	"<input value="+val.courseEndTime+ " id='course-end-time"+ noofclassesinaweek+"' name='course-end-time' class='form-control' type='text'  placeholder='COURSE END TIME(hh:mm)' />" +		  		
				  	"<input value="+val.courseStartDate+ " id='course-start-date"+ noofclassesinaweek+"' name='course-start-date' class='form-control' type='text'  placeholder='COURSE START DATE (MM/DD/YYYY)' />"+
				  	"<input value="+val.courseEndDate+ " id='course-end-date"+ noofclassesinaweek+"' name='course-end-date' class='form-control' type='text'  placeholder='COURSE END DATE(MM/DD/YYY)' />" +
		  	"</div>")
			});
			
		//	alert(result.courseName);
		},
		failure : function () {
			console.log("failed");
		}		
	}) 
	});

</script>
</html>