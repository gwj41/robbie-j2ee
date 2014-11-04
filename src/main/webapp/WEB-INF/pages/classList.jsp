<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath=request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath%>/script/nivo-slider/nivo-slider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=basePath%>/script/nivo-slider/demo/style.css" type="text/css" media="screen" />
<link type="text/css" href="<%=basePath%>/script/development-bundle/themes/sunny/jquery.ui.all.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/jquery-1.5.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.accordion.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/nivo-slider/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript">
	function getStudent(pageNo){
		$.getJSON("flow/getStudents",
				{pageNo:pageNo},
				function(result){
					//var data = eval("(" + result + ")");
					var data = $.parseJSON(result);
					var text = "";
					var previousPageNo = data.previousPageNo;
					var nextPageNo = data.nextPageNo;
					var currentPageNo = data.currentPageNo;
					var totlePage = data.totlePage;
					var options = "";
					var resultList = data.result;
					var length = resultList.length;
					if(length > 0) {
						for(var i = 0;i < length;i++){
							text += "<tr><td>" + resultList[i].name + "</td>" +
							"<td>" + resultList[i].clazz.name + "</td></tr>";
						}
						for(var i = 1;i <= totlePage;i++) {
							if(i == currentPageNo) {
								options += "<option selected value='" + i + "'>第" + i + "页</option>";
							} else {
								options += "<option value='" + i + "'>第" + i + "页</option>";
							}
							
						}
						
						text += "<tr>"+
						"<td><input type='button' value='Previous Page' onclick='getStudent(" + previousPageNo + ")'></td>"+
						"<td><select onchange='getStudent(this.options[this.options.selectedIndex].value)'>" + options + "</select></td>"+
						"<td><input type='button' value='Next Page' onclick='getStudent(" + nextPageNo + ")'></td></tr>";
					}
					$("#table1").html(text);
				}
		);
	}
	$(function() {
		$("#accordion").accordion({autoHeight: false,collapsible: true});
		$("#deleteClasses").click(deleteClasses);
		$('#slider').nivoSlider();
	});
	function deleteClasses() {
		var chkIds = "";
		$("input[name='classId']:checked").each(function(i){
			chkIds += $(this).val() + ",";
		});
		
		//var ids = document.getElementsByName("classId");
		//var length = ids.length;
		//for (var i = 0; i < length; i++) {
		//	if(ids[i].checked){
		//		chkIds += ids[i].value + ",";
		//	}
		//}

		window.location.href = "deleteClasses?classIds=" + chkIds;
	}
</script>
</head>
<body>
	<div id="wrapper">
    
        <a href="http://dev7studios.com" id="dev7link" title="Go to dev7studios">dev7studios</a>

        <div id="slider-wrapper">
        
            <div id="slider" class="nivoSlider">
                <img src="<%=basePath%>/script/nivo-slider/demo/images/toystory.jpg" alt="" />
                <a href="http://dev7studios.com">
                	<img src="<%=basePath%>/script/nivo-slider/demo/images/up.jpg" alt="" title="This is an example of a caption" />
                </a>
                <img src="<%=basePath%>/script/nivo-slider/demo/images/walle.jpg" alt="" />
                <img src="<%=basePath%>/script/nivo-slider/demo/images/nemo.jpg" alt="" title="#htmlcaption" />
            </div>
            <div id="htmlcaption" class="nivo-html-caption">
                <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>.
            </div>
        
        </div>

    </div>
	<div id="accordion">
		<h3><a href="#">Classes</a></h3>
		<div>
			<table>
				<c:if test="${classList != null}">
					<c:forEach items="${classList}" var="clazz">
						<tr>
							<td>
								<input type="checkbox" name="classId" value="${clazz.id}">
							</td>
							<td>
								<a href="queryStudents?clazz.id=${clazz.id}">${clazz.name}</a>
							</td>
							<td>
								${clazz.teacher}
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td>
							<input type="button" value="删除" id="deleteClasses">
						</td>
						<td>
							<input type="button" value="查看">
						</td>
					</tr>
				</c:if>
			</table>
		</div>
		<h3><a href="#">All Students</a></h3>
		<div>
			<input type="button" id="allStudents" value="列出所有学生" onclick="getStudent('1')"><br>
			<table id="table1">
			</table>
		</div>
	</div>
	<input type="button" value="back" onclick="history.back()">
</body>
</html>