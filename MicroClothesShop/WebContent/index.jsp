<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>index</title>
</head>

<body>
	<%
		StringBuffer url = request.getRequestURL();
		String urll = url.toString();
		System.out.println(urll);
		if (urll.equalsIgnoreCase("http://localhost/MicroClothesShop/Admin/")) {
	%>
	<jsp:forward page="/servlet/AdminRequestForward?name=AdminMain.html" />
	<%
		} else if (urll
				.equalsIgnoreCase("http://localhost/MicroClothesShop/")) {
	%>
	<jsp:forward page="/servlet/UserRequestForward?name=UserMain.html" />
	<%
		} else {
	%>
	<jsp:forward page="/servlet/UserRequestForward?name=Error.jsp" />
	<%
		}
	%>
</body>
</html>
