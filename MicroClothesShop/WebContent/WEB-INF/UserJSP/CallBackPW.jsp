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

<title>找回密码</title>
<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon">
<style>
.imgs {
	position: absolute;
	margin-left: 170px;
	margin-top: 160px;
	height: 410px;
	width: 400px;
}

#aa {
	position: absolute;
	margin-left: 850px;
	margin-top: 200px;
	height: 210px;
	width: 300px;
	border: 1px solid #aaa;
}

.imgs p {
	position: absolute;
	font-size: 28px;
	margin-top: -90px;
}

.imgs img {
	position: absolute;
	margin-left: 90px;
}

.tip {
	font-size: 22px;
}

form {
	position: absolute;
	font-size: 18px;
	margin-left: 32px;
}
</style>
</head>

<body bgcolor="#eee">
	<div class="imgs">
		<p>
			<b>微衣网店密码找回</b>
		</p>
		<img src="/MicroClothesShop/images/100.jpg" width="400px"
			height="300px" border="1px solid #aaa" />
	</div>
	<div id="aa">
		<div class="tip">请输入新的信息</div>
		<hr />
		<br />
		<form action="/MicroClothesShop/servlet/CallBackPWed" method="post">
			新&nbsp;&nbsp;密&nbsp;&nbsp;码：<input type="password" name="pw" /><br />
			<br /> 确认密码：<input type="password" name="repw" /><br /> <br />
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="reset" value="重置" />
		</form>
	</div>
</body>
</html>
