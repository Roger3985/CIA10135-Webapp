<%@ page import="com.roger.member.vo.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // MemberVO memberVO = (MemberVO) request.getAttribute(MemberVO);
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>點讚修改 - update_clicklike_input.jsp</title>
</head>
<body bgcolor="white">

<table id="table-1">
    <tr>
        <td>
            <h3>點讚修改 - update_clicklike_input.jsp</h3>
            <h4><a href="/clicklike/select_page.jsp"><img src="./images/back.jpg" width="100" height="32" border="0">回首頁</a></h4>
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

<jsp:useBean id="clickLikeService" scope="page" class="com.roger.clicklike.service.ClickLikeService" />
<jsp:useBean id="clickLikeVo" scope="page" class="com.roger.clicklike.vo.ClickLikeVo" />

<form method="post" action="/clicklike/ClickLikeController" name="form1">
    <table>
        <tr>
            <td>修改前會員編號:</td>
            <td>
                <select size="1" name="memNo">
                    <c:forEach var="clickLikeVo" items="${clickLikeService.all}" >
                    <option value="${clickLikeVo.memNo}">${clickLikeVo.memNo}
                        </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.memAcc}</td>
        </tr>
        <tr>
            <td>修改後會員編號:</td>
            <td><input type="TEXT" name="memNo" value="${param.memNo}" size="45" required="required"/></td>
            <td>${errorMsgs.memNo}</td>
        </tr>

        <br><br>
        <tr>
            <td>修改前文章編號:</td>
            <td>
                <select size="1" name="artNo">
                    <c:forEach var="clickLikeVo" items="${clickLikeService.all}" >
                    <option value="${clickLikeVo.artNo}">${clickLikeVo.artNo}
                    </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.memAcc}</td>
        </tr>
        <tr>
            <td>文章編號:</td>
            <td><input type="TEXT" name="artNo" value="${param.artNo}" size="45" required="required"/></td>
            <td>${param.artNo}</td>
        </tr>

    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="memNo" value="${param.memNo}">
    <input type="submit" value="送出修改">
</form>
</body>
</html>
