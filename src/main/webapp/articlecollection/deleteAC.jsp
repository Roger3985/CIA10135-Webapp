<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // MemberVO memberVO = request.getAttribute(memberVO);
%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>文章收藏刪除 - deleteAC.jsp</title>
</head>
<body bgcolor="white">

<table id="table-1">
    <tr>
        <td>
            <h3>文章收藏刪除 - deleteAC.jsp</h3>
            <h4><a href="/articlecollection/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
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
<%--原始範例--%>
<%--<li>--%>
<%--    <form method="post" action="NoticeController?delete" name="form1">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>會員通知編號:</td>--%>
<%--                <td><input type="TEXT" name="motNo" value="${param.motNo}" size="45" required="required"/></td>--%>
<%--                <td>${param.motNo}</td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--        <input type="hidden" name="action" value="delete">--%>
<%--        <input type="hidden" name="motNo" value="${param.motNo}">--%>
<%--        <input type="submit" value="送出刪除">--%>
<%--    </form>--%>
<%--</li>--%>

    <jsp:useBean id="articleCollectionService" scope="page" class="com.roger.articlecollection.service.ArticleCollectionService" />

    <form method="post" action="/articlecollection/ArticleCollectionController" name="deleteForm" onsubmit="return confirm('確定要刪除這條通知嗎？');">
        <b>選擇會員通知編號:</b>
        <select size="1" name="memNo" style="width: 50px">
            <c:forEach var="articleCollectionVo" items="${articleCollectionService.all}">
                <option value="${articleCollectionVo.memNo}">${articleCollectionVo.memNo}</option>
            </c:forEach>
        </select>
        <input type="hidden" name="action" value="delete">
        <input type="submit" value="送出刪除">
    </form>

</body>
</html>
