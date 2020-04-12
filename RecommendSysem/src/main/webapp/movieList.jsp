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
	<script>
		$(document).ready(function() {
			// 轮播区动态效果
			$("#owl-demo").owlCarousel({

				// 每隔3秒自动切换
				autoPlay: 3000,

				items : 5,
				itemsDesktop : [640,4],
				itemsDesktopSmall : [414,3]

			});

		});
	</script>
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
	
	<style>
        #exit{margin:0 auto;width:72px;}
    </style>
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
			<form id="searchForm" action="" method="">
				<input type="text" name="mName" id="search" placeholder="请输入电影名称" required="">
				<input type="button" value="搜索" onclick="searchMovie();">
			</form>
		</div>
		<div class="w3l_sign_in_register">
			<ul>
				<li id="li">
					<!-- jstl方法取出session中的数据 -->
					<a href="#" id="username">${sessionScope.user.username }</a>
				</li>
				<li><a href="javascript:void(0);" id="exit" onclick="exit();"><i class="fa fa-power-off"></i></a></li>
			</ul>
			<input type="hidden" value="${sessionScope.user.id}" id="userId" />
		</div>
		<div class="clearfix"></div>
	</div>
</div>

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
						<li class="active"><a href="javascript:;" onclick="toIndex();">首页</a></li>
						<li><a href="javascript:;" onclick="toRecommend();">推荐电影</a></li>
						<li><a href="${PROJECT_PATH }/historyList.jsp">观看历史</a></li>
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
					<h4 class="latest-text">电影库</h4>
					<div class="container">
						<div class="agileits-single-top">
							<ol class="breadcrumb">
								<li><a href="index.jsp">Home</a></li>
								<li class="active">movies</li>
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

<!-- //banner -->
<!-- banner-bottom -->
<div class="banner-bottom">
	<h4 class="latest-text">推荐电影</h4>
	<div class="container">
		<div class="w3_agile_banner_bottom_grid">
			<div id="owl-demo" class="owl-carousel owl-theme">

				<div class="item" v-for="i in movies">
					<div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
						<a href="javascript:;" v-on:click="play_video(i)" class="hvr-shutter-out-horizontal"><img
								v-bind:src="i.mPoster" v-bind:title="i.mName"
								class="img-responsive" alt=" " />
							<div class="w3l-action-icon">
								<i class="fa fa-play-circle" aria-hidden="true"></i>
							</div> </a>
						<div class="mid-1 agileits_w3layouts_mid_1_home">
							<div class="w3l-movie-text">
								<h6>
									<a href="javascript:;" v-on:click="play_video(i)" v-bind:title="i.mName" class="set-font-size">{{i.mName}}</a>
								</h6>
							</div>
							<div class="mid-2 agile_mid_2_home">
								<p>{{i.mYear}}</p>
								<div class="block-stars">
									<ul class="w3l-ratings">
										<li><a href="#"><i class="fa fa-star"
														   aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-star"
														   aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-star"
														   aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-star"
														   aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-star-half-o"
														   aria-hidden="true"></i></a></li>
									</ul>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
</div>

<!-- //Latest-tv-series -->
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
	to_page(1);
});

//1.使用vue解析json并渲染电影数据到页面
var v = new Vue({
	el: '#loop',
	data: {
		// 电影信息列表
		rows: []
		
	}
});

//2.使用vue解析json并渲染电影数据到轮播导航栏
var v1 = new Vue({
	el: '#owl-demo',
	data: {
		movies: []
	}
});

function to_page(pn){
	var result;
	$.ajax({
		type : "GET",
		url : "${PROJECT_PATH }/movie/movieList",
		data:"pageNumber="+pn,
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
	// 1.解析json并显示电影数据(这里必须将数据赋值给vue中的data)
	build_movie_table(result);
	
	// 3.解析json并显示分页条信息
	build_page_nav(result);
}

function build_movie_table(result){
	
	v.rows = result.extend.movieList.list;
	
	v1.movies = result.extend.movieList.list;
	
}

function build_page_nav(result){
	// 清空分页栏信息
	$("#page_nav_area").empty();
	
	var ul = $("<ul></ul>").addClass("pagination");
	
	var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","javascript:scroll(0,0);"));
	var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","javascript:scroll(0,0);"));
	// 判断页码上是否还有前一页，没有则点击a标签不生效
	if(result.extend.movieList.hasPreviousPage == false){
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}else{
		// 为首页、上一页添加单击事件
		firstPageLi.click(function(){
			to_page(1);
		});
		prePageLi.click(function(){
			to_page(result.extend.movieList.pageNum - 1);
		});
	}
	// javascript:scroll(0,0);表示点击之后立即回到顶部
	var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","javascript:scroll(0,0);"));
	var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","javascript:scroll(0,0);"));
	// 判断页码上是否还有下一页，没有则点击a标签不生效
	if(result.extend.movieList.hasNextPage == false){
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	}else{
		// 为下一页、末页添加单击事件
		nextPageLi.click(function(){
			to_page(result.extend.movieList.pageNum + 1);
		});
		lastPageLi.click(function(){
			to_page(result.extend.movieList.pages);
		});
	}
	
	// 添加首页和前一页的提示
	ul.append(firstPageLi).append(prePageLi);
	
	// 遍历显示的页码号 1,2,3 ...,遍历给ul添加页码提示
	$.each(result.extend.movieList.navigatepageNums,function(index,item){
		var pageLi = $("<li></li>").append($("<a></a>").append(item).attr("href","javascript:scroll(0,0);"));
		// 判断当前页是否是传过来的数据中的信息，是则可以点击a标签
		if(result.extend.movieList.pageNum == item){
			pageLi.addClass("active");
		}
		// 绑定单击事件，获取对应页码的数据
		pageLi.click(function(){
			to_page(item);
		});
		
		ul.append(pageLi);
	});
	
	// 添加末页和下一页的提示
	ul.append(nextPageLi).append(lastPageLi);
	
	// 把ul加入到#page_nav_area
	ul.appendTo("#page_nav_area");
}
</script>

<script type="text/javascript">

	function toIndex(){
		// a标签与input的取文本值、取值函数不同
		if($.trim($('#username').text())!=""){
			window.location.href="movieList.jsp";
		}else{
			window.location.href="index.jsp";
		}
		
	}
	
	function toRecommend(){
		// a标签与input的取文本值、取值函数不同
		if($.trim($('#username').text())!=""){
			window.location.href="recommendList.jsp";
		}else{
			window.location.href="index.jsp";
		}
	}

	function searchMovie() {
		// 1.判断搜索框是否为空，为空不能进行搜索
		var name = $("#search").val();

		if (name.length>0) {
			window.location.href="searchList.jsp?mName="+name;
		}

	}
	
	// 通过 v-on:click 绑定的方法可在<script>中直接实现，也可在vue的methods中实现
	function play_video(movie){
		window.location.href="single.jsp?mId="+movie.mId;
	}
	
	function exit(){
		window.location.href="index.jsp";
		
		// 清空session域中的用户对象
		//session.removeAttribute("user"); 
		// 使session域对象失效
		session.invalidate();
		
	}
</script>

</body>
</html>