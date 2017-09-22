<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<script src="js/jquery.fly.min.js"></script>
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
<script type="text/javascript" src="js/easing.js"></script> -->

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});

		/* $("#book_display").on("click",".addCart",function(){
			alert(11);
			addFly(this,event);
		}); */
		$(".addCart").click(function() {
			console.log($("[name=\"userId\"]").val());
			console.log($(this).attr("data"));
			
			$.ajax({
				url : "order/add",
				data : {
					"userId" : $("[name=\"userId\"]").val(),
					"bookId":$(this).attr("data")
				},
				type : "POST",
				async : false,
				dataType : "json",
				success : function(r) {
					console.log(r);
				}});
			addFly(this, event);
		})

	});

	function addFly(obj, event) {
		/*var addcar = $(this);
		var img = addcar.parent().find('img').attr('src');//获取当前点击图片链接
		var flyer = $('<img class="u-flyer" src="'+img+'">');//抛物体对象*/

	    var offset = $('#shoppingCart').offset();
		var img =$(obj).parents('div').find('.img').attr('src');//获取当前点击图片链接
//		alert(img);
		var flyer = $('<img class="u-flyer" src="'+img+'"/>');//抛物体对象
		flyer.fly({
			start : {
				left : event.pageX,//抛物体起点横坐标
				top : event.pageY
			//抛物体起点纵坐标
			},
			end : {
				left : offset.left,//抛物体终点横坐标
				top : offset.top,//抛物体终点纵坐标
				width : 0,
				height : 0,
			}
			/* onEnd: function(){ //结束回调 
//                $("#msg").show().animate({width: '250px'}, 200).fadeOut(1000); //提示信息 
                $(this).css("cursor","default").removeClass('orange').unbind('click'); 
                this.destory(); //移除dom 
            }  */
		});
	}

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
		var categoryArr = document.querySelectorAll(".category");
		var categoryId =document.querySelector("#categoryId");
		for (var i = 0; i < categoryArr.length; i++) {
			categoryArr[i].onclick = function() {
				categoryId.value = this.getAttribute("data");
				form.submit();
				return false;
			}
		}
		var btn = document.querySelector("#btn");
		btn.onclick = function() {
			pageIdx.value = 1;
		}
	}
</script>

</head>

<body>

<%
			if (request.getSession().getAttribute("userId") == null) {
				request.setAttribute("msg", "还没哟登录，不能访问哦!");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
%>
	<span ><img id="shoppingCart" src="img/oiohomepage/shopping_cart.png"></span>

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
					<p>&gtoio首页</p>
				</div>
				<ul>
					<!-- <li class="active" id="logo"><a href="index.html">OIO书店</a></li> -->
					<li id="one-li"><a
						href="user/detail?userId=${sessionScope.userId }"> 我的OIO </a></li>
					<li id="two-li"><a href="order/queryCart?userId=${sessionScope.userId }" id="cart" >购物车</a></li>
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
			<div class="content">
				<form action="book/query1" id="form" method="post">
					<input type="hidden" id="pageIdx" name="pageIdx"
						value="${pageIdx }" />
					<input type="hidden"  name="userId"
						value="${sessionScope.userId }" />
						<input type="hidden"  id="categoryId"  name="categoryId"
						value="${categoryId}" />
					<!-- 搜索框 -->
					<div id="commodity_search">
						<img alt="" src="img/oiohomepage/search.png"
							style="width: 60%; height: 50%; margin-left: 18%; margin-top: 5%;">

						<input type="text" class="form-control" placeholder="请输入需要查找的内容"
							name="name" value="${name}"
							style="margin-top: 3%; box-shadow: 0px 0px 30px #A8A8A8;">
						
						<!-- <button class="btn btn-default btn-lg disabled"
							style="width: 100%;">搜索</button> -->
	<button id="btn" class="btn btn-default" style="width: 100%;">搜索</button>
					</div>

					<!-- 图片横幅 -->
					<div id="yibenhaoshu">
						<img alt="" src="img/oiohomepage/yibenhaoshu.jpg"
							style="height: 200px; width: 720px; box-shadow: 0px 0px 30px #32CD32;"
							class="img-rounded">
					</div>

					<!-- 分类框 -->
					<div id="classification_box">
						<div id="classification_top">书籍分类
						<div><a data="0" class="category">全部书籍</a></div>
						<c:forEach items="${ cList}" var="l">
							<div><a data="${l.category.categoryId}" class="category">${l.category.categoryName}</a></div>
							
							<div>
							<c:forEach items="${l.categoryList}" var="c">
							<a data="${c.categoryId}" class="category">${c.categoryName}</a>
							</c:forEach>
							</div>
						</c:forEach>
						</div>
					</div>

					<!-- 书籍展示 -->
					<div id="book_display">
						<c:forEach items="${ book}" var="b">
							<div id="single_book_display">
								<a href="book/query2?bookId=${b.bookId }"><img
									class="img" src="img/oiohomepage/皮囊师.jpg" style="width: 115px;"></a>
								<div>
									<a id="book_name" href="book/query2?bookId=${b.bookId }" 
										style="font-weight: bolder; font-size: 18px;"> 
									<c:if
											test="${fn:length(b.name)>8 }">
										${fn:substring(b.name,0,8) }...
									</c:if> 
									<c:if test="${fn:length(b.name)<=8 }">
										${b.name}
									</c:if>
									</a>
								</div>
								<p style="color: #FF7F50; font-weight: bolder;"> ${ b.price}</p>
								<a id="Join_the_shopping_cart"  class="addCart" data="${b.bookId}"
									 style="margin-left: 50px;">加入购物车</a>
							</div>
						</c:forEach>

						<!-- 分页 -->
						<div id="book_paging" class="center-block"
							style="margin-bottom: 20px;">

							<div class="center-block"
								style="margin-top: 52px; margin-bottom: 52px;">

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
				</form>
			</div>



		</div>
	</div>
</body>
</html>