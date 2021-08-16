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
</head>
<body>
<form action="" method="post">
<div class="data">
  <table id="dataTable">
    <caption>
              ҽ�Ƽ�¼����
       <hr>       
    </caption>
    <tr>
    	<td></td>
    	<td></td>    	
    	<td >����:��${ins.truename }�� �Ա�:��${ins.sex }��</td>
    	<td colspan="3" ></td>
    </tr>
    <tr class="title">
       <td width="5%"></td>
       <td width="6%">���</td>
	   <td width="19%">ʱ��</td>
       <td width="35%">ҩƷ��Ϣ</td>
       <td width="35%">ҽ��</td>
       <td></td>
    </tr>
    <!-- �ж����ٶ����¶� -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose �ڲ���when��otherwise�൱��if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>
		       </td>
		       <td>${vs.count}</td>
		       <td>${ins.begintime }</td>
		       <td>${ins.drugmsg }</td>
		       <td>${ins.docsuggestion }</td>
		       <td></td>
		    </tr>
         </c:forEach>
		 <script>
		    newRows(10-${fn:length(rows)},6);
		 </script>
		 
      </c:when>
      <c:otherwise>   <!-- else -->
		    <script>
		      newRows(10,6);
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
      	<script>
      	</script>
         <input type="submit" name="next" value="����"          
      			formnovalidate="formnovalidate"
      			formaction="<%=path %>/b1031.htm"     			    	
                  	>
      </td>
    </tr>
  </table>
</div>
</form>
</body>
</html>