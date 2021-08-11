<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>医生详细页面</title>
<link rel="icon" href="<%=path%>/images/favicon.png" type="image/gif" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/doccss/bootstrap.css" />
<link href="<%=path%>/css/doccss/font-awesome.min.css" rel="stylesheet" />
<link href="<%=path%>/css/doccss/style.css" rel="stylesheet" />
<link href="<%=path%>/css/doccss/responsive.css" rel="stylesheet" />
<style>
table {
	border: 2px solid RGB(193,210,240);
	width: 85%;
	border-collapse: collapse;
	margin: 10px 0;
}

td {
	padding:0px 10px;
	width:200px;
	text-align: center;
	font-size: 15px;
	color: #666;
	height: 25px;
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
	<header class="header_section">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-lg custom_nav-container">
				<a class="navbar-brand" href=""> <span> ${doc.truename }.${doc.cnlevel}
				</span>
				</a>
			</nav>
		</div>
	</header>
	<section class="slider_section position-relative">
		<div class="slider_bg_box">
			<img src="<%=path%>/images/slider-bg.jpg" alt="">
		</div>
		<div class="slider_bg"></div>
		<div class="container">
			<div class="col-md-6 ml-auto">
				<div class="detail-box">
					<h1>
						欢迎来到${doc.clinicname } <br>
					</h1>
					<p>${doc.description }</p>
					<div>
						<a href="<%=path%>/c1022.htm?did=${doc.did}" class="slider-link">
							挂号 </a> <a href="<%=path%>/C1/C1020.jsp" class="slider-link"> 返回
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="doc" class="spcl_section layout_padding">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="detail_container">
						<div class="detail-box">
							<img src="<%=path%>/images/s1.jpg" alt="">
							<h5>擅长领域</h5>
							<p>${doc.specialty }</p>
						</div>
						<div class="detail-box">
							<img src="<%=path%>/images/s2.jpg" alt="">
							<h5>从医经历</h5>
							<p>${doc.learndes }</p>
						</div>
						<div class="detail-box">
							<img src="<%=path%>/images/s3.jpg" alt="">
							<h5>营业时间</h5>			
							<p>时间段1:</p>
							<p>${doc.open1 }~~~${doc.close1}</p>
							<p>时间段2:</li>
							<p>${doc.open2 }~~~${doc.close2}</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-5 ml-auto">
					<div class="img-box">
						<img src="<%=path%>/images/spcl-img.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="#appraise" class="about_section  layout_padding-bottom">
		<div class="container">
				<h2>
					查看评论
				</h2>
			<div class="row">
				<c:forEach var="app" items="${appraiseList }">
					<table>
						<tr>
							<td >用户名字:</td>
							<td>${app.truename}</td>
							<td>开始治疗时间:</td>
							<td>${app.begintime }</td>
							<td>完成治疗时间:</td>
							<td>${app.overtime }</td>
						</tr>
						<tr>
							<td>评论:</td>
							<td colspan="5">
							<e:textarea rows="3" cols="100" name="text"
								defval="${app.text }" disabled="true" />
							</td>
						</tr>
						</table>
				</c:forEach>
			</div>
		</div>
	</section>
</body>
</html>