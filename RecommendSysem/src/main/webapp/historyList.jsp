<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("PROJECT_PATH",request.getContextPath());
%>
<!DOCTYPE html>

<!-- <html lang="en"> -->
<html lang="zh-CN">
<head>
	<title>电影推荐系统</title>
	<!-- for-mobile-apps -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
	<script type="application/x-javascript">
		addEventListener("load", function() { 
			setTimeout(hideURLbar, 0); 
		}, false);
		function hideURLbar(){ 
			window.scrollTo(0,1);
		}
	</script>
	<!-- //for-mobile-apps -->
	<link rel="icon" type="image/x-icon" href="images/title.ico" />
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
		  media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/contactstyle.css" rel="stylesheet" type="text/css"
		  media="all" />
	<link href="css/faqstyle.css" rel="stylesheet" type="text/css"
		  media="all" />
	<link href="css/single.css" rel='stylesheet' type='text/css' />
	<link href="css/medile.css" rel='stylesheet' type='text/css' />
	<!-- banner-slider -->
	<link href="css/jquery.slidey.min.css" rel="stylesheet">
	<!-- //banner-slider -->
	<!-- pop-up -->
	<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
	<!-- //pop-up -->
	<!-- font-awesome icons -->
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<!-- vue -->
	<script type="text/javascript" src="js/vue.min.js"></script>
	<!-- js -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<!-- //js -->
	<!-- banner-bottom-plugin -->
	<link href="css/owl.carousel.css" rel="stylesheet" type="text/css"
		  media="all">
	<script src="js/owl.carousel.js"></script>

	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>

</head>

<body>
<!-- header -->
<div class="header">
	<div class="container">
		<div class="w3layouts_logo">
			<a href="index.jsp">
				<h1>
					One<span>Movies</span>
				</h1>
			</a>
		</div>
		<div class="w3_search">
			<form id="searchForm" action="${PROJECT_PATH }/movie/searchList" method="post">
				<input type="text" name="mName" id="search" placeholder="请输入电影名称" required="">
				<input type="submit" value="搜索">
			</form>
		</div>
		<div class="w3l_sign_in_register">
			<ul>
				<li id="li">
					<!-- jstl方法取出session中的数据 -->
					<a href="#">${sessionScope.user.username }</a>
				</li>
			</ul>
			<input type="hidden" value="${sessionScope.user.id}" id="userId" />
		</div>
		<div class="clearfix"></div>
	</div>
</div>

<!-- //bootstrap-pop-up -->
<!-- nav -->
<div class="movies_nav">
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="navbar-header navbar-left">
				<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<div class="collapse navbar-collapse navbar-right"
				 id="bs-example-navbar-collapse-1">
				<nav>
					<ul class="nav navbar-nav">
						<li><a href="index.jsp">首页</a></li>
						<li class="active"><a href="historyList.jsp">观看历史</a></li>
					</ul>
				</nav>
			</div>
		</nav>
	</div>
</div>

<!-- /w3l-medile-movies-grids -->
<div class="general-agileits-w3l">
	<div class="w3l-medile-movies-grids">

		<div class="movie-browse-agile">
			<!--/browse-agile-w3ls -->
			<div class="browse-agile-w3ls general-w3ls">
				<div class="tittle-head">
					<h4 class="latest-text">推荐电影</h4>
					<div class="container">
						<div class="agileits-single-top">
							<ol class="breadcrumb">
								<li><a href="index.jsp">Home</a></li>
								<li class="active">history</li>
							</ol>
						</div>
					</div>
				</div>
				<div class="container">
					<div class="browse-inner" id="loop">

						<div class="col-md-2 w3l-movie-gride-agile" v-for="item in rows">
							<a href="javascript:;" v-on:click="play_video(item)" class="hvr-shutter-out-horizontal"><img
									v-bind:src="item.mPoster" class="figure_pic" v-bind:title="item.mName" alt=" " />
								<div class="w3l-action-icon">
									<i class="fa fa-play-circle" aria-hidden="true"></i>
								</div> </a>
							<div class="mid-1">
								<div class="w3l-movie-text" id="single">
									<h6>
										<a href="javascript:;" v-on:click="play_video(item)" v-bind:title="item.mName" class="set-font-size">{{item.mName}}</a>
									</h6>
								</div>
								<div class="w3l-movie-text">
									<h6>{{item.mTag}}</h6>
								</div>
								<div class="mid-2">

									<p>{{item.mYear}}</p>
									<div class="block-stars">
										<ul class="w3l-ratings">
											<li><a href="#"><i class="fa fa-star"
															   aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-star"
															   aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-star"
															   aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-star-half-o"
															   aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-star-o"
															   aria-hidden="true"></i></a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>

					</div>

				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--//browse-agile-w3ls -->
	<div class="blog-pagenat-wthree" id="page_nav_area">
		
	</div>
