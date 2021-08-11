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
    	//用于页面跳转，获取下个页面所需主键
    	let currForm=document.getElementById("myform");
    	currForm.action="<%=path%>/a1032.htm?rid="+vrid;
    	//alert(currForm.action);
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
              评价管理
       <hr>       
    </caption>
    <tr class="title">
       <td colspan="10">查询条件</td>
    </tr>
    <!-- 
             查询条件的控件命名:
       对于区间条件: b+字段名  做开始区间   e+字段名  结束区间
       对于非区间查询条件 :  q+字段名   
     -->
    <tr>
       <td>用户账号</td>
       <td> 
          <e:text name="qaccount" />
       </td>
       <td>真实姓名</td>
       <td><e:text name="qtruename" /></td>
       <td>所属社区</td>
       <td><e:select value="occommunity" name="qcommunity" header="true" /></td>
       <td>用户状态</td>
       <td><e:text name="userstate"/></td>
    </tr>
    <tr>
       <td>性别</td>
       <td>
          <e:radio name="qsex" value="男:1,女:2,不限:''" defval=""/>
       </td>
       <td>评价分数[B]</td>
       <td>
         <e:text  name="bgrade" />
       </td>
       <td>评价分数[E]</td>
       <td>
         <e:text  name="egrade" />
       </td>
       <td>评价状态</td>
       <td><e:text name="qappraisestate"/></td>
    </tr>
  </table>
</div>
<!-- 查询结果-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td></td>
       <td>序号</td>
       <td>账号</td>
       <td>真实姓名</td>
       <td>评价状态</td>       
       <td>评价分数</td>
       <td >评价内容</td>
       <td></td>
    </tr>
    <!-- 行多行少都是事儿 -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose 内部的when和otherwise相当于if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>
		       <input type="checkbox" name="aid" value="${ins.aid }">
		       </td>
		       <td>${vs.count}</td>
		       <td>${ins.account }</td>
		       <td>
		           ${ins.truename }
		       </td>
		       <td>『${ins.appraisestate }』${ins.svalue }</td>
		       <td>${ins.grade }</td>
		       <td >${ins.text }</td>
		       <td></td>
		    </tr>
         </c:forEach>
		 <script>
		    newRows(10-${fn:length(rows)},8);
		 </script>
		 
      </c:when>
      <c:otherwise>   <!-- else -->
		    <script>
		      newRows(10,8);
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
         <input type="submit" name="next" value="查询" formaction="<%=path%>/a1051.htm">
         <!-- disabled="disabled" input内部有这个，按钮会变成灰色，不能点击  -->
         <input type="submit" name="next" value="显示"  formaction="<%=path%>/a1052.htm">
         <input type="submit" name="next" value="隐藏"  formaction="<%=path%>/a1053.htm">
      </td>
    </tr>
  </table>
</div>
</form>
</body>
</html>