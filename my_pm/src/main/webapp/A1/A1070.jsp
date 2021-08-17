<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<html>
<head>
<%
String path = request.getContextPath();
%>
<style type="text/css">
@IMPORT url("<%=path%>/css/wangcss/style.css");
</style>
<script>
		if(${empty msg}){
			alte(${msg})
		}
</script>
<style>
caption {
	font-size: 20px;
	font-weight: bolder;
}

hr {
	width: 200px;
}

table {
	width: 70%;
	border-collapse: collapse;
	margin: 0 auto;
}

td {
	font-size: 15px;
	color: #666;
	height: 40px;
}

table tr:nth-child(odd) {
	background: #fff;
}

table tr:nth-child(even) {
	background: #F5FAFA;
}

tr td:nth-child(odd) {
	text-align: right;
	padding-right: 15;
}

tr td:nth-child(even) {
	text-align: left;
}

.btn {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 上传图片 
	<div class="layui-upload">
		  <button type="button" class="layui-btn" id="test1">上传图片</button>
		  <div class="layui-upload-list">
		    <img class="layui-upload-img" id="demo1">
		    <p id="demoText"></p>
		  </div>
		  <div style="width: 95px;">
		    <div class="layui-progress layui-progress-big" lay-showpercent="yes" lay-filter="demo">
		      <div class="layui-progress-bar" lay-percent=""></div>
		    </div>
		  </div>
	</div>   
	<a name="list-progress"> </a>
	-->
	<form id="myform" action="" method="post">
		<table>
			<caption>
				个人中心
				<hr>
			</caption>
			<tr>
				<td>姓名:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    							${userinfo.truename}
    					</c:when>
						<c:otherwise>
							<input type="text" name="truename" value="${userinfo.truename}">
						</c:otherwise>
					</c:choose></td>
				<td>年龄:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    							${userinfo.age}
    					</c:when>
						<c:otherwise>
							<input type="text" name="age" value="${userinfo.age}">
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>账号:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    							${userinfo.account}
    					</c:when>
						<c:otherwise>
							<input type="text" value="${userinfo.account}" readonly>
						</c:otherwise>
					</c:choose></td>
				<td>用户类型:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    							${userinfo.cnsystype }
    					</c:when>
						<c:otherwise>
							<input type="text" value="${userinfo.cnsystype }" readonly>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>民族:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.cnnation}
    					</c:when>
						<c:otherwise>
							<e:select value="ocnation" name="nation"
								defval="${userinfo.cnnation}" />
						</c:otherwise>
					</c:choose></td>
				<td>性别:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.cnsex}
    					</c:when>
						<c:otherwise>
							<e:radio value="ocsex" name="sex" defval="${userinfo.sex}" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>生日:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    				${userinfo.birthday}
    					</c:when>
						<c:otherwise>
							<input type="date" value="${userinfo.birthday}">
						</c:otherwise>
					</c:choose></td>
				<td>手机号:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.phonenumber}
    					</c:when>
						<c:otherwise>
							<input type="text" value="${userinfo.phonenumber}">
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>地址:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    							${userinfo.address}
    					</c:when>
						<c:otherwise>
							<input type="text" value="${userinfo.address}">
						</c:otherwise>
					</c:choose></td>
				<td>邮箱:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.mail}
    					</c:when>
						<c:otherwise>
							<input type="text" value="${userinfo.mail}">
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>身份证号:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.idcard}
    					</c:when>
						<c:otherwise>
							<input type="text" value="${userinfo.idcard}" readonly>
						</c:otherwise>
					</c:choose></td>
				<td>社区:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.cncommunity}
    					</c:when>
						<c:otherwise>
							<e:select value="occommunity" name="community"
								defval="${userinfo.cncommunity}" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>个人签名:</td>
				<td colspan="4"><c:choose>
						<c:when test="${empty param.type}">
							<e:textarea rows="5" cols="130" name="memo"
								defval="${userinfo.memo }" />
						</c:when>
						<c:otherwise>
							<e:textarea rows="5" cols="130" name="memo"
								defval="${userinfo.memo }" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr class="btn">
				<td colspan="4" style="text-align: center;"><input
					type="submit" value="${empty param.type? "编辑":"修改" }"  
					formaction="<%=path%>${empty param.type?"/a1070.htm":"/a1071.htm" }">
					<input type="submit" value="返回"
					formaction="<%=path%>${empty param.type?"/information.jsp":"/A1/A1070.jsp" }">
				</td>
			</tr>
		</table>
		<input type="hidden" name="account" value="${userinfo.account }">
		<input type="hidden" name="upass" value="${userinfo.upass }">
	</form>
</body>
</html>