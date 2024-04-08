<%@ page import="com.roger.member.vo.MemberVO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
  MemberVO memberVO = (MemberVO) request.getAttribute("memberVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>會員資料新增 - addMem.jsp</title>

<style>
  table#table-1 {
    width: 450px;
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
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>會員資料新增 - addEmpMem.jsp</h3></td><td>
		 <h4><a href="../notice/select_page.jsp"><img src="../images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message.value}</li>
		</c:forEach>
	</ul>
</c:if>

<jsp:useBean id="memberService" scope="page" class="com.roger.member.service.MemberService" />

<FORM METHOD="post" ACTION="/member/MemberServlet" name="form1">
<table>
	<td>會員編號:</td>
	<td>
		<select size="1" name="memNo" style="width: 50px">
			<c:forEach var="memberVO" items="${memberService.all}">
				<option value="${memberVO.memNo}">${memberVO.memNo}</option>
			</c:forEach>
		</select>
	</td>
	<td>${errorMsgs.memNo}</td>
	</tr>
	<tr>
		<td>會員姓名:</td>
		<td>
			<select size="1" name="mName">
				<c:forEach var="memberVO" items="${memberService.all}" >
				<option value="${memberVO.mName}">${memberVO.mName}
					</c:forEach>
			</select>
		</td>
		<td>${errorMsgs.mName}</td>
	</tr>
		<td>會員密碼:</td>
		<td><input name="memPwd" id="f_date1" type="text" ></td> <td>${errorMsgs.memPwd}</td>
	</tr>
	<tr>
		<td>手機號碼:</td>
		<td><input name="memMob" type="TEXT" value="${param.memMob}"   size="45"/></td> <td>${errorMsgs.memMob}</td>
	</tr>
	<tr>
		<td>性別:</td>
		<td><input type="TEXT" name="mGender" value="${param.mGender}"   size="45"/></td> <td>${errorMsgs.mGender}</td>
	</tr>
	<tr>
		<td>email:</td>
		<td><input type="TEXT" name="memMail" value="${param.memMail}"   size="45"/></td> <td>${errorMsgs.memMail}</td>
	</tr>
	<tr>
		<td>地址:</td>
		<td><input type="TEXT" name="memAdd" value="${param.memAdd}"   size="45"/></td> <td>${errorMsgs.memAdd}</td>
	</tr>
	<tr>
		<td>會員生日:</td>
		<td><input type="TEXT" name="memBd" value="${param.memBd}"   size="45"/></td> <td>${errorMsgs.memBd}</td>
	</tr>
	<tr>
		<td>信用卡:</td>
		<td><input type="TEXT" name="memCard" value="${param.memCard}"   size="45"/></td> <td>${errorMsgs.memCard}</td>
	</tr>
	<tr>
		<td>第三方平台:</td>
		<td><input type="TEXT" name="provider" value="${param.provider}"   size="45"/></td> <td>${errorMsgs.provider}</td>
	</tr>
	<tr>
		<td>第三方用戶資料:</td>
		<td><input type="TEXT" name="clientID" value="${param.clientID}"   size="45"/></td> <td>${errorMsgs.clientID}</td>
	</tr>
	<tr>
		<td>第三方平台顯示名稱:</td>
		<td><input type="TEXT" name="displayName" value="${param.displayName}"   size="45"/></td> <td>${errorMsgs.displayName}</td>
	</tr>
	<tr>
		<td>第三方API訪問令牌:</td>
		<td><input type="TEXT" name="accessToken" value="${param.accessToken}"   size="45"/></td> <td>${errorMsgs.accessToken}</td>
	</tr>
	<tr>
		<td>刷新訪問令牌的令牌:</td>
		<td><input type="TEXT" name="refreshToken" value="${param.refreshToken}"   size="45"/></td> <td>${errorMsgs.refreshToken}</td>
	</tr>
	<tr>
		<td>訪問令牌的過期時間:</td>
		<td><input type="TEXT" name="tknExpireTime" value="${param.tknExpireTime}"   size="45"/></td> <td>${errorMsgs.tknExpireTime}</td>
	</tr>
	<tr>
		<td>記錄第三方登入創建時間:</td>
		<td><input type="TEXT" name="creationTime" value="${param.creationTime}"   size="45"/></td> <td>${errorMsgs.creationTime}</td>
	</tr>
	<tr>
		<td>會員註冊完成時間:</td>
		<td><input type="TEXT" class="f_date1" name="memberJoinTime" value="${param.memberJoinTime}"   size="45"/></td> <td>${errorMsgs.memberJoinTime}</td>
	</tr>
	<tr>
		<td>帳號驗證狀態:</td>
		<td><input type="TEXT" name="memStat" value="${param.memStat}"   size="45"/></td> <td>${errorMsgs.memStat}</td>
	</tr>

<%--	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />--%>
<%--	<tr>--%>
<%--		<td>部門:<font color=red><b>*</b></font></td>--%>
<%--		<td><select size="1" name="deptno">--%>
<%--			<c:forEach var="deptVO" items="${deptSvc.all}">--%>
<%--				<option value="${deptVO.deptno}" ${(param.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname}--%>
<%--			</c:forEach>--%>
<%--		</select></td>--%>
<%--	</tr>--%>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<% 
  java.sql.Date hiredate = null;
  try {
	    hiredate = java.sql.Date.valueOf(request.getParameter("hiredate").trim());
   } catch (Exception e) {
	    hiredate = new java.sql.Date(System.currentTimeMillis());
   }
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
 	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=hiredate%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        
        
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

        //      1.以下為某一天之前的日期無法選擇
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
</script>
</html>