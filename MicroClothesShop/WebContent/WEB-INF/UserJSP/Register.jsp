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

<title>用户注册</title>

<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon">
<link href="/MicroClothesShop/css/jquery-ui.css" rel="stylesheet"
	type="text/css">
<link href="/MicroClothesShop/css/register.css" rel="stylesheet"
	type="text/css">
<script src="/MicroClothesShop/js/jquery.js" type="text/javascript"></script>
<script src="/MicroClothesShop/js/formValidator_min.js"
	type="text/javascript"></script>
<script src="/MicroClothesShop/js/formValidatorRegex.js"
	type="text/javascript"></script>
<script src="/MicroClothesShop/js/register.js" type="text/javascript"></script>
<script src="/MicroClothesShop/js/xmlhttprequest.js"
	type="text/javascript"></script>
</head>

<body>
	<div id="tilss">
		<b><i>微衣网上服装店用户注册</i> </b>
	</div>
	<!--注册开始-->
	<div class="reg">
		<form action="/MicroClothesShop/servlet/Register" method="post" name="form1" id="form1">
			<dl>
				<dt class="f14 b">帐户基本信息</dt>
				<dd>
					<span class="title">登录账号：</span><input class="reg_input"
						name="t_UserName" id="t_UserName"
						onblur="checkusername(this.value);" type="text" /><span
						id="t_UserNameTip" class="onshow"></span>
				</dd>
				<dd>
					<span class="title">地址：</span><input class="reg_input"
						name="address" id=""
						onblur="checkNickName(this.value)" type="text" /><span
						id="iptNickNameTip" class="onshow"></span>
				</dd>
				<dd>
					<span class="title">邮编：</span><input class="reg_input"
						name="code" id=""
						onblur="checkNickName(this.value)" type="text" /><span
						id="iptNickNameTip" class="onshow"></span>
				</dd>
				<dd>
					<span class="title">性别：</span><input type="radio" id="Sex_Man"
						name="rb_Sex" value="0" checked="CHECKED" /><label for="Sex_Man">
						帅哥</label> <input type="radio" id="Sex_Woman" name="rb_Sex" value="0" /><label
						for="Sex_Woman"> 美女</label> <input name="" type="checkbox"
						value="" /> 不公开
				</dd>
			</dl>
			<dl>
				<dt class="f14 b">帐户安全设置</dt>
				<dd>
					<span class="title">登录密码：</span><input class="reg_input"
						onblur="return checkpasswd(this);" id="t_UserPass"
						name="t_UserPass" type="password" /><span id="t_UserPassTip"
						class="onshow"></span>
				</dd>
				<dd>
					<span class="title">确认登录密码：</span><input
						onblur="checkdoublepassword();" class="reg_input" type="password"
						id="t_RePass" name="t_RePass" /><span id="t_RePassTip"
						class="onshow"></span>
				</dd>
				<dd>
					<span class="title">手机号码：</span><input name="phone" id="iptName"
						class="reg_input" type="text" onblur="return isCnn(this)" /><span
						id="iptNameTip" class="onshow"></span>
				</dd>
				<dd>
					<span class="title">开户银行：</span><select name="bank">
						<option value="volvo">中国银行</option>
						<option value="saab">中国工商银行</option>
						<option value="opel">中国农业银行</option>
						<option value="audi">中国建设银行</option>
						<option value="audi">中国建设银行</option>
					</select> <span id="t_UserNameTip" class="onshow"></span>
				</dd>
				<dd>
					<span class="title">银行卡号：</span><input class="reg_input"
						name='iptCard' type='text' id='iptCard'
						onblur="return checktheform();" /><span id="iptCardTip"
						class="onshow"></span>
				</dd>
				<dd>
					<span class="title">税号：</span><input name="iptName" id="iptName"
						class="reg_input" type="text" onblur="return isCnn(this)" /><span
						id="iptNameTip" class="onshow"></span>
				</dd>
				<dd>
					<span class="title">邮箱地址：</span><input class="reg_input"
						name="t_Email" type="text" id="t_Email"
						onblur="checkemail(this.value)" /><span id="t_EmailTip"
						class="onshow"></span>
				</dd>
				<dd>
					<span class="title">验证码：</span><input id="t_CheckCode"
						class="reg_input_pic" name="t_CheckCode" type="text" maxlength="4" />
					<img class="img" id="imgg" src="/MicroClothesShop/servlet/VCode"
						width="60" height="30" /><span id="next" onclick="changevimage()">换一张
					</span>
				</dd>
			</dl>
			<div class="f_reg_but">
				<input type="submit" value="免费注册" /><span class="clew_txt">如果您已有帐号，可<a
					href="#">直接登录</a> </span>
			</div>
		</form>
	</div>
	<!--注册结束-->
</body>
</html>
