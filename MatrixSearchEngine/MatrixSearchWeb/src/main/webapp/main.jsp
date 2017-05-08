<%-- 
    Document   : main
    Created on : Apr 2, 2017, 7:38:03 PM
    Author     : vincent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <title>matrix search</title>
        <link href="/MatrixSearchWeb/IMG/time.png" rel="shortcut icon">
        <link href="/MatrixSearchWeb/CSS/main.css" rel="stylesheet" type="text/css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="all">
            <div id="heads">
                <img id="imm" src="/MatrixSearchWeb/IMG/timg.jpg" height="60px" width="160px"/>
                <form action="/MatrixSearchWeb/search" method="post">	
                    <input type="text" name="search" id="con" placeholder="请输入搜索内容..."/>&nbsp;
                    <input type="submit" value="搜索一下" id="se"/>
                </form>
            </div>
            <div id="bodys">
                <c:choose>
                    <c:when test="${requestScope.flag eq 0 }">
                        <div id="sorry">Sorry! We Can't Provide Anything!</div>
                    </c:when>
                    <c:otherwise>
                        <p id="tips">矩阵搜索为您搜索到${fn:length(requestScope.pb.sortedUrls)}条信息，用时${sessionScope.time}毫秒</p>
                        <c:forEach items="${requestScope.res}" var="record">  
                            <table border="0" id="rcon">
                                <tr>
                                    <td class="ha1">
                                        <a href="<c:url value='/go?url=${record.url}'/>"  target="_blank" style="text-decoration:none;cursor: pointer;">${record.title}&nbsp;${record.date}</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="ha2">                        
                                        ${record.con}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="ha3">
                                        <a href="<c:url value='/go?url=${record.url}'/>" target="_blank" style="cursor: pointer;">${record.url}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>jiabowen provide</em>                                 
                                    </td>
                                </tr>
                            </table>
                            <br/>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>           
            </div>
            <c:if test="${requestScope.flag eq 1}">
                <div id="page">                 
                    第${requestScope.pb.currentPage}页
                    <c:if test="${requestScope.pb.currentPage > 1}">
                        <a href="<c:url value='/paging?page=${requestScope.pb.currentPage-1 }'/>" style="text-decoration:none;cursor: pointer;">&nbsp;&nbsp;&nbsp;上一页</a>
                    </c:if>
                    &nbsp;&nbsp;&nbsp;
                    <c:set var="begin" value="1" />
                    <c:set var="end" value="10" />
                    <c:choose>
                        <c:when test="${requestScope.pb.totalSize <= 10 }">
                            <c:set var="begin" value="1" />
                            <c:set var="end" value="${requestScope.pb.totalSize }" />
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${requestScope.pb.currentPage-4 < 1}">
                                    <c:set var="begin" value="1" />
                                    <c:set var="end" value="10" />
                                </c:when>
                                <c:when test="${requestScope.pb.currentPage + 5 > requestScope.pb.totalSize}">
                                    <c:set var="begin" value="${requestScope.pb.totalSize - 9 }" />
                                    <c:set var="end" value="${requestScope.pb.totalSize}" />
                                </c:when>
                                <c:otherwise>
                                    <c:set var="begin" value="${requestScope.pb.currentPage - 4}" />
                                    <c:set var="end" value="${requestScope.pb.currentPage + 5}" />
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach begin="${begin }" end="${end }" var="i">
                        <c:choose>
                            <c:when test="${requestScope.pb.currentPage eq i }">${i}&nbsp;&nbsp;</c:when>
                            <c:otherwise>
                                <a href="<c:url value='/paging?page=${i }'/>" style="text-decoration:none;cursor: pointer;">[${i}]&nbsp;&nbsp; </a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${requestScope.pb.currentPage < requestScope.pb.totalSize }">
                        <a href="<c:url value='/paging?page=${requestScope.pb.currentPage+1 }'/>" style="text-decoration:none;cursor: pointer;">&nbsp;&nbsp;&nbsp;下一页 </a>
                    </c:if>                   
                </div>
            </c:if>
            <div id="bott">
                <p id="bcon">Copyright @ jiabowen all right received 1994-2017</p>
            </div>
        </div>
    </body>
</html>
