<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
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
	${msg }
	<br> ${ins }
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					医生信息
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">修改医生信息</td>
				</tr>
				<tr>
					<td width="15%">姓名</td>
					<td width="35%"><input type="text" name="mtruename"
							value = "${param.mtruename }" /></td>
					<td width="15%">擅长领域</td>
					<td width="35%"><input type="text" name="mspecialty"
							value = "${param.mspecialty }" /></td>
				</tr>
				<tr>
					<td>医生等级</td>
					<td>
						<select name="mlevel">
							<c:forEach var="level" items="${oclevel }">
								<c:choose>
									<c:when test="${ins.cnlevel == level.value }">
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
					<td>诊所名称</td>
					<td><input type="text" name="mclinicname" value = "${param.mclinicname }" />
					</td>
				</tr>
				<tr>
					<td>诊所地址</td>
					<td><input type="text" name="mclinicaddress"
							value = "${param.mclinicaddress }" /></td>
					<td>从医年份</td>
					<td><input type="text" name="mworkyear" value = "${param.mworkyear }" /></td>
				</tr>
				<tr>
					<td>医生状态</td>
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
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>格言</td>
					<td colspan="3">
						<textarea rows="3" cols="122" name="mdescription">${param.mdescription }</textarea>
					</td>
				</tr>
				<tr>
					<td>个人描述</td>
					<td colspan="3">
						<textarea rows="3"
							cols="122" name="mdocdes" >${param.mdocdes }</textarea>
					</td>
				</tr>
				<tr>
					<td>学习经历</td>
					<td colspan="3">
						<textarea rows="3" cols="122" name="mlearndes" >${param.mlearndes }</textarea>
					</td>
				</tr>
				<tr>
					<td>备注</td>
					<td colspan="3">
						<textarea rows="3" cols="122" name="mmemo" >${param.mmemo }</textarea>
					</td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="保存"
						formaction="<%=path%>/b1011.htm"> <input type="submit"
						name="next" value="返回" formnovalidate="formnovalidate"
						formaction="<%=path %>/b1010.htm">
					</td>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>