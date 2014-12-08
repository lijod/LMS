<%@ include file="../common.jsp"%>
<%@ include file="../check-login.jsp"%>
<link href="/LMS/css/jquery-te-1.4.0.css" rel="stylesheet">

<script src="/LMS/js/jquery-te-1.4.0.min.js" type="text/javascript"></script>

<html>
<body>

<div class="container">

<table>

<tr>
<td> 
<label>TA hours - Start Time</label>
</td>
<td> 
<input id="txt-ta-start-time" name="start-time" type="text"  placeholder="START-TIME" /> 
</td>
</tr>

<tr>
<td> 
<label>TA hours - End Time</label>
</td>
<td> 
<input id="txt-ta-end-time"  type="text"  placeholder="END-TIME" /> 
</td>
</tr>

<tr>
<td> 
<label>TA hours - Location</label>
</td>
<td> 
<input id="txt-ta-location" name="ta-location" type="text"  placeholder="LOCATION" /> 
</td>
</tr>

<tr>
<td> 
<label>TA Day</label>
</td>
<td> 
<select id="ta-hour-day"  class='form-control'>
	<option value='monday'>Monday</option>
	<option value='tuesday'>Tuesday</option>
	<option value='wednesday'>Wednesday</option>
	<option value='thursday'>Thursday</option>
	<option value='friday'>Friday</option>
	<option value='saturday'>Saturday</option>
	<option value='sunday'>Sunday</option>		  	
</select>
</td>
</tr>

<tr>
<td></td>
<td><button id="btn-save-ta-schedule" class="btn btn-default">Save Your Schedule</button></td>
</tr>



</table>

</div>


</body>
</html>

<script type="text/javascript">

$("#btn-save-ta-schedule"){
	
	
	
	
	var taStarTime= $("#txt-ta-start-time").val();
	var taEndTime  = $("#txt-ta-end-time").val();
			
	var taLocation = $("#txt-ta-location").val();
	var taDay = ("#ta-hour-day").children(":selected").attr("value");
}


</script>


