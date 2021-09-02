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
<script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
<style type="text/css">
body{
background: url(<%=path%>/images/contact-bg.jpg) no-repeat bottom;
background-size: cover;
}
body:before {
    position: absolute;
    content: '';
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    background: rgba(0, 0, 0, 0.4);
    z-index: -1;
}
dd{
color:#000;
}
.layui-form-label{
padding:15px 15px;
}
</style>
</head>
<body>
	<section class="contact_section layout_padding">
		<div class="container">
			<div class="heading_container heading_center">
				<h2>
					挂号单<br>${msg}
				</h2>
			</div>
			<div class="">
				<div class="row">
					<div class="col-md-7 mx-auto">
						<form  class="layui-form" action="<%=path%>/c1023.htm?did=${param.did}" method="post">
							<div class="contact_form-container">
								<!-- 时间下拉列表 -->
								 <div class="layui-form-item">
								    	<label class="layui-form-label" style="font-size:20px;font-weight:bold; ">时间:</label>
								    <div class="layui-input-block">
								      <select name="appiontment" lay-filter="aihao">
								        	<option selected="selected" value="">==选择时间==</option>
										<c:forEach var="time" items="${timeList }">
											<option value="${time.appiontment}">${time.getTime}</option>
										</c:forEach>
	    							  </select>
	    							</div>
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