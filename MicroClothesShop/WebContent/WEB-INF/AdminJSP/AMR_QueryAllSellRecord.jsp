<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link href="/MicroClothesShop/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="/MicroClothesShop/css/qalluser.css" rel="stylesheet"
	type="text/css" />
<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/xmlhttprequest.js"></script>
<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/qallrecord.js"></script>
<style type="text/css">
#opt {
	margin-left: 700px;
	margin-top: 30px;
}

.but {
	width: 80px;
}

#mmss {
	margin-left: 100px;
	font-size: 16px;
	color: #2211FF;
	font-size: 16px;
}
</style>
</head>

<body>
	<div id="all">
		<div id="opt">
			<button class="but" onclick="ruku()">入库记录</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="record()">销售记录</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="kucun()">服装库存</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="fenxi()">记录分析</button>
		</div>
		<div id="mmss">店铺销售总额：￥${money}</div>
		<div id="tableInfo" style="height:300px">

			<table class="tablelist">
				<thead class="tablehead">
					<tr>
						<th>服装名称</th>
						<th>单价</th>
						<th>品牌</th>
						<th>折扣</th>
						<th>销量</th>
						<th>销售额</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${records}" var="r">
						<tr>
							<td>${r.name}</td>
							<td>${r.price}</td>
							<td>${r.brand}</td>
							<td>${r.discount}</td>
							<td>${r.num}</td>
							<td>${r.money}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
