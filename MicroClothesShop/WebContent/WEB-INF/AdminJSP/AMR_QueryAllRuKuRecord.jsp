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

#tableInfo {
	height: 320px;
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

		<div id="tableInfo">
			<table class="tablelist">
				<thead class="tablehead">
					<tr>
						<th>入库ID</th>
						<th>入库日期</th>
						<th>操作员</th>
						<th>商品名称</th>
						<th>入库量</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${ruku}" var="r">
						<tr>
							<td>${r.r_id}</td>
							<td>${r.r_date}</td>
							<td>${r.a_id}</td>
							<td>${r.c_id}</td>
							<td>${r.r_num}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
