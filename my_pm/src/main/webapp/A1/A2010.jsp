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
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					查看个人信息
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">个人信息</td>
				</tr>
				<tr>
					<td width="15%">个人账号</td>
					<td width="35%"><e:text name="maccount"
							defval="${ins.account }" /></td>
					<td width="15%">个人密码</td>
					<td width="35%"><e:text name="mupass" defval="${ins.upass }" />
					</td>
				</tr>
				<tr>
					<td width="15%">姓名</td>
					<td width="35%"><e:text name="mtruename"
							defval="${ins.truename }" /></td>
					<td width="15%">身份证</td>
					<td width="35%"><e:text name="midcard" defval="${ins.idcard }" />
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td><e:radio name="msex" value="男:1,女:2"
							defval="${ins.cnsex }" /></td>
					<td>年龄</td>
					<td><e:text name="mage" defval="${ins.age }" /></td>
				</tr>
				<tr>
					<td>民族</td>
					<td><e:select value="ocnation" name="mnation"
							defval="${ins.cnnation }" /></td>
					<td>地区</td>
					<td><e:select value="occommunity" name="mcommunity"
							defval="${ins.cncommunity }" /></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><e:date name="mbirthday" defval="${ins.birthday }" /></td>
					<td>手机号</td>
					<td><e:text name="mphonenumber" defval="${ins.phonenumber }" />
					</td>
				</tr>
				<tr>
					<td>地址</td>
					<td><e:text name="maddress" defval="${ins.address }" /></td>
					<td>邮箱</td>
					<td><e:text name="mmail" defval="${ins.mail }" /></td>
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
					<td>注册日期</td>
					<td><e:text name="mbegintime" defval="${ins.begintime }" /></td>
				</tr>
				<tr>
					<td>医生描述</td>
					<td colspan="3"><e:textarea rows="3" cols="122"
							name="mdescription" defval="${ins.description }" /></td>
				</tr>
				<tr>
					<td>备注</td>
					<td colspan="3"><e:textarea rows="5" cols="122" name="mmemo"
							defval="${ins.memo }" /></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="修改"
						formaction="<%=path%>/a2012.htm?path=1"></td>
				</tr>
			</table>
		</div>

	</form>
</body>