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
<link href="/MicroClothesShop/css/qallorder.css" rel="stylesheet"
	type="text/css" />
<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/xmlhttprequest.js"></script>
<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/order.js"></script>
<style type="text/css">
#all {
	margin-top: 30px;
}

#opt {
	margin-top: 20px;
	margin-bottom: 20px;
}
</style>
</head>

<body>
	<div id="all">
		<div id="opt">
			<button class="but" onclick="tuihuo()">退货</button>
		</div>
		<div id="tableInfo">
			<table id="tableid" class="tablelist">
				<thead class="tablehead">
					<tr>
						<th></th>
						<th>订单号</th>
						<th>提交退货日期</th>
						<th>总价值</th>
						<th>提交用户</th>
						<th>操作员</th>
						<th>处理日期</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tui}" var="t">
						<tr>
							<td><input name="checkbox" type="radio" value="${t.o_id}" />
							</td>
							<td>${t.o_id}</td>
							<td>${t.t_date}</td>
							<td>${t.o_money}</td>
							<td>${t.u_id}</td>
							<td>${t.a_id}</td>
							<td>${t.t_odate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
