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
<script src="js/jquery-3.1.0.js"></script>
<script src="js/bootstrap.js"></script>
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
<!-- <script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
 -->
<script type="text/javascript">
	window.onload = function() {

		var aArr = document.querySelectorAll(".page");
		var pageIdx = document.querySelector("#pageIdx");

		var form = document.querySelector("#form");
		for (var i = 0; i < aArr.length; i++) {
			aArr[i].onclick = function() {
				pageIdx.value = this.getAttribute("data");
				form.submit();
				return false;
			}
		}
	}
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
					<p>&gt我的订单</p>
				</div>
				<ul>
					<!-- <li class="active" id="logo"><a href="index.html">OIO书店</a></li> -->
					<li id="one-li"><a
						href="user/detail?userId=${sessionScope.userId }"> 我的OIO </a></li>
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
			<div class="content" style="height: 550px;">


				<div id="left_navigation">
					<div>
						<img alt="" src="img/lvyu.png" style="width: 160px;">
					</div>
					<div>
						<div style="margin-top: 10%;">
							<a class="left_navigation-entry">我的订单</a>
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

	
					<div style="margin-top: 5%;">
						<div id="personal_data_left" style="width: 30%; margin-left: 15%;">
							<p>${msg }</p>
							<div class="personal_data_left_content">
								<c:forEach items="${OrderList }" var="l">
									<div>${l.orderListinfo.createTime }-
										${l.orderListinfo.orderId } - ${l.orderListinfo.status }
										${l.orderListinfo.totalAmount }</div>
									<div>
										<c:forEach items="${l.orderitems }" var="o">
								${o.bookName }- ${o.count }-${o.eachPrice }-${o.status }-${o.returnReason }
								</c:forEach>
									</div>
								</c:forEach>

								<form action="order/queryOrder" id="form" method="post">
									<input type="hidden" id="pageIdx" name="pageIdx"
										value="${pageIdx }" /> <input type="hidden" name="userId"
										value="${sessionScope.userId }" />
								</form>

								<c:choose>
									<c:when test="${pageIdx>1 }">
										<a class="btn btn-default  page" role="button" href=""
											data="${pageIdx-1}">上一页</a>
									</c:when>
									<c:otherwise>
										<span>上一页</span>
									</c:otherwise>
								</c:choose>

								<c:forEach begin="1" end="${totalPage}" varStatus="s">
									<a
										class="btn btn-default <c:if test="${s.count==pageIdx}">active</c:if> page"
										role="button" data="${s.count }">${s.count }</a>
								</c:forEach>

								<c:choose>
									<c:when test="${pageIdx < totalPage}">
										<a href="" data="${pageIdx+1}" class="btn btn-default  page"
											role="button">下一页</a>
									</c:when>
									<c:otherwise>
										<span>下一页</span>
									</c:otherwise>
								</c:choose>
							</div>
						</div>



					</div>


				</div>



			</div>
		</div>
		</div>
</body>
</html>