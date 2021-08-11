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
    let onEdit=function(vrid){
    	//����ҳ����ת����ȡ�¸�ҳ����������
    	let currForm=document.getElementById("myform");
    	currForm.action="<%=path%>/a1032.htm?rid="+vrid;
    	
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
	<script type="text/javascript">
	function quanxuan(a)
	{
	    //�ҵ��������еĸ�ѡ��
	    var ck =document.getElementsByClassName("qx");
	    
	    //�������и�ѡ������ѡ��״̬��
	    for(var i=0;i<ck.length;i++)
	    {
	        if(a.checked)//�ж�ȫѡ��ť��״̬�ǲ���ѡ�е�
	        {
	            ck[i].setAttribute("checked","checked");//�����ѡ�еģ��������е�״̬Ϊѡ�С�
	        }
	        else
	        {
	            ck[i].removeAttribute("checked");//�������ѡ�еģ����Ƴ����е�״̬��checked��ѡ�
	        }
	    }
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
              ҽ�Ƽ�¼����
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
          <e:text name="qaccount" />
       </td>
       <td>��ʵ����</td>
       <td><e:text name="qtruename" /></td>
       <td>��������</td>
       <td><e:select value="occommunity" name="qcommunity" header="true" /></td>
       <td>��¼״̬</td>
       <td><e:text name="qrecordstate"/></td>
    </tr>
    <tr>
       <td>�Ա�</td>
       <td>
          <e:radio name="qsex" value="��:1,Ů:2,����:''" defval=""/>
       </td>
       <td>��¼ʱ��[B]</td>
       <td>
         <e:date  name="bbegintime"/>
       </td>
       <td>��¼ʱ��[E]</td>
       <td>
         <e:date  name="ebegintime"/>
       </td>
	   <td colspan="2"></td>
    </tr>
  </table>
</div>
<!-- ��ѯ���-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td>
       <input type="checkbox" onclick="quanxuan(this)" />ȫѡ<br />
       </td>
       <td>���</td>
       <td>�˺�</td>
       <td>��ʵ����</td>
       <td>�Ա�</td>
       <td>����</td>
       <td>��¼״̬</td>
       <td>¼��ʱ��</td>
       <td></td>
    </tr>
    <!-- �ж����ٶ����¶� -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose �ڲ���when��otherwise�൱��if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>
		       <input type="checkbox" class="qx" name="rid" value="${ins.rid }">
		       </td>
		       <td>${vs.count}</td>
		       <td>${ins.account }</td>
		       <td>		       
		           ${ins.truename }
		       </td>
		       <td>${ins.sex }</td>
		       <td>${ins.community }</td>
		       <td>${ins.state }</td>
		       <td>${ins.begintime }</td>
		       <td>
		       	   <a href="javascript:onEdit('${ins.rid}')" >		       	   	         
		           <img alt="" src="<%=path%>/img/edit.png">
					�鿴��¼					
		           </a>
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
  <!-- ҳ�����������ѯ�����½���ʾҳ�������б� -->
  ${pageController }  
</div>

<!-- ���ܰ�ť -->
<div class="button">
  <table>
    <tr>
      <td>
         <input type="submit" name="next" value="��ѯ" formaction="<%=path%>/a1031.htm">
         <!-- disabled="disabled" input�ڲ����������ť���ɻ�ɫ�����ܵ��  -->
         <input type="submit" id="delButton" name="next" value="ɾ��"  formaction="<%=path%>/a1033.htm">
      </td>
    </tr>
  </table>
</div>
</form>
</body>
</html>