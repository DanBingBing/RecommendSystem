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
    <link href="css/popuo-box.css" rel="stylesheet" type="text/css"
          media="all" />
    <!-- //pop-up -->
    <!-- font-awesome icons -->
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <!-- vue -->
    <script type="text/javascript" src="js/vue.min.js"></script>
    <!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <!-- banner-bottom-plugin -->
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="all">
    <script src="js/owl.carousel.js"></script>

    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
        	// 返回顶部
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
            <form id="searchForm" action="">
                <input type="text" name="mName" id="search" placeholder="请输入电影名称" required="">
                <input type="button" value="搜索" onclick="searchMovie();">
            </form>
        </div>
        <div class="w3l_sign_in_register">
            <ul>
                <li id="li">
                	<a href="" id="loginHref" data-toggle="modal" data-target="#myModal">登录</a>
                </li>
                
            </ul>
            
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- //header -->

<!-- bootstrap-pop-up -->
<!-- 用户登录注册模态框 -->
<div class="modal video-modal fade" id="myModal" tabindex="-1"
     role="dialog" aria-labelledby="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
               	 登录 & 注册
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close" onclick="closeModal()">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <section>
                <div class="modal-body">
                    <div class="w3_login_module">
                        <div class="module form-module">
                            <div class="toggle">
                                <i class="fa fa-times fa-pencil"></i>
                                <div class="tooltip">用户注册</div>
                            </div>
                            <div class="form" id="form1">
                                <h3>登录到你的账户</h3>
                                <form id="loginForm" action="">
                                    <input type="text" id="username" name="username"
                                           placeholder="用户名" required=""> <input type="password"
                                               id="password" name="password" placeholder="密码" required="">
                                    <!-- <input type="submit" value="登录"> -->
                                    <input type="button" value="登录" onclick="loginCheck()">
                                </form>
                            </div>

                            <div class="form" id="form2">
                                <h3>创建一个新账户</h3>
                                <form action="" id="registerForm">
                                    <input type="text" id="name" name="name" placeholder="昵称"
                                           required=""> 
                                    <input type="text" id="username1"
                                          name="username" placeholder="用户名" required=""> 
                                    <input type="password" id="password1" name="password"
                                          placeholder="密码" required="">
                                    <!-- <input type="submit" value="注册"> -->
                                    <input type="button" value="注册" onclick="registerCheck()">
                                </form>
                            </div>
                            <div id="message" class="message"></div>
                            <div class="cta">
                                <a href="#">忘记密码?</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>

<script>
    $('.toggle').click(function() {
        // Switches the Icon
        $(this).children('i').toggleClass('fa-pencil');
        // Switches the forms
        $('.form').animate({
            height : "toggle",
            'padding-top' : 'toggle',
            'padding-bottom' : 'toggle',
            opacity : "toggle"
        }, "slow");
    });
</script>

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
                        <li class="active"><a href="index.jsp">首页</a></li>

                    </ul>
                </nav>
            </div>
        </nav>
    </div>
</div>

<!-- //banner -->
<!-- banner-bottom -->
<div class="banner-bottom">
    <h4 class="latest-text">推荐电影</h4>
    <div class="container">
        <div class="w3_agile_banner_bottom_grid" id="run">
            <div id="owl-demo" class="owl-carousel owl-theme">

                <div class="item" v-for="i in movies">
                    <div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
                        <a href="javascript:;" v-on:click="play_video(i)" class="hvr-shutter-out-horizontal"><img
                                v-bind:src="i.mPoster" v-bind:title="i.mName"
                                class="img-responsive" alt=" " />
                            <div class="w3l-action-icon">
                                <i class="fa fa-play-circle" aria-hidden="true"></i>
                            </div> 
                        </a>
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
                                <li class="active">movie</li>
                            </ol>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="browse-inner" id="loop">

                        <div class="col-md-2 w3l-movie-gride-agile" v-for="item in rows" v-bind:key="item.mId">
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
                Copyright &copy; 2019.
                <a target="_blank" href="#">localhost:8080/RecommendSystem</a>
            </p>
        </div>
        <div class="col-md-7 w3ls_footer_grid1_right">
            <ul>
                <li><a href="index.jsp">Movies</a></li>
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
	to_page(1);
	
});

var result;

//1.使用vue解析json并渲染电影数据到页面
var v = new Vue({
	el: '#loop',
	data: {
		// 电影信息列表
		rows:[]
		
	}
});

//2.使用vue解析json并渲染电影数据到轮播导航栏
var v1 = new Vue({
	el: '#run',
	data: {
		movies:[]
	}
});

//轮播区动态效果
$("#owl-demo").owlCarousel({

	// 每隔3秒自动切换
	autoPlay: 3000,

	items : 5,
	itemsDesktop : [640,4],
	itemsDesktopSmall : [414,3]

});

