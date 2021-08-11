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
<form action="" method="post">
 <div class="edit">
   <table>
     <caption>
             ҽ�Ƽ�¼
        <hr>
     </caption>
     <tr class="title">
       <td colspan="4">��ϸ��Ϣ</td>
     </tr>
     <tr>
       <td width="25%">�Һŵ���</td>
       <td width="25%">${ins.onum }</td>
       <td width="25%">���۷�����0-10��</td>
	   <td width="25%"><e:number  name="qgrade" step="0" defval="6" /></td>
     </tr>
	 <tr>
	 	<td><(�ޣ���)>���۴˴ξ���</td>
	 	<td colspan="3">
	 	  <e:textarea rows="5" cols="115" name="qtext" defval=""/>
	 	</td>
	 </tr>
	 <tr class="edit_button">
       <td colspan="4">
          <input type="submit" name="next" value="�ύ" 
                 formaction="<%=path%>/c1071.htm?thepath=3">
          <input type="submit" name="next" value="����"
          		formnovalidate="formnovalidate"
          		formaction="<%=path %>/c1070.htm"
          >
       </td>
       </tr>
   </table>
 </div>
<input type="hidden" name="oid" value="${ins.oid }">
<input type="hidden" name="onum" value="${ins.onum }">
<input type="hidden" name="docid" value="${ins.docid }">
</form>
</body>
</html>