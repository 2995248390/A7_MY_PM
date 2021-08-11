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
	<br>
	<!--  ${ins }-->
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					用户${empty param.uid?'添加':'修改' }
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">用户信息</td>
				</tr>
				<tr>
					<td width="15%">用户账号</td>
					<td width="35%"><e:text name="maccount"
							defval="${ins.account }" /></td>
					<td width="15%">用户密码</td>
					<td width="35%"><e:text name="mpass" /></td>
				</tr>
				<tr>
					<td width="15%">用户姓名</td>
					<td width="35%"><e:text name="mtruename"
							defval="${ins.truename }" /></td>
					<td width="15%">身份证</td>
					<td width="35%"><e:text name="midcard" defval="${ins.idcard }" />
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td><e:radio name="msex" value="男:1,女:2"
							defval="${empty param.uid?'1':ins.sex }" /></td>
					<td>年龄</td>
					<td><e:text name="mage" defval="${ins.age }" /></td>
				</tr>
				<tr>
					<td>民族</td>
					<td><e:select value="ocnation" name="mnation"
							defval="${ins.nation }" /></td>
					<td>地区</td>
					<td><e:select value="occommunity" name="mcommunity"
							defval="${ins.community }" /></td>
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
					<td>备注</td>
					<td colspan="3"><e:textarea rows="5" cols="122" name="mmemo"
							defval="${ins.memo }" /></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next"
						value="${empty param.uid?'添加':'修改' }"
						formaction="<%=path%>/a101${empty param.uid?'3':'4' }.htm">
						<!--
	              /a1013.htm  --数据添加
	              /a1014.htm  --数据修改
	               
	            --> <input type="submit" name="next" value="返回"
						formnovalidate="formnovalidate" formaction="<%=path %>/a1011.htm">

					</td>
				</tr>
			</table>
		</div>

		<input type="hidden" name="uid" value="${param.uid }">
		<e:hidden name="qename" />
		<e:hidden name="qidcard" />
		<e:hidden name="qsex" />
		<e:hidden name="qnation" />
		<e:hidden name="qage" />
		<e:hidden name="qcommunity" />
		<e:hidden name="qaccount" />
		<e:hidden name="query" />


	</form>
</body>
</html>