</div>

<!-- footer -->
<div class="footer">
	<div class="container">
		<div class="w3ls_footer_grid">
			<div class="col-md-6 w3ls_footer_grid_left">
				<div class="w3ls_footer_grid_left1">
					<h2>订阅我们</h2>
					<div class="w3ls_footer_grid_left1_pos">
						<form action="#" method="post">
							<input type="email" name="email" placeholder="你的邮箱..."
								   required=""> <input type="submit" value="发送">
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-6 w3ls_footer_grid_right">
				<a href="index.jsp"><h2>
					One<span>Movies</span>
				</h2></a>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="col-md-5 w3ls_footer_grid1_left">
			<p>
				Copyright &copy; 2019.<a
					target="_blank" href="#">localhost:8080/RecommendSystem</a>
			</p>
		</div>
		<div class="col-md-7 w3ls_footer_grid1_right">
			<ul>
				<li><a href="movieList.jsp">Movies</a></li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script>
    $(document).ready(function() {
    	// 模态框控制
        $(".dropdown").hover(function() {
            $('.dropdown-menu', this).stop(true, true).slideDown("fast");
            $(this).toggleClass('open');
        }, function() {
            $('.dropdown-menu', this).stop(true, true).slideUp("fast");
            $(this).toggleClass('open');
        });
    });
</script>
<!-- //Bootstrap Core JavaScript -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
	$(document).ready(function() {

		$().UItoTop({
			easingType : 'easeOutQuart'
		});

	});
</script>

<script type="text/javascript">
jQuery(document).ready(function($) {
	to_page();
});

//1.使用vue解析json并渲染电影数据到页面
var v = new Vue({
	el: '#loop',
	data: {
		// 电影信息列表
		rows: []
		
	}
});

function to_page(){
	var result;
	
	if($.trim($('#userId').val())!=""){
		var uId = $('#userId').val();
		
		$.ajax({
			type : "GET",
			url : "${PROJECT_PATH }/userMovie/historyList",
			data:"uId="+uId,
			dataType : "json",//接收服务端返回的数据类型
			async : false,
			success : function(data) {
				console.log(data);
				// 把ajax的请求域vue的渲染数据分离
				result = data;
				
			},
			error : function() {
				console.log("服务端出现异常！");
				//window.location.href="500.jsp";
			}
		});
		// 将ajax请求数据与vue渲染数据分离，vue不能定义在success函数中
		build_movie_table(result);
		
	}
}		
	

function build_movie_table(result){
	
	v.rows = result.extend.historyList;
	
}

</script>

<script type="text/javascript">
	function searchMovie() {
		// 1.判断搜索框是否为空，为空不能进行搜索
		var name = $("#search").val();

		if (name.length>0) {
			// 2.获取搜索框中的值并传递给后台处理
			$.ajax({
				//表单提交时以post方式，否则后台封装的对象是乱码
				type : "post",
				url : "${PROJECT_PATH }/movie/searchList",
				data: $('#searchForm').serialize(),
				dataType : "json",//接收服务端返回的数据类型
				async : false,
				success : function(result) {
					window.location.href="searchList.jsp";
				}
			});
		}

	}
	
	// 通过 v-on:click 绑定的方法可在<script>中直接实现，也可在vue的methods中实现
	function play_video(movie){
		window.location.href="single.jsp?mId="+movie.mId;
	}
</script>
</body>
</html>