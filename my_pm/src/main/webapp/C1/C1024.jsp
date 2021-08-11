<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>挂号单生成后的信息</title>
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
				挂号单${vs.count}<br>${msg}
				</caption>
					<tr>
					<td>挂号单号:${order.onum}</td>		
					<td>挂号单id:${order.oid }		
					<td>医生名字:${order.docname }</td>
					<td>诊所地址:${order.clinicaddress }</td>
					<td>医生电话:${order.docphone }</td>
					</tr>
					<tr>
					<td>患者名字:${userinfo.truename }</td>	
					<td colspan="2">预约时间:${order.appointment }</td>				
					<td colspan="2">挂号单生成时间:${order.begintime }</td>
					<td colspan="2">挂号单完成时间:
					<c:choose>
					<c:when test="${empty order.overtime }">未完成</c:when>
					<c:otherwise>${order.overtime}</c:otherwise>
					</c:choose>
					</td>
					</tr>
				</table>
			</c:forEach>
	</div>
</body>
</html>