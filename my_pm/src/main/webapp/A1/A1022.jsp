<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%String path=request.getContextPath(); %>
<html>
<head>
   <title>Insert title here</title>
   <style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");</style>
   <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
     <script type="text/javascript">
    let onEdit=function(puid){    	
    	let currForm=document.getElementById("myform");   	
    	currForm.action="<%=path%>/a1027.htm?did="+puid;    	
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
  <script type="text/javascript">
    function onNext1()
    { 
    	//alert("hello");
    	window.setTimeout("clearMsg()","10000");
    }
    function clearMsg()
    {
    	//ert("clear......");
    	document.getElementById("msg").innerHTML="";
    }
  </script>
</head>
<body onload="onNext1()">
<div id="msg" class="msg"></div>
${msg }

<br>
${msg2}
<br>
<form id="myform" action="" method="post">
 <div class="edit">
   <table>
     <caption>
             医生${empty param.uid?'添加':'修改' }
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">医生信息</td>
     </tr>
     <tr>
       <td width="15%">用户账号</td>
       <td width="35%">
         <input type = "text" name="maccount" value="${ins.account }"/>
       </td>
       <c:choose>
       <c:when test="${ins.account == null}">
       <td width="15%">用户密码</td>
       <td width="35%">                                
         <input type = "text" name="mupass" />
         </td>
         </c:when>
         <c:otherwise>
       <td width="15%">用户密码（不改则不填）</td>
       <td width="35%">
         <input type = "text" name="mupass" />
         </td>
         </c:otherwise>
       	
       </c:choose>
     </tr>
      <tr>
       <td width="15%">医生姓名</td>
       <td width="35%">
         <input type = "text" name="mtruename" value="${ins.truename }"/>
       </td>
       <td width="15%">身份证</td>	
       <td width="35%">
         <input type = "text" name="midcard" value="${ins.idcard }"/>
       </td>	
     </tr>
		 <tr>
		 	<td>性别</td>
		 	<td>
		 	  <c:choose>
							<c:when test = "${empty param.uid or ins.sex == '1' }">
								<input type = "radio" name="msex" value="1" checked="checked"/>男
								<input type = "radio" name="msex" value="2" />女
							</c:when>
							<c:otherwise>
								<input type = "radio" name="msex" value="1" />男
								<input type = "radio" name="msex" value="2" checked="checked" />女
							</c:otherwise>
						</c:choose>
		 	</td>
		 	<td>年龄</td>
		 	<td>
		 	  <input type = "text" name="mage" value="${ins.age }"/>
		 	</td>
		 </tr>
		 <tr>
		 	<td>民族</td>
		 	
		 	  <td>
		 	  			<select name="mnation">
							<c:forEach var = "nation" items = "${ocnation }" >
								<c:choose>
									<c:when test = "${ nation.value == ins.nation}">
										<option value="${nation.value}" selected="selected">${nation.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${nation.value}" >${nation.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
		 	
		 	<td>地区</td>
		 	<td>
		 	 <select name="mcommunity">
							<c:forEach var="community" items="${occommunity}">
								<c:choose>
									<c:when test = "${ community.value == ins.community}">
										<option value="${community.value}" selected="selected">${community.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${community.value}" >${community.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
		 	</td>
		 </tr>
		 <tr>
		 	<td>生日</td>
		 	<td>
		 	  <input type = "date" name="mbirthday" value="${ins.birthday }"/>
		 	</td>
		 	<td>手机号</td>
		 	<td>
		 	   <input type = "text" name="mphonenumber" value="${ins.phonenumber }"/>
		 	</td>
		 </tr>
		 <tr>
		 	<td>居住地址</td>
		 	<td>
		 	   <input type = "text" name="maddress" value="${ins.address }"/>
		 	</td>
		 	<td>邮箱</td>
		 	<td>
		 	   <input type = "text" name="mmail" value="${ins.mail }"/>
		 	</td>
		 </tr>
		 <tr>
		 <td> 医生等级</td>
		 <td>
		 <select name="mlevel">
    	<c:forEach var="level" items="${oclevel}">
								<c:choose>
									<c:when test = "${ level.value == ins.level}">
										<option value="${level.value}" selected="selected">${level.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${level.value}" >${level.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
    			</select>
		 </td>
		  <td> 从医时间</td>
		 <td>
		       <input type = "text" name="mworkyear" value="${ins.workyear }"/>
		 </td>
		 
		 </tr>
		  <tr>
		 <td> 诊所地址</td>
		 <td>
		         <input type = "text" name="mclinicaddress" value="${ins.clinicaddress }"/>
		 </td>
		  <td> 诊所名字</td>
		 <td>
		       <input type = "text" name="mclinicname" value="${ins.clinicname }"/>
		 </td>
		 
		 </tr>
		 <tr>
		 	<td>备注</td>
		 	<td colspan="3">
		 	  <textarea rows="5" cols="122" name="mmemo">${ins.memo }</textarea></td>		 	
		 </tr>
		 <tr>
		 	<td>医生描述</td>
		 	<td colspan="3">
		 	  <textarea rows="5" cols="122" name="mdescription"> ${ins.description } </textarea></td>
		 	
		 </tr>
		 <tr class="edit_button">
	       <td colspan="4">
	          <input type="submit" name="next" value="${empty param.uid?'添加':'修改' }" 
	                 formaction="<%=path%>/a102${empty param.uid?'3':'5' }.htm">
	          
	           
	               <input type="submit" name="next" value="返回"  
	                           formnovalidate="formnovalidate"
	                           formaction="<%=path %>/a1021.htm"
	                           >  
	           
	       </td>
        </tr>
   </table>
 </div>
  
 		<input type = "hidden" name="uid" value="${param.uid }">
		<input type = "hidden" name = "qname" value = "${param.qname }" >
		<input type = "hidden" name = "qidcard" value = "${param.qidcard }" >
		<input type = "hidden" name = "qsex" value = "${param.qsex }" >
		<input type = "hidden" name = "qnation" value = "${param.qnation }" >
		<input type = "hidden" name = "qage" value = "${param.qage }" >
		<input type = "hidden" name = "qcommunity" value = "${param.qcommunity }" >
		<input type = "hidden" name = "qaccount" value = "${param.qaccount }" >
 		<input type = "hidden" name = "query" value="${param.query }"/>

 
</form>
</body>
