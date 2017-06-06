<%-- 
    Document   : monitor
    Created on : May 31, 2017, 6:43:25 PM
    Author     : vincent
--%>
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
        <title>管理员登录</title>
        <link href="/Monitor/IMG/title.ico" rel="shortcut icon" />
        <link href="/Monitor/CSS/adminlogin.css" rel="stylesheet" type="text/css" />      
        <script src="/Monitor/JS/xmlhttprequest.js" type="text/javascript"></script>
        <script src="/Monitor/JS/adminlogin.js" type="text/javascript"></script>
    </head>

    <body>
        <div id="login">
            <div id="photo">
                <img src="/Monitor/IMG/admin.jpg" height="100px" width="100px"/>
            </div><br/>
            <div id="con"><br/><br/><br/>
                <form action="/Monitor/adminLogin" method="post">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：<input type="text" name="username" /><br /> <br/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：<input type="password" name="pw" /><br /> <br />
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" id="submit" value="登录" style="cursor:pointer"/>
                </form>
                <p><a href="javascript:void(0)" onclick="callbackpw()">忘记密码</a>&nbsp;|&nbsp;<a href="">帮助</a></p>
            </div>
        </div>
        <br>
    </body>
</html>
