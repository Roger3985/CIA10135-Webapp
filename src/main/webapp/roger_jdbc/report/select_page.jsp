<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>IBM Report: Home</title>

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
    <tr><td><h3>IBM Report: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Report: Home</p>

<h3>檢舉文章資料查詢:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
    <font style="color:red">請修正以下錯誤:</font>
        <ul>
            <c:forEach var="message" items="${errorMsgs}">
                <li style="color:red">${message.value}</li>
            </c:forEach>
        </ul>
</c:if>

<ul>
    <li><a href='/report/listAllReport.jsp'>List</a> all Reports.  <br><br></li>


    <li>
        <FORM METHOD="post" ACTION="/report/ReportController" >
            <b>輸入檢舉文章編號(如1001):</b>
            <input type="text" name="reportNo" value="${param.reportNo}"><font color=red>${errorMsgs.reportNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <jsp:useBean id="reportService" scope="page" class="com.roger_hibernate.report.service.ReportService" />

    <li>
        <FORM METHOD="post" ACTION="/report/ReportController" >
            <b>選擇檢舉文章編號:</b>
            <select size="1" name="reportNo">
                <c:forEach var="reportVo" items="${reportService.all}">
                    <option value="${reportVo.reportNo}">${reportVo.reportNo}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>


    <li>
        <FORM METHOD="post" ACTION="/report/ReportController" >
            <b>選擇會員姓名:</b>
            <select size="1" name="artReplyNo">
                <c:forEach var="reportVo" items="${reportService.all}" >
                <option value="${reportVo.artReplyNo}">${reportVo.artReplyNo}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Name">
            <input type="submit" value="送出">
        </FORM>
    </li>

</ul>


<h3>回覆檢舉管理</h3>

<ul>
    <li><a href='/report/addReport.jsp'>新增回覆檢舉資料</a></li>
</ul>
<ul>
    <li><a href='/report/update_report_input.jsp'>修改回覆檢舉資料</a></li>
</ul>
<ul>
    <li><a href='/report/deleteReport.jsp'>刪除回覆檢舉資料</a></li>
</ul>
<ul>
    <li><a href='/report/listAllReport.jsp'>查詢全部回覆檢舉資料</a></li>
</ul>

</body>
</html>