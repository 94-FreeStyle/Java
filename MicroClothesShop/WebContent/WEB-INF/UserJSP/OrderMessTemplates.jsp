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
<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon" />
<title>订单详情</title>
<style type="text/css">
#all {
	width: 900px;
	margin-left: auto;
	margin-right: auto;
	margin-left: auto;
}

#ti {
	margin-left: 0px;
	font-size: 18px;
	color: #2222FF;
	font-size: 20px;
	background-color: #eee;
	width: 100%;
	height: 30px;
}

#con {
	margin-top: 30px;
}

tr {
	height: 140px;
}

td {
	width: 250px;
}

.messs {
	font-size: 17px;
	color: #1133ff;
}

#wuliu {
	height: 250px;
	width: 100%;
	border: 1px dashed #ccc;
	margin-bottom: 50px;
	overflow: auto;
}

.quu {
	margin-left: 660px;
	margin-top: -15px;
	margin-bottom: 30px;
	height: 40px;
	width: 100px;
	font-size: 16px;
	letter-spacing: 3px;
	cursor: pointer;
}

.quuu {
	position:absoluet;
	margin-left: 800px;
	margin-top: -114px;
	margin-bottom: 30px;
	height: 40px;
	width: 100px;
	font-size: 16px;
	letter-spacing: 3px;
	cursor: pointer;
}
</style>
<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/xmlhttprequest.js"></script>
<script type="text/javascript">
	function queren() {
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = querycallback;
		xmlHttp.open("post", "/MicroClothesShop/servlet/ShouHuo");
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttp.send("oid=${order.o_id}");

	}

	function querycallback() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				var text = xmlHttp.responseText;
				alert(text);
			}
		}
	}

	function tuihuo() {
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = tuicallback;
		xmlHttp.open("post", "/MicroClothesShop/servlet/TuiHuo");
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttp.send("oid=${order.o_id}");

	}

	function tuicallback() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				var text = xmlHttp.responseText;
				alert(text);
			}
		}
	}
</script>
</head>

<body>
	<div id="all">
		<div id="ti">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单号：${order.o_id}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态：${order.o_statu}
		</div>
		<br /> <br />
		<div class="messs">订单所含所有商品信息</div>
		<div id="con">
			<table class="tt" id="tab">
				<c:forEach items="${cloth}" var="c">
					<tr class="ttr">
						<td class="t1" align="center" valign="middle"><img
							src="${c.c_image }" width="120px" height="120px"
							style="border:1px solid #666" /></td>
						<td class="t5" align="center" valign="middle">${c.c_name }</td>
						<td class="t2" align="center" valign="middle">￥${c.c_price }</td>
						<td class="t3" align="center" valign="middle"><input
							type="text" value="${nums}" style="width:35px" /></td>
					</tr>
					<tr style="height:20px">
						<td colspan="6"><hr />
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br /> <br />
		<div class="messs">物流信息</div>
		<br />
		<div id="wuliu"></div>
		<div id="queren">
			<button class="quu" onclick="queren()">确认收货</button>
			<button class="quuu" onclick="tuihuo()">退货</button>
		</div>
	</div>
</body>
</html>
