<%@ page import="com.roger_hibernate.clicklike.vo.ClickLikeVO" %>
<%@ page import="com.roger_hibernate.clicklike.vo.ClickLikeVO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
    ClickLikeVO clickLikeVo = (ClickLikeVO) request.getAttribute("clickLikeVo");
    // EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
    <title>會員點讚資料 - listOneCL.jsp</title>

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
        <h3>會員點讚資料 - listOneCL.jsp</h3>
        <h4><a href="/clicklike/select_page.jsp"><img src="./images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>會員編號</th>
        <th>文章編號</th>
    </tr>

    <tr>
        <td>${clickLikeVo.memNo}</td>
        <td>${clickLikeVo.artNo}</td>
    </tr>
</table>

</body>
</html>