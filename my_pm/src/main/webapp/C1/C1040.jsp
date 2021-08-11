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
					挂号单
					<hr>
				</caption>
				<tr class="title">
					<td colspan="2">填写挂号单</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="truename"
						value="${ins.truename }"></td>
				</tr>
				<tr>
					<td>选择医生</td>
					<td></td>
				</tr>
				<tr>
					<td>预约时间</td>
					<td></td>
				</tr>
				<tr>
					<td>状况描述（可选）</td>
					<td></td>
				</tr>
			</table>

		</div>
		<input type="hidden" name="rid" value="${ins.rid }">
	</form>
</body>
</body>
</html>