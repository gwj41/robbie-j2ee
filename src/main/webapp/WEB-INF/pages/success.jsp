<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="<%=basePath%>/script/development-bundle/themes/sunny/jquery.ui.all.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/jquery-1.5.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.core.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.widget.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/development-bundle/ui/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/galleria/galleria-1.2.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$.getJSON("getAllClass.action",
			function(data){
				var options = "";
				for(var i in data){
					options += "<option value ='" + data[i].id + "'>" + data[i].name + "</option>";
				}
				$("#class").html(options);
		$("#disputeBtn").bind("click",addRow);
		$("#deleteBtn").bind("click",removeRow);
		});
	
	$("#datepicker").datepicker( {
					changeMonth : true,
					changeYear : true,
					showButtonPanel : true,
					closeText : 'X',
					dateFormat: 'yy-mm-dd',
					altFormat: 'yy-mm-dd',
					appendText: '(yyyy-mm-dd)'
				});
	});

	function queryStudents() {
		$.getJSON("flow/queryStudents",
				function(data){
				$("#studentList").html(data);
		});
	}
	function getStudents() {
		window.location.href = "flow/getStudents";
	}
	function showArticle() {
		window.location.href="flow/showArticle";
	}
	function check() {
		var addClazzForm = document.getElementById("addClazz");
		if ($("#name").val() == "") {
			$("#nameError").fadeIn("slow").fadeOut("slow");
			return false;
		}
		if ($("#teacher").val() == "") {
			$("#teacherError").fadeIn("slow").fadeOut("slow");
			return false;
		}
		addClazzForm.submit();
	}
	function addRow() {
		var table = document.getElementById("table");
		var row = table.insertRow(2);
		var cell1 = row.insertCell(0);
		var clearBtn = document.createElement("input");
		clearBtn.type = "button";
		clearBtn.value = "Clear";
		clearBtn.onclick = function(){alert("js worked!")};
		cell1.appendChild(clearBtn);
		var cell2 = row.insertCell(1);
		var text = document.createElement("input");
		text.type = "text";
		text.value = "HTC Desire";
		cell2.appendChild(text);
	}
	function removeRow() {
		var table = document.getElementById("table");
		
	}
