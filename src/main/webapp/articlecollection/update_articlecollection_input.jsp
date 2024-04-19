<%@ page import="com.roger.member.vo.MemberVO" %>
<%@ page import="com.roger.articlecollection.vo.ArticleCollectionVO" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // ArticleCollectionVO articleCollectionVo = (ArticleCollectionVO) request.getAttribute(ArticleCollectionVO);
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>文章收藏修改 - update_articlecollection_input.jsp</title>
</head>
<body bgcolor="white">

<table id="table-1">
    <tr>
        <td>
            <h3>文章收藏修改 - update_articlecollection_input.jsp</h3>
            <h4><a href="/articlecollection/select_page.jsp"><img src="./images/back.jpg" width="100" height="32" border="0">回首頁</a></h4>
        </td>
    </tr>
</table>

<h3>資料修改:</h3>
    <%--  錯誤表列  --%>
    <c:if test="${not empty errorMsgs}">
        <font style="color:red">請修正以下錯誤</font>
        <ul>
            <c:forEach var="message" items="${errorMsgs}">
                <li style="color:red">${message.value}</li>
            </c:forEach>
        </ul>
    </c:if>

<jsp:useBean id="articleCollectionService" scope="page" class="com.roger.articlecollection.service.ArticleCollectionService" />

<form method="post" action="/articlecollection/ArticleCollectionController" name="form1">
    <table>
        <tr>
            <td>會員編號:</td>
            <td>
                <select size="1" name="memNo">
                    <c:forEach var="articleCollectionVo" items="${articleCollectionService.all}" >
                    <option value="${articleCollectionVo.memNo}">${articleCollectionVo.memNo}
                    </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.memNo}</td>
        </tr>
        <tr>
            <td>文章編號:</td>
            <td>
                <select size="1" name="artNo">
                    <c:forEach var="articleCollectionVo" items="${articleCollectionService.all}" >
                    <option value="${articleCollectionVo.artNo}">${articleCollectionVo.artNo}
                    </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.artNo}</td>
        </tr>

    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="memNo" value="${param.memNo}">
    <input type="submit" value="送出修改">
</form>
</body>
</html>
