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

<title>NONAME</title>
<style>
#til {
	font-size: 28px;
	letter-spacing: 5px;
	text-align: center;
	margin-top: 30px; //
	vertical-align: middle;
}

#all {
	margin-left: 300px;
	margin-top: 40px;
	height: 420px;
	width: 700px;
	border: 1px solid #666;
	background-color: #eee;
	border-radius: 5px;
}

tr {
	height: 50px;
}

td {
	width: 140px;
}

#files {
	cursor: pointer;
}
</style>

</head>

<body>
	<div id="til">微衣服装编辑</div>
	<div id="all">
		<form action="/MicroClothesShop/servlet/EditedCloth" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td align="right">服装名：</td>
					<td><input type="text" name="c_name" value="${cloth.c_name}"/></td>
					<td align="right">显示图片：</td>
					<td><input type="file" id="files" name="c_image" value="${cloth.c_image}"/>
					</td>
				</tr>

				<tr>
					<td align="right">品牌：</td>
					<td><input type="text" name="c_brand" value="${cloth.c_brand}"/></td>
					<td align="right">供应商：</td>
					<td><input type="text" name="c_product" value="${cloth.c_product}"/></td>
				</tr>
				<tr>
					<td align="right">大小：</td>
					<td><input type="text" name="c_size" value="${cloth.c_size}"/></td>
					<td align="right">款式：</td>
					<td><input type="text" name="c_style" value="${cloth.c_style}"/></td>
				</tr>
				<tr>
					<td align="right">颜色：</td>
					<td><input type="text" name="c_color" value="${cloth.c_color}"/></td>
					<td align="right">材料：</td>
					<td><input type="text" name="c_metra" value="${cloth.c_metra}"/></td>
				</tr>
				<tr>
					<td align="right">价格：</td>
					<td><input type="text" name="c_price" value="${cloth.c_price}"/></td>
					<td align="right">折扣：</td>
					<td><input type="text" name="c_discount" value="${cloth.c_discount}"/></td>

				</tr>
				<tr>
					<td align="right">季节：</td>
					<td><input type="text" name="c_semester" value="${cloth.c_semester}"/>
					</td>
					<td align="right">适应人群：</td>
					<td><input type="text" name="c_people" value="${cloth.c_people}"/>
					</td>
				</tr>
				<tr>
					<td align="right">数量：</td>
					<td><input type="text" name="c_surplusnum" value="${cloth.c_surplusnum}"/>
					</td>
					<td align="right">包装：</td>
					<td><input type="text" name="c_package" value="${cloth.c_package}"/></td>
				</tr>
				<tr>
					<td><input type="hidden" name="c_id" value="${cloth.c_id}"></td>
					<td align="right"><input type="submit" value="提交" />
					</td>
					<td></td>
					<td><input type="reset" value="重置" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
