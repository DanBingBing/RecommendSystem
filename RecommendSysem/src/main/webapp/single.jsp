<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	pageContext.setAttribute("PROJECT_PATH",request.getContextPath());
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>电影播放</title>
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
	<link href="${PROJECT_PATH }/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${PROJECT_PATH }/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${PROJECT_PATH }/css/medile.css" rel='stylesheet' type='text/css' />
	<link href="${PROJECT_PATH }/css/single.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="${PROJECT_PATH }/css/contactstyle.css" type="text/css" media="all" />
	<link rel="stylesheet" href="${PROJECT_PATH }/css/faqstyle.css" type="text/css" media="all" />
	<!-- news-css -->
	<link rel="stylesheet" href="${PROJECT_PATH }/news-css/news.css" type="text/css" media="all" />
	<!-- //news-css -->
	<!-- list-css -->
	<link rel="stylesheet" href="${PROJECT_PATH }/list-css/list.css" type="text/css" media="all" />
	<!-- //list-css -->
	<!-- font-awesome icons -->
	<link rel="stylesheet" href="${PROJECT_PATH }/css/font-awesome.min.css" />
	<!-- vue -->
    <script type="text/javascript" src="${PROJECT_PATH }/js/vue.min.js"></script>
	<!-- js -->
	<script type="text/javascript" src="${PROJECT_PATH }/js/jquery-2.1.4.min.js"></script>
	<!-- //js -->
	<!-- //font-awesome icons -->
	<link href="${PROJECT_PATH }/css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
	<script src="${PROJECT_PATH }/js/owl.carousel.js"></script>
	<!-- start-smoth-scrolling -->
	<script type="text/javascript" src="${PROJECT_PATH }/js/move-top.js"></script>
	<script type="text/javascript" src="${PROJECT_PATH }/js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
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
				<a href="index.html"><h1>
						One<span>Movies</span>
					</h1></a>
			</div>
			<div class="w3_search">
				<form id="searchForm" action="">
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
	<!-- //header -->
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
							<li><a href="javascript:;" onclick="toIndex();">首页</a></li>
							<li><a href="javascript:;" onclick="toRecommend();">推荐电影</a></li>
							<li class="active"><a href="${PROJECT_PATH }/single.jsp">电影单页</a></li>
						</ul>
					</nav>
				</div>
			</nav>
		</div>
	</div>


	<!-- single -->
	<div class="single-page-agile-main">
		<div class="container">
			<!-- /w3l-medile-movies-grids -->
			<div class="agileits-single-top">
				<ol class="breadcrumb">
					<li><a href="${PROJECT_PATH }/index.jsp">Home</a></li>
					<li class="active">video</li>
				</ol>
			</div>
			<div class="single-page-agile-info">
				<!-- /movie-browse-agile -->
				<div class="show-top-grids-w3lagile">
					<div class="col-sm-8 single-left" id="single">
						<div class="song">
							<div class="song-info">
								<h3>{{mName}}</h3>
							</div>
							<div class="video-grid-single-page-agileits">
								<div data-video="" id="video" class="video-img">
									<a href="javascript:;" v-on:click="playVideo()"
										class="hvr-shutter-out-horizontal"> <img
										src="${PROJECT_PATH }/images/5.jpg" alt=""
										class="img-responsive" title="点击播放" />
										<div class="w3l-action-icon">
											<i class="fa fa-play-circle" aria-hidden="true"></i>
										</div>
									</a>
								</div>
							</div>
						</div>
						<div class="song-grid-right">
							<div class="share">
								<h5>{{mTag}}</h5>
								<div class="single-agile-shar-buttons">
									<ul>

										<li class="news-twitter">
											<h6>{{mYear}}</h6>
										</li>

									</ul>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>

						<div class="all-comments">
							<div class="all-comments-info" id="showGrade">
								<h3>请为该电影评分</h3>
								<div class="agile-info-wthree-box">
									<form action="" id="gradeForm">
										<div class="col-sm-4">
											<!-- 下拉列表 -->
											<select class="form-control" name="mov_grade">
												<option>5</option>
												<option>4</option>
												<option>3</option>
												<option>2</option>
												<option>1</option>
											</select>
										</div>

										<input type="button" id="gradeButton" value="确定"
											onclick="grade();">
										<div class="clearfix"></div>
									</form>
									<h4 id="message"></h4>
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-4 single-right">

					<h3>演员</h3>
					<div class="single-grid-right">
						<div class="col-md-8 single-right-grid-right">
							<p class="views">演员1 演员2</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="single-grid-right">
						<div class="col-md-8 single-right-grid-right">
							<p class="views"></p>
						</div>
						<div class="clearfix"></div>
					</div>
					<h3>电影简介</h3>
					<div class="single-grid-right">
						<div class="col-md-8 single-right-grid-right">
							<p class="views">电影简介...</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="single-grid-right">
						<div class="col-md-8 single-right-grid-right">
							<p class="views"></p>
						</div>
						<div class="clearfix"></div>
					</div>

				</div>

				<div class="clearfix"></div>
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
							<a href="${PROJECT_PATH }/index.jsp"><h2>
									One<span>Movies</span>
								</h2></a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-5 w3ls_footer_grid1_left">
						<p>
							Copyright &copy; 2019.<a target="_blank" href="#">localhost:8080/RecommendSystem</a>
						</p>
					</div>
					<div class="col-md-7 w3ls_footer_grid1_right">
						<ul>
							<li><a href="${PROJECT_PATH }/movieList.jsp">Movies</a></li>

						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //footer -->
			<!-- Bootstrap Core JavaScript -->
	