</script>
<style type="text/css">
        
            /* Demo styles */
            html,body{background:#FEE0C6;margin:0;}
            .content{color:#777;font:12px/1.4 "helvetica neue",arial,sans-serif;width:820px;margin:20px auto;}
            h1{font-size:12px;font-weight:normal;color:#222;margin:0;}
            p{margin:0 0 20px}
            a {color:#22BCB9;text-decoration:none;}
            .cred{margin-top:20px;font-size:11px;}
            
            /* This rule is read by Galleria to define the gallery height: */
            #galleria{height:420px;}
            
</style>
</head>
<body>
	<div class="content">
        <h1>Galleria Classic Theme</h1>
        <p>Demonstrating a basic gallery example.</p>
        
        <!-- Adding gallery images. We use resized thumbnails here for better performance, but it’s not necessary -->
        
        <div id="galleria">
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Locomotives-Roundhouse2.jpg/1000px-Locomotives-Roundhouse2.jpg">
            	<img title="Locomotives Roundhouse"
            	     alt="Steam locomotives of the Chicago &amp; North Western Railway." 
            	     src="http://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Locomotives-Roundhouse2.jpg/100px-Locomotives-Roundhouse2.jpg">
        	</a>
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Icebergs_in_the_High_Arctic_-_20050907.jpg/1000px-Icebergs_in_the_High_Arctic_-_20050907.jpg">
                <img title="Icebergs in the High Arctic"
                     alt="”The debris loading isn't particularly extensive, but the color is usual.”"
                     src="http://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Icebergs_in_the_High_Arctic_-_20050907.jpg/100px-Icebergs_in_the_High_Arctic_-_20050907.jpg">
            </a>
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Ara%C3%B1a._A_Estrada%2C_Galiza._02.jpg/1000px-Ara%C3%B1a._A_Estrada%2C_Galiza._02.jpg">
                <img title="Araña"
                     alt="Xysticus cristatus, A Estrada, Galicia, Spain"
                     src="http://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Ara%C3%B1a._A_Estrada%2C_Galiza._02.jpg/100px-Ara%C3%B1a._A_Estrada%2C_Galiza._02.jpg">
            </a>
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/9104_-_Milano_-_Museo_storia_naturale_-_Fluorite_-_Foto_Giovanni_Dall%27Orto_22-Apr-2007.jpg/1000px-9104_-_Milano_-_Museo_storia_naturale_-_Fluorite_-_Foto_Giovanni_Dall%27Orto_22-Apr-2007.jpg">
                <img title="Museo storia naturale"
                     src="http://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/9104_-_Milano_-_Museo_storia_naturale_-_Fluorite_-_Foto_Giovanni_Dall%27Orto_22-Apr-2007.jpg/100px-9104_-_Milano_-_Museo_storia_naturale_-_Fluorite_-_Foto_Giovanni_Dall%27Orto_22-Apr-2007.jpg">
            </a>
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Grj%C3%B3tagj%C3%A1_caves_in_summer_2009_%282%29.jpg/1000px-Grj%C3%B3tagj%C3%A1_caves_in_summer_2009_%282%29.jpg">
                <img title="Grjótagjá caves in summer 2009"
                     src="http://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Grj%C3%B3tagj%C3%A1_caves_in_summer_2009_%282%29.jpg/100px-Grj%C3%B3tagj%C3%A1_caves_in_summer_2009_%282%29.jpg">
            </a>
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/9/90/20091128_Loutra_Thermes_Xanthi_Thrace_Greece_2.jpg/1000px-20091128_Loutra_Thermes_Xanthi_Thrace_Greece_2.jpg">
                <img title="Thermes"
                     alt="Xanthi hot-spa springs, Xanthi Prefecture, Greece"
                     src="http://upload.wikimedia.org/wikipedia/commons/thumb/9/90/20091128_Loutra_Thermes_Xanthi_Thrace_Greece_2.jpg/100px-20091128_Loutra_Thermes_Xanthi_Thrace_Greece_2.jpg">
            </a>
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Polish_Army_Ko%C5%82obrzeg_077.JPG/1024px-Polish_Army_Ko%C5%82obrzeg_077.JPG">
                <img title="Polish Army Kołobrzeg"
                     alt="A display of the Polish Army. Both the soldier, and the vehicle belong to the 7th Pomeranian Coastal Defence Brigade, a part of the Szczecin-based 12th Mechanized Division ”Bolesław Krzywousty”"
                     src="http://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Polish_Army_Ko%C5%82obrzeg_077.JPG/100px-Polish_Army_Ko%C5%82obrzeg_077.JPG">
            </a>
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/20100213_Zlatograd_Bulgaria_3.jpg/1024px-20100213_Zlatograd_Bulgaria_3.jpg">
                <img title="Zlatograd Bulgaria"
                     src="http://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/20100213_Zlatograd_Bulgaria_3.jpg/100px-20100213_Zlatograd_Bulgaria_3.jpg">
            </a>
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/FEMA_-_5399_-_Photograph_by_Andrea_Booher_taken_on_09-28-2001_in_New_York.jpg/1024px-FEMA_-_5399_-_Photograph_by_Andrea_Booher_taken_on_09-28-2001_in_New_York.jpg">
                <img title="09-28-2001 in New York City"
                     alt="New York, NY, September 28, 2001 -- Debris on surrounding roofs at the site of the World Trade Center. Photo by Andrea Booher/ FEMA News Photo"
                     src="http://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/FEMA_-_5399_-_Photograph_by_Andrea_Booher_taken_on_09-28-2001_in_New_York.jpg/100px-FEMA_-_5399_-_Photograph_by_Andrea_Booher_taken_on_09-28-2001_in_New_York.jpg">
            </a>
            <a href="http://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Antennae%2C_Hubble_images.jpg/1024px-Antennae%2C_Hubble_images.jpg">
                <img src="http://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Antennae%2C_Hubble_images.jpg/100px-Antennae%2C_Hubble_images.jpg">
            </a>
        </div>
        
        <p class="cred">Made by <a href="http://galleria.aino.se">Galleria</a>.</p>
    </div>
    <script>

    // Load the classic theme
    Galleria.loadTheme('<%=basePath%>/script/galleria/themes/twelve/galleria.twelve.min.js');
    
    // Initialize Galleria
    $('#galleria').galleria();

    </script>
	<form action="addClass.action" id="addClazz" method="post">
		Add class:<br>
		<table>
			<tr>
				<td>
					Class Name:
				</td>
				<td>
					<input id="name" type="text" name="name">
					<span id="nameError" style="display: none"><font color="red">请填写班级名称</font></span>
				</td>
			</tr>
			<tr>
				<td>
					Teacher Name:
				</td>
				<td>
					<input id="teacher" type="text" name="teacher">
					<span id="teacherError" style="display: none"><font color="red">请填写老师</font></span>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input value="新增" type="button" onclick="check()">
				</td>
			</tr>
		</table>
	</form>
	<form action="addStudents" method="post">
		Add student:<br>
		<table>
			<tr>
				<td>
					Student Name:
				</td>
				<td>
					<input type="text" name="student.name">
				</td>
			</tr>
			<tr>
				<td>
					Student gender:
				</td>
				<td>
					<input type="text" name="student.gender">
				</td>
			</tr>
			<tr>
				<td>
					Birthday:
				</td>
				<td>
					<input type="text" id="datepicker" name="birthday">
				</td>
			</tr>
			<tr>
				<td>
					Student age:
				</td>
				<td>
					<input type="text" name="student.age">
				</td>
			</tr>
			<tr>
				<td>
					Class:
				</td>
				<td>
					<select name="student.clazz.id" id="class">
						
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input value="新增" type="submit">
				</td>
			</tr>
		</table>
	</form>
	<form action="queryClasses">
		List all classes:<input type="submit">
	</form>
	<div>
		List all students:<input type="button" value="查询所有学生" onclick="queryStudents()">
	</div>
	<div id="studentList">
		
	</div>
	<input type="button" value="查看文章内容" onclick="showArticle()">
	<div>
		<table id="table">
			<tr>
				<td>Action</td><td>Value</td>
			</tr>
			<tr>
				<td><input type="button" value="Dispute" id="disputeBtn" /></td><td><input id="deleteBtn" type="button" value="Delete" /></td>
			</tr>
		</table>
	</div>
</body>
</html>