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
          <e:text name="qdid" />
       </td>
       <td>����</td>
       <td><e:text name="qtruename" /></td>
       <td>�Ա�</td>
       <td>
          <e:radio name="qsex" value="��:1,Ů:2,����:''" defval=""/>
       </td>
       <td>״̬</td>
       <td>
       <e:radio name="qdocstate" value="����:1,�ر�:2" defval=""/>
         
       </td>
    </tr>
    <tr>
       <td>���ڵ���</td>
       <td>
         <e:select value="occommunity" name="qcommunity" header="true" />
       </td>
    <td>��������</td>
    <td>
    <e:select value="occlinicname" name="qclinicname" header="true" />
    </td>   
     <td>ҽ���ȼ�</td>     
    <td>
    <e:select value="oclevel" name="qlevel" header="true" />
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