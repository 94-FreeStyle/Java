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

<title>NONAME</title>


<link href="/MicroClothesShop/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="/MicroClothesShop/css/qalluser.css" rel="stylesheet"
	type="text/css" />
<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/xmlhttprequest.js"></script>
<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/cloth.js"></script>

</head>
<body>
	<div id="all">
		<div id="nmess">
			目前商铺共有服装${cnum}件,有${jnum}件需要进货(<a href="/MicroClothesShop/servlet/JinHuo" style="font-size:14px;" target="rightFrame">点击查看需进货服装列表</a>)
		</div>
		<div id="serach">
			<form>
				<input name="con" type="text" id="serachContent" value="  请输入服装编号" />
				<input type="button" id="submit" value="查询" onclick="querycloth()" />
			</form>
		</div>
		<div id="opt">
			<button class="but" onclick="add()">添加</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="edit()">编辑</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="DeleteRow('tableid')">删除</button>
		</div>
		<div id="tableInfo1">
			<table class="tablelist">
				<thead class="tablehead">
					<tr>
						<th></th>
						<th>编号</th>
						<th>名称</th>
						<th>单价</th>
						<th>品牌</th>
						<th>折扣</th>
						<th>库存</th>
						<th>已售</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input name="xcheckbox" type="checkbox" value="" />
						</td>
						<td id="ccid"></td>
						<td id="ccname"></td>
						<td id="ccprice"></td>
						<td id="ccbrand"></td>
						<td id="ccdiscount"></td>
						<td id="ccsurplus"></td>
						<td id="ccselled"></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div id="tableInfo">
			<table id="tableid" class="tablelist">
				<thead class="tablehead">
					<tr>
						<th></th>
						<th>编号</th>
						<th>名称</th>
						<th>单价</th>
						<th>品牌</th>
						<th>折扣</th>
						<th>库存</th>
						<th>已售</th>

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
							<td>${c.c_discount}</td>
							<td>${c.c_surplusnum}</td>
							<td>${c.c_sellednum}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
