<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>用户注册</title>
<style type="text/css">
html {
	scroll-behavior: smooth;
}
body, html {
	margin: 0;
	padding: 0;
	color: #585858;
}
form{
	
	background-size:100% 100%;
}
.main {
	background: url(<%=path%>/images/bg2.jpg) no-repeat bottom;
	background-size: cover;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	-ms-background-size: cover;
	min-height: 100vh;
	padding: 2em 0;
	position: relative;
	z-index: 1;
	justify-content: center;
	display: grid;
	align-items: center;
}
.main:before {
	position: absolute;
	content: '';
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	background: rgba(0, 0, 0, 0.1);
	z-index: -1;
}
.btn {
	color:#fff;
	font-size:15px;
	width:100px;
	padding:6px 6px;
	background:#EA4C89;
	cursor: pointer;
	border:0px;
	border-radius:35px;
}
.btn:hover {
	background: #de3d7b;
}
td{
	color:#fff;
	font-size:13px;
	font-weight:bold;
}
hr{
width:200px;
}
caption {
	color:#fff;
	font-size:20px;
	font-weight:bold;
}
</style>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
</head>
<body onload="onNext1()">
<section class="main">
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					用户注册
					<hr>
				</caption>
				<tr>
					<td width="15%">用户姓名:</td>
					<td width="35%"><e:text name="truename"
							 /></td>
					<td width="15%">身份证:</td>
					<td width="35%"><e:text name="idcard"  />
					</td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><e:radio name="sex" value="男:1,女:2"
							defval="1" /></td>
					<td>年龄:</td>
					<td><e:text name="age" /></td>
				</tr>
				<tr>
					<td>民族:</td>
					<td><e:select value="ocnation" name="nation"
							/></td>
					<td>地区:</td>
					<td><e:select value="occommunity" name="community"
							 /></td>
				</tr>
				<tr>
					<td>生日:</td>
					<td><e:date name="birthday"  /></td>
					<td>手机号:</td>
					<td><e:text name="phonenumber" />
					</td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><e:text name="address"  /></td>
					<td>邮箱:</td>
					<td><e:text name="mail" /></td>
				</tr>
				<tr>
					<td>备注:</td>
					<td colspan="3"><textarea rows="5" cols="60" name="memo" ></textarea></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4" align="center">
						<input type="submit" class="btn" value="注册"  formaction="<%=path%>/register.htm">
						<input type="submit"  class="btn"  value="返回" formaction="<%=path %>/login.jsp">
					</td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="account" value="${account }">
		<input type="hidden" name="upass" value="${upass}">
	</form>
	</section>
</body>
</html>