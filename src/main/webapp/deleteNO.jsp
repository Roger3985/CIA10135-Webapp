<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // NoticeVO noticeVO = (NoticeVO) request.getAttribute(noticeVO);
%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>訊息資料修改 - update_notice_input.jsp</title>
</head>
<body bgcolor="white">

<table id="table-1">
    <tr>
        <td>
            <h3>訊息資料修改 - update_notice_input.jsp</h3>
            <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
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

<form method="post" action="NoticeController?delete" name="form1">
    <table>
        <tr>
            <td>會員通知編號:</td>
            <td><input type="TEXT" name="notNo" value="${param.notNo}" size="45" required="required"/></td>
            <td>${param.notNo}</td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="notNo" value="${param.notNo}">
    <input type="submit" value="送出刪除">
</form>
</body>
</html>
