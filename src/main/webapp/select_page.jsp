<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>IBM Notice: Home</title>

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
    <tr><td><h3>IBM Notice: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Notice: Home</p>

<h3>資料查詢:</h3>

<%-- 錯誤表列 --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<ul>
    <li><a href='listAllNO.jsp'>List</a> all Notices.  <br><br></li>


    <li>
        <FORM METHOD="post" ACTION="NoticeController" >
            <b>輸入會員通知編號 (如1):</b>
            <input type="text" name="motNo" value="${param.motNo}"><font color=red>${errorMsgs.motNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <jsp:useBean id="noticeService" scope="page" class="service.NoticeService" />

    <li>
        <FORM METHOD="post" ACTION="NoticeController" >
            <b>選擇會員通知編號:</b>
            <select size="1" name="motNo">
                <c:forEach var="noticeVO" items="${noticeService.all}" >
                <option value="${noticeVO.motNo}">${noticeVO.motNo}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="NoticeController" >
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


<h3>通知訊息管理</h3>

<ul>
    <li><a href='addNO.jsp'>新增訊息</a></li>
</ul>
<ul>
    <li><a href='update_notice_input.jsp'>修改通知訊息</a></li>
</ul>
<ul>
    <li><a href='deleteNO.jsp'>刪除通知訊息</a></li>
</ul>
<ul>
    <li><a href='listAllNO.jsp'>查詢全部通知訊息</a></li>
</ul>

</body>
</html>