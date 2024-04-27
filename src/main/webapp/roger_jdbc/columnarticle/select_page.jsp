<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>IBM ColumnArticle: Home</title>

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
    <tr><td><h3>IBM ColumnArticle: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM ColumnArticle: Home</p>

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
    <li><a href='/columnarticle/listAllCA.jsp'>List</a> all ColumnArticle.  <br><br></li>


    <li>
        <FORM METHOD="post" ACTION="/columnarticle/ColumnArticleController" >
            <b>��J�峹�s��:</b>
            <input type="text" name="artNo" value="${param.artNo}"><font color=red>${errorMsgs.artNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

    <jsp:useBean id="columnArticleService" scope="page" class="com.roger_hibernate.columnarticle.service.ColumnArticleService" />

    <li>
        <FORM METHOD="post" ACTION="/columnarticle/ColumnArticleController" >
            <b>��ܤ峹�s��:</b>
            <select size="1" name="artNo">
                <c:forEach var="columnArticleVo" items="${columnArticleService.all}" >
                <option value="${columnArticleVo.artNo}">${columnArticleVo.artNo}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

    <li>
        <FORM METHOD="post" ACTION="/columnarticle/ColumnArticleController" >
            <b>��ܳq���s��:</b>
            <select size="1" name="artNo">
                <c:forEach var="columnArticleVo" items="${columnArticleVoService.all}" >
                <option value="${columnArticleVo.artNo}">${columnArticleVo.artNo}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

</ul>


<h3>�q���T���޲z</h3>

<ul>
    <li><a href='/columnarticle/addCA.jsp'>�s�W�M��峹</a></li>
</ul>
<ul>
    <li><a href='/columnarticle/update_columnarticle_input.jsp'>�ק�M��峹</a></li>
</ul>
<ul>
    <li><a href='/columnarticle/deleteCA.jsp'>�R���M��峹</a></li>
</ul>
<ul>
    <li><a href='/columnarticle/listAllCA.jsp'>�d�ߥ����M��峹</a></li>
</ul>

</body>
</html>