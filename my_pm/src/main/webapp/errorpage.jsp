<%@ page language="java" pageEncoding="GBK"%>
<html>
<head>
<%String path = request.getContextPath();%>
<link href="<%=path%>/css/errorcss/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="<%=path%>/css/errorcss/font-awesome.css" rel="stylesheet"
	type="text/css" media="all" />
<body>

	<div class="container-w3layouts  text-center">
		<h2 class="txt-wthree">${empty msg?msg:"ÍøÂç´íÎó"}</h2>
		<p>
			Looks like the page you are trying to visit does not exist <br>
			Please check the URL and Try again.
		</p>
		<div class="home">
			<a href="<%=path%>/login.htm?path=1" target="_parent">home</a>
		</div>
	</div>
	<div class="w3_agile-footer">
		<p>@ A7.Community health management system</p>
	</div>
</body>
</html>