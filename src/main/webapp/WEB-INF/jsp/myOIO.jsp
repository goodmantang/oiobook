<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%
			if (request.getSession().getAttribute("userId") == null) {
				request.setAttribute("msg", "还没哟登录，不能访问哦!");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
%>
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
					<a href="book/query?pageIdx=1"> <img id="oio_logo" alt=""
						src="img/model/150537980818443.png">
					</a>
				</div>
				<div id="navigation">
					<p>&gt我的OIO</p>
				</div>
				<ul>
					<!-- <li class="active" id="logo"><a href="index.html">OIO书店</a></li> -->
					<li id="one-li"><a
						href="user/detail?userId=${sessionScope.userId }"> 我的OIO </a></li>
					<li id="two-li"><a href="order/queryCart?userId=${sessionScope.userId }">购物车</a></li>
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
			<div class="content" style="height: 550px;">


				<div id="left_navigation">
					<div>
						<img alt="" src="img/lvyu.png" style="width: 160px;">
					</div>
					<div>
						<div style="margin-top: 10%;">
							<a href="order/queryOrder?userId=${sessionScope.userId }" class="left_navigation-entry">我的订单</a>
						</div>
						<div style="margin-top: 10%;">
							<a href="user/myAccount?userId=${sessionScope.userId }"
								class="left_navigation-entry">我的账户</a>
						</div>
						<div style="margin-top: 10%;">
							<a class="left_navigation-entry">购物车</a>
						</div>
					</div>
				</div>

				<div id="right_navigation" class="row">

					<img src="${userImg} " class="img-circle" id="round_head"
						style="margin-top: 2%; margin-left: 2%;">
					<p
						style="margin-top: -5%; margin-left: 30%; font-weight: bolder; font-size: 35px">${user.userName }
					</p>
					<a href="service/modifyuser" style="color: red; margin-left: 83%;">编辑个人资料&gt&gt</a>
					<HR
						style="FILTER: alpha(opacity = 100, finishopacity = 0, style = 3)"
						width="80%" color=#C0C0C0 SIZE=3>

					<hr style="margin: 0px; height: 3px; border: 1px; background-color: #C0C0C0; color: #D5D5D5;" />

					<div style="margin-top: 5%;">

						<div id="personal_data_left" style="width: 30%; margin-left: 15%;">
							<div class="personal_data_left_content">
								<p>
									性 别 ：
									<c:choose>
										<c:when test="${user.sex==1 }">男</c:when>
										<c:when test="${user.sex==2 }">女</c:when>
									</c:choose>
								</p>
							</div>
							<div class="personal_data_left_content">
								<p>电 话 ： ${user.mobile }</p>
							</div>
							<div class="personal_data_left_content">
								<p>邮 箱 ： ${user.email }</p>
							</div>
						</div>
						<div id="personal_data_right" style="width: 30%;">
							<a href="user/addAddress" class="account_operation">新增</a>
							<p class="personal_data_right_content">收货地址 ：</p>
							<div class="scroll_bar">
								<c:forEach items="${address }" var="a" varStatus="s">
									<p>${s.count}:${a.consigneeName}-${a.mobile}-${a.zipNo}-${a.address}</p>
								</c:forEach>
							</div>
							<a href="user/addBankcard" class="account_operation">新增</a>
							<p class="personal_data_right_content">银行卡 ：</p>
							<div class="scroll_bar">
								<c:forEach items="${bankcard }" var="b" varStatus="s">
									<p>${s.count}:${b.bankCardName}${b.bankCardId}</p>
								</c:forEach>
							</div>

						</div>

					</div>


				</div>



			</div>
		</div>
</body>
</html>