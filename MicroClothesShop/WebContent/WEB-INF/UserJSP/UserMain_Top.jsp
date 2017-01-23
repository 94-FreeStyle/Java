<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>NoName</title>
<link href="/MicroClothesShop/css/usermaintop.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<div id="all">
		<div id="til">
			<b>微衣网上服装店</b>
		</div>
		<div id="fun">
			<a href="/MicroClothesShop/servlet/MainRightDisplay?pageCode=1"
				target="rightFrame">首页</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="/MicroClothesShop/servlet/ShoppingCart" target="_blank">购物车</a>
			&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="/MicroClothesShop/servlet/MyPage" target="_blank">个人主页</a>
			&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="/MicroClothesShop/servlet/MyOrder" target="_blank">我的订单</a>
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="" target="_parent">帮助</a>
		</div>
		<div id="user">
			<img src="${user.u_image}" height="22px"
				width="22px" />&nbsp;&nbsp;&nbsp;&nbsp;${user.u_name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="" target="_parent">退出</a>
		</div>
	</div>
</body>
</html>
