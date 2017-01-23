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

<title>用户支付</title>

<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon">
<link href="/MicroClothesShop/css/pay.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript">
	function vpay() {
		var opts = document.getElementsByName("pd_FrpId");
		for (i = 0; i < opts.length; i++) {
			if (opts[i].checked == true) {
				var bank = opts[i].value;
				window.open("/MicroClothesShop/servlet/Payed?oid="
						+ "${oid}&bank=" + bank);
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
	<div id="all">
		<div id="address">
			<p class="tiii">您的收货信息为：
			<hr />
			</p>
			<p class="tii">
				<input type="radio" />${address}
			</p>
		</div>
		<div id="mess">
			<p class="tiii">
				订单信息：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b
					style="font-size:12px;color:#aaa">订单号：${oid}</b>
			</p>

			<div class="biaoti">
				<hr />
				<table class="tt">
					<thead>
						<tr>
							<th>商品图片</th>
							<th>商品名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>总价</th>
						</tr>
					</thead>
					<tbody>
						<tr class="ttr">
							<td class="t1" align="center" valign="middle"><img
								src="${buyClo.c_image}" width="100px" height="100px">
							</td>
							<td class="t5" align="center" valign="middle">${buyClo.c_name}</td>
							<td class="t2" align="center" valign="middle">￥${buyClo.c_price}</td>
							<td class="t3" align="center" valign="middle">${numm}件</td>
							<td class="t4" align="center" valign="middle">￥${mon}</td>
						</tr>
						<tr>
							<td colspan="5"><hr />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div id="bank">
			<p class="tiii">请您选择在线支付银行：</p>
			<hr />
			<table>

				<tr>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="CMBCHINA-NET"><img
						src="/MicroClothesShop/bank_img/cmb.bmp" />
					</td>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="ICBC-NET"><img
						src="/MicroClothesShop/bank_img/gongShang.bmp" /></td>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="ABC-NET"><img
						src="/MicroClothesShop/bank_img/abc.bmp" /></td>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="CCB-NET"><img
						src="/MicroClothesShop/bank_img/ccb.bmp" />
					</td>
				</tr>
				<tr>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="CMBC-NET"><img
						src="/MicroClothesShop/bank_img/cmbc.bmp" /></td>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="CEB-NET"><img
						src="/MicroClothesShop/bank_img/guangda.bmp" />
					</td>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="BOCO-NET"><img
						src="/MicroClothesShop/bank_img/bcc.bmp" /></td>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="SDB-NET"><img
						src="/MicroClothesShop/bank_img/sfz.bmp" /></td>
				</tr>
				<tr>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="BCCB-NET"><img
						src="/MicroClothesShop/bank_img/bj.bmp" /></td>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="CIB-NET"><img
						src="/MicroClothesShop/bank_img/cib.bmp" />
					</td>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="SPDB-NET"><img
						src="/MicroClothesShop/bank_img/shpd.bmp" />
					</td>
					<td align="center"><INPUT TYPE="radio" NAME="pd_FrpId"
						value="ECITIC-NET"><img
						src="/MicroClothesShop/bank_img/zx.bmp" /></td>
				</tr>
			</table>
		</div>
		<div id="buy">
			<div class="aaa">
				总计：<b>￥${mon}</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href=""><input
					type="button" value="支付" class="jie" onclick="vpay()" /> </a>
			</div>
		</div>
	</div>
</body>
</html>
