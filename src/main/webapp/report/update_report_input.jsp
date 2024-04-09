<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // NoticeVO noticeVO = (NoticeVO) request.getAttribute(noticeVO);
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>回覆檢舉資料修改 - update_report_input.jsp</title>
</head>
<body bgcolor="white">

<table id="table-1">
    <tr>
        <td>
            <h3>回覆檢舉資料修改 - update_report_input.jsp</h3>
            <h4><a href="/report/select_page.jsp"><img src="./images/back.jpg" width="100" height="32" border="0">回首頁</a></h4>
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

<form method="post" action="/report/ReportController" name="form1">
    <table>
        <tr>
            <td>檢舉文章編號:</td>
            <td><input type="TEXT" name="reportNo" value="${param.reportNo}" size="45"/></td> <td>${errorMsgs.reportNo}</td>
        </tr>
        <tr>
            <td>文章回覆編號:</td>
            <td><input type="TEXT" name="artReplyNo" value="${param.artReplyNo}" size="45"/></td> <td>${errorMsgs.artReplyNo}</td>
        </tr>
        <tr>
            <td>會員編號:</td>
            <td><input type="TEXT" name="memNo"   value="${param.memNo}"   size="45"/></td> <td>${errorMsgs.memNo}</td>
        </tr>
        <tr>
            <td>管理員編號:</td>
            <td><input name="admNo" id="f_date1" type="text" ></td> <td>${errorMsgs.admNo}</td>
        </tr>
        <tr>
            <td>檢舉時間:</td>
            <td><input name="reportTime" type="TEXT" value="${param.reportTime}"   size="45"/></td> <td>${errorMsgs.reportTime}</td>
        </tr>
        <tr>
            <td>檢舉原因:</td>
            <td><input type="TEXT" name="reportReason" value="${param.reportReason}"   size="45"/></td> <td>${errorMsgs.reportReason}</td>
        </tr>
        <tr>
            <td>留言檢舉狀態:</td>
            <td><input type="TEXT" name="reportType" value="${param.reportType}"   size="45"/></td> <td>${errorMsgs.reportType}</td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="motNo" value="${param.reportNo}">
    <input type="submit" value="送出修改">
</form>
</body>
</html>
