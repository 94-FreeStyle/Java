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

<title>用户登录</title>
<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon">
<link href="/MicroClothesShop/css/userlogin.css" rel="stylesheet"
	type="text/css">
<script src="/MicroClothesShop/js/xmlhttprequest.js"
	type="text/javascript"></script>
<script>
	function callbackpw() {
		document.getElementById("blockk").style.display = "block";
	}
	
	function closeed(){
		window.location.url="/MicroClothesShop/servlet/UserRequestForward?name=Login.jsp";
	}
</script>
<style>
#blockk {
	display: none;
	position: absolute;
	z-index: 8;
	margin-top: 180px;
	margin-left: 500px;
	width: 400px;
	height: 280px;
	border: 1px solid #666;
	border-radius: 7px;
	background-color: #ddd;
}

#blockk table {
	margin-left: 60px;
}

#blockk p {
	font-size: 22px;
	margin-left: 30px;
}

#blockk tr {
	height: 55px;
}
</style>
</head>

<body>
	<div id="tu">
		<div class="til">
			<b><i>微衣网上服装店</i> </b>
		</div>
		<div class="imgs">
			<img src="/MicroClothesShop/images/102.jpg" width="380px"
				height="260px" />
		</div>
	</div>
	<div id="login">
		<div class="login-head">微衣用户登录</div>
		<br /> <br />
		<div class="login-body">
			<form action="/MicroClothesShop/servlet/UserLogin" method="post">
				&nbsp;&nbsp;&nbsp;用户名：<input type="text" name="username"
					class="required"><br /> <br />
				&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：<input type="password"
					name="pw" class="required"><br /> <br /> <input
					type="submit" value="登录" id="tijiao"><br /> <br />
			</form>
			<div class="beizhu">
				<a href="javascript:void(0)" onclick="callbackpw()">忘记密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
					href="/MicroClothesShop/servlet/UserRequestForward?name=Register.jsp">注册新账号</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
					href="/MicroClothesShop/servlet/Advice" target="_blank">意见反馈</a>
			</div>
		</div>
	</div>
	<div id="blockk">
		<p>请输入以下信息</p>
		<hr />
		<form action="/MicroClothesShop/servlet/CallBackPW" method="post">
			<table>
				<tr>
					<td align="right">用&nbsp;&nbsp;戶&nbsp;&nbsp;名：</td>
					<td><input type="text" id="name" name="name" />
					</td>
				</tr>
				<tr>
					<td align="right">注冊邮箱：</td>
					<td><input type="text" id="mail" name="mail" />
					</td>
				</tr>
				<tr>
					<td align="left"><input type="reset" value="重置" />
					</td>
					<td align="left"><input type="submit" value="提交" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="关闭" onclick="closeed()" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
