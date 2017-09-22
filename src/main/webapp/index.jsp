<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>model</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/model.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/oiostyle.css" rel="stylesheet" type="text/css"
	media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Jewellry online Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 




</script>
<link href='http://fonts.googleapis.com/css?family=Michroma'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Courgette'
	rel='stylesheet' type='text/css'>

<script type="text/javascript">
	jQuery(document).ready(
			function($) {
				$(".scroll").click(function(event) {
					event.preventDefault();
					$('html,body').animate({
						scrollTop : $(this.hash).offset().top
					}, 1000);
				});

				$("[name=\"captcha\"]").blur(
						function() {
							var val = $("[name=\"captcha\"]").val();
							$.ajax({
								url : "check",
								data : {
									captcha : val
								},
								type : "POST",
								success : function(r) {
									$("#msg").empty();
									if (r === "true") {
										//alert("验证通过");
										$("#login").attr("disabled", false);
										$("<span>", {
											"id" : "msg"
										}).text("√").css("color", "green")
												.insertAfter("#captcha");
									} else {
										//alert("验证码不正确!!");
										$("#login").attr("disabled", true);
										$("<span>", {
											"id" : "msg"
										}).text("×").css("color", "red")
												.insertAfter("#captcha");
									}
								}

							});

						});

				$("form").on("click", "#captcha", function() {
					$(this).attr("src", "captcha?" + new Date().getTime());
				});

			});
</script>


</head>

<body>

	<!-- model -->
	<div class="container">
		<div class="header-top">
			<div class="header-top-in">
				<div class="top-header">
					<div class="logo">
						<a href="index.html"><img src="img/model/dushulogo.png"
							alt=" "></a>
					</div>
					<div class="left-head">
						<img class="img-responsive" src="img/model/green_brick.png"
							alt=" ">
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="top-header-in">
					<img class="img-responsive bag" src="img/model/logo_1.png" alt=" ">
				</div>
				<div class="clearfix"></div>
			</div>
			<!---->
			<div class="top-nav">
				<div id="oiologo">
					<a href=""> <img id="oio_logo" alt=""
						src="img/model/150537980818443.png">
					</a>
				</div>
				<ul>
					<!-- <li class="active" id="logo"><a href="index.html">OIO书店</a></li> -->
					<li id="one-li"><a > 我的OIO </a></li>
					<li id="two-li"><a >购物车</a></li>
					<li id="Three-li"><a >退出登录</a></li>
				</ul>
				<!--script-->
				<script>
					$("span.menu").click(function() {
						$(".top-nav ul").slideToggle(500, function() {
						});
					});
				</script>
			</div>



			<!--  这里是内容区 所有内容写在这个div里面  -->
			<div id="content">

				<div>
					<img id="zhuceimg" src="img/login/shuyuan.png">
				</div>

				<form action="user/login" method="post">
				<!-- <input type="hidden" name="pageIdx" value="1"/>
				 -->
					<div id="login_box" class="col-md-12">

						<div>
							<p id="login_p">${msg}</p>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-md-3 control-label"
								style="margin-top: 30px; margin-left: 20px;">用户名 ：</label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="inputEmail3"
									placeholder="请输入用户名" name="userName"
									style="margin-top: 25px; margin-left: -12px;">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-md-3 control-label"
								style="margin-top: 10px; margin-left: 20px;">密&nbsp&nbsp&nbsp码 ：</label>
							<div class="col-md-8">
								<input type="password" class="form-control" id="inputPassword3"
									name="password" placeholder="请输入密码"
									style="margin-top: 5px; margin-left: -12px;">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-md-3 control-label"
								style="margin-top: 10px; margin-left: 20px;">验证码 ：</label>
							<div class="col-md-4">
								<input name="captcha" type="text" class="form-control"
									id="inputPassword3" placeholder="输入验证码"
									style="margin-top: 5px; margin-left: -12px;">
							</div>
							<div id="captchas">
								<img src="captcha" id="captcha">
							</div>
						</div>
						<div>
							<button id="login" class="col-md-9 btn btn-default"
								style="font-weight:bold;margin-top: 15px; margin-left: 50px;">登&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp录</button>
						</div>

						<div style="margin-top: 55%; margin-left: -75%;">
							<a class="account_operation" href="user/forgetPwd">忘记密码</a>
						</div>
						<div style="margin-top: -5.5%; margin-left: 75%;">
							<a class="account_operation" href="user/add">帐号注册</a>
						</div>

					</div>
				</form>

			</div>



		</div>
	</div>
</body>
</html>