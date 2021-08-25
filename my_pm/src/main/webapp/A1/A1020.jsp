<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
   <%String path=request.getContextPath(); %>

<html>
<head>
<head>
   <title>ҽ���˺Ź���</title>
   <style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");</style>
   <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
   <style type="text/css">
     #pageController{
       width: 75px;
      }
   </style>
   <script type="text/javascript">
    let onEdit=function(vuid){
    	let currForm=document.getElementById("myform");
    	currForm.action="<%=path%>/a1024.htm?uid="+vuid;
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
</head>
</head>
<body>
${msg}
<br>
<br>
<form id="myform" action="" method="post">
<!-- ��ѯ���� -->
<div class="query">
  <table>
    <caption>
              ҽ���˺Ź���
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
       <td>ҽ�����</td>
       <td> 
          <input type = "text" name="qdid" />
       </td>
       <td>����</td>
       <td><input type = "text" name="qtruename" /></td>
       <td>�Ա�</td>
       <td>
          <input type = "radio" name="qsex" value="1" />��
		  <input type = "radio" name="qsex" value="2" />Ů
		  <input type = "radio" name="qsex" value="" />����
       </td>
       <td>״̬</td>
       <td>
       <input type="radio" name="qdocstate" value="1" />����
       <input type="radio" name="qdocstate" value="2" />�ر�
       <input type="radio" name="qdocstate" value="3" />ɾ��
       <input type="radio" name="qdocstate" value="" />����  
       </td>
    </tr>
    <tr>
       <td>���ڵ���</td>
       <td>
         <select name="qcommunity">
         		<option value="">==����==</option>
				<c:forEach var="community" items="${occommunity}">									
				<option value="${community.value}" >${community.name}</option>									
				</c:forEach>
				</select>
       </td>
    <td>��������</td>
    <td>
    <input type = "text" name="qclinicname"/>
    </td>   
     <td>ҽ���ȼ�</td>     
    <td>
    <select name="qlevel">
    	<option value="">==����==</option>
    	<c:forEach var="level" items="${oclevel}">									
				<option value="${level.value}" >${level.name}</option>									
				</c:forEach>
    </select>
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
       <td>ҽ�����</td>
       <td>����</td>
       <td>�Ա�</td>
       <td>�����ַ</td>
       <td>��������</td>
       <td>״̬</td>
       <td>���ڵ���</td>
       
    </tr>
    <!-- �ж����ٶ����¶� -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- if -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>
		       <input type="checkbox" name="uid" value="${ins.uid }">
		       </td>
		       <td>${vs.count}</td>
		       <td>${ins.did }</td>
		       
		       <td>
		         <a href="javascript:onEdit('${ins.uid}');" >
		           <img alt="" src="<%=path%>/img/edit.png">
		           ${ins.truename }
		         </a>
		       </td>
		       <td>${ins.cnsex }</td>
		       <td>${ins.clinicaddress }</td>
		       <td>${ins.clinicname }</td>
		       <td>${ins.cndocstate }</td>
		       <td>${ins.cncommunity }</td>			   
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
         <input type="submit" name="next" value="��ѯ" formaction="<%=path%>/a1021.htm">
         <input type="submit" value="���" formaction="<%=path%>/a1022.htm">
         <input type="submit" id="delButton" name="next" value="ɾ��"  formaction="<%=path%>/a1026.htm">
      </td>
    </tr>
  </table>
</div>

		
		
</form>
</body>
</html>