<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>���ҽ��ҳ��</title>
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
							<h2>ҽ����Ա</h2>
							<p>�������в�����ʹ�ĳ���ſ�����ð�������ǻ�ÿһλ���ˡ�</p>
						</div>
					</div>
				</div>
				<div class="row">
					<c:forEach var="doc" items="${docList}" varStatus="st">

						<div class="col-lg-6 col-md-6">
							<div class="single-blogs mb-30">
								<div class="blog-img">
									<a href="<%=path%>/c1021.htm?did=${doc.did}">
									<img src="<%=path%>/docimg.htm?did=${doc.did}" style="width: 300px; height: 200px;">
									</a>
									<ul list-style="none">
										<li>�ó�����:${doc.specialty }</li>
										<li>ҽ��ְ��:${doc.cnlevel }</li>
										<li>�Ա�:${doc.cnsex }</li>
									</ul>
								</div>
								<div class="blog-caption">
									<h3>
										<a href="">${doc.truename }</a>
									</h3>
									<p>${doc.description }</p>
									<a href="<%=path%>/c1021.htm?did=${doc.did}" class="browse-btn">�˽����</a>
									<a href="<%=path%>/c1022.htm?did=${doc.did}" class="browse-btn">�Һ�</a>
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