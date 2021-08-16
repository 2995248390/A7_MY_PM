<%@ page language="java" pageEncoding="GBK"%>
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
  
  <script type="text/javascript">
	var t = new Date();//获取当前时间
	var year = t.getFullYear();//获取当前时间年份
	var month = t.getMonth();//获取当前时间月份
	var day = t.getDate();//获取当前时间日

	var nowTime = year+"-"+month+"-"+day;
  </script>


  <script>
	setInterval(function(){
		document.getElementById("time").innerHTML = new Date().toLocaleString();
	},1000)

  </script>


</head>
<body onload="onNext1()">
<div id="msg" class="msg"></div>
<span id="time"></span>
${msg }
<br>
${ins }


<br>
<form id="myform" action="" method="post">
 <div class="edit">
   <table>
     <caption>
             医疗记录表
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">病人信息</td>
     </tr>
     <tr>

       <td >预约号</td>
       <td >         
         <input type="text" name="onum" value="${onum }" disabled="disabled">
       </td>
     </tr>
	 <tr>
	 	<td>药品信息</td>
	 	<td colspan="4">
	 	  <textarea rows="5" cols="115" name="dramsg" required="required"></textarea>
	 	</td>
	 </tr>
	 <tr>
	 	<td>医嘱</td>
	 	<td colspan="4">
	 	  <textarea rows="5" cols="115" name="docsuggestion" required="required"></textarea>
	 	</td>
	 </tr>
	 <tr class="edit_button">
       <td colspan="4">
          <input type="submit" name="next" value="提交" 
                 formaction="<%=path%>/b1041.htm?thepath="2> 
         <input type="submit" name="next" value="返回"  
         		formnovalidate="formnovalidate"
         		formaction="<%=path %>/b1031.htm"
                     >                         
       </td>
       </tr>
   </table>
 </div>
 <input type="hidden" name="eid" value="${param.eid }">
 <input type="hidden" name="onum" value="${onum }">
 <input type="hidden" name="qeno" value="${qeno }">
 <e:hidden name="qeno"/>
</form>
</body>
</html>