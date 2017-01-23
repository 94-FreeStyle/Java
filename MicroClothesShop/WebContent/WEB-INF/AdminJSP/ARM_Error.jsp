<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>404错误页</title>
<link href="/MicroClothesShop/icons/title.ico" rel="shortcut icon"/>
<link href="/MicroClothesShop/css/error.css" rel="stylesheet"
	type="text/css"/>
<script type="text/javascript" src="/MicroClothesShop/js/jquery.js"></script>

<script language="javascript">
	$(function() {
		$('.error').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 490) / 2
		});
		$(window).resize(function() {
			$('.error').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 490) / 2
			});
		})
	});
</script>


</head>


<body style="background:#edf6fa;">

	<div class="error">

		<h2>非常遗憾，您访问的页面不存在！</h2>
		<p>看到这个提示，就自认倒霉吧!</p>
		<div class="reindex">
			<a href="/MicroClothesShop/servlet/AdminRequestForward?name=AdminLogin.jsp"
				target="_parent">返回首页</a>
		</div>

	</div>

</body>
</html>
