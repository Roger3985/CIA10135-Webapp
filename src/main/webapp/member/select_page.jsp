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

<h3>資料查詢:</h3>

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
    <li><a href='/member/listAllMem.jsp'>List</a> all Members.  <br><br></li>


    <li>
        <FORM METHOD="post" ACTION="/member/MemberServlet" >
            <b>輸入會員編號 (如1):</b>
            <input type="text" name="memNo" value="${param.memNo}"><font color=red>${errorMsgs.memNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <jsp:useBean id="memberService" scope="page" class="com.roger.member.service.MemberService" />

    <li>
        <FORM METHOD="post" ACTION="/member/MemberServlet" >
            <b>選擇會員編號:</b>
            <select size="1" name="memNo">
                <c:forEach var="memberVO" items="${memberService.all}" >
                <option value="${memberVO.memNo}">${memberVO.memNo}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="/member/MemberServlet" >
            <b>選擇會員姓名:</b>
            <select size="1" name="mName">
                <c:forEach var="memberVO" items="${memberService.all}" >
                <option value="${memberVO.mName}">${memberVO.mName}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Name">
            <input type="submit" value="送出">
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="/member/MemberServlet" >
            <b>選擇會員帳號:</b>
            <select size="1" name="memAcc">
                <c:forEach var="memberVO" items="${memberService.all}" >
                <option value="${memberVO.memAcc}">${memberVO.memAcc}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Account">
            <input type="submit" value="送出">
        </FORM>
    </li>

</ul>


<h3>會員資料管理</h3>

<ul>
    <li><a href='/member/addMem.jsp'>新增會員資料</a></li>
</ul>
<ul>
    <li><a href='/member/update_member_input.jsp'>修改會員資料</a></li>
</ul>
<ul>
    <li><a href='/member/deleteMem.jsp'>刪除會員資料</a></li>
</ul>
<ul>
    <li><a href='/member/listAllMem.jsp'>查詢全部會員資料</a></li>
</ul>

</body>
</html>