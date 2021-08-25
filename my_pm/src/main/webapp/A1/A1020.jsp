<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
   <%String path=request.getContextPath(); %>

<html>
<head>
<head>
   <title>医生账号管理</title>
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
<!-- 查询条件 -->
<div class="query">
  <table>
    <caption>
              医生账号管理
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
       <td>医生编号</td>
       <td> 
          <input type = "text" name="qdid" />
       </td>
       <td>姓名</td>
       <td><input type = "text" name="qtruename" /></td>
       <td>性别</td>
       <td>
          <input type = "radio" name="qsex" value="1" />男
		  <input type = "radio" name="qsex" value="2" />女
		  <input type = "radio" name="qsex" value="" />不限
       </td>
       <td>状态</td>
       <td>
       <input type="radio" name="qdocstate" value="1" />开放
       <input type="radio" name="qdocstate" value="2" />关闭
       <input type="radio" name="qdocstate" value="3" />删除
       <input type="radio" name="qdocstate" value="" />不限  
       </td>
    </tr>
    <tr>
       <td>所在地区</td>
       <td>
         <select name="qcommunity">
         		<option value="">==不限==</option>
				<c:forEach var="community" items="${occommunity}">									
				<option value="${community.value}" >${community.name}</option>									
				</c:forEach>
				</select>
       </td>
    <td>诊所名字</td>
    <td>
    <input type = "text" name="qclinicname"/>
    </td>   
     <td>医生等级</td>     
    <td>
    <select name="qlevel">
    	<option value="">==不限==</option>
    	<c:forEach var="level" items="${oclevel}">									
				<option value="${level.value}" >${level.name}</option>									
				</c:forEach>
    </select>
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
       <td>医生编号</td>
       <td>姓名</td>
       <td>性别</td>
       <td>门诊地址</td>
       <td>诊所名字</td>
       <td>状态</td>
       <td>所在地区</td>
       
    </tr>
    <!-- 行多行少都是事儿 -->
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

<!-- 功能按钮 -->
<div class="button">
  <table>
    <tr>
      <td>
         <input type="submit" name="next" value="查询" formaction="<%=path%>/a1021.htm">
         <input type="submit" value="添加" formaction="<%=path%>/a1022.htm">
         <input type="submit" id="delButton" name="next" value="删除"  formaction="<%=path%>/a1026.htm">
      </td>
    </tr>
  </table>
</div>

		
		
</form>
</body>
</html>