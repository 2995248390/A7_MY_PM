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
          <e:text name="qdid" />
       </td>
       <td>姓名</td>
       <td><e:text name="qtruename" /></td>
       <td>性别</td>
       <td>
          <e:radio name="qsex" value="男:1,女:2,不限:''" defval=""/>
       </td>
       <td>状态</td>
       <td>
       <e:radio name="qdocstate" value="开放:1,关闭:2" defval=""/>
         
       </td>
    </tr>
    <tr>
       <td>所在地区</td>
       <td>
         <e:select value="occommunity" name="qcommunity" header="true" />
       </td>
    <td>诊所名字</td>
    <td>
    <e:select value="occlinicname" name="qclinicname" header="true" />
    </td>   
     <td>医生等级</td>     
    <td>
    <e:select value="oclevel" name="qlevel" header="true" />
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