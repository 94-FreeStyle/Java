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
	src="/MicroClothesShop/js/user.js"></script>


</head>

<body>
	<div id="all">
		<div id="nmess">
			商铺当前注册用户共有${unum}个,当前在线${dnum}个
		</div>
		<div id="serach">
			<form>
				<input name="con" type="text" id="serachContent" value="  请输入用户名" />
				<input type="button" id="submit" value="查询" onclick="queryuser()" />
			</form>
		</div>
		<div id="opt">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="DeleteRow('tableid')">删除</button>
		</div>
		<div id="tableInfo1">
			<table class="tablelist">
				<thead class="tablehead">
					<tr>
						<th></th>
						<th>用户名</th>
						<th>邮箱</th>
						<th>电话</th>
						<th>地址</th>
						<th>银行账户</th>
						<th>密码</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input name="xcheckbox" type="radio" value="" /></td>
						<td id="uuname"></td>
						<td id="uumail"></td>
						<td id="uuphone"></td>
						<td id="uuadd"></td>
						<td id="uubank"></td>
						<td id="uupw"></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div id="tableInfo">
			<table id="tableid" class="tablelist">
				<thead class="tablehead">

					<tr>
						<th></th>
						<th>用户名</th>
						<th>邮箱</th>
						<th>电话</th>
						<th>地址</th>
						<th>银行账户</th>
						<th>密码</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${useres}" var="u">
						<tr>
							<td><input name="checkbox" type="radio" value="${u.u_id}" />
							</td>
							<td>${u.u_name}</td>
							<td>${u.u_mail}</td>
							<td>${u.u_phone}</td>
							<td>${u.u_address}</td>
							<td>${u.u_banknum}</td>
							<td>${u.u_pw}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
