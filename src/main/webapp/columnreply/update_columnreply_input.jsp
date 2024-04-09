<%@ page import="com.roger.member.vo.MemberVO" %>
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

<jsp:useBean id="columnReplyService" scope="page" class="com.roger.columnreply.service.ColumnReplyService" />

<form method="post" action="/columnreply/ColumnReplyController" name="form1">
    <table>
        <tr>
            <td>會員編號:</td>
            <td>
                <select size="1" name="memNo" style="width: 50px">
                    <c:forEach var="memberVO" items="${columnReplyService.all}">
                        <option value="${memberVO.memNo}">${memberVO.memNo}</option>
                    </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.memNo}</td>
        </tr>
        <tr>
            <td>會員姓名:</td>
            <td>
                <select size="1" name="mName">
                    <c:forEach var="memberVO" items="${memberService.all}" >
                    <option value="${memberVO.mName}">${memberVO.mName}
                        </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.mName}</td>
        </tr>
        <tr>
            <td>會員帳號:</td>
            <td>
                <select size="1" name="memAcc">
                    <c:forEach var="memberVO" items="${memberService.all}" >
                    <option value="${memberVO.memAcc}">${memberVO.memAcc}
                        </c:forEach>
                </select>
            </td>
            <td>${errorMsgs.memAcc}</td>
        </tr>
        <tr>
            <td>會員密碼:</td>
            <td><input name="memPwd" id="f_date1" type="text" ></td> <td>${errorMsgs.memPwd}</td>
        </tr>
        <tr>
            <td>手機號碼:</td>
            <td><input name="memMob" type="TEXT" value="${param.memMob}"   size="45"/></td> <td>${errorMsgs.memMob}</td>
        </tr>
        <tr>
            <td>性別:</td>
            <td><input type="TEXT" name="mGender" value="${param.mGender}"   size="45"/></td> <td>${errorMsgs.mGender}</td>
        </tr>
        <tr>
            <td>email:</td>
            <td><input type="TEXT" name="memMail" value="${param.memMail}"   size="45"/></td> <td>${errorMsgs.memMail}</td>
        </tr>
        <tr>
            <td>地址:</td>
            <td><input type="TEXT" name="memAdd" value="${param.memAdd}"   size="45"/></td> <td>${errorMsgs.memAdd}</td>
        </tr>
        <tr>
            <td>會員生日:</td>
            <td><input type="TEXT" name="memBd" value="${param.memBd}"   size="45"/></td> <td>${errorMsgs.memBd}</td>
        </tr>
        <tr>
            <td>信用卡:</td>
            <td><input type="TEXT" name="memCard" value="${param.memCard}"   size="45"/></td> <td>${errorMsgs.memCard}</td>
        </tr>
        <tr>
            <td>第三方平台:</td>
            <td><input type="TEXT" name="provider" value="${param.provider}"   size="45"/></td> <td>${errorMsgs.provider}</td>
        </tr>
        <tr>
            <td>第三方用戶資料:</td>
            <td><input type="TEXT" name="clientID" value="${param.clientID}"   size="45"/></td> <td>${errorMsgs.clientID}</td>
        </tr>
        <tr>
            <td>第三方平台顯示名稱:</td>
            <td><input type="TEXT" name="displayName" value="${param.displayName}"   size="45"/></td> <td>${errorMsgs.displayName}</td>
        </tr>
        <tr>
            <td>第三方API訪問令牌:</td>
            <td><input type="TEXT" name="accessToken" value="${param.accessToken}"   size="45"/></td> <td>${errorMsgs.accessToken}</td>
        </tr>
        <tr>
            <td>刷新訪問令牌的令牌:</td>
            <td><input type="TEXT" name="refreshToken" value="${param.refreshToken}"   size="45"/></td> <td>${errorMsgs.refreshToken}</td>
        </tr>
        <tr>
            <td>訪問令牌的過期時間:</td>
            <td><input type="TEXT" name="tknExpireTime" value="${param.tknExpireTime}"   size="45"/></td> <td>${errorMsgs.tknExpireTime}</td>
        </tr>
        <tr>
            <td>記錄第三方登入創建時間:</td>
            <td><input type="TEXT" name="creationTime" value="${param.creationTime}"   size="45"/></td> <td>${errorMsgs.creationTime}</td>
        </tr>
        <tr>
            <td>會員註冊完成時間:</td>
            <td><input type="TEXT" class="f_date1" name="memberJoinTime" value="${param.memberJoinTime}"   size="45"/></td> <td>${errorMsgs.memberJoinTime}</td>
        </tr>
        <tr>
            <td>帳號驗證狀態:</td>
            <td><input type="TEXT" name="memStat" value="${param.memStat}"   size="45"/></td> <td>${errorMsgs.memStat}</td>
        </tr>

    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="memNo" value="${param.memNo}">
    <input type="submit" value="送出修改">
</form>
</body>
</html>
