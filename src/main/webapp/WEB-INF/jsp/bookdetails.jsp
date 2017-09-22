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

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});

		$(".cart-to").click(function() {
			$.ajax({
				url : "order/add",
				data : {
					"userId" : $("[name=\"userId\"]").val(),
					"bookId" : $("[name=\"bookId\"]").val()
				},
				type : "POST",
				async : false,
				dataType : "json",
				success : function(r) {
					console.log(r);
					alert("添加成功");
				}
			});
		});

		$("[name=\"count\"]").blur(function() {
			var count = $("[name=\"count\"]").val();
			var eachprice = $("#eachPrice").text();
			$("#total").text(count * eachprice);
			$("[name=\"totalPrice\"]").val(count * eachprice);
		});

		$("#btn").click(function() {
			$.ajax({
				url : "order/pay",
				data : {
					"userId" : $("[name=\"userId\"]").val(),
					"bookId" : $("[name=\"bookId\"]").val(),
					"addressId" : $("[name=\"addressId\"]").val(),
					"count" : $("[name=\"count\"]").val(),
					"payment" : $("[name=\"payment\"]").val(),
					"totalAmount" : $("[name=\"totalPrice\"]").val()
				},
				type : "POST",
				async : false,
				dataType : "json",
				success : function(r) {
					if(r.success){
					$("#msg").text("付款成功，恭喜你又剁手一次").css("color", "green").show().delay(3000).fadeOut();
					
					}else{
					$("#msg").text(r.msg).css("color", "red").show().delay(3000).fadeOut();
					}
				}
			});

		});

	});
</script>


