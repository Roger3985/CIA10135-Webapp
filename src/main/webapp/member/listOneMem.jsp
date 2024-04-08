<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.roger.member.vo.MemberVO"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
    MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
    // EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
    <title>�|����� - listOneMem.jsp</title>

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
        <h3>�|����� - listOneMem.jsp</h3>
        <h4><a href="select_page.jsp"><img src="./images/back.jpg" width="100" height="32" border="0">�^����</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>�|���s��</th>
        <th>�|���m�W</th>
        <th>�|���b��</th>
        <th>�|���K�X</th>
        <th>������X</th>
        <th>�ʧO</th>
        <th>email</th>
        <th>�a�}</th>
        <th>�|���ͤ�</th>
        <th>�H�Υd</th>
        <th>�ĤT�襭�x</th>
        <%--        <th>�ĤT��Τ���</th>--%>
        <%--        <th>�ĤT�襭�x��ܦW��</th>--%>
        <%--        <th>�ĤT��API�X�ݥO�P</th>--%>
        <%--        <th>��s�X�ݥO�P���O�P</th>--%>
        <%--        <th>�X�ݥO�P���L���ɶ�</th>--%>
        <%--        <th>�O���ĤT��n�J�Ыخɶ�</th>--%>
        <%--        <th>�|�����U�����ɶ�</th>--%>
        <%--        <th>�b�����Ҫ��A</th>--%>
    </tr>
    <tr>
        <td>${memberVO.memNo}</td>
        <td>${memberVO.mName}</td>
        <td>${memberVO.memAcc}</td>
        <td>${memberVO.memPwd}</td>
        <td>${memberVO.memMob}</td>
        <td>${memberVO.mGender}</td>
        <td>${memberVO.memMail}</td>
        <td>${memberVO.memAdd}</td>
        <td>${memberVO.memBd}</td>
        <td>${memberVO.memCard}</td>
        <td>${memberVO.provider}</td>
        <%--            <td>${memberVO.clientID}</td>--%>
        <%--            <td>${memberVO.displayName}</td>--%>
        <%--            <td>${memberVO.accessToken}</td>--%>
        <%--            <td>${memberVO.refreshToken}</td>--%>
        <%--            <td>${memberVO.tknExpireTime}</td>--%>
        <%--            <td>${memberVO.creationTime}</td>--%>
        <%--            <td>${memberVO.memberJoinTime}</td>--%>
        <%--            <td>${memberVO.memStat}</td>--%>
    </tr>
</table>

</body>
</html>