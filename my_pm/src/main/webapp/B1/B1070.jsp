<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
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

<br>
<form action="" method="post">
 <div class="edit">
   <table>
     <caption>
             �Һŵ�����
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">�Һŵ���Ϣ</td>
     </tr>
      <tr>
       <td width="15%">����</td>
       <td width="35%">
         ${ins.truename }
       </td>
       <td width="15%">���֤</td>	
       <td width="35%">
        ${ins.idcard }
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
		 	<td>����</td>
		 	<td>
		 	  ${ins.cnnation }
		 	</td>
		 	<td>ҽ������</td>
		 	<td>
		 	 ${ins2.truename }
		 	</td>
		 </tr>
		 <tr>
		 	<td>ԤԼ��</td>
		 	<td>
		 	  ${ins.onum }
		 	</td>
		 	<td>�ֻ���</td>
		 	<td>
		 	${ins.phonenumber }
		 	</td>
		 </tr>
		  <tr>
		 	<td>����ʱ��</td>
		 	<td>${ins.begintime }</td>
		 	<td>���ʱ��</td>
		 <td>${ins.overtime}</td>
		 </tr>
		
		 <tr class="edit_button">
	       <td colspan="4">
	                 <input type="submit" name="next" value="����" 
	                 formaction="<%=path%>/b1061.htm?">
	       </td>
        </tr>
   </table>
 </div>
 <input type="hidden" name="eid" value="${param.rid }">
</form>
</body>
