<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%String path=request.getContextPath(); %>
<html>
<head>
   <title>历史患者查询</title>
   <style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");
   </style>
    <script type="text/javascript">
    let onEdit=function(prid){
    	
    	let currForm=document.getElementById("myform");
    	
    	currForm.action="<%=path%>/b1080.htm?rid="+prid;
    	
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
   <script type="text/javascript">
    let onEdit2=function(poid){
    	
    	let currForm=document.getElementById("myform");
    	
    	currForm.action="<%=path%>/b1070.htm?oid="+poid;
    	
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
   
    <script type="text/javascript">
    let onEdit3=function(puid){
    	
    	let currForm=document.getElementById("myform");
    	
    	currForm.action="<%=path%>/b1081.htm?uid="+puid;
    	
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
   
   <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
</head>
<body>
${msg }
<br>

<br>
<form id="myform" action="" method="post">
<!-- 查询条件 -->
<div class="query">
  <table>
    <caption>
              历史患者查询
       <hr>       
    </caption>
    <tr class="title">
       <td colspan="8">查询条件</td>
    </tr>
    <!-- 
             查询条件的控件命名:
       对于区间条件: b+字段名  做开始区间   e+字段名  结束区间
       对于非区间查询条件 :  q+字段名   
     -->
    <tr>
       <td>挂号单号</td>
       <td> 
          <input type = "text" name="qoid" />
       </td>
       <td>患者姓名</td>
       <td><input type = "text" name="qtruename" /></td>
       <td>患者性别</td>
       <td>
          <input type = "radio" name="qsex" value="1"  />男
		  <input type = "radio" name="qsex" value="2" />女
		  <input type = "radio" name="qsex" value="" />不限
       </td>
       <td>民族</td>
       <td>
         <select name="qnation">
				<option value="">==不限==</option>
				<c:forEach var = "nation" items = "${ocnation }" >
				<option value="${nation.value}" >${nation.name}</option>									
				</c:forEach>
			</select>			
       </td>
    </tr>
    <tr>
       <td>地区</td>
       <td>
        <select name="qcommunity">
			<option value="">==不限==</option>
			<c:forEach var = "community" items = "${occommunity }" >
			<option value="${community.value}">${community.name}</option>
			</c:forEach>
				</select>
       </td>
       <td>挂号时间段[B]</td>
       <td>
         <input type = "date" name="btime"/>
       </td>
       <td>挂号时间段[E]</td>
       <td>
         <input type = "date" name="etime"/>
       </td>
       <td></td>
       <td></td>
    </tr>
  </table>
</div>
<!-- 查询结果-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td></td>
       <td>序号</td>
       <td>挂号单号</td>
       <td>患者姓名</td>
       <td>患者性别</td>
       <td>民族</td>
       <td>医疗记录</td>
       <td>体检信息</td>
       <td></td>
    </tr>
      <c:choose>
      <c:when test="${rows!=null }">   <!-- choose 内部的when和otherwise相当于if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>
		      
		       </td>
		       <td>${vs.count}</td>
		       <td>
		        <a href="javascript:onEdit2('${ins.oid}')" >
		           <img alt="" src="<%=path%>/img/edit.png">
		            </a>
		       ${ins.oid }
		       </td>
		       <td>		       
		           ${ins.truename }
		       </td>
		       <td>${ins.cnsex }</td>
		       <td>${ins.cnnation }</td>
		       <td>				      		                  		         		         
		     <c:choose >
		     <c:when test="${ins.state==1 }">
		     <a href="javascript:onEdit('${ins.rid}')">
		           <img alt="" src="<%=path%>/img/edit.png">
		           		查看详情  ${ins.begintime }
		           		</a>
		     </c:when>
		     <c:otherwise>
		                                 没有相关记录
		     </c:otherwise>
		     </c:choose>
		         		      		            		          		         	        
		       </td>
		       <td>
		        <a href="javascript:onEdit3('${ins.uid}')">
		           <img alt="" src="<%=path%>/img/edit.png">
		           		点击查看  
		         </a> 
		   
		       </td>
		       <td>
		       	   
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
   ${pageController }  
</div>

<!-- 功能按钮 -->
<div class="button">
  <table>
    <tr>
      <td>
         <input type="submit" name="next" value="查询" formaction="<%=path%>/b1061.htm">

      </td>
    </tr>
  </table>
</div>
</form>
</body>
</html>