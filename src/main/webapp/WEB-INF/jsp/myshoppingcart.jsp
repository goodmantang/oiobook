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
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/model.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/oiostyle.css" rel="stylesheet" type="text/css" media="all" />
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
		
		/* 更改书籍选中数量和总价 */
		$(".chioce").click(function(){
			if ($(this).prop("checked")) {
				$("#totalcount").text(Number($("#totalcount").text())+1);
				$("#totalprice").text(Number($("#totalprice").text())+Number($(this).parent().parent().find(".unitPrice").text()));
			}else{
				$("#totaltount").text($("#totalcount").text()-1);
				$("#totalprice").text($("#totalprice").text()-$(this).parent().parent().find(".unitPrice").text());
			}
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
						<a href="index.html"><img src="img/model/dushulogo.png" alt=" "></a>
					</div>
					<div class="left-head">
						<img class="img-responsive" src="img/model/green_brick.png" alt=" ">
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
					<a href="book/query?pageIdx=1">
						<img id="oio_logo" src="img/model/150537980818443.png">
					</a>
				</div>
				<div id="navigation">
					<p>&gt购物车</p>
				</div>
				<ul >
					<!-- <li class="active" id="logo"><a href="index.html">OIO书店</a></li> -->
					<li id="one-li"><a href="connect/myoio"> 我的OIO </a></li>
					<li id="two-li"><a href="order/queryCart?userId=${sessionScope.userId }">购物车</a></li>
					<li id="Three-li"><a href="about.html">退出登录</a></li>
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

				<div class="row" style="width: 500px;margin-left: 614px;">
					<input type="text" class="form-control col-md-1" style="width: 300px;" placeholder="输入查找内容"><span><a class="btn btn-success" style="width:150px;">查找书籍</a></span>	
				</div>

				<div>
					<hr style="margin:30px 65px 20px 65px; height: 3px; border: 1px; background-color: #888888; color: #D5D5D5; width: 1000px;" />
				</div>
				
				<div style="margin-bottom: 40px;">
					<label class="checkbox-inline" style="margin-left: 80px;">
						<input type="checkbox" id="inlineCheckbox1" value="option1"> 全选
					</label>
					<p style="display:inline-block; width: 60px;margin-left: 170px;">商品信息</p>
					<p style="display:inline-block; margin-left: 220px;">数量（本）</p>
					<p style="display:inline-block; margin-left: 200px;">单价（元）</p>
				</div>

				<c:if test="${cart==null || fn:length(cartList) > 0}">
					<div style="margin: 100px  400px;color: #FF6347;">
						<p>购物车空空的，快去添加点书籍吧！~~~</p>
					</div>
				</c:if>
				<c:forEach items="${cart }" var="cl">
					<div id="single_commodity">
						<div style="position: absolute; margin-top: 8px; margin-left: 15px"><input type="checkbox" id="inlineCheckbox1" value="option1" class="chioce" /></div>
						<img alt="" src="img/oiohomepage/皮囊师.jpg" style="height: 120px; margin: 14px 20px 14px 130px;display:inline-block;">
						<div style="display:inline-block; margin-left: 10px; font-weight: bold;font-size: 15px;">
							<c:if test="${fn:length(cl.bookName)>8 }">
								《 <p style="display:inline-block;">${fn:substring(cl.bookName,0,8) }...</p> 》
							</c:if>
							<c:if test="${fn:length(cl.bookName)<=8 }">
								《 <p style="display:inline-block;">${cl.bookName }</p> 》
							</c:if>
						</div>
						<div style=" display:inline-block; font-size: 1.7em; color: red ;float: right; font-weight: 600; margin-top: 57px; margin-right: 135px; width: 150px;">
							￥ <p style="display:inline-block;" class="unitPrice">${cl.totalAmount }</p>
						</div>
						<div style=" display:inline-block; margin-right: 200px;float: right; margin-top: 57px" >
							<input type="number" value="${cl.count }" class="form-control" style="width: 68px;"/>
						</div>
					</div>
				</c:forEach>
				
				<div style="width:100% ; height: 60px;margin-top: 50px; background-color: #C0C0C0;">
					<div style="display:inline-block;font-size: 18px;margin-top: 18px;margin-left: 70px;">已选&nbsp;&nbsp;<p style="display:inline-block; color:#FF8C00; font-weight: bold;" id="totalcount">0</p>&nbsp;&nbsp;件商品</div>
					<a class="btn btn-success btn-lg" style=" display:inline-block;float:right;height:100%;width:200px;font-size: 25px;font-weight: bold;">结&nbsp;&nbsp;&nbsp;算</a>
					<div style="display:inline-block;font-size: 18px;margin-top: 18px;float:right;margin-right: 400px;">合计&nbsp;&nbsp;<p style=" display:inline-block;  color:#FF8C00; font-weight: bold;" id="totalprice">0.00</p>&nbsp;&nbsp;元</div>
				</div>

			</div>
			
			

		</div>
	</div>
</body>
</html>