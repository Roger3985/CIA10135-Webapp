<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>IBM Clicklike: Home</title>

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
    <tr><td><h3>IBM Clicklike: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Clicklike: Home</p>

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
    <li><a href='/clicklike/listAllCL.jsp'>List</a> all Clicklikes.  <br><br></li>


    <li>
        <FORM METHOD="post" ACTION="/clicklike/ClickLikeController" >
            <b>輸入會員編號 (如1):</b>
            <input type="text" name="memNo" value="${param.memNo}"><font color=red>${errorMsgs.memNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <jsp:useBean id="clicklikeService" scope="page" class="com.roger_hibernate.clicklike.service.ClickLikeService" />

    <li>
        <FORM METHOD="post" ACTION="/clicklike/ClickLikeController">
            <b>選擇會員編號:</b>
            <select size="1" name="memNo">
                <c:forEach var="clicklikeVo" items="${clicklikeService.all}" >
                <option value="${clicklikeVo.memNo}">${clicklikeVo.memNo}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>
</ul>


<h3>通知訊息管理</h3>

<ul>
    <li><a href='/clicklike/addCL.jsp'>新增點讚</a></li>
</ul>
<ul>
    <li><a href='/clicklike/update_clicklike_input.jsp'>修改點讚</a></li>
</ul>
<ul>
    <li><a href='/clicklike/deleteCL.jsp'>刪除點讚</a></li>
</ul>
<ul>
    <li><a href='/clicklike/listAllCL.jsp'>查詢全部點讚</a></li>
</ul>

</body>
</html>