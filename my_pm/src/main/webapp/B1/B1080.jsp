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
${msg }
<br>
<br>
<!--${ins }-->
</br>
<form action="" method="post">
 <div class="edit">
   <table>
     <caption>
             记录详情
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">医疗记录</td>
     </tr>
      <tr>
       <td width="15%">姓名</td>
       <td width="35%">
         ${ins.truename }
       </td>
       <td width="15%">身份证</td>	
       <td width="35%">
        ${ins.idcard }
       </td>	
     </tr>
		 <tr>
		 	<td>性别</td>
		 	<td>
		 	 ${ins.cnsex }
		 	</td>
		 	<td>年龄</td>
		 	<td>
		 	${ins.age }
		 	</td>
		 </tr>
		 <tr>
		 	<td>民族</td>
		 	<td>
		 	  ${ins.cnnation }
		 	</td>
		 	<td>录入时间</td>
		 	<td>
		 	 ${ins.begintime }
		 	</td>
		 </tr>
		 <tr>
		 	<td>预约号</td>
		 	<td>
		 	  ${ins.onum }
		 	</td>
		 	<td>手机号</td>
		 	<td>
		 	${ins.phonenumber }
		 	</td>
		 </tr>
		  <tr>
		 	<td>医生嘱咐</td>
		 	<td colspan="3">
		 	  <e:textarea rows="3" cols="122" name="mdocsuggestion" defval="${ins.docsuggestion }"/>
		 	</td>
		 </tr>
		 <tr>
		 	<td>开药信息</td>
		 	<td colspan="3">
		 	  <e:textarea rows="5" cols="122" name="mdrugmsg" defval="${ins.drugmsg }"/>
		 	</td>
		 </tr>
		 <tr class="edit_button">
	       <td colspan="4">
	               
	                  <input type="submit" name="next" value="返回" 
	                 formaction="<%=path%>/b1061.htm?${ins.rid}">
	       </td>
	                
        </tr>
   </table>
 </div>

</form>
</body>
