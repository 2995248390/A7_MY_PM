<%@ page language="java" pageEncoding="GBK"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
@IMPORT url("<%=path%>/css/wangcss/style.css");
</style>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
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
					�Һŵ�
					<hr>
				</caption>
				<tr class="title">
					<td colspan="2">��д�Һŵ�</td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="truename"
						value="${ins.truename }"></td>
				</tr>
				<tr>
					<td>ѡ��ҽ��</td>
					<td></td>
				</tr>
				<tr>
					<td>ԤԼʱ��</td>
					<td></td>
				</tr>
				<tr>
					<td>״����������ѡ��</td>
					<td></td>
				</tr>
			</table>

		</div>
		<input type="hidden" name="rid" value="${ins.rid }">
	</form>
</body>
</body>
</html>