<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="icon" type="image/x-icon" href="${PROJECT_PATH }/images/title.ico" />
	<link href="${PROJECT_PATH }/css/bootstrap.css" rel="stylesheet" type="text/css"
		  media="all" />
	<link href="${PROJECT_PATH }/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${PROJECT_PATH }/css/contactstyle.css" rel="stylesheet" type="text/css"
		  media="all" />
	<link href="${PROJECT_PATH }/css/faqstyle.css" rel="stylesheet" type="text/css"
		  media="all" />
	<link href="${PROJECT_PATH }/css/single.css" rel='stylesheet' type='text/css' />
	<link href="${PROJECT_PATH }/css/medile.css" rel='stylesheet' type='text/css' />
	<!-- banner-slider -->
	<link href="${PROJECT_PATH }/css/jquery.slidey.min.css" rel="stylesheet">
	<!-- //banner-slider -->
	<!-- pop-up -->
	<link href="${PROJECT_PATH }/css/popuo-box.css" rel="stylesheet" type="text/css"
		  media="all" />
	<!-- //pop-up -->
	<!-- font-awesome icons -->
	<link rel="stylesheet" href="${PROJECT_PATH }/css/font-awesome.min.css" />

	<!-- vue -->
	<script type="text/javascript" src="${PROJECT_PATH }/js/vue.min.js"></script>
	<!-- js -->
	<script type="text/javascript" src="${PROJECT_PATH }/js/jquery-2.1.4.min.js"></script>
	<!-- //js -->
	<!-- banner-bottom-plugin -->
	<link href="${PROJECT_PATH }/css/owl.carousel.css" rel="stylesheet" type="text/css"
		  media="all">
	<script src="${PROJECT_PATH }/js/owl.carousel.js"></script>

	<script type="text/javascript" src="${PROJECT_PATH }/js/move-top.js"></script>
	<script type="text/javascript" src="${PROJECT_PATH }/js/easing.js"></script>
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
			<a href="${PROJECT_PATH }/index.jsp">
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
						<li class="active"><a href="${PROJECT_PATH }/index.jsp">首页</a></li>

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
								<li><a href="${PROJECT_PATH }/index.jsp">Home</a></li>
								<li class="active">search</li>
							</ol>
						</div>
					</div>
				</div>
				<div class="container">
					<div class="browse-inner" id="vue-space">
						<c:forEach var="movie" items="${movieList}">
						<div class="col-md-2 w3l-movie-gride-agile">
							<a href="javascript:;" onclick="play_video('${movie.mName}','${movie.mTag}','${movie.mYear}');" class="hvr-shutter-out-horizontal">
								<img src="${PROJECT_PATH }/${movie.mPoster }" class="figure_pic" title="${movie.mName }" alt=" " />
								<div class="w3l-action-icon">
									<i class="fa fa-play-circle" aria-hidden="true"></i>
								</div> </a>
							<div class="mid-1">
								<div class="w3l-movie-text" id="single">
									<h6>
										<a href="javascript:;" onclick="play_video('${movie.mName}','${movie.mTag}','${movie.mYear}');" title="${movie.mName }" class="set-font-size">${movie.mName }</a>
									</h6>
								</div>
								<div class="w3l-movie-text">
									<h6>${movie.mTag }</h6>
								</div>
								<div class="mid-2">

									<p>${movie.mYear }</p>
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
						</c:forEach>
					</div>

				</div>


				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--//browse-agile-w3ls -->
	<div class="blog-pagenat-wthree">
		<ul>
			<li><a class="frist" href="#">上一页</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a class="last" href="#">下一页</a></li>
		</ul>
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
					target="_blank" href="#">localhost:8080/Recommend</a>
			</p>
		</div>
		<div class="col-md-7 w3ls_footer_grid1_right">
			<ul>
				<li><a href="genres.html">Movies</a></li>
				<li><a href="faq.html">FAQ</a></li>
				<li><a href="horror.html">Action</a></li>
				<li><a href="genres.html">Adventure</a></li>
				<li><a href="comedy.html">Comedy</a></li>
				<li><a href="icons.html">Icons</a></li>
				<li><a href="contact.html">Contact Us</a></li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="${PROJECT_PATH }/js/bootstrap.min.js"></script>
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
	
	// 通过 v-on:click 绑定的方法可在<script>中直接实现，也可在vue的methods中实现
	function play_video(mName,mTag,mYear){
		console.log(mName+":"+mTag+":"+mYear);
		window.location.href="single.jsp?mName="+movie.mName+"&mTag="+movie.mTag+"&mYear="+movie.mYear;
	}
</script>
</body>
</html>