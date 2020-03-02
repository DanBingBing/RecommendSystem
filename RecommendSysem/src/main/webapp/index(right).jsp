<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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
        addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
        function hideURLbar(){ window.scrollTo(0,1); }
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
            <form id="searchForm" action="">
                <input type="text" name="mName" id="search" placeholder="请输入电影名称" required="">
                <input type="button" value="搜索" onclick="searchMovie()">
            </form>
        </div>
        <div class="w3l_sign_in_register">
            <ul>
                <li id="li"><a href="" id="loginHref" data-toggle="modal"
                               data-target="#myModal">登录</a></li>
            </ul>

        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- //header -->
<!-- bootstrap-pop-up -->
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
<!-- //nav -->
<!-- banner -->
<div id="slidey" style="display: none;">
    <ul>
        <li><img src="images/5.jpg" alt=" ">
            <p class='title'>Tarzan</p>
            <p class='description'>Tarzan, having acclimated to life in
                London, is called back to his former home in the jungle to
                investigate the activities at a mining encampment.</p></li>
        <li><img src="images/2.jpg" alt=" ">
            <p class='title'>Maximum Ride</p>
            <p class='description'>Six children, genetically cross-bred with
                avian DNA, take flight around the country to discover their
                origins. Along the way, their mysterious past is ...</p></li>
        <li><img src="images/3.jpg" alt=" ">
            <p class='title'>Independence</p>
            <p class='description'>The fate of humanity hangs in the balance
                as the U.S. President and citizens decide if these aliens are to be
                trusted ...or feared.</p></li>
        <li><img src="images/4.jpg" alt=" ">
            <p class='title'>Central Intelligence</p>
            <p class='description'>Bullied as a teen for being overweight,
                Bob Stone (Dwayne Johnson) shows up to his high school reunion
                looking fit and muscular. Claiming to be on a top-secret ...</p></li>
        <li><img src="images/6.jpg" alt=" ">
            <p class='title'>Ice Age</p>
            <p class='description'>In the film's epilogue, Scrat keeps
                struggling to control the alien ship until it crashes on Mars,
                destroying all life on the planet.</p></li>
        <li><img src="images/7.jpg" alt=" ">
            <p class='title'>X - Man</p>
            <p class='description'>In 1977, paranormal investigators Ed
                (Patrick Wilson) and Lorraine Warren come out of a self-imposed
                sabbatical to travel to Enfield, a borough in north ...</p></li>
    </ul>
</div>
<script src="js/jquery.slidey.js"></script>
<script src="js/jquery.dotdotdot.min.js"></script>
<script type="text/javascript">
    $("#slidey").slidey({
        interval : 8000,
        listCount : 5,
        autoplay : false,
        showList : true
    });
    $(".slidey-list-description").dotdotdot();
</script>

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
                                <li><a href="index.html">首页</a></li>
                                <li class="active">home</li>
                            </ol>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="browse-inner" id="loop">

                        <div class="col-md-2 w3l-movie-gride-agile" v-for="item in rows">
                            <a href="single.html" class="hvr-shutter-out-horizontal"><img
                                    v-bind:src="item.mPoster" class="figure_pic" v-bind:title="item.mName" alt=" " />
                                <div class="w3l-action-icon">
                                    <i class="fa fa-play-circle" aria-hidden="true"></i>
                                </div> </a>
                            <div class="mid-1">
                                <div class="w3l-movie-text" id="single">
                                    <h6>
                                        <a href="single.html" v-bind:title="item.mName" class="set-font-size">{{item.mName}}</a>
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

