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
	<br>
	<!--  ${ins }-->
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					查看诊所信息
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">诊所信息</td>
				</tr>
				<tr>
					<td width="15%">医生姓名</td>
					<td width="35%"><e:text name="mtruename"
							defval="${ins.truename }" /></td>
					<td width="15%">诊所名称</td>
					<td width="35%"><e:text name="mclinicname"
							defval="${ins.clinicname }" /></td>
				</tr>
				<tr>
					<td>诊所状态</td>
					<td><e:radio name="mdocstate" value="开放:1,关闭:2"
							defval="${ins.cndocstate }" /></td>
					<td width="15%">医生年龄</td>
					<td width="35%"><e:text name="mage" defval="${ins.age }" /></td>
				</tr>
				<tr>
					<td>医生性别</td>
					<td><e:radio name="msex" value="男:1,女:2"
							defval="${ins.cnsex }" /></td>
					<td>医生等级</td>
					<td><e:select value="一级医师:1,二级医师:2,三级医师:3,门诊医师:4"
							name="mlevel" defval="${ins.cnlevel }" /></td>
				</tr>
				<tr>
					<td>上午上班时间</td>
					<td><input type="time" name="mopen1" value="${ins.open1 }">
					</td>
					<td>上午下班时间</td>
					<td><input type="time" name="mclose1" value="${ins.close1 }">
					</td>
				</tr>
				<tr>
					<td>下午上班时间</td>
					<td><input type="time" name="mopen2" value="${ins.open2 }">
					</td>
					<td>下午下班时间</td>
					<td><input type="time" name="mclose2" value="${ins.close2 }">
					</td>
				</tr>
				<tr>
					<td>上午预约人数</td>
					<td><e:text name="mgetnum1" defval="${ins.getnum1 }" /></td>
					<td>下午预约人数</td>
					<td><e:text name="mgetnum2" defval="${ins.getnum2 }" /></td>
				</tr>
				<tr>
					<td>预约天数</td>
					<td><e:text name="mgetday" defval="${ins.getday }" /></td>
					<td>诊所地址</td>
					<td><e:text name="mclinicaddress"
							defval="${ins.clinicaddress }" /></td>
				</tr>
				<tr>
					<td>从医年份</td>
					<td><e:text name="mworkyear" defval="${ins.workyear }" /></td>
					<td>注册日期</td>
					<td><e:text name="mbegintime" defval="${ins.begintime }" /></td>
				<tr>
					<td>诊所描述</td>
					<td colspan="3"><e:textarea rows="5" cols="122"
							name="mclinicdes" defval="${ins.clinicdes }" /></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="编辑"
						formaction="<%=path%>/B1/B1021.jsp"></td>
				</tr>
			</table>
		</div>

	</form>
</body>