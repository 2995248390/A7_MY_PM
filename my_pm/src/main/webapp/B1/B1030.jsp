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
    let onEdit1=function(euid){
    	//用于页面跳转，获取下个页面所需主键
    	let currForm=document.getElementById("myform");  	
    	currForm.action="<%=path%>/b1032.htm?uid="+euid;
    	currForm.submit();    	
    }
   let onEdit2=function(euid){
   	//用于页面跳转，获取下个页面所需主键
   	let currForm=document.getElementById("myform");
  		currForm.action="<%=path%>/b1033.htm?uid="+euid;
   	currForm.submit();    	
   }
   
   let onEdit3=function(onum){
	   	//用于页面跳转，获取下个页面所需主键
	   	let currForm=document.getElementById("myform");
	  		currForm.action="<%=path%>/b1041.htm?onum="+onum+"&thepath="+1;
	   	currForm.submit();    	
	   }
   
   </script>
     <script type="text/javascript">
	var t = new Date();//获取当前时间
	var year = t.getFullYear();//获取当前时间年份
	var month = t.getMonth();//获取当前时间月份
	var day = t.getDate();//获取当前时间日

	var nowTime = year+"-"+month+"-"+day;
  </script>
  <script>
	setInterval(function(){
		document.getElementById("time").innerHTML = new Date().toLocaleString();
	},1000)
  </script>  
</head>
<body>
<span id="time"></span>
${msg }<!-- 显示查询条件的结果（查询成功或没有符合条件的数据） -->
<br>
${ins }
<br>
<form id="myform" action="" method="post" >
<!-- 查询条件 -->
<div class="query" >
  <table>
    <caption>
              挂号队列
       <hr>       
    </caption>
  </table>
</div>
<!-- 查询结果-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td width="7%">序号</td>
       <td width="15%">预约号</td>       
       <td width="10%">真实姓名</td>
       <td width="8%">性别</td>
       <td width="15%">预约时间</td>
       <td width="15%">当前医疗记录</td>
       <td width="15%">历史医疗记录</td>
       <td width="15%">体检记录</td> 
    </tr>
    <!-- 行多行少都是事儿 -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose 内部的when和otherwise相当于if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>${vs.count}</td>
	       	   <td>${ins.onum }</td>
		       <td>${ins.truename }</td>
		       <td>${ins.sex }</td>
		       <td>${ins.appointment }</td>
		       <td>
		       	   <a href="javascript:onEdit3('${ins.onum }')" >		         
		           <img alt="" src="<%=path%>/img/edit.png">
					填写医疗记录				
		           </a>
		       </td>
		       <td>
		       	   <a href="javascript:onEdit1('${ins.uid }')" >		         
		           <img alt="" src="<%=path%>/img/query.gif">
					查看医疗记录				
		           </a>
		       </td>
		       <td>
		       	   <a href="javascript:onEdit2('${ins.uid }')" >		         
		           <img alt="" src="<%=path%>/img/query.gif">
					查看体检记录					
		           </a>
		       </td>	       
		    </tr>
         </c:forEach>
		 <script>
		    newRows(12-${fn:length(rows)},8);
		 </script>		 
      </c:when>
      <c:otherwise>   <!-- else -->
		    <script>
		      newRows(12,8);
		    </script>
      </c:otherwise>
    </c:choose>
  </table>
  <!-- 页码控制器，查询后左下角显示页码下拉列表 -->
  ${pageController }  
</div>

 <e:hidden name="did"/>
</form>
</body>
</html>