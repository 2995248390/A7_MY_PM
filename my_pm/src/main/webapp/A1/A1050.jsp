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
    let onEdit=function(vrid){
    	//����ҳ����ת����ȡ�¸�ҳ����������
    	let currForm=document.getElementById("myform");
    	currForm.action="<%=path%>/a1032.htm?rid="+vrid;
    	//alert(currForm.action);
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
              ���۹���
       <hr>       
    </caption>
    <tr class="title">
       <td colspan="10">��ѯ����</td>
    </tr>
    <!-- 
             ��ѯ�����Ŀؼ�����:
       ������������: b+�ֶ���  ����ʼ����   e+�ֶ���  ��������
       ���ڷ������ѯ���� :  q+�ֶ���   
     -->
    <tr>
       <td>�û��˺�</td>
       <td> 
          <input type="text" name="qaccount" >
       </td>
       <td>��ʵ����</td>
       <td><input type="text" name="qtruename" ></td>
       <td>��������</td>
       <td>
       <select  name="qcommunity"  >
       		<option value="">--����--</option>
       		<c:forEach var="com" items="${occommunity }" >
       		<option value="${com.value }">${com.name }</option>
      		</c:forEach>
       </select>
       </td>
       <td>�û�״̬</td>
       <td><input type="text" name="userstate" ></td>       
    </tr>
    <tr>
       <td>�Ա�</td>
       <td>
          <input type="radio" name="qsex"  id="qsex" value="1">��
          <input type="radio" name="qsex"  id="qsex" value="2">Ů
          <input type="radio" name="qsex"  id="qsex" value="" checked="checked">����
       </td>
       <td>���۷���[B]</td>
       <td>
         <input type="text" name="bgrade" >
       </td>
       <td>���۷���[E]</td>
       <td>
         <input type="text" name="egrade" >
       </td>
       <td>����״̬</td>
       <td><input type="text" name="qappraisestate" ></td>
    </tr>
  </table>
</div>
<!-- ��ѯ���-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td></td>
       <td>���</td>
       <td>�˺�</td>
       <td>��ʵ����</td>
       <td>����״̬</td>       
       <td>���۷���</td>
       <td >��������</td>
       <td></td>
    </tr>
    <!-- �ж����ٶ����¶� -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose �ڲ���when��otherwise�൱��if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>
		       <input type="checkbox" name="aid" value="${ins.aid }">
		       </td>
		       <td>${vs.count}</td>
		       <td>${ins.account }</td>
		       <td>
		           ${ins.truename }
		       </td>
		       <td>��${ins.appraisestate }��${ins.svalue }</td>
		       <td>${ins.grade }</td>
		       <td >${ins.text }</td>
		       <td></td>
		    </tr>
         </c:forEach>
		 <script>
		    newRows(10-${fn:length(rows)},8);
		 </script>
		 
      </c:when>
      <c:otherwise>   <!-- else -->
		    <script>
		      newRows(10,8);
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
         <input type="submit" name="next" value="��ѯ" formaction="<%=path%>/a1051.htm">
         <!-- disabled="disabled" input�ڲ����������ť���ɻ�ɫ�����ܵ��  -->
         <input type="submit" name="next" value="��ʾ"  formaction="<%=path%>/a1052.htm">
         <input type="submit" name="next" value="����"  formaction="<%=path%>/a1053.htm">
      </td>
    </tr>
  </table>
</div>
</form>
</body>
</html>