<%@ page language="java" pageEncoding="GBK"%>
<html>
<head>
<title>welcome,Login!</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/logincss/style.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/zcss/style.css">
<style>
h1 {
	color: #fff;
}

body {
	overflow: -Scroll;
	overflow-y: hidden;
}
</style>
</head>
<body>
	<section class="main">
		<div class="logo text-center">
			<h1>����ҽ�ƹ���ϵͳ</h1>
		</div>
		<div class="content-w3ls text-center">
			<img src="images/admin.png" alt="" class="img-responsive">
			<div class="login-page">
				<div class="form">
					<form class="register-form"
						action="${pageContext.request.contextPath}/register.htm?path=1"
						method="post">
						<div class="wthree-field">
							<input name="newaccount" id="text1" type="text" placeholder="�˺�" required>
						</div>
						<div class="wthree-field">
							<input name="newupass" id="myInput" type="Password" placeholder="����">
						</div>
						<div class="wthree-field">
							<button type="submit" class="btn">������Ϣ</button>
						</div>
						<div>
							<span style="color: #f00; font-weight: bold;">${param.flag==8?"�˺��������":""}</span>
						</div>
						<p class="message">
							�Ѿ�ע��? <a href="#">��¼</a>
						</p>
					</form>
					<form class="login-form"
						action="${pageContext.request.contextPath}/login.htm"
						method="post">
						<div class="wthree-field">
							<input name="account" id="text1" type="text" value=""
								placeholder="�˺�" required>
						</div>
						<div class="wthree-field">
							<input name="upass" id="myInput" type="Password" placeholder="����">
						</div>
						<div class="wthree-field">
							<button type="submit" class="btn">��¼</button>
						</div>
						<div>
							<span style="color: #f00">${param.flag==8?"�˺��������":""}</span>
								<span style="color: #f00">${msg }</span>
						</div>

						<p class="message">
							���û�? <a href="#">����ע��</a>
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