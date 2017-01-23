<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的主页</title>
<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon" />
<link href="/MicroClothesShop/css/person.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<div id="top">
		<b class="shou"><a
			href="/MicroClothesShop/servlet/UserRequestForward?name=UserMain.html">回到首页</a>
		</b> <b class="tou"><img src="${user.u_image}" width="22px"
			height="22px" />&nbsp;&nbsp;&nbsp;${user.u_name}</b>
	</div>
	<div id="all">
		<div id="left">
			<div id="mess">
				<p>我的信息</p>
			</div>
			<div id="tou">
				<img src="${user.u_image}" width="142px" height="142px">
			</div>
			<div id="name">
				<p>${user.u_name}</p>
				<form action="/MicroClothesShop/servlet/UploadUserTou" method="post"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td style="width:30px;overflow:hidden"><input type="file" id="files" name="imag" />
							</td>
							<td style="margin-left:-30px"><input type="submit"
								value="上传" style="cursor:pointer">
							</td>
						</tr>
					</table>
				</form>
			</div>

			<div id="xinxi">
				<table>
					<tr>
						<td>帐&nbsp;&nbsp;户&nbsp;&nbsp;名：</td>
						<td>${user.u_name}</td>
					</tr>
					<tr>
						<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
						<td>${user.u_sex}</td>
					</tr>
					<tr>
						<td>银行账户：</td>
						<td>${user.u_banknum}</td>
					</tr>
					<tr>
						<td>注册邮箱：</td>
						<td>${user.u_mail}</td>
					</tr>
					<tr>
						<td>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
						<td>${user.u_phone}</td>
					</tr>
					<tr>
						<td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
						<td>${user.u_address}</td>
					</tr>
				</table>
			</div>
			<div id="ou">
				<div id="til">
					<p>购物达人</p>
				</div>
				<div id="persons">
					<c:forEach items="${topu}" var="t">
						<table>
							<tr>
								<td rowspan="2"><img src="${t.u_image}" width="50px"
									height="50px" />
								</td>
								<td align="center" valign="middle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${t.u_name}</td>
							</tr>
							<tr>
								<td align="center" valign="middle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${t.u_sex}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;22</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>

	</div>
	<div id="right">
		<div id="wmess">
			<p>我的微衣记录</p>

			<div id="sr">
				<div class="ts">
					<b>消费记录</b>
				</div>
				<div id="scon"></div>
			</div>
			<div id="tui">
				<div class="ts">
					<b>统计推荐</b>
				</div>
				<div id="tcon"></div>
			</div>

		</div>
	</div>
</body>
</html>
