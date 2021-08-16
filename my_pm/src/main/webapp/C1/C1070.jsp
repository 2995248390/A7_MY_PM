<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    let onEdit1=function(thepath,index){
    	//����ҳ����ת����ȡ�¸�ҳ����������
    	//alert(thepath);
   		//alert(index);
    	let currForm=document.getElementById("myform");  	
    	currForm.action="<%=path%>/c1071.htm?thepath="+thepath+"&oid="+index;
    	
    	currForm.submit();
    }
   </script>
   <script type="text/javascript">
   let onEdit2=function(thepath,index){
   		//����ҳ����ת����ȡ�¸�ҳ����������
   		//alert(2);
   		let currForm=document.getElementById("myform");
  		currForm.action="<%=path%>/c1071.htm?thepath="+thepath+"&oid="+index;
   		currForm.submit();    	
   }
   </script>
</head>
<body>
${msg }<!-- ��ʾ��ѯ�����Ľ������ѯ�ɹ���û�з������������ݣ� -->
<br>
${ins }
<br>
<form id="myform" action="" method="post" >
<!-- ��ѯ���� -->
<div class="query" >
  <table>
    <caption>
              �ҵ�ҽ�Ƽ�¼
       <hr>       
    </caption>
    <tr class="title">
       <td colspan="6">��������</td>
    </tr>
    <!-- 
             ��ѯ�����Ŀؼ�����:
       ������������: b+�ֶ���  ����ʼ����   e+�ֶ���  ��������
       ���ڷ������ѯ���� :  q+�ֶ���   
     -->
    <tr>
       <td>����</td>
       <td> 
          <input type="text" name="qonum">
       </td>
       <td>ԤԼʱ��B</td>       
       <td><input type="datetime-local" name="bappointment"></td>
       <td>ԤԼʱ��E</td>       
       <td><input type="datetime-local" name="eappointment"></td>
    </tr>
    <tr>
       <td>��״̬</td>
       <td>
       <select name="qorderliststate">
        	<option value="">--����--</option>
        	<c:forEach var="order" items="${qorderliststate }">
        		<option value="${order.value }">${order.name }</option>
        	</c:forEach>
       </select>
       </td>
       <td>���ʱ��B</td>       
       <td><input type="datetime-local" name="bovertime"></td>
       <td>���ʱ��E</td>       
       <td><input type="datetime-local" name="eovertime"></td>   
    </tr>
  </table>
</div>
<!-- ��ѯ���-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td width="5%">���</td>
       <td width="10%">����</td>
       <td width="10%">��״̬</td>       
       <td width="20%">ԤԼʱ��</td>
       <td width="20%">���ʱ��</td>
       <td width="20%">�鿴��ϸ��¼</td>
       <td width="15%">����</td>
    </tr>
    <!-- �ж����ٶ����¶� -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose �ڲ���when��otherwise�൱��if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>${vs.count}</td>
		       <td>
		       		${ins.onum }
		       </td>
		       <td>${ins.svalue }</td> 
		       <td>${ins.appointment }</td>
		       <td>${ins.overtime }</td>
		       <td>
		           <img alt="" src="<%=path%>/img/query.gif">		       
		       	   <a href="javascript:onEdit1(1,${ins.oid });" >		       	   	         
					${ins.svalue=='�Һ���'?'':'�鿴��ϸ��¼' }
		           </a>
		       </td>
		       <td>
		           <img alt="" src="<%=path%>/img/edit.png">		       
		       	   <a href="javascript:onEdit2(${ins.svalue=='δ����'?2:4 },${ins.oid });" >		       	   	         
					${ins.svalue=='δ����'?'��д����':ins.svalue=='������'?'�鿴����':'' }
		           </a>
		       </td>
		    </tr>
         </c:forEach>
		 <script>
		    newRows(12-${fn:length(rows)},7);
		 </script>
		 
      </c:when>
      <c:otherwise>   <!-- else -->
		    <script>
		      newRows(12,7);
		    </script>
      </c:otherwise>
    </c:choose>
  </table>
  <!-- ҳ�����������ѯ�����½���ʾҳ�������б� -->
  ${pageController }  
</div>
<!-- ���ܰ�ť -->
<div class="button">
  <table>
    <tr>
      <td>
         <input type="submit" name="next" value="��ѯ" formaction="<%=path%>/c1070.htm">
         <!-- disabled="disabled" input�ڲ����������ť���ɻ�ɫ�����ܵ��  -->
      </td>
    </tr>
  </table>
</div>

</form>
</body>
</html>