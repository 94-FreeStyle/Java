<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户订单</title>
<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon" />
<link href="/MicroClothesShop/css/pay.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
th {
	width: 150px;
}
</style>
</head>

<body>
	<div id="top">
		<b class="shou"><a
			href="/MicroClothesShop/servlet/UserRequestForward?name=UserMain.html"
			target="_parent">回到首页</a> </b> <b class="tou"><img
			src="${user.u_image}" width="22px" height="22px" />&nbsp;&nbsp;&nbsp;${user.u_name}</b>
	</div>
	<div id="all">
		<div id="address">
			<p class="tiii" style="margin-top:5px">
				微衣用户订单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="#66ee33" size="3">(注：状态一栏中&nbsp;&nbsp;0表示未付款，1表示已购买，2表示已发货，3表示已收货，4表示已退货)</font>
			<hr />
			</p>
		</div>
		<div id="mess">

			<div class="biaoti">
				<table class="tt">
					<thead>
						<tr>
							<th>订单号</th>
							<th>提交日期</th>
							<th>商品详情</th>
							<th>状态</th>
							<th>总价</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="6"><hr /></td>
						</tr>
						<c:forEach items="${order}" var="o">
							<tr class="ttr">
								<td class="t1" align="center" valign="middle"
									style="color:#aa2211">[${o.o_id}]</td>
								<td class="t5" align="center" valign="middle">${o.o_tdate}</td>
								<td class="t2" align="center" valign="middle"><a
									href="/MicroClothesShop/servlet/OrderMessage?oid=${o.o_id}"
									style="color:#1122ff">点击查看详情</a></td>
								<td class="t4" align="center" valign="middle">${o.o_statu}</td>
								<td class="t6" align="center" valign="middle"
									style="color:#ff1111">${o.o_money}</td>
								<td class="t3" align="center" valign="middle"><a href="">购买</a>
								</td>
							</tr>
							<tr>
								<td colspan="6"><hr /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
