<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>IBM ColumnReply: Home</title>

    <style>
        table#table-1 {
            width: 450px;
            background-color: #CCCCFF;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 3px ridge Gray;
            height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
    <tr><td><h3>IBM ColumnReply: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM ColumnReply: Home</p>

<h3>專欄文章回覆資料查詢:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
    <font style="color:red">請修正以下錯誤:</font>
        <ul>
            <c:forEach var="message" items="${errorMsgs}">
                <li style="color:red">${message.value}</li>
            </c:forEach>
        </ul>
<</c:if>

<ul>
    <li><a href='/columnreply/listAllCR.jsp'>List</a> all ColumnReplys.  <br><br></li>


    <li>
        <FORM METHOD="post" ACTION="/columnreply/ColumnReplyController" >
            <b>輸入會員通知編號 (如1):</b>
            <input type="text" name="columnReplyNo" value="${param.columnReplyNo}"><font color=red>${errorMsgs.columnReplyNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <jsp:useBean id="columnReplyService" scope="page" class="com.roger_hibernate.columnreply.service.ColumnReplyService" />

    <li>
        <FORM METHOD="post" ACTION="/columnreply/ColumnReplyController" >
            <b>選擇會員通知編號:</b>
            <select size="1" name="columnReplyNo">
                <c:forEach var="columnReplyVo" items="${columnReplyService.all}" >
                <option value="${columnReplyVo.columnReplyNo}">${columnReplyVo.columnReplyNo}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="/columnreply/ColumnReplyController" >
            <b>選擇通知編號:</b>
            <select size="1" name="memNo">
                <c:forEach var="noticeVO" items="${noticeService.all}" >
                <option value="${noticeVO.memNo}">${noticeVO.memNo}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

</ul>


<h3>專欄文章回覆管理</h3>

<ul>
    <li><a href='/columnreply/addCR.jsp'>新增專欄文章回覆</a></li>
</ul>
<ul>
    <li><a href='/columnreply/update_columnreply_input.jsp'>修改專欄文章回覆</a></li>
</ul>
<ul>
    <li><a href='/columnreply/deleteCR.jsp'>刪除專欄文章回覆</a></li>
</ul>
<ul>
    <li><a href='/columnreply/listAllCR.jsp'>查詢全部專欄文章回覆</a></li>
</ul>

</body>
</html>