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
	<script type="text/javascript">
	function quanxuan(a)
	{
	    //找到下面所有的复选框
	    var ck =document.getElementsByClassName("qx");
	    
	    //遍历所有复选框，设置选中状态。
	    for(var i=0;i<ck.length;i++)
	    {
	        if(a.checked)//判断全选按钮的状态是不是选中的
	        {
	            ck[i].setAttribute("checked","checked");//如果是选中的，就让所有的状态为选中。
	        }
	        else
	        {
	            ck[i].removeAttribute("checked");//如果不是选中的，就移除所有的状态是checked的选项。
	        }
	    }
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
              医疗记录管理
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
       <td>记录状态</td>
       <td><e:text name="qrecordstate"/></td>
    </tr>
    <tr>
       <td>性别</td>
       <td>
          <e:radio name="qsex" value="男:1,女:2,不限:''" defval=""/>
       </td>
       <td>记录时间[B]</td>
       <td>
         <e:date  name="bbegintime"/>
       </td>
       <td>记录时间[E]</td>
       <td>
         <e:date  name="ebegintime"/>
       </td>
	   <td colspan="2"></td>
    </tr>
  </table>
</div>
<!-- 查询结果-->
<div class="data">
  <table id="dataTable">
    <tr class="title">
       <td>
       <input type="checkbox" onclick="quanxuan(this)" />全选<br />
       </td>
       <td>序号</td>
       <td>账号</td>
       <td>真实姓名</td>
       <td>性别</td>
       <td>社区</td>
       <td>记录状态</td>
       <td>录入时间</td>
       <td></td>
    </tr>
    <!-- 行多行少都是事儿 -->
    <c:choose>
      <c:when test="${rows!=null }">   <!-- choose 内部的when和otherwise相当于if  else  -->
         <c:forEach items="${rows }" var="ins" varStatus="vs">
		    <tr>
		       <td>
		       <input type="checkbox" class="qx" name="rid" value="${ins.rid }">
		       </td>
		       <td>${vs.count}</td>
		       <td>${ins.account }</td>
		       <td>		       
		           ${ins.truename }
		       </td>
		       <td>${ins.sex }</td>
		       <td>${ins.community }</td>
		       <td>${ins.state }</td>
		       <td>${ins.begintime }</td>
		       <td>
		       	   <a href="javascript:onEdit('${ins.rid}')" >		       	   	         
		           <img alt="" src="<%=path%>/img/edit.png">
					查看记录					
		           </a>
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
  <!-- 页码控制器，查询后左下角显示页码下拉列表 -->
  ${pageController }  
</div>

<!-- 功能按钮 -->
<div class="button">
  <table>
    <tr>
      <td>
         <input type="submit" name="next" value="查询" formaction="<%=path%>/a1031.htm">
         <!-- disabled="disabled" input内部有这个，按钮会变成灰色，不能点击  -->
         <input type="submit" id="delButton" name="next" value="删除"  formaction="<%=path%>/a1033.htm">
      </td>
    </tr>
  </table>
</div>
</form>
</body>
</html>