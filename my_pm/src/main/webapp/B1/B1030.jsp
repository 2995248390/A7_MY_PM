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
   <style type="text/css">
     #pageController{
       width: 75px;
      }
   </style>
   <script type="text/javascript">
    let onEdit1=function(euid){
    	//����ҳ����ת����ȡ�¸�ҳ����������
    	let currForm=document.getElementById("myform");  	
    	currForm.action="<%=path%>/b1032.htm?uid="+euid;
    	currForm.submit();    	
    }
   let onEdit2=function(euid){
   	//����ҳ����ת����ȡ�¸�ҳ����������
   	let currForm=document.getElementById("myform");
  		currForm.action="<%=path%>/b1033.htm?uid="+euid;
   	currForm.submit();    	
   }
   
   let onEdit3=function(onum){
	   	//����ҳ����ת����ȡ�¸�ҳ����������
	   	let currForm=document.getElementById("myform");
	  		currForm.action="<%=path%>/b1041.htm?onum="+onum+"&thepath="+1;
	   	currForm.submit();    	
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
<body>
<span id="time"></span>
${msg }<!-- ��ʾ��ѯ�����Ľ������ѯ�ɹ���û�з������������ݣ� -->
<br>
${ins }
<br>
<form id="myform" action="" method="post" >
<!-- ��ѯ���� -->
<div class="query" >
  <table>
    <caption>
              �ҺŶ���
       <hr>       
    </caption>
  </table>
</div>
<!-- ��ѯ���-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td width="7%">���</td>
       <td width="15%">ԤԼ��</td>       
       <td width="10%">��ʵ����</td>
       <td width="8%">�Ա�</td>
       <td width="15%">ԤԼʱ��</td>
       <td width="15%">��ǰҽ�Ƽ�¼</td>
       <td width="15%">��ʷҽ�Ƽ�¼</td>
       <td width="15%">����¼</td> 
    </tr>
    <!-- �ж����ٶ����¶� -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose �ڲ���when��otherwise�൱��if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>${vs.count}</td>
	       	   <td>${ins.onum }</td>
		       <td>${ins.truename }</td>
		       <td>${ins.sex }</td>
		       <td>${ins.appointment }</td>
		       <td>
		       	   <a href="javascript:onEdit3('${ins.onum }')" >		         
		           <img alt="" src="<%=path%>/img/edit.png">
					��дҽ�Ƽ�¼				
		           </a>
		       </td>
		       <td>
		       	   <a href="javascript:onEdit1('${ins.uid }')" >		         
		           <img alt="" src="<%=path%>/img/query.gif">
					�鿴ҽ�Ƽ�¼				
		           </a>
		       </td>
		       <td>
		       	   <a href="javascript:onEdit2('${ins.uid }')" >		         
		           <img alt="" src="<%=path%>/img/query.gif">
					�鿴����¼					
		           </a>
		       </td>	       
		    </tr>
         </c:forEach>
		 <script>
		    newRows(12-${fn:length(rows)},8);
		 </script>		 
      </c:when>
      <c:otherwise>   <!-- else -->
		    <script>
		      newRows(12,8);
		    </script>
      </c:otherwise>
    </c:choose>
  </table>
  <!-- ҳ�����������ѯ�����½���ʾҳ�������б� -->
  ${pageController }  
</div>

 <e:hidden name="did"/>
</form>
</body>
</html>