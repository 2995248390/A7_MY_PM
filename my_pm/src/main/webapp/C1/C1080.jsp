<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>浏览医生页面</title>
<link rel="stylesheet" href="<%=path%>/css/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=path%>/css/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/slicknav.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/animate.min.css">
<link rel="stylesheet"
	href="<%=path%>/css/assets/css/magnific-popup.css">
<link rel="stylesheet"
	href="<%=path%>/css/assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/themify-icons.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/slick.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/nice-select.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/style.css">
<style>
ul {
	margin-top: 15px;
	font-size: 20px;
}
</style>
</head>
<body background="">
	<main>
		<section id="doc" class="home-blog section-padding">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-xl-8 col-lg-8 col-md-10">
						<!-- Section Tittle -->
						<div class="section-tittle text-center mb-40">
							<h2>资讯</h2>
							<p>掌握医疗知识,生活美好人生</p>
						</div>
					</div>
				</div>
				<div class="row">
					<c:forEach var="info" items="${infoList}" varStatus="st">

						<div class="col-lg-12 col-md-10">
							<div class="single-blogs mb-30">
								<div class="blog-img">
									
								
								</div>
								<div class="blog-caption">
									<h3>
										<a href="${info.url}">${info.memo}</a>
									</h3>
									<p>简介：${info.text }</p>
									
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
	</main>
</body>
</html>