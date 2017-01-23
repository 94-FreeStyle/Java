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

<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/xmlhttprequest.js"></script>
<script type="text/javascript">
	function updatekucun1(cid) {
		createXMLHttpRequest();
		var num = prompt("请输入添加的数量", "");
		xmlHttp.onreadystatechange = updatekucuncall;
		xmlHttp.open("post", "/MicroClothesShop/servlet/UpdateKuCun");
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttp.send("cid=" + cid + "&num=" + num);

	}

	function updatekucuncall() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				alert("添加成功！");
			}
		}
	}
</script>
<style type="text/css">
#all {
	width: 900px;
	margin: auto;
}

#titles {
	margin-top: 50px;
	margin-left: 50px;
	font-size: 18px;
	color: #1122ff;
}

#tableInfo {
	margin-left: 50px;
	margin-top: 30px;
	height: 800px;
	overflow: auto;
	height: 800px;
}
</style>
</head>

<body>
	<div id="all">
		<div id="titles">用户待进货服装</div>
		<div id="tableInfo">
			<table id="tableid" class="tablelist">
				<thead class="tablehead">
					<tr>
						<th></th>
						<th>编号</th>
						<th>名称</th>
						<th>单价</th>
						<th>品牌</th>
						<th>库存</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clothes}" var="c">
						<tr>
							<td><input name="checkbox" type="radio" value="${c.c_id}" />
							</td>
							<td>${c.c_id}</td>
							<td>${c.c_name}</td>
							<td>${c.c_price}</td>
							<td>${c.c_brand}</td>
							<td>${c.c_surplusnum}</td>
							<td><div onclick="updatekucun1('${c.c_id}')"
									style="cursor:pointer">添加库存</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
