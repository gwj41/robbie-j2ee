<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students</title>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/jquery-1.5.1.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		var classId = ${clazz.id};
		$.getJSON("getStudents.action",
			function(data){
				var text = "";
				for(var i in data){
					text += "<tr><td>"+data[i].name+"</td><td>"+data[i].clazz.name+"</td></tr>";
				}
				$("#table1").html(text);
		});
	});
</script>
</head>
<body>
	Students:
	<table id="table1">
	
	</table>
</body>
</html>