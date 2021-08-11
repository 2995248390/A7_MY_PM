<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String path=request.getContextPath(); %>
<html>
<head>
   <title>Insert title here</title>
   <style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");</style>
   <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
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
<br>
 <c:choose >
		     <c:when test="${ins==null }">
		   δ¼������¼
		     </c:when>
		  
		     </c:choose>
<br>
<form action="" method="post">
 <div class="edit">
   <table>
     <caption>
             ��쵵��
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">ҽ�Ƽ�¼</td>
     </tr>
      <tr>
       <td width="15%">����</td>
       <td width="35%">
         ${ins.truename }
       </td>
       <td width="15%">������</td>	
       <td width="35%">
        ${ins.bid }
       </td>	
     </tr>
		 <tr>
		 	<td>�Ա�</td>
		 	<td>
		 	 ${ins.cnsex }
		 	</td>
		 	<td>����</td>
		 	<td>
		 	${ins.age }
		 	</td>
		 </tr>
		 <tr>
		 	<td>�ֻ���</td>
		 	<td>
		 	${ins.phonenumber }
		 	</td>
		 	<td>¼��ʱ��</td>
		 	<td>
		 	 ${ins.begintime }
		 	</td>
		 </tr>
		 <tr>
		 	<td>Ѫѹ</td>
		 	<td>
		 	  ${ins.blood }
		 	</td>
		 	<td>���</td>
		 	<td>
		 	${ins.height }
		 	</td>
		 </tr>
		   <tr>
		 	<td>����</td>
		 	<td>
		 	  ${ins.weight }
		 	</td>
		 	<td>�λ���</td>
		 	<td>
		 	${ins.airs }
		 	</td>
		 </tr>
		 <tr class="edit_button">
	       <td colspan="4">
	                 <input type="submit" name="next" value="����" 
	                 formaction="<%=path%>/b1061.htm">
	       </td>
        </tr>
   </table>
 </div>
 <input type="hidden" name="eid" value="${param.rid }">
</form>
</body>
