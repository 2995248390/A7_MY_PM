<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
${msg }
<br>
${ins }
<br>
<form action="" method="post">
 <div class="edit">
   <table>
     <caption>
             ҽ�Ƽ�¼
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">��¼��Ϣ</td>
     </tr>
     <tr>
       <td width="15%">��¼����</td>
       <td width="35%">
         ${ins.rid }
       </td>
       <td width="15%">�û�����</td>
       <td width="35%">
         ${ins.truename }
       </td>
     </tr>
		 <tr>
		 	<td>����ҽ��</td>
			<td>${ins.doc }</td>
		 <td>��¼����</td>
		 	<td>
		 	  ${ins.begintime }	 	
		 </tr>
		 <tr>
		 	<td>ҩƷ��Ϣ</td>
		 	<td colspan="3">
		 	  ${ins.drugmsg }
		 	</td>
		 </tr>
		 <tr>
		 	<td>ҽ��</td>
		 	<td colspan="3">
		 	  <p>${ins.docsuggestion }
		 	  </p>
		 	</td>
		 </tr>
		 <tr class="edit_button">
	       <td colspan="4">
	          <input type="submit" name="next" value="ɾ��" 
	                 formaction="<%=path%>/a1033.htm">
	           
	               <input type="submit" name="next" value="����"  
	               		formnovalidate="formnovalidate"
	               		formaction="<%=path %>/a1031.htm"
	                           >
	       </td>
        </tr>
   </table>
 </div>
 <input type="hidden" name="rid" value="${ins.rid }">
 <e:hidden name=""/>
 <e:hidden name="qename"/>
 <e:hidden name="qsex"/>
 <e:hidden name="qnation"/>
 <e:hidden name="qjob"/>
 <e:hidden name="bsal"/>
 <e:hidden name="esal"/>
 <e:hidden name="query"/>
 
</form>
</body>
</html>