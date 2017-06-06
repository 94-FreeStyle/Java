<%-- 
    Document   : monitor
    Created on : May 31, 2017, 6:43:25 PM
    Author     : vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="/Monitor/IMG/title.ico" rel="shortcut icon" />
        <link href="/Monitor/CSS/monitor.css" rel="stylesheet" type="text/css" />      
        <script src="/Monitor/JS/xmlhttprequest.js" type="text/javascript"></script>
        <script src="/Monitor/JS/monitor.js" type="text/javascript"></script>
        <title>Monitor</title>
    </head>
    <body>
        <h1>&nbsp;&nbsp;&nbsp;爬虫组件</h1>
        <div id="spider">
            <div id="sleft">
                存储路径：<input name="savepath" type="text"/><br/><br/>
                备份路径：<input name="backuppath" type="text"/><br/><br/>
                日志路径：<input name="slogpath" type="text"/><br/><br/>
                <button onclick="runSpider()">启动</button>
            </div>
            <div id="sright">
                总的线程数：12 <br/><br/>
                存活线程数：12 <br/><br/>
                待爬取队列：2341111 <br/><br/>
                已爬取数量：100087
            </div>
        </div>
        <h1>&nbsp;&nbsp;&nbsp;内容提取</h1>
        <div id="parser">
            存储路径：<input name="savepath" type="text"/><br/><br/>
            日志路径：<input name="backuppath" type="text"/><br/><br/>
            <button onclick="runSpider()">启动</button><br/><br/>
            进度：12%
        </div>
        <h1>&nbsp;&nbsp;&nbsp;索引建立</h1>
        <div id="index">
            日志路径：<input name="backuppath" type="text"/><br/><br/>
            <button onclick="runSpider()">启动</button><br/><br/>
            进度：12%
        </div>
        <h1>&nbsp;&nbsp;&nbsp;PR计算</h1>
        <div id="pr">
            日志路径：<input name="backuppath" type="text"/><br/><br/>
            <button onclick="runSpider()">启动</button><br/><br/>
            进度：12%
        </div>
        <h1>&nbsp;&nbsp;&nbsp;TF-IDF计算</h1>
        <div id="ti">
            日志路径：<input name="backuppath" type="text"/><br/><br/>
            <button onclick="runSpider()">启动</button><br/><br/>
            进度：12%
        </div>
        <h1>&nbsp;&nbsp;&nbsp;web监控</h1>
        <div id="web">
            缓存大小：456 <br/><br/>
            访问数量：45 <br/><br/>
            搜索数量：789 <br/><br/>
        </div>
    </body>
</html>
