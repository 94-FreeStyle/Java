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
	<div id="til">微衣服装入库</div>
	<div id="all">
		<form style="margin-left:80px;" action="/MicroClothesShop/servlet/UploadImg" method="post"
			enctype="multipart/form-data">
			<tr>
				</td>
				<td align="right">服装图片：</td>
				<td><input type="file" id="files" name="imag" /></td>
				<td><input type="submit" value="上传图片">
				</td>
			</tr>
		</form>
		<form action="/MicroClothesShop/servlet/ClothesUpload" method="post">
			<table>
				<tr>
					<td align="right">服装名：</td>
					<td><input type="text" name="c_name" /></td>
					<td align="right"></td>
					<td></td>
				</tr>

				<tr>
					<td align="right">品牌：</td>
					<td><input type="text" name="c_brand" vlues="" /></td>
					<td align="right">供应商：</td>
					<td><input type="text" name="c_product" vlues="" /></td>
				</tr>
				<tr>
					<td align="right">型号：</td>
					<td><input type="text" name="c_size" vlues="" /></td>
					<td align="right">款式：</td>
					<td><input type="text" name="c_style" vlues="" /></td>
				</tr>
				<tr>
					<td align="right">颜色：</td>
					<td><input type="text" name="c_color" vlues="" /></td>
					<td align="right">材料：</td>
					<td><input type="text" name="c_metra" vlues="" /></td>
				</tr>
				<tr>
					<td align="right">价格：</td>
					<td><input type="text" name="c_price" vlues="" /></td>
					<td align="right">折扣：</td>
					<td><input type="text" name="c_discount" vlues="" /></td>

				</tr>
				<tr>
					<td align="right">季节：</td>
					<td><input type="text" name="c_semester" vlues="" />
					</td>
					<td align="right">适应人群：</td>
					<td><input type="text" name="c_people" vlues="" />
					</td>
				</tr>
				<tr>
					<td align="right">数量：</td>
					<td><input type="text" name="c_surplusnum" vlues="" />
					</td>
					<td align="right">包装：</td>
					<td><input type="text" name="c_package" vlues="" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input type="submit" value="添加" />
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
