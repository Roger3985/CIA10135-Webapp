<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>IBM ArticleCollection: Home</title>

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

<p>This is the Home page for IBM ArticleCollection: Home</p>

<h3>��Ƭd��:</h3>

<%-- ���~��C --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">�Эץ��H�U���~:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<ul>
    <li><a href='/articlecollection/listAllAC.jsp'>List</a> all ArticleCollections.  <br><br></li>


    <li>
        <FORM METHOD="post" ACTION="/articlecollection/ArticleCollectionController" >
            <b>��J�|���s�� (�p1):</b>
            <input type="text" name="memNo" value="${param.memNo}"><font color=red>${errorMsgs.memNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>

    <jsp:useBean id="articleCollectionService" scope="page" class="com.roger.articlecollection.service.ArticleCollectionService" />

    <li>
        <FORM METHOD="post" ACTION="/clicklike/ClickLikeController">
            <b>��ܷ|���s��:</b>
            <select size="1" name="memNo">
                <c:forEach var="articleCollectionVo" items="${articleCollectionService.all}" >
                <option value="${articleCollectionVo.memNo}">${articleCollectionVo.memNo}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>
</ul>


<h3>�峹���ú޲z</h3>

<ul>
    <li><a href='/articlecollection/addAC.jsp'>�s�W�峹����</a></li>
</ul>
<ul>
    <li><a href='/articlecollection/update_articlecollection_input.jsp'>�ק�峹����</a></li>
</ul>
<ul>
    <li><a href='/articlecollection/deleteAC.jsp'>�R���峹����</a></li>
</ul>
<ul>
    <li><a href='/articlecollection/listAllAC.jsp'>�d�ߥ����峹����</a></li>
</ul>

</body>
</html>