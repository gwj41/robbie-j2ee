<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/jquery-1.5.1.js"></script>
<script type="text/javascript">
	
</script>
<title>Article</title>
</head>
<body>
	<div id="article">${content.content}</div>
	<input type="button" value="back" onclick="history.back();">
</body>
</html>