<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>×ÊÑ¶Ò³Ãæ</title>
<script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
</head>
<body>
	<div class="layui-carousel" id="test" >
  <div carousel-item="">
    <div><img alt="" src="<%=path%>/images/bg.jpg" style="width:100%;height:100%"></div>
    <div><img alt="" src="<%=path%>/images/bg2.jpg" style="width:100%;height:100%"></div>
    <div><img alt="" src="<%=path%>/images/bg3.jpg" style="width:100%;height:100%"></div>
    <div><img alt="" src="<%=path%>/images/true.jpg" style="width:100%;height:100%"></div>
    <div><img alt="" src="<%=path%>/images/test.jpg" style="width:100%;height:100%"></div>
  </div>
</div> 
<script>
layui.use(['carousel'], function(){
	  var carousel = layui.carousel
	  //Í¼Æ¬ÂÖ²¥
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