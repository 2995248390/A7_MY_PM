<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
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
					<td width="35%"><e:text name="mtruename"
							defval="${ins.truename }" /></td>
					<td width="15%">擅长领域</td>
					<td width="35%"><e:text name="mspecialty"
							defval="${ins.specialty }" /></td>
				</tr>
				<tr>
					<td>医生等级</td>
					<td><e:select value="一级医师:1,二级医师:2,三级医师:3,门诊医师:4"
							name="mlevel" defval="${ins.cnlevel }" /></td>
					<td>诊所名称</td>
					<td><e:text name="mclinicname" defval="${ins.clinicname }" />
					</td>
				</tr>
				<tr>
					<td>诊所地址</td>
					<td><e:text name="mclinicaddress"
							defval="${ins.clinicaddress }" /></td>
					<td>从医年份</td>
					<td><e:text name="mworkyear" defval="${ins.workyear }" /></td>
				</tr>
				<tr>
					<td>医生状态</td>
					<td><e:radio name="mdocstate" value="开放:1,关闭:2"
							defval="${ins.cndocstate }" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>格言</td>
					<td colspan="3"><e:textarea rows="3" cols="122"
							name="mdescription" defval="${ins.description }" /></td>
				</tr>
				<tr>
					<td>个人描述</td>
					<td colspan="3"><e:textarea rows="3" cols="122" name="mdocdes"
							defval="${ins.docdes }" /></td>
				</tr>
				<tr>
					<td>学习经历</td>
					<td colspan="3"><e:textarea rows="3" cols="122"
							name="mlearndes" defval="${ins.learndes }" /></td>
				</tr>
				<tr>
					<td>备注</td>
					<td colspan="3"><e:textarea rows="5" cols="122" name="mmemo"
							defval="${ins.memo }" /></td>
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