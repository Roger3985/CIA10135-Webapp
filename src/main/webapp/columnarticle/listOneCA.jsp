<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
    // NoticeVO noticeVO = (NoticeVO) request.getAttribute("noticeVO");
    // EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
    <title>�M��峹��� - listOneCA.jsp</title>

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
        <h3>�M��峹��� - listOneCA.jsp</h3>
        <h4><a href="/columnarticle/listAllCA.jsp"><img src="./images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
    </td></tr>
</table>

<table>
    <tr>
        <th>�峹�s��</th>
        <th>�޲z���s��</th>
        <th>�峹���D</th>
        <th>�峹���e</th>
        <th>�峹�o��ɶ�</th>
        <th>�峹�����s��</th>
        <th>�峹���A</th>
    </tr>

    <tr>
        <td>${columnArticleVo.artNo}</td>
        <td>${columnArticleVo.admNo}</td>
        <td>${columnArticleVo.artTitle}</td>
        <td>${columnArticleVo.artContent}</td>
        <td>${columnArticleVo.artTime}</td>
        <td>${columnArticleVo.artCatNo}</td>
        <td>${columnArticleVo.artStat}</td>
    </tr>
</table>

</body>
</html>