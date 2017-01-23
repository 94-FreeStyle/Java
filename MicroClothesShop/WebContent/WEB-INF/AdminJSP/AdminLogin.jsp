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

<title>管理员登录</title>

<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon" />
<link href="/MicroClothesShop/css/adminlogin.css" rel="stylesheet"
	type="text/css" />
<script src="/MicroClothesShop/js/adminlogin.js" type="text/javascript"></script>
<script src="/MicroClothesShop/js/xmlhttprequest.js"
	type="text/javascript"></script>
<script>
	function callbackpw() {
		var mail = prompt("请输入您的注册邮箱", "");
		createXMLHttpRequest();	
		xmlHttp.open("post", "/MicroClothesShop/servlet/CallBackPW");
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttp.onreadystatechange = callback;
		xmlHttp.send("mail=" + mail);
	}

	function callback() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				var fan=xmlHttp.responseText;
				if (fan=="ok") {
					alert("已成功发送邮件！");
				} else {
					alert("密码找回失败！");
				}
			}

		}
	}
</script>
</head>

<body>
	<div id="login">
		<div id="photo">
			<img src="/MicroClothesShop/images/admin.jpg" height="100px" width="100px"/>
		</div><br/>
		<div id="con"><br/><br/><br/>
			<form action="/MicroClothesShop/servlet/AdminLogin" method="post">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：<input type="text" name="username" /><br /> <br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：<input type="password" name="pw" /><br /> <br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" id="submit" value="登录" style="cursor:pointer"/>
			</form>
			<p><a href="javascript:void(0)" onclick="callbackpw()">忘记密码</a>&nbsp;|&nbsp;<a href="">帮助</a></p>
		</div>
	</div>
	<br>
</body>
</html>