<script src="${PROJECT_PATH }/js/bootstrap.min.js"></script>
<script>
	jQuery(document).ready(function(){
		$(".dropdown").hover(
				function() {
					$('.dropdown-menu', this).stop( true, true ).slideDown("fast");
					$(this).toggleClass('open');
				},
				function() {
					$('.dropdown-menu', this).stop( true, true ).slideUp("fast");
					$(this).toggleClass('open');
				}
		);
	});
</script>
			<!-- //Bootstrap Core JavaScript -->
			<!-- here stars scrolling icon -->
			<script type="text/javascript">
	jQuery(document).ready(function() {

		$().UItoTop({ easingType: 'easeOutQuart' });

	});
</script>

<script>
//或去url中的参数
jQuery(document).ready(function() {
	
	var mId = getQueryString("mId");
	
	var	uId;
	
	$.ajax({
        type : "post",
        url : "${PROJECT_PATH }/movie/getSingle",
        dataType : "json",//接收服务端返回的数据类型
        async : false,
        data : {"mId":mId},
        success : function(result) {
            console.log(result);//打印服务端返回的数据
            
            var v = new Vue({
        		el: '#single',
        		data: {
        			mName: result.extend.movie.mName,
        			mTag: result.extend.movie.mTag,
        			mYear: result.extend.movie.mYear
        		},
            	methods:{
            		playVideo(){
            			if($.trim($('#userId').val())!=""){
            				uId = $('#userId').val();
            				
            				$.ajax({
                		        type : "post",
                		        url : "${PROJECT_PATH }/userMovie/addMovieToUser",
                		        dataType : "json",//接收服务端返回的数据类型
                		        async : false,
                		        data : {"mId":mId,"uId":uId},
                		        success : function(result) {
                		            console.log(result);//打印服务端返回的数据
						            if(result.code==200){
                		            	// 清空之前的显示的信息
                		                $("#message").empty();
                		                $("#message").append(result.extend.msg).attr("style","color:green;");
                		            }else{
                		            	// 清空之前的显示的信息
                		                $("#message").empty();
                		                $("#message").append(result.extend.msg).attr("style","color:red;");
                		            }
                		        },
                		        error : function() {
                		        	console.log("服务端出现异常！");
                		        	//window.location.href="500.jsp";
                		        }
                		    });
            				
            			}else{
            				// 清空之前的显示的信息
            			    $("#message").empty();
            			    $("#message").append("请先登录！").attr("style","color:red;");
            			}
            			
            		}
            	}
        	});
            
        },
        error : function() {
        	console.log("服务端出现异常！");
        	//window.location.href="500.jsp";
        }
    });
	
	if($.trim($('#userId').val())!=""){
		uId = $('#userId').val();

		getSingleMovie(mId,uId);
	}
		
});