<!-- //banner -->
<!-- banner-bottom -->
<div class="banner-bottom">
    <a href="#">
        <h4 class="latest-text w3_latest_text">推荐电影</h4>
    </a>
    <div class="container">
        <div class="w3_agile_banner_bottom_grid">
            <div id="owl-demo" class="owl-carousel owl-theme">

                <div class="item" v-for="i in movies">
                    <div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
                        <a href="single.html" class="hvr-shutter-out-horizontal"><img
                                v-bind:src="i.mPoster" v-bind:title="i.mName"
                                class="img-responsive" alt=" " />
                            <div class="w3l-action-icon">
                                <i class="fa fa-play-circle" aria-hidden="true"></i>
                            </div> </a>
                        <div class="mid-1 agileits_w3layouts_mid_1_home">
                            <div class="w3l-movie-text">
                                <h6>
                                    <a href="single.html" v-bind:title="i.mName" class="set-font-size">{{i.mName}}</a>
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
                    target="_blank" href="#">localhost：8080</a>
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

    function loginCheck() {
    	
        var username = $("#username").val();
        var password = $("#password").val();

        if (username.length > 0 && password.length > 0) {
            $.ajax({
                type : "post",
                url : "/loginCheck",
                dataType : "json",//接收服务端返回的数据类型
                async : false,
                data : $('#loginForm').serialize(),
                success : function(result) {
                    console.log(result);//打印服务端返回的数据
                    //动态创建一个标签用于显示提示信息(其他信息)
                    build_msg_table(result);
                },
                error : function() {
                    alert("服务器端出现异常！");
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
        	//加载第一页的推荐电影
            to_page();
        	
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
            $("#username").val('');
            $("#password").val('');
            $("#name").val('');
            $("#username1").val('');
            $("#password1").val('');
            $("#message").empty();
            // 关闭模态框(登录成功后自动关闭模态框)
            $("#myModal").modal("hide");

            // 隐藏顶部轮播图
            //$("#slidey").hide();
            // 清空顶部轮播图
            $("#slidey").empty();

            
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
                url : "/registerCheck",
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
                            url : "/register",
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
                                alert("服务器端出现异常！");
                            }
                        });
                    }

                },
                error : function() {
                    alert("服务器端出现异常！");
                }
            });
        } else {
            // 清空之前的显示的信息
            $("#message").empty();
            $("#message").append($("<h5></h5>").append("注册信息不能为空！")).attr(
                    "style", "color:red;");
        }
    }

    // 定义一个总记录数，用于查询分页插件查询最后一页的信息
    // 定义一个当前记录数，用户查询当前页的信息
    var totalRecord,currentPage;

    function to_page() {
    	
        $.ajax({
            type : "GET",
            url : "/movieList",
            dataType : "json",//接收服务端返回的数据类型
            async : false,
            success : function(result) {
                console.log(result);
                // 1.使用vue解析json并渲染电影数据到页面
                var v = new Vue({
                    el: '#loop',
                    data: {
                        rows: result.extend.movieList,
                        url:'single.html?username='
                    }
                });

                var vm = new Vue({
                    el: '#owl-demo',
                    data: {
                        movies: result.extend.movieList
                    }
                });

                $("#owl-demo").owlCarousel({

                    autoPlay : 3000, //Set AutoPlay to 3 seconds

                    items : 5,
                    itemsDesktop : [ 640, 4 ],
                    itemsDesktopSmall : [ 414, 3 ]

                });
            },
            error : function() {
                alert("服务器端出现异常！");
            }
        });
    }
    
    
	function searchMovie() {
		// 1.判断搜索框是否为空，为空不能进行搜索
		var name = $("#search").val();
		
		if (name.length>0) {
			// 2.获取搜索框中的值并传递给后台处理
			$.ajax({
				//表单提交时以post方式，否则后台封装的对象是乱码
				type : "post",
				url : "/searchList",
				data: $('#searchForm').serialize(),
				dataType : "json",//接收服务端返回的数据类型
				async : false,
				success : function(result) {
					console.log(result);
					// 3.使用vue解析json并渲染电影数据到页面
					var v2 = new Vue({
						el : '#loop',
						data : {
							rows : result.extend.movieList,
						}
					});
				}
			});
		}
		
	}
</script>
</body>
</html>