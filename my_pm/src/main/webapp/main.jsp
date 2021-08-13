<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%
String path = request.getContextPath();
%>
<title>����ҽ��</title>
<style>
@import url("css/wangcss/main/main.css");
</style>
<script type="text/javascript" src="<%=path%>/js/jquery341.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/main/tendina.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/main/common.js"></script>
	<script type="text/javascript">
		if(	${userinfo==null}){
			$.ajax({
				url:'main.htm',
				type:'post',
				async:false,
				success:function(data){
					$(".layout_left_menu").html(data)
				}
			});
		};
		$(".left").toggle();

	</script>
</head>
<body>
	<!--����-->
	<div class="layout_top_header">
		<div style="float: left">
			<span
				style="font-size: 16px; line-height: 45px; padding-left: 20px; color: #a4caac">����ҽ�ƹ���ϵͳ
				</h1>
			</span>
		</div>
	<c:choose>
	<c:when test="${userinfo==null}">
			<div class="ad_setting">
			<a href="login.jsp"><span style="color: rgba(255, 255, 255, .5); margin-left: 30px;">��¼/ע��</span></a>
			</div>
			<div class="ad_setting">
			<span style="color: rgba(255, 255, 255, .5); margin-left: 30px;">�ο�</span>
			</div>
			<div class="ad_setting">
			<a href="information.jsp" target="menuFrame"><span style="color: rgba(255, 255, 255, .5); margin-left: 30px;">����ϵͳ</span></a>
			</div>
	</c:when>
	<c:otherwise>
	<div id="ad_setting" class="ad_setting">
			<a class="ad_setting_a" href="javascript:;"> <i
				class="icon-user glyph-icon" style="font-size: 20px"></i> <span>(${userinfo.truename})</span>
				<i class="icon-chevron-down glyph-icon"></i>
			</a>
			<ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
				<li class="ad_setting_ul_li"><a href="<%=path%>/A1/A1070.jsp"
					target="menuFrame"><i class="icon-user glyph-icon"></i> �������� </a></li>
				<li class="ad_setting_ul_li"><a href="<%=path%>/a1081.htm"
					target="menuFrame"><i class="icon-gear glyph-icon"></i> �˺Ű�ȫ </a></li>
				<li class="ad_setting_ul_li"><a href="<%=path%>/login.htm?flag=0"><i
					class="icon-signout glyph-icon"></i>�˳�</a></li>
			</ul>	
	</div>
	<div class="ad_setting">
		<span style="color: rgba(255, 255, 255, .5); margin-left: 30px;">${userinfo.cnsystype}</span>
	</div>
	<div class="ad_setting">
		<a href="information.jsp" target="menuFrame"><span style="color: rgba(255, 255, 255, .5); margin-left: 30px;">����ϵͳ</span></a>
	</div>
	</c:otherwise>
	</c:choose>

	</div>
	<!--�˵�-->
	<div class="left">
		<div id="my_menu" class="sdmenu">
			<div class="layout_left_menu">${sysmenu}</div>
		</div>
	</div>
	<div class="Switch"></div>
	<!-- ������ -->
	<div id="layout_right_content" class="layout_right_content">

		<div class="mian_content">
			<div id="page_content">
				<iframe id="menuFrame" name="menuFrame" src="information.jsp"
					style="overflow: visible;" scrolling="yes" frameborder="no"
					width="100%" height="100%"></iframe>
			</div>
		</div>
	</div>
	<!-- �ײ� -->
	<div class="layout_footer">
		<p>@ A7.Community health management system</p>
	</div>
</body>
</html>