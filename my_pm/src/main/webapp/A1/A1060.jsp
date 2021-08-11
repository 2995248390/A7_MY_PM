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
 
  <script type="text/javascript">
    let onEdit=function(iid){
    	let currForm=document.getElementById("myform");
    	currForm.action="<%=path%>/a1063.htm?rsnolist="+iid;
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
   
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
<form id="myform" action="" method="post">
<div id="msg" class="msg">

 ${msg }

</div >
<!-- ��ѯ���� -->
<div class="query">
  <table>
    <caption>
        ��Ѷ����
       <hr>      
    </caption>
    
    <tr class="title" >
       <td colspan="8">��ѯ����</td>
    </tr>
    <!-- 
             ��ѯ�����Ŀؼ�����
     -->
     
    <tr>
      
       <td>��Ѷ��ˮ��</td>
       <td> 
          <e:text  name="qinno" />
       </td>
       
       <td>���ݼ��</td>
       <td><e:text name="qinsyn" /></td>
       
       <td>ҳ������</td>
      
       <td><e:text name="qinurl" /></td>
       
       <td>״̬</td>
       <td>
      <e:radio name="qinstate" value="�ɼ�:1,���ɼ�:2" defval="1"/>
       </td>
       
    </tr>
    
   
  </table>
</div>
<!-- ��ѯ���  -->
<div class="data">

  <table id="dataTable">
    <tr class="title">
       <td>
       
       </td>
       <td>��Ѷ��ˮ��</td>
       <td>���ݼ��</td>
       <td>
          <a  herf="">ҳ������</a> 
        </td>
       <td>¼��ʱ��</td>
       <td></td>
    </tr>
<br>

    <c:choose>
      <c:when test="${rows!=null }">
         <c:forEach items="${rows }" var="ins" varStatus="vs" >
            <tr>
           
            <td>
             <input type="checkbox"  class="checklist" name="rsnolist" value="${ins.iid}"> 
            </td>
            <td>${vs.count }</td>
            <td>
               ${ins.text } 
            </td>
             <td> 
                <a href="javascript:onEdit('${ins.iid}')">
		           <img alt="" src="<%=path%>/img/edit.png">
		        </a>
             <a href="${ins.url }">${ins.url }</a>
             </td>
            <td>${ins.begintime }</td>
            <td></td>
           
            </tr>
         </c:forEach>
          <script>
              newRows(10- ${fn:length(rows)},6);
          </script>
       </c:when>
       <c:otherwise>
         <script>
              newRows(10,6);
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
         <input type="submit" name="next" value="��ѯ"  formaction="<%=path%>/a1060.htm">
         <input type="submit" value="���" formaction="<%=path%>/A1/A1061.jsp?path=1">
         <input type="submit" id="delButton" name="next" value="ɾ��"  formaction="<%=path%>/a1062.htm">
          <input type="submit" name="update" value="�޸�"  formaction="<%=path%>/a1063.htm?">
          <input type="submit" value="����" formaction="<%=path%>/a1060.htm">
      </td>
    </tr>
  </table>
</div> 
 
 </form>
</body>
</html>
