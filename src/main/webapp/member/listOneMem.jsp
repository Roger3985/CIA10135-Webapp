<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.roger.member.vo.MemberVO"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
    MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
    // EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
    <title>會員資料 - listOneMem.jsp</title>

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
            width: 600px;
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
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
    <tr><td>
        <h3>會員資料 - listOneMem.jsp</h3>
        <h4><a href="select_page.jsp"><img src="./images/back.jpg" width="100" height="32" border="0">回首頁</a></h4>
    </td></tr>
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
    </tr>
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
    </tr>
</table>

</body>
</html>