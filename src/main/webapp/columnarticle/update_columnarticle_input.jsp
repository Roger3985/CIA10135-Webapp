<%@ page import="com.roger.member.vo.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // MemberVO memberVO = (MemberVO) request.getAttribute(MemberVO);
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>專欄文章資料修改 - update_columnarticle_input.jsp</title>
</head>
<body bgcolor="white">

<table id="table-1">
    <tr>
        <td>
            <h3>專欄文章資料修改 - update_columnarticle_input.jsp</h3>
            <h4><a href="/columnarticle/select_page.jsp"><img src="./images/back.jpg" width="100" height="32" border="0">回首頁</a></h4>
        </td>
    </tr>
</table>

<h3>專欄文章資料修改:</h3>
    <%--  錯誤表列  --%>
    <c:if test="${not empty errorMsgs}">
        <font style="color:red">請修正以下錯誤</font>
        <ul>
            <c:forEach var="message" items="${errorMsgs}">
                <li style="color:red">${message.value}</li>
            </c:forEach>
        </ul>
    </c:if>

<jsp:useBean id="memberService" scope="page" class="com.roger.member.service.MemberService" />

<form method="post" action="/member/MemberServlet" name="form1">
    <table>
        <tr>
            <td>管理員編號:</td>
            <td><input type="TEXT" name="admNo" value="${param.admNo}" size="45"/></td> <td>${errorMsgs.admNo}</td>
        </tr>
        <tr>
            <td>文章標題:</td>
            <td><input type="TEXT" name="artTitle"   value="${param.artTitle}"   size="45"/></td> <td>${errorMsgs.artTitle}</td>
        </tr>
        <tr>
            <td>文章內容:</td>
            <td><input name="artContent" id="f_date1" type="text" ></td> <td>${errorMsgs.artContent}</td>
        </tr>
        <tr>
            <td>文章發表時間:</td>
            <td><input name="artTime" type="TEXT" value="${param.artTime}"   size="45"/></td> <td>${errorMsgs.artTime}</td>
        </tr>
        <tr>
            <td>文章分類編號:</td>
            <td><input type="TEXT" name="artCatNo" value="${param.artCatNo}"   size="45"/></td> <td>${errorMsgs.artCatNo}</td>
        </tr>
        <tr>
            <td>文章狀態:</td>
            <td><input type="TEXT" name="artStat" value="${param.artStat}"   size="45"/></td> <td>${errorMsgs.artStat}</td>
        </tr>

    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="artNo" value="${param.artNo}">
    <input type="submit" value="送出修改">
</form>
</body>
</html>
