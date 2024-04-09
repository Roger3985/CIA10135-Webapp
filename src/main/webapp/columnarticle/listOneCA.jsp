<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
    // NoticeVO noticeVO = (NoticeVO) request.getAttribute("noticeVO");
    // EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
    <title>專欄文章資料 - listOneCA.jsp</title>

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
        <h3>專欄文章資料 - listOneCA.jsp</h3>
        <h4><a href="/columnarticle/listAllCA.jsp"><img src="./images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>文章編號</th>
        <th>管理員編號</th>
        <th>文章標題</th>
        <th>文章內容</th>
        <th>文章發表時間</th>
        <th>文章分類編號</th>
        <th>文章狀態</th>
    </tr>

    <tr>
        <td>${columnArticleVo.artNo}</td>
        <td>${columnArticleVo.admNo}</td>
        <td>${columnArticleVo.artTitle}</td>
        <td>${columnArticleVo.artContent}</td>
        <td>${columnArticleVo.artTime}</td>
        <td>${columnArticleVo.artCatNo}</td>
        <td>${columnArticleVo.artStat}</td>
    </tr>
</table>

</body>
</html>