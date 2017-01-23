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

<title>购物车</title>

<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon">

<link href="/MicroClothesShop/css/cart.css" rel="stylesheet"
	type="text/css">
<script src="/MicroClothesShop/js/cart.js" type="text/javascript"></script>
<script src="/MicroClothesShop/js/xmlhttprequest.js"
	type="text/javascript"></script>
<script>
	function deleted(id) {
		var b = window.confirm("您确认删除吗？");
		if (b) {
			window.location.href = "/MicroClothesShop/servlet/DeleteCart?cid="
					+ id;
		}
	}

	function payed() {
		var mon;
		if (navigator.appName.indexOf("Explorer") > -1) {
			mon = document.getElementById("mmoneyy").innerText;
		} else {
			mon = document.getElementById("mmoneyy").textContent;
		}
		var pars = "";
		var flag = 0;
		var opts = document.getElementsByName("checkbox");
		var num = opts.length;
		for (i = 0; i < opts.length; i++) {
			if (opts[i].checked == true) {
				pars = pars + "&s" + i + "=" + opts[i].value + "&n" + i + "="
						+ document.getElementById(opts[i].value + "l").value;
				flag++;
			} else {
				pars = pars + "&s" + i + "=xxxx";
			}
		}
		if (flag == 0) {
			alert("请选择至少一件商品！");
		} else {
			window.open("/MicroClothesShop/servlet/BuyInCart?num=" + num
					+ "&mon=" + mon + pars);
		}
	}

	function allxuan() {
		document.getElementsByName("checkbox").checked = "checked";
	}

	function changem() {
		createXMLHttpRequest();
		var pars = "";
		var opts = document.getElementsByName("checkbox");
		var flag = 0;
		var len = opts.length;
		for (i = 0; i < opts.length; i++) {
			if (opts[i].checked) {
				pars = pars + "&s" + i + "=" + opts[i].value;
				++flag;
			} else {
				pars = pars + "&s" + i + "=xxxx";
			}

		}

		if (flag == 0) {
			document.getElementById("mmoneyy").innerHTML = "0.0";
		} else {
			xmlHttp.onreadystatechange = callback;

			xmlHttp.open("post", "/MicroClothesShop/servlet/CartChanged?num="
					+ len + pars);
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			xmlHttp.send(null);
		}
	}

	function callback() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				document.getElementById("mmoneyy").innerHTML = xmlHttp.responseText;
			}
		}
	}
</script>
</head>

<body>
	<div id="top">
		<b class="shou"><a
			href="/MicroClothesShop/servlet/UserRequestForward?name=UserMain.html">回到首页</a>
		</b> <b class="tou"><img src="${user.u_image}" width="22px"
			height="22px" />&nbsp;&nbsp;&nbsp;${user.u_name}</b>
	</div>
	<div id="bodyer">
		<div id="tile">
			<b>微衣网</b>&nbsp;&nbsp;&nbsp;购物车
		</div>
		<div id="con">

			<div class="biaoti">
				<input type="checkbox" id="all" onclick="allxuan()" />全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品描述&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作
			</div>
			<div id="cao">
				<table class="tt" id="tab">
					<c:forEach items="${carts}" var="c">
						<tr class="ttr" id="${c.c_id }">
							<td><input id="checkbox" type="checkbox" name="checkbox"
								value="${c.c_id}" checked="checked" onclick="changem()" /></td>
							<td class="t1" align="center" valign="middle"><img
								src="${c.c_image }" width="120px" height="120px"
								style="border:1px solid #666" /></td>
							<td class="t5" align="center" valign="middle">${c.c_name }</td>
							<td class="t2" align="center" valign="middle">￥${c.c_price }</td>
							<td class="t3" align="center" valign="middle"><input
								id="${c.c_id }l" type="text" value="${c.c_num}"
								style="width:28px" /></td>
							<td class="t4" align="right" valign="middle"><a
								style="cursor:pointer" onclick="deleted('${c.c_id }')">刪除&nbsp;&nbsp;&nbsp;</a>
							</td>
						</tr>
						<tr style="height:20px">
							<td colspan="6"><hr />
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>

		<div id="buy">
			<div class="aaa">
				总计: ￥：<b id="mmoneyy">${money}</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="button" value="结算" class="jie" onclick="payed()" />
			</div>
		</div>
	</div>
</body>
</html>
