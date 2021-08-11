<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
@IMPORT url("<%=path%>/css/wangcss/style.css");
</style>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
<style type="text/css">
#pageController {
	width: 75px;
}
</style>
<script type="text/javascript">
    let onEdit=function(vrid){
    	let currForm=document.getElementById("myform");
    	currForm.action="<%=path%>/b2011.htm?rid="+vrid;
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
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
					医疗记录管理
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
					<td>姓名</td>
					<td><e:text name="qtruename" /></td>
					<td>身份证号</td>
					<td><e:text name="qidcard" /></td>
					<td>性别</td>
					<td><e:radio name="qsex" value="男:1,女:2,不限:''" defval="" /></td>
					<td>民族</td>
					<td><e:select value="ocnation" name="qnation" header="true" />
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><e:text name="qage" /></td>
					<td>地区</td>
					<td><e:select value="occommunity" name="qcommunity"
							header="true" /></td>
					<!--    <td>工资区间[B]</td>
       <td>
         <e:number step="0.01" name="bsal"/>
       </td>
       <td>工资区间[E]</td>
       <td>
         <e:number step="0.01" name="esal"/>
       </td>
        -->
					<td>录入时间</td>
					<td><e:date name="qbegintime" /></td>
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
					<td>身份证</td>
					<td>账号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>医生嘱咐</td>
					<td>开药信息</td>
					<td></td>
				</tr>
				<!-- 行多行少都是事儿 -->
				<c:choose>
					<c:when test="${rows!=null }">
						<!-- if -->
						<c:forEach items="${rows }" var="ins" varStatus="vs">
							<tr>
								<td></td>
								<td>${vs.count}</td>
								<td>${ins.idcard }</td>
								<td><a href="javascript:onEdit('${ins.rid}')"> <img
										alt="" src="<%=path%>/img/edit.png"> ${ins.account }
								</a></td>
								<td>${ins.truename }</td>
								<td>${ins.cnsex }</td>
								<td>${ins.docsuggestion }</td>
								<td>${ins.drugmsg }</td>
								<td></td>
							</tr>
						</c:forEach>
						<script>
		    newRows(10-${fn:length(rows)},9);
		 </script>

					</c:when>
					<c:otherwise>
						<!-- else -->
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
					<td><input type="submit" name="next" value="查询"
						formaction="<%=path%>/b2010.htm"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>