<link rel="stylesheet" href="css/etalage.css">
<script src="js/jquery.etalage.min.js"></script>
<script>
	jQuery(document)
			.ready(
					function($) {

						$('#etalage')
								.etalage(
										{
											thumb_image_width : 300,
											thumb_image_height : 400,
											source_image_width : 900,
											source_image_height : 1200,
											show_hint : true,
											click_callback : function(
													image_anchor, instance_id) {
												alert('Callback example:\nYou clicked on an image with the anchor: "'
														+ image_anchor
														+ '"\n(in Etalage instance: "'
														+ instance_id + '")');
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
					<p>&gt商品详情页面</p>
				</div>
				<ul>
					<!-- <li class="active" id="logo"><a href="index.html">OIO书店</a></li> -->
					<li id="one-li"><a
						href="user/detail?userId=${sessionScope.userId }"> 我的OIO </a></li>
					<li id="two-li"><a
						href="order/queryCart?userId=${sessionScope.userId }">购物车</a></li>
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
				<input type="hidden" name="userId" value="${sessionScope.userId }" />
				<input type="hidden" name="bookId" value="${book.bookId }" />
				<div class="single">
					<div class="col-md-9 top-in-single">
						<div class="col-md-5 single-top">
							<ul id="etalage" style="margin-left: 50px;">
								<li><a href="optionallink.html"> <img
										class="etalage_thumb_image img-responsive"
										src="img/oiohomepage/皮囊师.jpg" alt=""> <img
										class="etalage_source_image img-responsive"
										src="img/oiohomepage/皮囊师.jpg" alt="">
								</a></li>
							</ul>

						</div>
						<div class="col-md-7 single-top-in">
							<div class="single-para" id="single-paraa">
								<h4 style="width: 350px; height: 100px:">${book.name}</h4>
								<h4>作者：${book.author }</h4>
								<div class="para-grid">
									<span class="add-to">$ ${book.price }</span> <a class="cart-to">Add
										to Cart</a>
									<div class="clearfix"></div>
								</div>
								<h5>库存 : ${book.count} 本</h5>
								<!-- 								 <button  class="cart btn" data-toggle="modal" data-target=".bs-example-modal-sm">立即购买</button> 
 -->
								<!--  <button class="btn btn-primary cart" data-toggle="modal" data-target=".bs-example-modal-sm">立即购买</button> -->
								<button type="button" class="btn btn-primary cart"
									data-toggle="modal" data-target=".bs-example-modal-sm">立即购买</button>
								<div id="msg"
									style="display: none; font-size: 40px; width: 400px; height: 150px; position: absolute; buttom: 0px; left: 0px; z-index: 5000; opacity: 0.8;"></div>
							</div>
						</div>
						<div class="clearfix"></div>
						<!----- tabs-box ---->
						<div class="sap_tabs">
							<div id="horizontalTab"
								style="display: block; width: 100%; margin: 0px;">
								<ul class="resp-tabs-list">
									<li class="resp-tab-item " aria-controls="tab_item-0"
										role="tab"><span>书籍详情</span></li>
									<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>评论</span></li>
									<div class="clearfix"></div>
								</ul>
								<div class="resp-tabs-container">
									<h2 class="resp-accordion resp-tab-active" role="tab"
										aria-controls="tab_item-0">
										<span class="resp-arrow"></span>Product Description
									</h2>
									<div class="tab-1 resp-tab-content resp-tab-content-active"
										aria-labelledby="tab_item-0" style="display: block">
										<div class="facts">
											<p>书名：${book.name }</p>
											<p>作者：${book.author }</p>
											<p>单价：￥${book.price }</p>
											<ul>
												<li>${book.bookDescribe }</li>
											</ul>
										</div>
									</div>
									<h2 class="resp-accordion" role="tab"
										aria-controls="tab_item-1">
										<span class="resp-arrow"></span>Additional Information
									</h2>
									<div class="tab-1 resp-tab-content"
										aria-labelledby="tab_item-1">
										<div class="facts">
											<p>评论区</p>
											<ul id="book_comment">
												<c:forEach items="${comment }" var="bc" varStatus="s">
													<li style="border-bottom: 1px solid #808080;">第${s.count }楼说：${bc.bookComment }</li>
												</c:forEach>
											</ul>
										</div>
									</div>
									<h2 class="resp-accordion" role="tab"
										aria-controls="tab_item-2">
										<span class="resp-arrow"></span>Reviews
									</h2>

								</div>
							</div>
							<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
							<script type="text/javascript">
								$(document).ready(function() {
									$('#horizontalTab').easyResponsiveTabs({
										type : 'default', //Types: default, vertical, accordion           
										width : 'auto', //auto or any width like 600px
										fit : true
									// 100% fit in a container
									});
								});
							</script>

						</div>

					</div>

					<div class="clearfix"></div>


				</div>


			</div>

		</div>
	</div>
	<!--付款模态框  -->
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">购买</h4>
				</div>
				<p>书名：${book.name }</p>
				<span>单价：￥ <a id="eachPrice">${book.price}</a></span>
				<div class="input-group">
					<div class="input-group-addon">数&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp量</div>
					<input type="number" class="form-control" id="exampleInputAmount"
						placeholder="count" name="count" max="${book.count}" value="1">
				</div>
				<div class="input-group">
					<div class="input-group-addon">付款方式</div>
					<select name="payment" class="form-control">
						<option value="0">余额</option>
						<c:forEach items="${bankcard }" var="b">
							<option value="${b.id }">${b.bankCardName}:
								<c:choose>
									<c:when test="${fn:length(b.bankCardId)>8 }">${fn:substring(b.bankCardId,0,4)}...${fn:substring(b.bankCardId,fn:length(b.bankCardId)-4,fn:length(b.bankCardId))}</c:when>
									<c:otherwise>${b.bankCardId}</c:otherwise>
								</c:choose></option>
						</c:forEach>
					</select>
				</div>
				<div class="input-group">
					<div class="input-group-addon">地&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp址</div>
					<select name="addressId" class="form-control">
						<c:forEach items="${address }" var="a">
							<option value="${a.addressId }">${a.consigneeName}-${a.mobile}-${a.address}</option>
						</c:forEach>
					</select>
				</div>

				<div class="input-group">
					<div class="input-group-addon">
						总价 <a id="total">${book.price}</a>
					</div>
					<input type="hidden" name="totalPrice" value="${book.price}">
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="btn" class="btn btn-primary" data-dismiss="modal">确认购买</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>