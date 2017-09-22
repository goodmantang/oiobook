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
	jQuery(document)
			.ready(
					function($) {
						$(".scroll").click(function(event) {
							event.preventDefault();
							$('html,body').animate({
								scrollTop : $(this.hash).offset().top
							}, 1000);
						});

						$("#balance")
								.click(
										function() {
											query();
										});
							$("#show").on("click",".pageNav",function(){
								//alert($(this).data("pageIdx"));
								$("[name=pageIdx]").val($(this).data("pageIdx"));
								query();
							});
});
	function query(){
		$
		.ajax({
			url : "user/queryBalance",
			data : {
				"userId" : $("[name=\"userId\"]").val(),
				"pageIdx":$("[name=pageIdx]").val()
			},
			type : "POST",
			async : false,
			dataType : "json",
			success : function(r) {
				console.log(r);
				if (r.success) {
					$("#show")
							.empty();
					var table = $("<table class='table'>");
					table
							.append($("<tr><th>操作时间</th><th>操作</th><th>金额</th><th>订单id</th></tr>"))
					$("#show")
							.append(
									table);
					var balanceList = r.balanceRecord;
					for (var i = 0; i < balanceList.length; i++) {
						var b = balanceList[i];
						table
								.append(
										$("<tr>"))
								.append(
										$(
												"<td>")
												.text(
														new Date(b.operateTime).toLocaleString()))
														console.log(typeof(b.operateTime));
						if (b.operation == 0) {
							table
									.append($(
											"<td>")
											.text(
													"充值"))
						} else {
							table
									.append($(
											"<td>")
											.text(
													"消费"))
						}
						table
								.append(
										$(
												"<td>")
												.text(
														b.amount))
								.append(
										$(
												"<td>")
												.text(
														b.orderId))
					}
					$("#show")
							.append(
									$("</table>"));
					//构造分页导航条
					var page = $("<div>").attr("id","page");
					//构造上一页
					var pageIdx = $("[name=pageIdx]").val();
					if(pageIdx>1){
						page.append($("<a></a>",{"href":"javascript:;"}).addClass("pageNav skip").text("上一页").data("pageIdx",pageIdx-1));
					}else{
						page.append($("<span></span>").text("上一页"))
					}
					//构造页码导航
					for(var i=1;i<=r.totalPage;i++){
						page.append($("<a></a>",{"href":"javascript:;"}).addClass("pageNav").text(i).data("pageIdx",i));
					}
					//构造下一页
					if(pageIdx<r.totalPage){
						page.append($("<a></a>",{"href":"javascript:;"}).addClass("pageNav skip").text("下一页").data("pageIdx",Number(pageIdx)+1));
					}else{
						page.append($("<span></span>").text("下一页"))
					}
					$("#show").append(page);
					} else {
						$("#show").test("没有数据");
				}

			}

		});
	}
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
					<p>&gt我的账户</p>
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

					<img src="${userImg} " class="img-circle" id="round_head"
						style="margin-top: 2%; margin-left: 2%;">
					<p
						style="margin-top: -5%; margin-left: 30%; font-weight: bolder; font-size: 35px">${user.userName }
					</p>
					<HR
						style="FILTER: alpha(opacity = 100, finishopacity = 0, style = 3)"
						width="80%" color=#C0C0C0 SIZE=3>

					<hr
						style="margin: 0px; height: 3px; border: 1px; background-color: #C0C0C0; color: #D5D5D5;" />

					<div style="margin-top: 5%;">
						<div id="personal_data_left" style="width: 30%; margin-left: 15%;">
							<p>${msg }</p>
							<div class="personal_data_left_content">
								<p>账户余额 ： ${user.balance }</p>
							</div>
						</div>
						<div id="personal_data_left" style="width: 30%; margin-left: 15%;">
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target=".bs-example-modal-sm">充值</button>
						</div>

						<div id="personal_data_left" style="width: 30%; margin-left: 15%;">
							<button type="button" id="balance" class="btn btn-primary"
								data-toggle="modal" data-target=".bs-example-modal-lg">收支记录</button>
						</div>



					</div>


				</div>



			</div>
		</div>

		<!--充值的模态框  -->
		<div class="modal fade bs-example-modal-sm" tabindex="-1"
			role="dialog" aria-labelledby="mySmallModalLabel">
			<div class="modal-dialog modal-sm" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">充值</h4>
					</div>
					<form action="user/recharge" method="post">
						<input type="hidden" value="${sessionScope.userId }" name="userId">
						<div class="modal-body">
							<p>选择银行卡</p>
							<select class="form-control" name="bankcard">
								<c:forEach items="${ bankcardList}" var="b">
									<option value="${b.id}">${b.bankCardName}:
										${b.bankCardId}</option>
								</c:forEach>
							</select>
							<p>请输入充值金额</p>
							<div class="input-group">
								<div class="input-group-addon">$</div>
								<input type="number" class="form-control"
									id="exampleInputAmount" placeholder="Amount" step="0.01"
									name="amount">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button class="btn btn-primary">充值</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 收支记录模态框 -->
		<div class="modal fade bs-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">收支记录</h4>
					</div>
						<input type="hidden" id="pageIdx" name="pageIdx" value="1" />
					<div class="modal-body" id="show">
					
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
</body>
</html>