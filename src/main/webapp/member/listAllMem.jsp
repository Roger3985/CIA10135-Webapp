<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.*"%>
<%@ page import="com.roger.member.service.MemberService" %>
<%@ page import="com.roger.member.vo.MemberVO" %>

<%
    MemberService memberService = new MemberService();
    List<MemberVO> list = memberService.getAll();
    pageContext.setAttribute("list", list);
%>
<html>
<head>
    <title>所有會員註冊的資料 - listAllMEM.jsp</title>

    <style>
        table#table-1 {
            background-color: #CCCCFF;
            border: 2px solid black;
            text-align: center;
        }
        table#table-1 h4 {
            color: red;
            display: block;
            margin-bottom: 1px;
        }
        h4 {
            color: blue;
            display: inline;
        }
    </style>

    <style>
        table {
            width: 800px;
            background-color: white;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        table, th, td {
            border: 1px solid #CCCCFF;
        }
        th, td {

            padding: 5px;
            text-align: center;
        }
    </style>

</head>
<body bgcolor="white">

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
    <tr>
        <td>
            <h3>所有會員註冊的資料 - listAllMEM</h3>
            <h4><a href="../member/select_page.jsp"><img src="./images/back1.gif" width="100" height="32" border="0">回首頁</a> </h4>
        </td>
    </tr>
</table>

<table>
    <tr>
        <th>會員編號</th>
        <th>會員姓名</th>
        <th>會員帳號</th>
        <th>會員密碼</th>
        <th>手機號碼</th>
        <th>性別</th>
        <th>email</th>
        <th>地址</th>
        <th>會員生日</th>
        <th>信用卡</th>
        <th>第三方平台</th>
<%--        <th>第三方用戶資料</th>--%>
<%--        <th>第三方平台顯示名稱</th>--%>
<%--        <th>第三方API訪問令牌</th>--%>
<%--        <th>刷新訪問令牌的令牌</th>--%>
<%--        <th>訪問令牌的過期時間</th>--%>
<%--        <th>記錄第三方登入創建時間</th>--%>
<%--        <th>會員註冊完成時間</th>--%>
<%--        <th>帳號驗證狀態</th>--%>
<%--        <th>新增</th>--%>
<%--        <th>修改</th>--%>
        <th>刪除</th>
        <th>查詢</th>
    </tr>

    <c:forEach var="memberVO" items="${list}">
        <tr>
            <td>${memberVO.memNo}</td>
            <td>${memberVO.mName}</td>
            <td>${memberVO.memAcc}</td>
            <td>${memberVO.memPwd}</td>
            <td>${memberVO.memMob}</td>
            <td>${memberVO.mGender}</td>
            <td>${memberVO.memMail}</td>
            <td>${memberVO.memAdd}</td>
            <td>${memberVO.memBd}</td>
            <td>${memberVO.memCard}</td>
            <td>${memberVO.provider}</td>
<%--            <td>${memberVO.clientID}</td>--%>
<%--            <td>${memberVO.displayName}</td>--%>
<%--            <td>${memberVO.accessToken}</td>--%>
<%--            <td>${memberVO.refreshToken}</td>--%>
<%--            <td>${memberVO.tknExpireTime}</td>--%>
<%--            <td>${memberVO.creationTime}</td>--%>
<%--            <td>${memberVO.memberJoinTime}</td>--%>
<%--            <td>${memberVO.memStat}</td>--%>

<%--            <td>--%>
<%--                <form method="post" action="/member/MemberServlet" style="margin-bottom: 0px;">--%>
<%--                    <input type="submit" value="新增">--%>
<%--                    <input type="hidden" name="memNo"  value="${memberVO.memNo}">--%>
<%--                    <input type="hidden" name="action" value="insert"></form>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <form method="post" action="/member/MemberServlet" style="margin-bottom: 0px;">--%>
<%--                    <input type="submit" value="修改">--%>
<%--                    <input type="hidden" name="memNo"  value="${memberVO.memNo}">--%>
<%--                    <input type="hidden" name="action"	value="update"></form>--%>
<%--            </td>--%>
            <td>
                <form method="post" action="/member/MemberServlet" style="margin-bottom: 0px;" onsubmit="return confirm('確定要刪除這條通知嗎？');">
                    <input type="submit" value="刪除">
                    <input type="hidden" name="memNo"  value="${memberVO.memNo}">
                    <input type="hidden" name="action" value="delete"></form>
            </td>
            <td>
                <!--action 是請求資源-->
                <form method="post" action="/member/MemberServlet" style="margin-bottom: 0px;">
                    <input type="submit" value="查詢">
                    <input type="hidden" name="memNo"  value="${memberVO.memNo}">
                    <input type="hidden" name="action" value="getOne_For_Display"></form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
