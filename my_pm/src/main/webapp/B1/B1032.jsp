<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%String path=request.getContextPath(); %>
<html>
<head>
	<title>Insert title here</title>
	<style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");</style>
    <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
</head>
<body onload="onNext1()">
<div id="msg" class="msg"></div>
<br>
${ins }
<br>
<form action="" method="post">
 <div class="edit">
	${msg }
   <table>
     <caption>
             �û�����¼
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">��¼��Ϣ</td>
     </tr>
     <tr>
       <td width="15%">����</td>
       <td width="35%">
         ${ins.truename }
       </td>
       <td width="15%">�Ա�</td>
       <td width="35%">
         ${ins.sex }
       </td>
     </tr>
		 <tr>
		 	<td>�λ���</td>
			<td>${ins.airs }</td>
		 	<td>����</td>
		 	<td>
		 	  ${ins.pulse }
		 	</td>	 	
		 </tr>
		 <tr>
		 	<td>����</td>
			<td>${ins.weight }</td>
		 	<td>���</td>
		 	<td>
		 	  ${ins.height }	
		 	</td> 	
		 </tr>
		 <tr>
		 	<td>Ѫѹ</td>
			<td>${ins.blood }</td>
		 	<td>¼��ʱ��</td>
		 	<td>
		 	  ${ins.begintime }	
		 	</td> 	
		 </tr>		 
		 <tr class="edit_button">
	       <td colspan="4">
	          <input type="submit" name="next" value="����"  
	               		formnovalidate="formnovalidate"
	               		formaction="<%=path %>/b1031.htm"
	                           >
	       </td>
        </tr>
   </table>
 </div>
 <input type="hidden" name="rid" value="${ins.rid }">
 <e:hidden name=""/>

</form>
</body>
</html>