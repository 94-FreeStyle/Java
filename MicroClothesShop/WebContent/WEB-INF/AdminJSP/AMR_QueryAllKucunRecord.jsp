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
}

.but {
	width: 80px;
}
</style>
</head>

<body>
	<div id="all">
		<div id="serach">
			<form>
				<input name="con" type="text" id="serachContent" value="  请输入服装编号" />
				<input type="button" id="submit" value="查询" onclick="querykucun()" />
			</form>
		</div>
		<div id="opt">
			<button class="but" onclick="ruku()">入库记录</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="record()">销售记录</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="kucun()">服装库存</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="fenxi()">记录分析</button>
		</div>
		<div id="tableInfo1">
			<table class="tablelist">
				<thead class="tablehead">
					<tr>
						<th></th>
						<th>服装编号</th>
						<th>名称</th>
						<th>单价</th>
						<th>品牌</th>
						<th>折扣</th>
						<th>库存量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="radio" value="" id="radioss"></td>
						<td id="ccid"></td>
						<td id="ccname"></td>
						<td id="ccprice"></td>
						<td id="ccbrand"></td>
						<td id="ccdiscount"></td>
						<td id="ccsurplus"></td>
						<td><div onclick="updatekucun1()" style="cursor:pointer">添加库存</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div id="tableInfo">
			<table class="tablelist">
				<thead class="tablehead">
					<tr>
						<th>服装编号</th>
						<th>名称</th>
						<th>单价</th>
						<th>品牌</th>
						<th>折扣</th>
						<th>库存量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${clothes}" var="c">
						<tr>
							<td>${c.c_id}</td>
							<td>${c.c_name}</td>
							<td>${c.c_price}</td>
							<td>${c.c_brand}</td>
							<td>${c.c_discount}</td>
							<td>${c.c_surplusnum}</td>
							<td><div onclick="updatekucun('${c.c_id}')"
									style="cursor:pointer">添加库存</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
