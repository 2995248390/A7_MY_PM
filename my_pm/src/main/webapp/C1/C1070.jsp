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
    	//用于页面跳转，获取下个页面所需主键
    	//alert(thepath);
   		//alert(index);
    	let currForm=document.getElementById("myform");  	
    	currForm.action="<%=path%>/c1071.htm?thepath="+thepath+"&oid="+index;
    	
    	currForm.submit();
    }
   </script>
   <script type="text/javascript">
   let onEdit2=function(thepath,index){
   		//用于页面跳转，获取下个页面所需主键
   		//alert(2);
   		let currForm=document.getElementById("myform");
  		currForm.action="<%=path%>/c1071.htm?thepath="+thepath+"&oid="+index;
   		currForm.submit();    	
   }
   </script>
</head>
<body>
${msg }<!-- 显示查询条件的结果（查询成功或没有符合条件的数据） -->
<br>
${ins }
<br>
<form id="myform" action="" method="post" >
<!-- 查询条件 -->
<div class="query" >
  <table>
    <caption>
              我的医疗记录
       <hr>       
    </caption>
    <tr class="title">
       <td colspan="6">排序条件</td>
    </tr>
    <!-- 
             查询条件的控件命名:
       对于区间条件: b+字段名  做开始区间   e+字段名  结束区间
       对于非区间查询条件 :  q+字段名   
     -->
    <tr>
       <td>单号</td>
       <td> 
          <input type="text" name="qonum">
       </td>
       <td>预约时间B</td>       
       <td><input type="datetime-local" name="bappointment"></td>
       <td>预约时间E</td>       
       <td><input type="datetime-local" name="eappointment"></td>
    </tr>
    <tr>
       <td>单状态</td>
       <td>
       <select name="qorderliststate">
        	<option value="">--不限--</option>
        	<c:forEach var="order" items="${qorderliststate }">
        		<option value="${order.value }">${order.name }</option>
        	</c:forEach>
       </select>
       </td>
       <td>完成时间B</td>       
       <td><input type="datetime-local" name="bovertime"></td>
       <td>完成时间E</td>       
       <td><input type="datetime-local" name="eovertime"></td>   
    </tr>
  </table>
</div>
<!-- 查询结果-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td width="5%">序号</td>
       <td width="10%">单号</td>
       <td width="10%">单状态</td>       
       <td width="20%">预约时间</td>
       <td width="20%">完成时间</td>
       <td width="20%">查看详细记录</td>
       <td width="15%">评价</td>
    </tr>
    <!-- 行多行少都是事儿 -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose 内部的when和otherwise相当于if  else  -->
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
					${ins.svalue=='挂号中'?'':'查看详细记录' }
		           </a>
		       </td>
		       <td>
		           <img alt="" src="<%=path%>/img/edit.png">		       
		       	   <a href="javascript:onEdit2(${ins.svalue=='未评价'?2:4 },${ins.oid });" >		       	   	         
					${ins.svalue=='未评价'?'填写评价':ins.svalue=='已评价'?'查看评价':'' }
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
  <!-- 页码控制器，查询后左下角显示页码下拉列表 -->
  ${pageController }  
</div>
<!-- 功能按钮 -->
<div class="button">
  <table>
    <tr>
      <td>
         <input type="submit" name="next" value="查询" formaction="<%=path%>/c1070.htm">
         <!-- disabled="disabled" input内部有这个，按钮会变成灰色，不能点击  -->
      </td>
    </tr>
  </table>
</div>

</form>
</body>
</html>