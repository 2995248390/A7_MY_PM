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
	<form id="myform" action="" method="post">
		<table>
			<caption>
				��������
				<hr>
			</caption>
			<tr>
				<td>����:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    							${userinfo.truename}
    					</c:when>
						<c:otherwise>
							<input type="text" name="truename" value="${userinfo.truename}">
						</c:otherwise>
					</c:choose></td>
				<td>����:</td>
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
				<td>�˺�:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    							${userinfo.account}
    					</c:when>
						<c:otherwise>
							<input type="text" name="account" value="${userinfo.account}" readonly>
						</c:otherwise>
					</c:choose></td>
				<td>�û�����:</td>
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
				<td>����:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.cnnation}
    					</c:when>
						<c:otherwise>
						<select name="nation">
						<option value="${userinfo.nation }" selected="selected">${userinfo.cnnation }</option>
						<c:forEach var="nation" items="${ocnation }">
						<option value="${nation.value}">${nation.name }</option>
						</c:forEach>
						</select>
						</c:otherwise>
					</c:choose></td>
				<td>�Ա�:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.cnsex}
    					</c:when>
						<c:otherwise>
							<c:choose>
							<c:when test="${userinfo.sex=='1'}">
							<input type="radio" name="sex" value="1" checked="checked">��
							<input type="radio" name="sex" value="2">Ů
							</c:when>
							<c:otherwise>
							<input type="radio" name="sex" value="1" >��
							<input type="radio" name="sex" value="2" checked="checked">Ů 
							</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>����:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.birthday}
    					</c:when>
						<c:otherwise>
							<input type="date" name="birthday" value="${userinfo.birthday}">
						</c:otherwise>
					</c:choose></td>
				<td>�ֻ���:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.phonenumber}
    					</c:when>
						<c:otherwise>
							<input type="text" name="phonenumber" value="${userinfo.phonenumber}">
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>��ַ:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    							${userinfo.address}
    					</c:when>
						<c:otherwise>
							<input type="text" name="address" value="${userinfo.address}">
						</c:otherwise>
					</c:choose></td>
				<td>����:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.mail}
    					</c:when>
						<c:otherwise>
							<input type="text" name="mail" value="${userinfo.mail}" readonly>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>���֤��:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.idcard}
    					</c:when>
						<c:otherwise>
							<input type="text" value="${userinfo.idcard}" readonly>
						</c:otherwise>
					</c:choose></td>
				<td>����:</td>
				<td><c:choose>
						<c:when test="${empty param.type}">
    						${userinfo.cncommunity}
    					</c:when>
						<c:otherwise>
						<select name="community">
						<option value="${userinfo.community}">${userinfo.cncommunity}</option>
						<c:forEach var="community" items="${occommunity }">
						<option value="${community.value }">${community.name }</option>
						</c:forEach>
						</select>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td>����ǩ��:</td>
				<td colspan="4">
					<c:choose>
						<c:when test="${empty param.type}">
							<textarea rows="5" cols="130" name="memo"
								 disabled="disabled">${userinfo.memo}</textarea>
						</c:when>
						<c:otherwise>
							<textarea rows="5" cols="130" name="memo">${userinfo.memo }</textarea>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr class="btn">
				<td colspan="4" style="text-align: center;"><input
					type="submit" value="${empty param.type? "�༭":"�޸�" }"  
					formaction="<%=path%>${empty param.type?"/a1070.htm":"/a1071.htm" }">
					<input type="submit" value="����"
					formaction="<%=path%>${empty param.type?"/information.jsp":"/A1/A1070.jsp" }">
				</td>
			</tr>
		</table>
		<input type="hidden" name="upass" value="${userinfo.upass }">
	</form>
</body>
</html>