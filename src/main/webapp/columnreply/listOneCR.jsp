<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.roger.member.vo.MemberVO"%>
<%@ page import="com.roger.columnreply.vo.ColumnReplyVO" %>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
    ColumnReplyVO columnReplyVo = (ColumnReplyVO) request.getAttribute("columnReplyVo");
    // EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
    <title>�M��峹�^�и�� - listOneCR.jsp</title>

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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
    <tr><td>
        <h3>�M��峹�^�и�� - listOneCR.jsp</h3>
        <h4><a href="select_page.jsp"><img src="./images/back.jpg" width="100" height="32" border="0">�^����</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>�峹�^�нs��</th>
        <th>�峹�s��</th>
        <th>�|���s��</th>
        <th>�d�����e</th>
        <th>�d���ɶ�</th>
        <th>�d�����A</th>

    </tr>
    <tr>
        <td>${columnReplyVo.columnReplyNo}</td>
        <td>${columnReplyVo.artNo}</td>
        <td>${columnReplyVo.memNo}</td>
        <td>${columnReplyVo.comContent}</td>
        <td>${columnReplyVo.comTime}</td>
        <td>${columnReplyVo.comStat}</td>
    </tr>
</table>

</body>
</html>