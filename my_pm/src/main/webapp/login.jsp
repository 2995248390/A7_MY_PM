<%@ page language="java" pageEncoding="GBK"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>welcome,Login!</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/logincss/style.css"
	type="text/css">
<style>
h1 {
	color: #fff;
}
.content-w3ls img{
margin-bottom:50px;
}
body {
	overflow: -Scroll;
	overflow-y: hidden;
}
</style>
<script type="text/javascript">
	function fh(){
		location.href="main.jsp"
	}
</script>
</head>
<body>
	<section class="main">
		<div class="logo text-center">
			<h1>社区医疗管理系统</h1>
		</div>
		<div class="content-w3ls text-center">
			<img src="images/admin.png" alt="" class="img-responsive">
			<div class="login-page">
				<div class="form">
					<form class="login-form"
						action="${pageContext.request.contextPath}/login.htm"
						method="post">
						<div class="wthree-field">
							<input name="account" id="text1" type="text" value="" placeholder="账号" required>
						</div>
						<div class="wthree-field">
							<input name="upass" id="myInput" type="Password" placeholder="密码" required>
						</div>
						<div class="wthree-field">
							<button type="submit" class="btn">登录</button>
							<button type="button" class="btn" onclick="fh()">主页</button>
						</div>
						<div>
							<span style="color: #f00">${param.flag==8?"账号密码错误":""}</span>
								<span style="color: #f00">${msg }</span>
						</div>
						<p class="message">
							新用户? <a href="register.htm?path=1">立即注册</a>
						</p>
					</form>
				</div>
			</div>
			<script src='js/jquery.min.js'></script>
			<script src="js/script.js"></script>
		</div>
		<div class="copyright">
			<p>@ A7.Community health management system</p>
		</div>
	</section>
</body>
</html>