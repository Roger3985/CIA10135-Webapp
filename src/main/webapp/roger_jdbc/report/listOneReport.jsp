<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.roger_hibernate.notice.vo.NoticeVO"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
    // NoticeVO noticeVO = (NoticeVO) request.getAttribute("noticeVO");
    // EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
    <title>檢舉文章資料 - listOneReport.jsp</title>

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
        <h3>檢舉文章資料 - listOneReport.jsp</h3>
        <h4><a href="/report/select_page.jsp"><img src="./images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>檢舉文章編號</th>
        <th>文章回覆編號</th>
        <th>會員編號</th>
        <th>管理員編號</th>
        <th>檢舉時間</th>
        <th>檢舉原因</th>
        <th>留言檢舉狀態</th>
    </tr>

    <tr>
        <td>${reportVo.reportNo}</td>
        <td>${reportVo.artReplyNo}</td>
        <td>${reportVo.memNo}</td>
        <td>${reportVo.admNo}</td>
        <td>${reportVo.reportTime}</td>
        <td>${reportVo.reportReason}</td>
        <td>${reportVo.reportType}</td>

    </tr>
</table>

</body>
</html>