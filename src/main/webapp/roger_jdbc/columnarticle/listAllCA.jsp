<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.*"%>
<%@ page import="com.roger_hibernate.columnarticle.service.ColumnArticleService" %>
<%@ page import="com.roger_hibernate.columnarticle.vo.ColumnArticleVO" %>

<%
    ColumnArticleService columnArticleService = new ColumnArticleService();
    List<ColumnArticleVO> list = columnArticleService.getAll();
    pageContext.setAttribute("list", list);
%>
<html>
<head>
    <title>所有專欄文章的資料 - listAllCA.jsp</title>

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
            <h3>所有專欄文章的資料 - listAllCA.jsp</h3>
            <h4><a href="/columnarticle/select_page.jsp"><img src="./images/back1.gif" width="100" height="32" border="0">回首頁</a> </h4>
        </td>
    </tr>
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
        <th>新增</th>
        <th>修改</th>
        <th>刪除</th>
        <th>查詢</th>
    </tr>

    <c:forEach var="columnArticleVo" items="${list}">
        <tr>
            <td>${columnArticleVo.artNo}</td>
            <td>${columnArticleVo.admNo}</td>
            <td>${columnArticleVo.artTitle}</td>
            <td>${columnArticleVo.artContent}</td>
            <td>${columnArticleVo.artTime}</td>
            <td>${columnArticleVo.artCatNo}</td>
            <td>${columnArticleVo.artStat}</td>

            <td>
                <form method="post" action="/columnarticle/ColumnArticleController" style="margin-bottom: 0px;">
                    <input type="submit" value="新增">
                    <input type="hidden" name="artNo"  value="${columnArticleVo.artNo}">
                    <input type="hidden" name="action" value="getOne_For_Insert"></form>
            </td>
            <td>
                <form method="post" action="/columnarticle/ColumnArticleController" style="margin-bottom: 0px;">
                    <input type="submit" value="修改">
                    <input type="hidden" name="artNo"  value="${columnArticleVo.artNo}">
                    <input type="hidden" name="action"	value="getOne_For_Update"></form>
            </td>
            <td>
                <form method="post" action="/columnarticle/ColumnArticleController" style="margin-bottom: 0px;" onsubmit="return confirm('確定要刪除這條通知嗎？');">
                    <input type="submit" value="刪除">
                    <input type="hidden" name="artNo"  value="${columnArticleVo.artNo}">
                    <input type="hidden" name="action" value="delete"></form>
            </td>
            <td>
                <form method="post" action="/columnarticle/ColumnArticleController" style="margin-bottom: 0px;">
                    <input type="submit" value="查詢">
                    <input type="hidden" name="artNo"  value="${columnArticleVo.artNo}">
                    <input type="hidden" name="action" value="getOne_For_Display"></form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
