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
<br>
<form action="" method="post">
 <div class="edit">
   <table>
     <caption>
             医疗记录
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">记录信息</td>
     </tr>
     <tr>
       <td width="25%">挂号单号：${ins.onum }</td>
       <td width="25%">预约时间：${ins.appointment }</td>
	   <td width="25%">姓名：${ins.username }</td>
	   <td width="25%">医生：${ins.docname }</td>
     </tr>
		 <tr>
		 	<td>药品信息</td>
		 	<td colspan="3">
		 	  <textarea rows="5" cols="115" disabled> ${ins.drugmsg }</textarea>
		 	</td>
		 </tr>
		 <tr>
		 	<td>医嘱</td>
		 	<td colspan="7">
		 		<textarea rows="5" cols="115" disabled>${ins.docsuggestion }</textarea>
		 	</td>
		 </tr>
		 <tr class="edit_button">
	       <td colspan="8">	           
               <input type="submit" name="next" value="返回"  
               		formnovalidate="formnovalidate"
               		formaction="<%=path %>/c1070.htm"
                           >
	       </td>
        </tr>
   </table>
 </div> 
</form>
</body>
</html>