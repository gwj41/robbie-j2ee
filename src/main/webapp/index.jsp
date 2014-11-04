<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String basePath=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My SSH project</title>
<link type="text/css" href="<%=basePath%>/script/development-bundle/themes/sunny/jquery.ui.all.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/jquery-1.5.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/easyslider/js/easySlider1.7.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/Qaptcha_v2.5/jquery/QapTcha.jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.position.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.draggable.js"></script>

<!-- CKeditor -->
<script type="text/javascript" src="<%=basePath%>/ckeditor/ckeditor.js"></script>
<script src="<%=basePath%>/ckeditor/_samples/sample.js" type="text/javascript"></script>
<link href="<%=basePath%>/ckeditor/_samples/sample.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/script/easyslider/css/screen.css" rel="stylesheet" type="text/css" media="screen" />
<!-- QapTcha CSS -->
<link rel="stylesheet" href="<%=basePath%>/script/Qaptcha_v2.5/jquery/QapTcha.jquery.css" type="text/css" />
<script type="text/javascript">
$(document).ready(function() {
    $("#datepicker").datepicker({changeMonth: true,changeYear: true,showButtonPanel: true,closeText: 'colse me'});
    $("#slider").easySlider({
		auto: true,
		continuous: true,
		nextId: "slider1next",
		prevId: "slider1prev"
	});
	// Simple call
	$('#QapTcha').QapTcha({disabledSubmit:false});
});
</script>
</head>
<body>
	<div id="container">

		<div id="header">
			<h1>Easy Slider jQuery Plugin - Multiple sliders</h1>
		</div>
	
		<div id="content">
		
			<div id="slider">
				<ul>				
					<li><a href="http://templatica.com/preview/30"><img src="<%=basePath%>/script/easyslider/images/01.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/7"><img src="<%=basePath%>/script/easyslider/images/02.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/25"><img src="<%=basePath%>/script/easyslider/images/03.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/26"><img src="<%=basePath%>/script/easyslider/images/04.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/27"><img src="<%=basePath%>/script/easyslider/images/05.jpg" alt="Css Template Preview" /></a></li>			
				</ul>
			</div>
		</div>
	</div>
	
	<div align="left" style="margin-left: 10px">
		<form action="flow/login">
			Hello:<input type="submit" value="click">
		</form>
		<p>Date: <input type="text" id="datepicker"></p>
		
		<form action="flow/saveContent" method="post">
			<p>
				<label for="editor1">
					Editor 1:</label><br />
				<textarea class="ckeditor" cols="80" id="editor1" name="content.content" rows="10">&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;</textarea>
			</p>
			<fieldset>
				<label>First Name</label> <input type="text" name="firstname" />
				<label>Last Name</label> <input type="text" name="lastname" />
				<div class="clr"></div>
				
				<!-- Add this line in your form -->
				<div id="QapTcha"></div>
				<input type="submit" name="submit" value="Submit form" />
			</fieldset>
		</form>
		<form method="post" action="">
			<fieldset>
				<label class="large">Disabled submit button</label>
				<select name="disabledSubmit">
					<option value='1' >Yes</option>
					<option value='2' selected="selected">No</option>
				</select>
		
				<input type="submit" name="changeOption" value="change Option">
			</fieldset>
		</form>
	</div>
</body>
</html>