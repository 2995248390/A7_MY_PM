<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
 <style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");</style>
   <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
 <style type="text/css">
   #pageController{
       width:100px;
   }
 </style>
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
  // 全部选中显示项
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

<div id="msg" class="msg">  ${msg }</div >

<form id="myform" action="" method="post">

<!-- 1.查询条件 -->
<div class="query" >
  <table>
    <!-- part1，表头显示 -->
    <caption>
              体检档案管理
       <hr>      
    </caption>
    
    <tr class="title">
       <td colspan="8">查询条件</td>
    </tr>
    
    <!-- 
     part2，查询条件的控件命名:
                       对于区间条件: b+字段名  做开始区间   e+字段名  结束区间
                       对于非区间查询条件 :  q+字段名   
     -->
    <tr>
       <td>档案流水号</td>
       <td> 
          <input type="text" name="qaino"  id="qaino">
       </td>
       
       <td>用户编号</td>
       <td>
          <input type="text" name="qpno"  id="qpno">
       </td>
       
       <td>性别</td>
       <td>
         <input type = "radio" name="qsex" value="1" />男
		  <input type = "radio" name="qsex" value="2" />女
		  <input type = "radio" name="qsex" value="" />不限
       </td>
       
       <td>姓名</td>
       <td>
          <input type="text" name="qpname"  id="qpname">
       </td>
    </tr>
    <tr>
      
       <td>民族</td>
       <td>
          <select  name="qnation" >
       		<option value="">--不限--</option>
       		
       		<c:forEach var="com" items="${ocnation }" >
       		<c:choose>
       		<c:when test="${ocnation==com.value }">
       		<option value="${com.value }" selected="selected">${com.name }</option>
       		</c:when>
       		<c:otherwise>
       		<option value="${com.value }" >${com.name }</option>
       		</c:otherwise>
       		</c:choose>
      		</c:forEach>
       </select>
          
       </td>
       <td>起始录入时间</td>
       <td>
           <input type="date" name="binputdate"  id="binputdate">
       </td>
       <td>截止录入时间</td>
       <td>
          <input type="date" name="einputdate"  id="einputdate">
       </td>
         <td></td>
         <td></td>
    </tr>
  </table>
</div>

<!-- 2.查询结果 -->


<div  class="data">
  <table id="dataTable">
  
    <!-- 表头设计 -->
    <tr class="title">
       <td></td>
       <td>序号</td>
       <td>档案流水号</td>
       <td>用户编号</td>
       <td>姓名</td>
       <td>性别</td>
       <td>民族</td>
       <td>血压</td>
       <td>身高</td>
       <td>体重</td>
       <td>肺活量</td>
       <td>脉搏</td>
       <td></td>
    </tr>
    
    <!-- 结果显示在表头下 -->
    <c:choose>
       <c:when test="${rows!=null }">
          <c:forEach items="${rows }" var="ins" varStatus="vs">
            <tr class="title">
              <td>
              <input type="checkbox" class="checklist" name="rsnolist" value="${ins.bid}">
              </td>
              <td>${vs.count}</td>
              <td>${ins.bid}</td>
              <td>${ins.uid}</td>
              <td>${ins.truename }</td>
              <td>${ins.sex}</td>
              <td>${ins.nation}</td>
              <td>${ins.blood}</td>
              <td>${ins.height}</td>
              <td>${ins.weight}</td>
              <td>${ins.airs}</td>
              <td>${ins.pulse}</td>
              <td></td>
            </tr>
          </c:forEach>
          <script>
              newRows(10- ${fn:length(rows)},13);
          </script>
          
       </c:when>
       <c:otherwise>
          <script>
              newRows(10,13);
          </script>
       </c:otherwise>
     </c:choose>
   
  </table>
  
    <!-- 对于结果显示情况的控件 -->
   <input type="checkbox" name="1" id="contorlbox1" onclick="chooseall()" >全选
   <br>
   ${pageController }
   
</div>

  <!-- 功能按钮 -->
<div class="button">
  <table>
    <tr>
      <td>
         <input type="submit" name="next" value="查询"  formaction="<%=path%>/a1041.htm">
        <input type="submit" name="reback" value="返回"  formaction="<%=path%>/a1040.htm">
         <input type="submit" id="delButton" name="next" value="删除"  formaction="<%=path%>/a1042.htm">
      </td>
    </tr>
  </table>
</div>

</form>
</body>
</html>