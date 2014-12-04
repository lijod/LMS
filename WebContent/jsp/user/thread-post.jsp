<%@ include file="../common.jsp"%>
<%@ include file="../check-login.jsp"%>

<link href="/LMS/css/jquery-te-1.4.0.css" rel="stylesheet">

<script src="/LMS/js/jquery-te-1.4.0.min.js" type="text/javascript"></script>

<body>

<div class="container">
	<h3>START YOUR THREAD</h3>
	<form action="" method="post" class="well">
		<textarea name="textarea" id="threadContent" style="height: 100px;"></textarea>
		<input class="form-control" type="submit" value="SUBMIT THREAD" style="" />
	</form>
</div>

<script>
	$("document").ready(function(){ 
		$('#threadContent').jqte();
	});

</script>

</body>