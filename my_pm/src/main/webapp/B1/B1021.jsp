<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>paramert title here</title>
<style type="text/css">
@IMPORT url("<%=path%>/css/wangcss/style.css");
</style>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
<script type="text/javascript">
    function onNext1()
    { 
    	//alert("hello");
    	window.setTimeout("clearMsg()","10000");
    }
    function clearMsg()
    {
    	//ert("clear......");
    	document.getElementById("msg").innerHTML="";
    }
  </script>
</head>
<body onload="onNext1()">
	<div id="msg" class="msg"></div>
	<br> ${msg }
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					修改诊所信息
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">诊所信息</td>
				</tr>
				<tr>
					<td width="15%">医生姓名</td>
					<td width="35%"><input type = "text" name="mtruename"
							value="${param.mtruename }" /></td>
					<td width="15%">诊所名称</td>
					<td width="35%"><input type = "text" name="mclinicname"
							value="${param.mclinicname }" /></td>
				</tr>
				<tr>
					<td>诊所状态</td>
					<td>
						<c:choose>
							<c:when test="${param.mdocstate == 1 }">
								<input type="radio" name="mdocstate" value="1" checked="checked" >开放
								<input type="radio" name="mdocstate" value="2" readonly>关闭
							</c:when>
							<c:otherwise>
								<input type="radio" name="mdocstate" value="1" readonly>开放
								<input type="radio" name="mdocstate" value="2" checked="checked" >关闭
							</c:otherwise>
						</c:choose>
					</td>
					<td width="15%">医生年龄</td>
					<td width="35%"><input type = "text" name="mage" value="${param.mage }" /></td>
				</tr>
				<tr>
					<td>医生性别</td>
					<td>
						<c:choose>
							<c:when test = "${param.msex == '1' }">
								<input type = "radio" name="msex" value="1" checked="checked"/>男
								<input type = "radio" name="msex" value="2" />女
							</c:when>
							<c:otherwise>
								<input type = "radio" name="msex" value="1" />男
								<input type = "radio" name="msex" value="2" checked="checked" />女
							</c:otherwise>
						</c:choose>		
					</td>
					<td>医生等级</td>
					<td>
						<select name="mlevel">
							<c:forEach var="level" items="${oclevel }">
								<c:choose>
									<c:when test="${param.mlevel == level.value }">
										<option value="${level.value}" selected="selected">${level.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${level.value}">${level.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<!--  <option value = "1">一级医师</option>
							<option value = "2">二级医师</option>
							<option value = "3">三级医师</option>
							<option value = "4">门诊医师</option>-->
					</select>
					</td>
				</tr>
				<tr>
					<td>上午上班时间</td>
					<td><input type="time" name="mopen1" value="${param.mopen1 }">
					</td>
					<td>上午下班时间</td>
					<td><input type="time" name="mclose1" value="${param.mclose1 }">
					</td>
				</tr>
				<tr>
					<td>下午上班时间</td>
					<td><input type="time" name="mopen2" value="${param.mopen2 }">
					</td>
					<td>下午下班时间</td>
					<td><input type="time" name="mclose2" value="${param.mclose2 }">
					</td>
				</tr>
				<tr>
					<td>上午预约人数</td>
					<td><input type = "text" name="mgetnum1" value="${param.mgetnum1 }" /></td>
					<td>下午预约人数</td>
					<td><input type = "text" name="mgetnum2" value="${param.mgetnum2 }" /></td>
				</tr>
				<tr>
					<td>预约天数</td>
					<td><input type = "text" name="mgetday" value="${param.mgetday }" /></td>
					<td>诊所地址</td>
					<td><input type = "text" name="mclinicaddress"
							value="${param.mclinicaddress }" /></td>
				</tr>
				<tr>
					<td>从医年份</td>
					<td><input type = "text" name="mworkyear" value="${param.mworkyear }" /></td>
					<td></td>
					<td></td>
				<tr>
					<td>诊所描述</td>
					<td colspan="3">
						<textarea rows="5" cols="122" name="mclinicdes" >${param.mclinicdes }</textarea>
					</td>
				
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="保存"
						formaction="<%=path%>/b1021.htm"> <input type="submit"
						name="next" value="返回" formnovalidate="formnovalidate"
						formaction="<%=path %>/b1020.htm">
					</td>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>