function to_page(pn){
	
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
	// 2.解析json并显示电影数据(这里必须将数据赋值给vue中的data)
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

    function loginCheck() {
    	
        var username = $("#username").val();
        var password = $("#password").val();

        if (username.length > 0 && password.length > 0) {
            $.ajax({
                type : "post",
                url : "${PROJECT_PATH }/user/loginCheck",
                dataType : "json",//接收服务端返回的数据类型
                async : false,
                data : $('#loginForm').serialize(),
                success : function(result) {
                    console.log(result);//打印服务端返回的数据
                    //动态创建一个标签用于显示提示信息(其他信息)
                    build_msg_table(result);
                },
                error : function() {
                	console.log("服务端出现异常！");
                	//window.location.href="500.jsp";
                }
            });
        } else {
            // 清空之前的显示的信息
            $("#message").empty();
            $("#message").append($("<h5></h5>").append("用户名或密码不能为空！"))
                    .attr("style", "color:red;");
        }
    }

    function build_msg_table(result) {
        var username = $("#username").val();
        
        //在 id="message" 的标签后动态添加一个标签
        if (result.code == 100) {
            // 清空之前的显示的信息
            $("#message").empty();
            $("#message").append(
                    $("<h5></h5>").append("提示信息：" + result.extend.msg))
                    .attr("style", "color:red;");
        } else {

            // 清空之前的显示的信息
            //$("#message").empty();
            //显示正在登录提示信息(登录成功时，关闭模态框的时间太快，看不见该提示消息)
            //$("#message").append($("<h5></h5>").append(result.extend.msg)).attr("style", "color:green;");
            
            // 清空之前的显示的信息
            $("#li").empty();
            // 在 id="li" 的标签后动态添加一个标签
            $("#li").append(
                    $("<li></li>").append(
                            $("<h4></h4>").append("欢迎登录：" + username)));
            // 隐藏 id="loginHref" 的标签
            // hide()方法是隐藏选中的元素，包括所有子节点，类似于style="display:none;",show()是显示
            $("#loginHref").hide();
            //清空模态框中的登录信息
            //$("#loginForm").empty(); //使用这个会清空form表单下的所有标签等信息，包括文本和子节点，remove()是移除指定的当前节点。
            //$("#loginForm input").val(''); //使用这个会清空form表单下的所有input框中的value值
            //$("#username").val('');
            $("#password").val('');
            $("#name").val('');
            $("#username1").val('');
            $("#password1").val('');
            $("#message").empty();
            // 关闭模态框(登录成功后自动关闭模态框)
            $("#myModal").modal("hide");
            
            // 登录成功后跳转到推荐页面
            window.location.href="recommendList.jsp";
        }

    }
    
    // 点击关闭模态框按钮
    function closeModal() {
        //清空模态框中的登录信息
        $("#username").val('');
        $("#password").val('');
        //清空模态框中的注册信息
        $("#name").val('');
        $("#username1").val('');
        $("#password1").val('');
        $("#message").empty();
    }

    function registerCheck() {

        var name = $("#name").val();
        var username1 = $("#username1").val();
        var password1 = $("#password1").val();

        if (name.length > 0 && username1.length > 0 && password1.length > 0) {

            $.ajax({
                type : "post",
                url : "${PROJECT_PATH }/user/registerCheck",
                dataType : "json",//接收服务端返回的数据类型
                async : false,
                data : $('#registerForm').serialize(),
                success : function(result) {
                    console.log(result);//打印服务端返回的数据
                    if (result.code == 100) {
                        //动态创建一个标签用于显示提示信息
                        build_msg_table(result);
                    } else {
                        $.ajax({
                            type : "post",
                            url : "${PROJECT_PATH }/user/register",
                            dataType : "json",//接收服务端返回的数据类型
                            async : false,
                            data : $('#registerForm')
                                    .serialize(),
                            success : function(result) {
                                console.log(result);//打印服务端返回的数据
                                // 清空之前的显示的信息
                                $("#message").empty();
                                $("#message").append($("<h5></h5>")
                                        .append(result.extend.msg+",欢迎登录！"))
                                        .attr("style","color:green;");
                                // 关闭当前注册窗口
                                $("#form2").attr("style","display: none;");
                                
                                // 打开登录窗口
                                $("#form1").attr("style","display: block;");
                                // 清空注册信息
                                $("#name").val('');
                                $("#nameuser1").val('');
                                $("#password1").val('');
                            },
                            error : function() {
                            	console.log("服务端出现异常！");
                            	//window.location.href="500.jsp";
                            }
                        });
                    }

                },
                error : function() {
                	console.log("服务端出现异常！");
                	//window.location.href="500.jsp";
                }
            });
        } else {
            // 清空之前的显示的信息
            $("#message").empty();
            $("#message").append($("<h5></h5>").append("注册信息不能为空！")).attr(
                    "style", "color:red;");
        }
    }

</script>

<script type="text/javascript">
	function searchMovie() {
		var name = $("#search").val();
		// 1.判断搜索框是否为空，不为空进入搜索
		if (name.length>0) {
			window.location.href="searchList.jsp?mName="+name;
		}

	}

	// 通过 v-on:click 绑定的方法可在<script>中直接实现，也可在vue的methods中实现
	function play_video(movie){
		window.location.href="single.jsp?mId="+movie.mId;
	}
</script>

</body>
</html>