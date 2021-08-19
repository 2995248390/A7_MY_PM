<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>资讯页面</title>
<link rel="stylesheet" href="<%=path%>/css/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/slicknav.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/animate.min.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/magnific-popup.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/themify-icons.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/slick.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/nice-select.css">
<link rel="stylesheet" href="<%=path%>/css/assets/css/style.css">
<script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
</head>
<body>
	<div class="layui-carousel" id="test" >
  <div carousel-item="" class="imgw">
    <div>
    <section class="slider-area position-relative">
		<div class="slider-active">
			<!-- Single Slider -->
			<div
				class="single-slider slider-height hero-overly slider-bg1 d-flex  align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xxl-6 col-xl-7 col-lg-8 col-md-10 col-sm-12">
							<div class="hero-caption">
								<span data-animation="fadeInUp" data-delay=".2s">社区医疗</span>
								<h1 data-animation="fadeInUp" data-delay=".2s">专业社区医疗配套服务</h1>
								<P data-animation="fadeInUp" data-delay=".4s">持续创新社区医疗发展与家庭健康改善</P>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
    </div>
    <div>
    <section class="slider-area position-relative">
		<div class="slider-active">
			<!-- Single Slider -->
			<div
				class="single-slider slider-height hero-overly slider-bg2 d-flex  align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xxl-6 col-xl-7 col-lg-8 col-md-10 col-sm-12">
							<div class="hero-caption">
								<span data-animation="fadeInUp" data-delay=".2s">社区医疗</span>
								<h1 data-animation="fadeInUp" data-delay=".2s">专业社区医疗配套服务</h1>
								<P data-animation="fadeInUp" data-delay=".4s">持续创新社区医疗发展与家庭健康改善</P>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
    </div>
    <div>
    <section class="slider-area position-relative">
		<div class="slider-active">
			<!-- Single Slider -->
			<div
				class="single-slider slider-height hero-overly slider-bg3 d-flex  align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xxl-6 col-xl-7 col-lg-8 col-md-10 col-sm-12">
							<div class="hero-caption">
								<span data-animation="fadeInUp" data-delay=".2s">社区医疗</span>
								<h1 data-animation="fadeInUp" data-delay=".2s">专业社区医疗配套服务</h1>
								<P data-animation="fadeInUp" data-delay=".4s">持续创新社区医疗发展与家庭健康改善</P>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
    </div>
    <div>
    <section class="slider-area position-relative">
		<div class="slider-active">
			<!-- Single Slider -->
			<div
				class="single-slider slider-height hero-overly slider-bg4 d-flex  align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xxl-6 col-xl-7 col-lg-8 col-md-10 col-sm-12">
							<div class="hero-caption">
								<span data-animation="fadeInUp" data-delay=".2s">社区医疗</span>
								<h1 data-animation="fadeInUp" data-delay=".2s">专业社区医疗配套服务</h1>
								<P data-animation="fadeInUp" data-delay=".4s">持续创新社区医疗发展与家庭健康改善</P>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
    </div>
    <div>
    <section class="slider-area position-relative">
		<div class="slider-active">
			<!-- Single Slider -->
			<div
				class="single-slider slider-height hero-overly slider-bg5 d-flex  align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xxl-6 col-xl-7 col-lg-8 col-md-10 col-sm-12">
							<div class="hero-caption">
								<span data-animation="fadeInUp" data-delay=".2s">社区医疗</span>
								<h1 data-animation="fadeInUp" data-delay=".2s">专业社区医疗配套服务</h1>
								<P data-animation="fadeInUp" data-delay=".4s">持续创新社区医疗发展与家庭健康改善</P>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
    </div>
  </div>
</div> 
<script>
layui.use(['carousel'], function(){
	  var carousel = layui.carousel
	  //图片轮播
	  carousel.render({
	    elem: '#test'
	    ,width: '100%'
	    ,height: '100%'
	    ,interval: 5000
	  });
	  
})
</script>
</body>
</html>