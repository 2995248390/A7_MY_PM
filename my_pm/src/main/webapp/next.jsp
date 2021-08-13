<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>�û�ע��</title>
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
					�û�ע��
					<hr>
				</caption>
				<tr>
					<td width="15%">�û�����:</td>
					<td width="35%"><e:text name="truename"
							 /></td>
					<td width="15%">���֤:</td>
					<td width="35%"><e:text name="idcard"  />
					</td>
				</tr>
				<tr>
					<td>�Ա�:</td>
					<td>
					<input type="radio" name="sex" value="1" checked="checked">��
					<input type="radio" name="sex" value="2">Ů
					</td>
					<td>����:</td>
					<td><e:text name="age" /></td>
				</tr>
				<tr>
					<td>����:</td>
					<td>
					<select name="nation">
						<c:forEach var="nation" items="${nationlist}">
						<option value="${nation.value}">${nation.name}</option>
						</c:forEach>
					</select>
					<td>����:</td>
					<td>
					<select name="community">
						<c:forEach var="community" items="${communitylist}">
						<option value="${community.value}">${community.name}</option>
						</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>����:</td>
					<td><e:date name="birthday"  /></td>
					<td>�ֻ���:</td>
					<td><e:text name="phonenumber" />
					</td>
				</tr>
				<tr>
					<td>��ַ:</td>
					<td><e:text name="address"  /></td>
					<td>����:</td>
					<td><e:text name="mail" /></td>
				</tr>
				<tr>
					<td>��ע:</td>
					<td colspan="3"><textarea rows="5" cols="60" name="memo" ></textarea></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4" align="center">
						<input type="submit" class="btn" value="ע��"  formaction="<%=path%>/register.htm">
						<input type="submit"  class="btn"  value="����" formaction="<%=path %>/login.jsp">
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