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
  
  <script type="text/javascript">
	var t = new Date();//��ȡ��ǰʱ��
	var year = t.getFullYear();//��ȡ��ǰʱ�����
	var month = t.getMonth();//��ȡ��ǰʱ���·�
	var day = t.getDate();//��ȡ��ǰʱ����

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


<br>
<form action="" method="post">
 <div class="edit">
   <table>
     <caption>
             	�鿴����
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">������Ϣ</td>
     </tr>
     <tr>

       <td width="25%">�Һŵ���</td>
       <td width="25%">${ins.onum }</td>
       <td width="25%">���۷���</td>
	   <td width="25%">${ins.grade }</td>
     </tr>
	 <tr>
	 	<td><(�ޣ���)>��������</td>
	 	<td colspan="3">
	 	  <textarea rows="5" cols="115" disabled>${ins.text }</textarea>
	 	</td>
	 </tr>
	 <tr class="edit_button">
       <td colspan="4">
          <input type="submit" name="next" value="����"
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