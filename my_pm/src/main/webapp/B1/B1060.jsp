<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%String path=request.getContextPath(); %>
<html>
<head>
   <title>��ʷ���߲�ѯ</title>
   <style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");
   </style>
    <script type="text/javascript">
    let onEdit=function(prid){
    	
    	let currForm=document.getElementById("myform");
    	
    	currForm.action="<%=path%>/b1080.htm?rid="+prid;
    	
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
   <script type="text/javascript">
    let onEdit2=function(poid){
    	
    	let currForm=document.getElementById("myform");
    	
    	currForm.action="<%=path%>/b1070.htm?oid="+poid;
    	
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
   
    <script type="text/javascript">
    let onEdit3=function(puid){
    	
    	let currForm=document.getElementById("myform");
    	
    	currForm.action="<%=path%>/b1081.htm?uid="+puid;
    	
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
   
   <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
</head>
<body>
${msg }
<br>

<br>
<form id="myform" action="" method="post">
<!-- ��ѯ���� -->
<div class="query">
  <table>
    <caption>
              ��ʷ���߲�ѯ
       <hr>       
    </caption>
    <tr class="title">
       <td colspan="8">��ѯ����</td>
    </tr>
    <!-- 
             ��ѯ�����Ŀؼ�����:
       ������������: b+�ֶ���  ����ʼ����   e+�ֶ���  ��������
       ���ڷ������ѯ���� :  q+�ֶ���   
     -->
    <tr>
       <td>�Һŵ���</td>
       <td> 
          <input type = "text" name="qoid" />
       </td>
       <td>��������</td>
       <td><input type = "text" name="qtruename" /></td>
       <td>�����Ա�</td>
       <td>
          <input type = "radio" name="qsex" value="1"  />��
		  <input type = "radio" name="qsex" value="2" />Ů
		  <input type = "radio" name="qsex" value="" />����
       </td>
       <td>����</td>
       <td>
         <select name="qnation">
				<option value="">==����==</option>
				<c:forEach var = "nation" items = "${ocnation }" >
				<option value="${nation.value}" >${nation.name}</option>									
				</c:forEach>
			</select>			
       </td>
    </tr>
    <tr>
       <td>����</td>
       <td>
        <select name="qcommunity">
			<option value="">==����==</option>
			<c:forEach var = "community" items = "${occommunity }" >
			<option value="${community.value}">${community.name}</option>
			</c:forEach>
				</select>
       </td>
       <td>�Һ�ʱ���[B]</td>
       <td>
         <input type = "date" name="btime"/>
       </td>
       <td>�Һ�ʱ���[E]</td>
       <td>
         <input type = "date" name="etime"/>
       </td>
       <td></td>
       <td></td>
    </tr>
  </table>
</div>
<!-- ��ѯ���-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td></td>
       <td>���</td>
       <td>�Һŵ���</td>
       <td>��������</td>
       <td>�����Ա�</td>
       <td>����</td>
       <td>ҽ�Ƽ�¼</td>
       <td>�����Ϣ</td>
       <td></td>
    </tr>
      <c:choose>
      <c:when test="${rows!=null }">   <!-- choose �ڲ���when��otherwise�൱��if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>
		      
		       </td>
		       <td>${vs.count}</td>
		       <td>
		        <a href="javascript:onEdit2('${ins.oid}')" >
		           <img alt="" src="<%=path%>/img/edit.png">
		            </a>
		       ${ins.oid }
		       </td>
		       <td>		       
		           ${ins.truename }
		       </td>
		       <td>${ins.cnsex }</td>
		       <td>${ins.cnnation }</td>
		       <td>				      		                  		         		         
		     <c:choose >
		     <c:when test="${ins.state==1 }">
		     <a href="javascript:onEdit('${ins.rid}')">
		           <img alt="" src="<%=path%>/img/edit.png">
		           		�鿴����  ${ins.begintime }
		           		</a>
		     </c:when>
		     <c:otherwise>
		                                 û����ؼ�¼
		     </c:otherwise>
		     </c:choose>
		         		      		            		          		         	        
		       </td>
		       <td>
		        <a href="javascript:onEdit3('${ins.uid}')">
		           <img alt="" src="<%=path%>/img/edit.png">
		           		����鿴  
		         </a> 
		   
		       </td>
		       <td>
		       	   
		       </td>
		    </tr>
         </c:forEach>
		 <script>
		    newRows(10-${fn:length(rows)},9);
		 </script>
		 
      </c:when>
      <c:otherwise>   <!-- else -->
		    <script>
		      newRows(10,9);
		    </script>
      </c:otherwise>
    </c:choose> 
  </table>
   ${pageController }  
</div>

<!-- ���ܰ�ť -->
<div class="button">
  <table>
    <tr>
      <td>
         <input type="submit" name="next" value="��ѯ" formaction="<%=path%>/b1061.htm">

      </td>
    </tr>
  </table>
</div>
</form>
</body>
</html>