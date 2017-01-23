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
</head>

<body>
	<div id="all">
		<div id="nmess">目前共有订单${onum}个,待发货订单共有${fnum}个</div>
		<div id="serach">
			<form>
				<input name="con" type="text" id="serachContent" value="  请输入订单编号" />
				<input type="button" id="submit" value="查询" onclick="queryorder()" />
			</form>
		</div>
		<div id="opt">
			<button class="but" onclick="xiang()">详情</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="fahuo()">发货</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="DeleteRow('tableid')">删除</button>
		</div>
		<div id="tableInfo1">
			<table class="tablelist">
				<thead class="tablehead">
					<tr>
						<th></th>
						<th>订单号</th>
						<th>提交日期</th>
						<th>总价值</th>
						<th>提交用户</th>
						<th>操作员</th>
						<th>状态</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input name="xcheckbox" type="checkbox" value="" /></td>
						<td id="ooid"></td>
						<td id="oodate"></td>
						<td id="oomoney"></td>
						<td id="oouser"></td>
						<td id="ooopt"></td>
						<td id="oostatu"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="tiaojians">
			<p style="font-size:18px">按状态查询</p>
			<br />

			<table>
				<tr>
					<td><input type="radio" name="statu" value="0">未付款</td>
					<td><input type="radio" name="statu" value="1">未发货</td>
					<td><input type="radio" name="statu" value="2">已发货</td>
					<td><input type="radio" name="statu" value="3">已查收</td>
					<td><input type="button" value="查询"
						style="width:50px;height:30px;font-size:14px;cursor:pointer"
						onclick="qureybystatu()" />
					</td>
				</tr>
			</table>

		</div>
		<div id="tableInfo">
			<table id="tableid" class="tablelist">
				<thead class="tablehead">
					<tr>
						<th></th>
						<th>订单号</th>
						<th>提交日期</th>
						<th>总价值</th>
						<th>提交用户</th>
						<th>操作员</th>
						<th>状态</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderes}" var="o">
						<tr>
							<td><input name="checkbox" type="radio" value="${o.o_id}" />
							</td>
							<td>${o.o_id}</td>
							<td>${o.o_tdate}</td>
							<td>${o.o_money}</td>
							<td>${o.u_id}</td>
							<td>${o.a_id}</td>
							<td>${o.o_statu}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
