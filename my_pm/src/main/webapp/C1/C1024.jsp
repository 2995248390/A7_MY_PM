<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>�Һŵ����ɺ����Ϣ</title>
<style>
table {
	border: 2px solid RGB(193,210,240);
	width: 90%;
	border-collapse: collapse;
	margin: 10px 0;
}

td {
	text-align: center;
	font-size: 15px;
	color: #666;
	height: 40px;
	pading:0px 10px;
}

table tr:nth-child(odd) {
	background: #fff;
}

table tr:nth-child(even) {
	background: #F5FAFA;
}
</style>
</head>
<body>
	<div align="center">
			<c:forEach var="order" items="${orderList }" varStatus="vs">
				<table >
				<caption>
				�Һŵ�${vs.count}<br>${msg}
				</caption>
					<tr>
					<td>�Һŵ���:${order.onum}</td>		
					<td>�Һŵ�id:${order.oid }		
					<td>ҽ������:${order.docname }</td>
					<td>������ַ:${order.clinicaddress }</td>
					<td>ҽ���绰:${order.docphone }</td>
					</tr>
					<tr>
					<td>��������:${userinfo.truename }</td>	
					<td colspan="2">ԤԼʱ��:${order.appointment }</td>				
					<td colspan="2">�Һŵ�����ʱ��:${order.begintime }</td>
					<td colspan="2">�Һŵ����ʱ��:
					<c:choose>
					<c:when test="${empty order.overtime }">δ���</c:when>
					<c:otherwise>${order.overtime}</c:otherwise>
					</c:choose>
					</td>
					</tr>
				</table>
			</c:forEach>
	</div>
</body>
</html>