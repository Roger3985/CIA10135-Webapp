<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>IBM Member: Home</title>

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
    <tr><td><h3>IBM Member: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Member: Home</p>

<h3>��Ƭd��:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
    <font style="color:red">�Эץ��H�U���~:</font>
        <ul>
            <c:forEach var="message" items="${errorMsgs}">
                <li style="color:red">${message.value}</li>
            </c:forEach>
        </ul>
</c:if>

<ul>
    <li><a href='/member/listAllMem.jsp'>List</a> all Members.  <br><br></li>


    <li>
        <FORM METHOD="post" ACTION="/member/MemberServlet" >
            <b>��J�|���s�� (�p1):</b>
            <input type="text" name="memNo" value="${param.memNo}"><font color=red>${errorMsgs.memNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

    <jsp:useBean id="memberService" scope="page" class="com.roger.member.service.MemberService" />

    <li>
        <FORM METHOD="post" ACTION="/member/MemberServlet" >
            <b>��ܷ|���s��:</b>
            <select size="1" name="memNo">
                <c:forEach var="memberVO" items="${memberService.all}" >
                <option value="${memberVO.memNo}">${memberVO.memNo}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="/member/MemberServlet" >
            <b>��ܷ|���m�W:</b>
            <select size="1" name="mName">
                <c:forEach var="memberVO" items="${memberService.all}" >
                <option value="${memberVO.mName}">${memberVO.mName}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Name">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="/member/MemberServlet" >
            <b>��ܷ|���b��:</b>
            <select size="1" name="memAcc">
                <c:forEach var="memberVO" items="${memberService.all}" >
                <option value="${memberVO.memAcc}">${memberVO.memAcc}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Account">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

</ul>


<h3>�|����ƺ޲z</h3>

<ul>
    <li><a href='/member/addMem.jsp'>�s�W�|�����</a></li>
</ul>
<ul>
    <li><a href='/member/update_member_input.jsp'>�ק�|�����</a></li>
</ul>
<ul>
    <li><a href='/member/deleteMem.jsp'>�R���|�����</a></li>
</ul>
<ul>
    <li><a href='/member/listAllMem.jsp'>�d�ߥ����|�����</a></li>
</ul>

</body>
</html>