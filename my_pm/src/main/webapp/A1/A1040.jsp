<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
 <style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");</style>
   <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
 <style type="text/css">
   #pageController{
       width:100px;
   }
 </style>
 <script type="text/javascript">
    function onNext1()
    { 
    	//alert("hello");
    	window.setTimeout("clearMsg()","3000");
    }
    function clearMsg()
    {
    	//ert("clear......");
    	document.getElementById("msg").innerHTML="";
    }
  </script>
   <script type="text/javascript">
  // ȫ��ѡ����ʾ��
  let chooseall=function()
  {
		 var x =document.getElementById("contorlbox1");
		 var box= document.getElementsByClassName("checklist");
		 for(var i=0;i<box.length;i++)
	     {   
			 if(x.checked==true)
				 {
				 box[i].checked=true;
				 }
			 else
				 {
				 box[i].checked=false;
				 }
		 }
  }
  </script>
</head>
<body onload="onNext1()">
<br>
<br>
<div id="msg" class="msg">

 ${msg }
</div >

<form id="myform" action="" method="post">

<!-- ��ѯ���� -->
<div class="query" >
  <table>
    <caption>
              ��쵵������
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
       <td>������ˮ��</td>
       <td> 
          <e:text  name="qaino" />
       </td>
       <td>�û����</td>
       <td><e:text name="qpno" /></td>
       <td>�Ա�</td>
       <td>
         <e:radio name="qsex" value="��:1,Ů:2,����:''" defval=""/>
       </td>
       <td>����</td>
       <td><e:text name="qpname" /></td>
    </tr>
    <tr>
      
       <td>����</td>
       <td>
          <e:select name="qnation" value="ocnation" header="true" />
       </td>
       <td>��ʼ¼��ʱ��</td>
       <td>
           <e:date name="binputdate"  />
       </td>
       <td>��ֹ¼��ʱ��</td>
       <td>
           <e:date name="einputdate"  />
       </td>
         <td></td>
         <td></td>
    </tr>
  </table>
</div>

<!-- 2.��ѯ��� -->


<div  class="data">
  <table id="dataTable">
    <tr class="title">
       <td></td>
       <td>���</td>
       <td>������ˮ��</td>
       <td>�û����</td>
       <td>����</td>
       <td>�Ա�</td>
       <td>����</td>
       <td>Ѫѹ</td>
       <td>���</td>
       <td>����</td>
       <td>�λ���</td>
       <td>����</td>
       <td></td>
    </tr>
    <c:choose>
       <c:when test="${rows!=null }">
          <c:forEach items="${rows }" var="ins" varStatus="vs">
            <tr class="title">
              <td>
              <input type="checkbox" class="checklist" name="rsnolist" value="${ins.bid}">
              </td>
              <td>${vs.count}</td>
              <td>${ins.bid}</td>
              <td>${ins.uid}</td>
              <td>${ins.truename }</td>
              <td>${ins.sex}</td>
              <td>${ins.nation}</td>
              <td>${ins.blood}</td>
              <td>${ins.height}</td>
              <td>${ins.weight}</td>
              <td>${ins.airs}</td>
              <td>${ins.pulse}</td>
              <td></td>
            </tr>
          </c:forEach>
          <script>
              newRows(10- ${fn:length(rows)},13);
          </script>
          
       </c:when>
       <c:otherwise>
          <script>
              newRows(10,13);
          </script>
       </c:otherwise>
     </c:choose>
   
  </table>
   <input type="checkbox" name="1" id="contorlbox1" onclick="chooseall()" >ȫѡ
   <br>
  ${pageController }
</div>
<!-- ���ܰ�ť -->
<div class="button">
  <table>
    <tr>
      <td>
         <input type="submit" name="next" value="��ѯ"  formaction="<%=path%>/a1041.htm">
        <input type="submit" name="reback" value="����"  formaction="<%=path%>/a1040.htm">
         <input type="submit" id="delButton" name="next" value="ɾ��"  formaction="<%=path%>/a1042.htm">
      </td>
    </tr>
  </table>
</div>
</form>
</body>
</html>