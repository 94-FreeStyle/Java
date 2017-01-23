<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>NoName</title>
<link href="/MicroClothesShop/css/atop.css" rel="stylesheet"
	type="text/css">
</head>

<body>
	<div class="title">微衣服装进销存后台管理</div>
	<div class="wel">
		<b><a href="/MicroClothesShop/servlet/QueryAllUser"
			target="rightFrame">用户管理</a> </b> <b><a
			href="/MicroClothesShop/servlet/QueryAllClothes" target="rightFrame">服装管理</a>
		</b> <b><a href="/MicroClothesShop/servlet/QueryAllOrder"
			target="rightFrame">订单管理</a> </b> <b><a
			href="/MicroClothesShop/servlet/TuiRecord" target="rightFrame">退货管理</a>
		</b><b><a href="/MicroClothesShop/servlet/QueryAllSelledRecord"
			target="rightFrame">统计分析</a> </b> <b class="adminn"
			style="font-size:13px;color:#1122ff;letter-spacing: 2px;">管理员：${name}</b>
		<div id="back">
			<a
				href="/MicroClothesShop/servlet/AdminRequestForward?name=AdminLogin.jsp"
				target="_parent">&nbsp;&nbsp;退出</a>
		</div>
	</div>
</body>
</html>