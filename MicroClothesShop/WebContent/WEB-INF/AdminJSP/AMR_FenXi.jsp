<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>NoName</title>

<link href="/MicroClothesShop/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="/MicroClothesShop/css/qalluser.css" rel="stylesheet"
	type="text/css" />
<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/xmlhttprequest.js"></script>
<script Charset="UTF-8" type="text/javascript"
	src="/MicroClothesShop/js/qallrecord.js"></script>
<style type="text/css">
#opt {
	margin-left: 700px;
	margin-top: 30px;
}

.but {
	width: 80px;
}

#mess {
	margin-top: 40px;
}

#zhuzhuang {
	margin-top: -340px;
	margin-left: 540px;
}
</style>
</head>

<body onload="startload()">
	<div id="all">
		<div id="opt">
			<button class="but" onclick="ruku()">入库记录</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="record()">销售记录</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="kucun()">服装库存</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="but" onclick="fenxi()">记录分析</button>
		</div>
		<div id="mess">
			<div id="bingtu">
				<b style="font-size:16px">销售财务各季度比例</b><br /> <br />
				<p>
					<canvas id="canvas_circle" width="500" height="300"
						style="border:2px solid #0026ff;"> 浏览器不支持canvas </canvas>
				</p>
			</div>
			<div id="zhuzhuang">
				<b style="font-size:16px">销售财务星期统计</b><br /> <br />
				<p>
					<canvas id="bchart" height="370" width="500">浏览器不支持canvas
					</canvas>
				</p>
			</div>
		</div>
	</div>

</body>
</html>
