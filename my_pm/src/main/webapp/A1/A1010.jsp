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
    let onEdit=function(vuid){
    	let currForm=document.getElementById("myform");
    	currForm.action="<%=path%>/a1012.htm?uid="+vuid;
    	//alert(currForm.action);
    	currForm.submit();
    }
    
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
	${msg}
	<br>
	<br>
	<form id="myform" action="" method="post">
		<!-- 查询条件 -->
		<div class="query">
			<table>
				<caption>
					用户账号管理管理
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
					<td><e:text name="qname" /></td>
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
					<td>账号</td>
					<td><e:text name="qaccount" /></td>
					<td></td>
					<td></td>

				</tr>
			</table>
		</div>
		<!-- 查询结果-->
		<div class="data">
			<table id="dataTable">
				<tr class="title">
					<td><input type="checkbox" onclick="quanxuan(this)" /></td>
					<td>序号</td>
					<td>身份证</td>
					<td>账号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>民族</td>
					<td>地区</td>
					<td>年龄</td>
					<td>状态</td>
				</tr>
				<!-- 行多行少都是事儿 -->
				<c:choose>
					<c:when test="${rows!=null }">
						<!-- if -->
						<c:forEach items="${rows }" var="ins" varStatus="vs">
							<tr>
								<td><input type="checkbox" class="qx" name="uid"
									value="${ins.uid }"></td>
								<td>${vs.count}</td>
								<td>${ins.idcard }</td>
								<td><a href="javascript:onEdit('${ins.uid}')"> <img
										alt="" src="<%=path%>/img/edit.png"> ${ins.account }
								</a></td>
								<td>${ins.truename }</td>
								<td>${ins.cnsex }</td>
								<td>${ins.cnnatino }</td>
								<td>${ins.cncommunity }</td>
								<td>${ins.age }</td>
								<td>${ins.cnstate }</td>
							</tr>
						</c:forEach>
						<script>
		    newRows(10-${fn:length(rows)},10);
		 </script>

					</c:when>
					<c:otherwise>
						<!-- else -->
						<script>
		      newRows(10,10);
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
						formaction="<%=path%>/a1011.htm"> <input type="submit"
						value="添加" formaction="<%=path%>/a1010.htm?path=1"> <input
						type="submit" id="delButton" name="next" value="删除"
						formaction="<%=path%>/a1015.htm"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>