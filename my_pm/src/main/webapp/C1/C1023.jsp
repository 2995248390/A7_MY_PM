<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>挂号页面</title>
<link rel="icon" href="<%=path%>/images/favicon.png" type="image/gif" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/doccss/bootstrap.css" />
<link href="<%=path%>/css/doccss/font-awesome.min.css" rel="stylesheet" />
<link href="<%=path%>/css/doccss/style.css" rel="stylesheet" />
<link href="<%=path%>/css/doccss/responsive.css" rel="stylesheet" />
<style>
.contact_section {
	position: inherit;
}

.filter-box {
	width: 400px;
	height: 34px;
	background-color: #ffffff;
	border: solid 1px #dcdcdc;
	font-family: Roboto;
	font-size: 12px;
	font-weight: normal;
	font-style: normal;
	font-stretch: normal;
	letter-spacing: normal;
	text-align: left;
	color: #3d3d3d;
	padding-left: 10px;
	border-color: #dcdcdc;
	-webkit-appearance: none;
}

select {
	background: url("http://images.cnblogs.com/cnblogs_com/webqiand/636997/o_select.png") no-repeat scroll right center transparent;
	background-position: 222px 9px; 4
	font-family: Roboto;
	font-size: 12px;
	color: #3d3d3d;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<section class="contact_section layout_padding">
		<div class="contact_bg_box">
			<img src="<%=path%>/images/contact-bg.jpg" alt="">
		</div>
		<div class="container">
			<div class="heading_container heading_center">
				<h2>
					挂号单<br>${msg}
				</h2>
			</div>
			<div class="">
				<div class="row">
					<div class="col-md-7 mx-auto">
						<form action="<%=path%>/c1023.htm?did=${param.did}" method="post">
							<div class="contact_form-container">
								<div class="time">
									<select name="appiontment" class="filter-box">
										<option selected="selected" value="">==选择时间==</option>
										<c:forEach var="time" items="${timeList }">
											<option value="${time.appiontment}">${time.getTime}</option>
										</c:forEach>
									</select>
								</div>
								<div class="btn-box ">
									<button type="submit">提交</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>