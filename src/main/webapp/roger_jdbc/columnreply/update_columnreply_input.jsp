<%@ page import="com.roger_hibernate.member.vo.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    // MemberVO memberVO = (MemberVO) request.getAttribute(MemberVO);
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>專欄文章回覆修改 - update_columnreply_input.jsp</title>
</head>
<body bgcolor="white">

<table id="table-1">
    <tr>
        <td>
            <h3>專欄文章回覆修改 - update_columnreply_input.jsp</h3>
            <h4><a href="/columnreply/select_page.jsp"><img src="./images/back.jpg" width="100" height="32" border="0">回首頁</a></h4>
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

<jsp:useBean id="columnReplyService" scope="page" class="com.roger_hibernate.columnreply.service.ColumnReplyService" />

<form method="post" action="/columnreply/ColumnReplyController" name="form1">
    <table>
        <tr>
            <td>文章回覆編號:</td>
            <td>
                <select size="1" name="columnReplyNo" style="width: 50px">
                    <c:forEach var="columnReplyVo" items="${columnReplyService.all}">
                        <option value="${columnReplyVo.columnReplyNo}">${columnReplyVo.columnReplyNo}</option>
                    </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.memNo}</td>
        </tr>
        <tr>
            <td>文章編號:</td>
            <td>
                <select size="1" name="artNo">
                    <c:forEach var="columnReplyVo" items="${columnReplyService.all}" >
                    <option value="${columnReplyVo.artNo}">${columnReplyVo.artNo}
                    </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.artNo}</td>
        </tr>
        <tr>
            <td>會員編號:</td>
            <td>
                <select size="1" name="memNo">
                    <c:forEach var="columnReplyVo" items="${columnReplyService.all}" >
                    <option value="${columnReplyVo.memNo}">${columnReplyVo.memNo}
                    </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.memAcc}</td>
        </tr>
        <tr>
            <td>留言內容:</td>
            <td><input name="memPwd" id="f_date1" type="text" ></td> <td>${errorMsgs.memPwd}</td>
        </tr>
        <tr>
            <td>留言時間:</td>
            <td><input name="memMob" type="TEXT" value="${param.memMob}"   size="45"/></td> <td>${errorMsgs.memMob}</td>
        </tr>
        <tr>
            <td>留言狀態:</td>
            <td><input type="TEXT" name="mGender" value="${param.mGender}"   size="45"/></td> <td>${errorMsgs.mGender}</td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="columnReplyNo" value="${param.columnReplyNo}">
    <input type="submit" value="送出修改">
</form>
</body>
</html>
