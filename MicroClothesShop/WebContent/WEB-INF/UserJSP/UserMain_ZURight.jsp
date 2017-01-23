<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>NoName</title>

<link href="/MicroClothesShop/css/usermainright.css" rel="stylesheet"
	type="text/css" />
<script src="/MicroClothesShop/js/xclothes.js" type="text/javascript"></script>
<script type="text/javascript">
	function _go(select) {
		var mp = document.getElementById("mpp").value;
		var index = select.selectedIndex;
		var option = select.options[index];
		var value = option.value;
		location = "<c:url value='/servlet/QueryClothes?pageCode='/>" + value
				+ "${url}" + "&c_maxprice=" + mp;
	}
	function toQuery(code) {
		var mp = document.getElementById("mpp").value;
		location = "<c:url value='/servlet/QueryClothes?pageCode='/>"
				+ code+"${url}" + "&c_maxprice=" + mp;
	}
</script>
</head>

<body>
	<div class="all">
		<div id="query">
			<form action="/MicroClothesShop/servlet/QueryClothes?pageCode=1"
				method="post">
				<p>
					品牌：<input value="爱马仕" type="radio" name="c_brand" />爱马仕&nbsp;&nbsp;&nbsp;
					<input value="LV" type="radio" name="c_brand" />LV&nbsp;&nbsp;&nbsp;
					<input value="乔丹" type="radio" name="c_brand" />乔丹&nbsp;&nbsp;&nbsp;
					<input value="李宁" type="radio" name="c_brand" />李宁&nbsp;&nbsp;&nbsp;
					<input value="美特斯邦威" type="radio" name="c_brand" />美特斯邦威&nbsp;&nbsp;&nbsp;
					<input value="特步" type="radio" name="c_brand" />特步&nbsp;&nbsp;&nbsp;
					<input value="耐克" type="radio" name="c_brand" />耐克&nbsp;&nbsp;&nbsp;
					<input value="贵人鸟" type="radio" name="c_brand" />贵人鸟&nbsp;&nbsp;&nbsp;
					<input value="杰克.琼斯" type="radio" name="c_brand" />杰克.琼斯
				</p>
				<p>
					价格：<input type="text" name="c_price" />---<input type="text"
						name="c_maxprice" id="mpp" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					颜色：<select name="c_color">
						<option value="" selected="selected"></option>
						<option value="黄色">黄色</option>
						<option value="蓝色">蓝色</option>
						<option value="绿色">绿色</option>
						<option value="红色">红色</option>
						<option value="橙色">橙色</option>
						<option value="白色">白色</option>
						<option value="黑色">黑色</option>
					</select>
				</p>
				<p>
					款式：<input value="休闲" type="radio" name="c_style" />休闲&nbsp;&nbsp;&nbsp;
					<input value="运动" type="radio" name="c_style" />运动&nbsp;&nbsp;&nbsp;
					<input value="外套" type="radio" name="c_style" />外套&nbsp;&nbsp;&nbsp;
					<input value="内衣" type="radio" name="c_style" />内衣&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询" />
				</p>
			</form>
		</div>
		<div class="zhan">
			<p>所有服装</p>
		</div>
		<div id="con">

			<table>
				<c:forEach items="${ pb.datas}" var="c">
					<tr>
						<td align="center" class="cimg"><a
							href="/MicroClothesShop/servlet/ClothesTem?id=${c.c_id }"
							target="rightFrame"><img src="${c.c_image }" width="100px"
								height="110px" /> </a>
						</td>
						<td align="center" class="brand">
							<div>${c.c_name }</div></td>
						<td align="center" class="styles">${c.c_color
							}&nbsp;&nbsp;${c.c_style }</td>
						<td align="center" class="price">￥：${c.c_price
							}&nbsp;&nbsp;享${c.c_discount}折</td>

					</tr>
					<tr style="height:50px">
						<td colspan="4"><hr /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="ye">
			<p>
				第${pb.pageCode }页
				<c:if test="${pb.pageCode>1 }">
					<a onclick="toQuery(${pb.pageCode-1})">&nbsp;&nbsp;&nbsp;上一页</a>
				</c:if>
				&nbsp;&nbsp;&nbsp;
				<c:set var="begin" value="1" />
				<c:set var="end" value="10" />
				<c:choose>
					<c:when test="${pb.totlePage<=10 }">
						<c:set var="begin" value="1" />
						<c:set var="end" value="${pb.totlePage }" />
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${pb.pageCode-4<1}">
								<c:set var="begin" value="1" />
								<c:set var="end" value="10" />
							</c:when>
							<c:when test="${pb.pageCode+5>pb.totlePage}">
								<c:set var="begin" value="${pb.totlePage-9 }" />
								<c:set var="end" value="${pb.totlePage }" />
							</c:when>
							<c:otherwise>
								<c:set var="begin" value="${pb.pageCode-4}" />
								<c:set var="end" value="${pb.pageCode+5}" />
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${begin}" end="${end }" var="i">
					<c:choose>
						<c:when test="${pb.pageCode eq i }">${i}</c:when>
						<c:otherwise>
							<a onclick="toQuery(${i})">[${i}]</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pb.pageCode<pb.totlePage }">
					<a onclick="toQuery(${pb.pageCode+1})">&nbsp;&nbsp;&nbsp;下一页</a>
				</c:if>
				&nbsp;&nbsp;&nbsp; 跳到第 <select onchange="_go(this)" name="pageCode">
					<c:forEach begin="1" end="${pb.totlePage }" var="i">
						<option value="${i }"
							<c:if test="${pb.pageCode eq i }">selected='selected'</c:if>>${i}</option>
					</c:forEach>
				</select>页&nbsp;&nbsp;&nbsp; 共${pb.totlePage}页
			</p>
		</div>

	</div>
</body>
</html>
