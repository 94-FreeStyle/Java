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

<title>NoName</title>
<style>
a {
	text-decoration: none;
}

.mainindex {
	margin-left: 130px;
	margin-top: 100px;
}
</style>
</head>

<body>

	<div class="mainindex">
		<div class="welinfo">
			<span><img src="/MicroClothesShop/images/sun.png" alt="天气" />
			</span> <b>${guan.a_name}&nbsp;&nbsp;&nbsp;${day}，欢迎使用服装进销存系统</b> <a
				href="#">帐号设置</a>
		</div>
		<br /> <br /> <br />
		<div class="welinfo">
			<span><img src="/MicroClothesShop/images/time.png" alt="时间" />
			</span> <i>您上次登录的时间：${guan.a_lt}</i> （不是您登录的？<a href="#">请点这里</a>）
		</div>
	</div>
</body>
</html>
