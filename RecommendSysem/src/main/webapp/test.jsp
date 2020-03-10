<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
<% 
	pageContext.setAttribute("PROJECT_PATH",request.getContextPath());
%>
	<!-- vue -->
    <script type="text/javascript" src="js/vue.min.js"></script>
	<!-- js -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
	${PROJECT_PATH }
	
	
	<script type="text/javascript">
	
	//1.使用vue解析json并渲染电影数据到页面
	var v = new Vue({
		el: '#loop',
		data: {
			// 电影信息列表
			rows: []
			
		}
	});
	
	$(document).ready(function($) {
		var result;
		
		$.ajax({
			// 传递中文参数是必须使用post请求
			type : "post",
			url : "${PROJECT_PATH }/movie/searchList1",
			data:{"pageNumber":1,"mName":"世界"},
			dataType : "json",//接收服务端返回的数据类型
			success : function(data) {
				console.log(data);
				console.log(data.code);
				console.log(data.extend.searchList.list);
				result = data.extend.searchList.list;
			},
			error : function() {
				console.log("服务端出现异常！");
			}
		});
		
		// 为vue实例中的data赋值
		v.rows = result;
		console.log(result);
	});
		
	</script>
</body>
</html>