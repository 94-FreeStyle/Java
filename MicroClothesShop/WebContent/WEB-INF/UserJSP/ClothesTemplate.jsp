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

<title>服装详细信息</title>

<link href="/MicroClothesShop/css/clothestemplate.css" rel="stylesheet"
	type="text/css">

<script src="/MicroClothesShop/js/xmlhttprequest.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function addcart() {
		createXMLHttpRequest();
		var cid = '${cloth.c_id}';

		var num = document.getElementById("num").value;

		var pac = document.getElementById("pac").value;
		xmlHttp.onreadystatechange = callback;

		xmlHttp.open("post", "/MicroClothesShop/servlet/AddCart");
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xmlHttp.send("cid=" + cid + "&cnum=" + num + "&package=" + pac);
	}
	function callback() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				alert("添加成功！");
			}
		}
	}
	
	function buynow(id) {
		var num=document.getElementById("num").value;
		window.open( "/MicroClothesShop/servlet/Buy?cid="+id+"&num="+num+"&mon="+num);
	}
</script>
</head>

<body>
	<div id="all">
		<table>
			<tr>
				<td rowspan="12"  valign="middle" class="iam"><img
					src="${cloth.c_image}" width="420px" height="470px" class="tutu" />
				</td>
				<td class="yim"><b>${cloth.c_name}</b></td>
			</tr>
			<tr>
				<td class="jian">${cloth.c_color}&nbsp;&nbsp;${cloth.c_style}</td>
			</tr>
			<tr>
				<td class="jia">￥：${cloth.c_price}&nbsp;&nbsp;享${cloth.c_discount}折</td>
			</tr>
			<tr>

				<td><i class="biao">品牌 </i>&nbsp;&nbsp;&nbsp;&nbsp;${cloth.c_brand}</td>
			</tr>
			<tr>
				<td><i class="biao">供应商</i>&nbsp;&nbsp;&nbsp;&nbsp;${cloth.c_product}</td>
			</tr>
			<tr>
				<td><i class="biao">材质</i>&nbsp;&nbsp;&nbsp;&nbsp;${cloth.c_metra}</td>
			</tr>
			<tr>

				<td><i class="biao">包装选择</i>&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="radio" value="精装礼盒" name="package" id="pac">精装礼盒&nbsp;&nbsp;&nbsp;<input
					type="radio" value="普通盒装" name="package" id="pac">普通盒装&nbsp;&nbsp;&nbsp;<input
					type="radio" value="塑料袋" name="package" id="pac">塑料袋</td>
			</tr>
			<tr>
				<td><i class="biao">款型颜色选择</i>&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="radio" value="花色" name="color">花色&nbsp;&nbsp;&nbsp;<input
					type="radio" value="橙色" name="color">橙色&nbsp;&nbsp;&nbsp;<input
					type="radio" value="蓝色" name="color">蓝色 &nbsp;&nbsp;&nbsp;<input
					type="radio" value="粉色" name="color">粉色</td>
			</tr>
			<tr>
				<td class="ku">库存还有${cloth.c_surplusnum}件</td>
			</tr>
			<tr>
				<td><i class="biao">数量选择</i>&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="text" value="1" id="num" style="width:30px;text-indent: 6px"
					name="cnum" />&nbsp;&nbsp;件</td>
			</tr>
			<tr>
				<td colspan="2"><i class="biao">尺码选择</i>&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="radio" value="XL" name="size">XL&nbsp;&nbsp;&nbsp;<input
					type="radio" value="XXL" name="size">XXL&nbsp;&nbsp;&nbsp;<input
					type="radio" value="ML" name="size">ML &nbsp;&nbsp;&nbsp;<input
					type="radio" value="XML" name="size">XML</td>
			</tr>

			<tr>
				<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="加入购物车" onclick="addcart()" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="现在就购买" onclick="buynow('${cloth.c_id}')" /></td>
			</tr>

		</table>
	</div>
</body>
</html>
