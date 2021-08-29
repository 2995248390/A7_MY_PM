<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
 <style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");</style>
   <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
    <script type="text/javascript">
    function onNext1()
    { 
    	//alert("hello");
    	window.setTimeout("clearMsg()","5000");
    }
    function clearMsg()
    {
    	//ert("clear......");
    	document.getElementById("msg").innerHTML="";
    }
  </script>
</head>

<body class="onNext1()">
<div id="msg" class="msg">

 ${msg }

</div >
<form>
<div  class="data">
  <table id="dataTable">
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
    <c:choose>
       <c:when test="${rows!=null }">
          <c:forEach items="${rows }" var="ins" varStatus="vs">
            <tr class="title">
              <td>
              <input type="checkbox" name="rsnolist" value="${ins.bid}">
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
  ${pageController }
</div>
<div class="button">
  <table>
    <tr>
      <td>
        <input type="submit" name="reback" value="返回"  formaction="<%=path%>/main.jsp">
      </td>
    </tr>
  </table>
</div>
</form>
</body>
</html>