<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
@IMPORT url("<%=path%>/css/wangcss/style.css");
</style>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
<script type="text/javascript">
	function onNext1() {
		//alert("hello");
		window.setTimeout("clearMsg()", "10000");
	}
	function clearMsg() {
		//ert("clear......");
		document.getElementById("msg").innerHTML = "";
	}
</script>
</head>
<body onload="onNext1()">
	<div id="msg" class="msg"></div>
	<br>
	<!--${ins }  -->
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					医生信息
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">医生信息</td>
				</tr>
				<tr>
					<td width="15%">姓名</td>
					<td width="35%"><input type="text" name="mtruename"
						value="${ins.truename }" readonly /></td>
					<td width="15%">擅长领域</td>
					<td width="35%"><input type="text" name="mspecialty"
						value="${ins.specialty }" readonly /></td>
				</tr>
				<tr>
					<td>医生等级</td>
					<td>
						<!--  <e:select value="一级医师:1,二级医师:2,三级医师:3,门诊医师:4"
							name="mlevel" defval="${ins.cnlevel }" readonly="true" />-->
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
					<td><input type="text" name="mclinicname"
						value="${ins.clinicname }" readonly /></td>
				</tr>
				<tr>
					<td>诊所地址</td>
					<td><input type="text" name="mclinicaddress"
						value="${ins.clinicaddress }" readonly /></td>
					<td>从医年份</td>
					<td><input type="text" name="mworkyear"
						value="${ins.workyear }" readonly /></td>
				</tr>
				<tr>
					<td>医生状态</td>
					<td>
						<!--<e:radio name="mdocstate" value="开放:1,关闭:2"
							defval="${ins.cndocstate }" readonly="true" />--> 
						<c:choose>
							<c:when test="${ins.cndocstate == 1 }">
								<input type="radio" name="mdocstate" value="1" checked="checked"
									readonly>开放
								<input type="radio" name="mdocstate" value="2" readonly>关闭
							</c:when>
							<c:otherwise>
								<input type="radio" name="mdocstate" value="1" readonly>开放
								<input type="radio" name="mdocstate" value="2" checked="checked"
									readonly>关闭
							</c:otherwise>
						</c:choose>
					</td>
					<td>注册日期</td>
					<td><input type="text" name="mbegintime"
						value="${ins.begintime }" readonly /></td>
				</tr>
				<tr>
					<td>格言</td>
					<td colspan="3">
						<!--<e:textarea rows="3" cols="122" name="mdescription" defval="${ins.description }" readonly="true" />-->
						<textarea rows="3" cols="122" name="mdescription" readonly>${ins.description }</textarea>
					</td>
				</tr>
				<tr>
					<td>个人描述</td>
					<td colspan="3">
						<!--  <e:textarea rows="3" cols="122" name="mdocdes"
							defval="${ins.docdes }" readonly="true" />--> <textarea rows="3"
							cols="122" name="mdocdes" readonly>${ins.docdes }</textarea>
					</td>
				</tr>
				<tr>
					<td>学习经历</td>
					<td colspan="3">
						<!--<e:textarea rows="3" cols="122"
							name="mlearndes" defval="${ins.learndes }" readonly="true" />-->
						<textarea rows="3" cols="122" name="mlearndes" readonly>${ins.learndes }</textarea>
					</td>
				</tr>
				<tr>
					<td>备注</td>
					<td colspan="3">
						<!--<e:textarea rows="5" cols="122" name="mmemo"
							defval="${ins.memo }" readonly="true" />--> 
						<textarea rows="3" cols="122" name="mmemo" readonly>${ins.memo }</textarea>
					</td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="编辑"
						formaction="<%=path%>/b1012.htm?path=1"></td>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>