</script>

<script>
function getSingleMovie(mId,uId){
	$.ajax({
        type : "post",
        url : "${PROJECT_PATH }/userMovie/getSingleMovie",
        dataType : "json",//接收服务端返回的数据类型
        data : {"mId":mId,"uId":uId},
        success : function(result) {
        	console.log(result);
        	// 如果后台传递过来的的是list集合，不能直接 result.extend.movie.movGrade 取出,因为movie是数组
        	// vue中能取，是vue做了处理
            if(result.code==200){
            	// 清空之前的显示的信息
                $("#showGrade").empty();
                $("#showGrade").append($("<h3></h3>").append("我的评分"));
                $("#showGrade").append($("<input />").attr("type","text").val(result.extend.movie.movGrade).attr("readonly","readonly"));
	
            }
        },
        error : function() {
        	console.log("服务端出现异常！");
        	//window.location.href="500.jsp";
        }
    });
}

function grade(){
	
	var mId = getQueryString("mId");
	
	var grade = $('#gradeForm').serialize();
	
	if($.trim($('#userId').val())!=""){
		var uId = $('#userId').val();
		
		$.ajax({
	        type : "post",
	        url : "${PROJECT_PATH }/userMovie/grade",
	        dataType : "json",//接收服务端返回的数据类型
	        //data : {"mId":mId,"mov_grade":mov_grade},
	        data : {"mov_grade":$('#gradeForm').serialize(),"mId":mId,"uId":uId},
	        success : function(result) {
	            console.log(result);//打印服务端返回的数据
	            if(result.code==200){
	            	// 清空之前的显示的信息
	                $("#message").empty();
	                $("#message").append(result.extend.msg).attr("style","color:green;");
	                // 评分成功后刷新该页面，去掉确定按钮、防止用户多次点击该按钮，多次发送推荐请求，增加服务器压力
	                window.location.href="${PROJECT_PATH }/single.jsp"; 
	                
	                // 评分成功后刷新用户的推荐电影信息
	     			refreshRecommend();
	                
	            }else{
	            	// 清空之前的显示的信息
	                $("#message").empty();
	                $("#message").append(result.extend.msg).attr("style","color:red;");
	            }
	            
	        },
	        error : function() {
	        	console.log("服务端出现异常！");
	        	//window.location.href="500.jsp";
	        }
	    });
	}else{
		// 清空之前的显示的信息
	    $("#message").empty();
	    $("#message").append("请先登录！").attr("style","color:red;");
	}
	
}

function refreshRecommend(){

	if($.trim($('#userId').val())!=""){
		var uId = $('#userId').val();
		
		// 刷新用户的推荐电影信息
		$.ajax({
			type : "post",
			url : "${PROJECT_PATH }/recommend/refreshRecommend",
			dataType : "json",//接收服务端返回的数据类型
			data : {"uId":uId},
			success : function(result) {
				console.log(result.extend.message);//打印服务端返回的数据
	            			
			},
			error : function() {
				console.log("服务端出现异常！");
				//window.location.href="500.jsp";
			}
		});
		
	}
	
}
</script>

<script>
function searchMovie() {
	var name = $("#search").val();
	// 1.判断搜索框是否为空，不为空进入搜索
	if (name!=''||name!=null) {
		window.location.href="searchList.jsp?mName="+name;
	}

}

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

function exit(){
	window.location.href="index.jsp";
	// 清空session域中的用户对象
	//session.removeAttribute("user"); 
	// 使session域对象失效
	session.invalidate();
}

//获取url上的参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return decodeURIComponent(r[2]);
    }else{
        return null;
    }
}
</script>
</body>
</html>