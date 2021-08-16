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
              医疗记录管理
       <hr>       
    </caption>
    <tr>
    	<td></td>
    	<td></td>    	
    	<td >姓名:『${ins.truename }』 性别:『${ins.sex }』</td>
    	<td colspan="3" ></td>
    </tr>
    <tr class="title">
       <td width="5%"></td>
       <td width="6%">序号</td>
	   <td width="19%">时间</td>
       <td width="35%">药品信息</td>
       <td width="35%">医嘱</td>
       <td></td>
    </tr>
    <!-- 行多行少都是事儿 -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose 内部的when和otherwise相当于if  else  -->
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
  <!-- 页码控制器，查询后左下角显示页码下拉列表 -->
  ${pageController }  
</div>
<!-- 功能按钮 -->
<div class="button">
  <table>
    <tr>
      <td>
      	<script>
      	</script>
         <input type="submit" name="next" value="返回"          
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