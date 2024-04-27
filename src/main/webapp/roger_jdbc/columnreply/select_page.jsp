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

<h3>�M��峹�^�и�Ƭd��:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
    <font style="color:red">�Эץ��H�U���~:</font>
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
            <b>��J�|���q���s�� (�p1):</b>
            <input type="text" name="columnReplyNo" value="${param.columnReplyNo}"><font color=red>${errorMsgs.columnReplyNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

    <jsp:useBean id="columnReplyService" scope="page" class="com.roger_hibernate.columnreply.service.ColumnReplyService" />

    <li>
        <FORM METHOD="post" ACTION="/columnreply/ColumnReplyController" >
            <b>��ܷ|���q���s��:</b>
            <select size="1" name="columnReplyNo">
                <c:forEach var="columnReplyVo" items="${columnReplyService.all}" >
                <option value="${columnReplyVo.columnReplyNo}">${columnReplyVo.columnReplyNo}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="/columnreply/ColumnReplyController" >
            <b>��ܳq���s��:</b>
            <select size="1" name="memNo">
                <c:forEach var="noticeVO" items="${noticeService.all}" >
                <option value="${noticeVO.memNo}">${noticeVO.memNo}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

</ul>


<h3>�M��峹�^�к޲z</h3>

<ul>
    <li><a href='/columnreply/addCR.jsp'>�s�W�M��峹�^��</a></li>
</ul>
<ul>
    <li><a href='/columnreply/update_columnreply_input.jsp'>�ק�M��峹�^��</a></li>
</ul>
<ul>
    <li><a href='/columnreply/deleteCR.jsp'>�R���M��峹�^��</a></li>
</ul>
<ul>
    <li><a href='/columnreply/listAllCR.jsp'>�d�ߥ����M��峹�^��</a></li>
</ul>

</body>
</html>