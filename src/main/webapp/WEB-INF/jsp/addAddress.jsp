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
					<li id="one-li"><a href="user/detail?userId=${sessionScope.userId }"> 我的OIO </a></li>
					<li id="two-li"><a href="404.html">购物车</a></li>
					<li id="Three-li"><a href="user/logout">退出登录</a></li>
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
					<img id="zhuceimg" src="img/register_retrieve/zhuce.png">
				</div>

				<form action="user/addAddress" method="post" enctype="multipart/form-data">
					<div id="register_box" class="col-md-12">

						<div>
							<p id="login_p">${msg}</p>
						</div>

						<input type="hidden" value="${sessionScope.userId }" name="userId">

						<div class="form-group">
							<label for="inputEmail3" class="col-md-3 control-label"
								style="margin-top: 30px; margin-left: 20px;">收货人 ：</label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="inputEmail3"
									placeholder="请输入收货人" name="consigneeName"
									style="margin-top: 25px; margin-left: -12px;">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-md-3 control-label"
								style="margin-top: 10px; margin-left: 20px;">电&nbsp&nbsp&nbsp话
								：</label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="inputPassword3"
									placeholder="请输入电话号码" name="mobile"
									style="margin-top: 5px; margin-left: -12px;">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-md-3 control-label"
								style="margin-top: 10px; margin-left: 20px;">邮&nbsp&nbsp&nbsp编
								：</label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="inputPassword3"
									placeholder="请输入邮编" name="zipNo"
									style="margin-top: 5px; margin-left: -12px;">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-md-3 control-label"
								style="margin-top: 10px; margin-left: 20px;">详细地址 </label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="inputPassword3"
									placeholder="请输入地址" name="address"
									style="margin-top: 10px; margin-left: -12px;">
							</div>
						</div>
						
						

						<div>
							<button class="col-md-9 btn btn-default"
								style="margin-top: 15px; margin-left: 50px; font-weight: bold;">添&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp加</button>
						</div>

					</div>
				</form>

			</div>



		</div>
	</div>
</body>
</html>