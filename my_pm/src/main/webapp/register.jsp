<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
</head>
<style>
body{
background: url(<%=path%>/images/bg2.jpg) no-repeat bottom;
background-size: cover;
}
.register{
background:RGB(255,255,255);
margin:30px 400px;
padding:15px 0px;
}
form{
margin:0px auto;
width:60%;
}
</style>
<body>
<div class="register">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>用户注册</legend>
</fieldset>
<form class="layui-form" action="" method="post" enctype="multipart/form-data"> 
	<!-- 账号输入框 -->
	<div class="layui-form-item">
	   		<label class="layui-form-label">账号</label>
	    <div class="layui-input-block">
	      	<input type="text" name="username" lay-verify="required" lay-reqtext="账号是必填项，岂能为空？" placeholder="请输入账号" autocomplete="off" class="layui-input">
	    </div>
  	</div>
    <!-- 密码输入框 -->
   	<div class="layui-form-item">
	   		<label class="layui-form-label">密码</label>
	    <div class="layui-input-block">
	      	<input type="password" name="username" lay-verify="required" lay-reqtext="密码是必填项，岂能为空？" placeholder="请输入密码" autocomplete="off" class="layui-input">
	    </div>
  	</div>       	
    <!-- 身份证号输入框 -->
	<div class="layui-form-item">
    <label class="layui-form-label">身份证:</label>
    <div class="layui-input-block">
      <input type="text" name="idcard" lay-verify="identity" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>
    <!-- 手机号和邮箱 -->
    <div class="layui-form-item">
	   <div class="layui-inline">
	      <label class="layui-form-label">手机号</label>
	   <div class="layui-input-inline">
	       <input type="tel" name="phonenum" lay-verify="required|phone" autocomplete="off" class="layui-input">
	   </div>
	   </div>
	   <div class="layui-inline">
      	   <label class="layui-form-label">邮箱:</label>
       <div class="layui-input-inline">
           <input type="text" name="mail" lay-verify="email" autocomplete="off" class="layui-input">
       </div>
       </div>
  	</div>
	<!-- 男女单选框和生日选择-->
	 <div class="layui-form-item" pane="">
	 	<div class="layui-inline">
		    <label class="layui-form-label">性别:</label>
			    <div class="layui-input-block">
			      <input type="radio" name="sex" value="男" title="男" checked="">
			      <input type="radio" name="sex" value="女" title="女">
			    </div>
		</div>
		<div class="layui-inline">
     		 	<label class="layui-form-label">生日:</label>
     		<div class="layui-input-inline">
        		<input type="text" name="birthday" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
     		</div>
    	</div>
 	 </div>
 	 <!-- 民族下拉列表 -->
	 <div class="layui-form-item">
	    	<label class="layui-form-label">民族:</label>
	    <div class="layui-input-block">
	      <select name="nation" lay-filter="aihao">
	        	<option value=""></option>
	       	<c:forEach var="nation" items="${nationlist}">
				<option value="${nation.value}">${nation.name}</option>
			</c:forEach>
	      </select>
	    </div>
	  </div>
   	 <!-- 地区下拉列表 -->
   	 <div class="layui-form-item">
	    	<label class="layui-form-label">社区:</label>
	    <div class="layui-input-block">
	      <select name="community" lay-filter="aihao">
	        		<option value=""></option>
	        	<c:forEach var="community" items="${communitylist}">
					<option value="${community.value}">${community.name}</option>
				</c:forEach>
	      </select>
	    </div>
	  </div>
 	 <!-- 用户备注 -->
 	<div class="layui-form-item layui-form-text">
	    	<label class="layui-form-label">个性签名:</label>
	    <div class="layui-input-block">
	     	 <textarea placeholder="请输入内容"  name="memo" class="layui-textarea"></textarea>
	    </div>
  	</div>
  	<!-- 按钮 -->
  	<div class="layui-form-item">
	    <div class="layui-input-block">
	      <button type="submit" class="layui-btn" lay-submit="register.htm" lay-filter="demo1">立即提交</button>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	      <button type="button" class="layui-btn" onclick="returnLogin()" lay-filter="demo1">返回</button>
	    </div>
  	</div>
</form>
</div>
<script>
function returnLogin(){
	location.href="login.jsp";
}
layui.use(['upload','form', 'layedit', 'laydate','element', 'layer'], function(){
	  var form = layui.form
	  var $ = layui.jquery
	  ,upload = layui.upload
	  ,element = layui.element
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	  //上传图片的操作
	  var uploadInst = upload.render({
		    elem: '#test1'
		    ,url: 'uploadimg.htm' //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		        $('#demo1').attr('src', result); //图片链接（base64）
		      });
		      
		      element.progress('demo', '0%'); //进度条复位
		      layer.msg('上传中', {icon: 16, time: 0});
		    }
		    ,done: function(res){
		      //如果上传失败
		      if(res.code > 0){
		        return layer.msg('上传失败');
		      }
		      //上传成功的一些操作
		      //……
		      $('#demoText').html(''); //置空上传失败的状态
		    }
		    ,error: function(){
		      //演示失败状态，并实现重传
		      var demoText = $('#demoText');
		      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
		      demoText.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
		    //进度条
		    ,progress: function(n, elem, e){
		      element.progress('demo', n + '%'); //可配合 layui 进度条元素使用
		      if(n == 100){
		        layer.msg('上传完毕', {icon: 1});
		      }
		    }
		  });
	  	//渲染时间框	
		laydate.render({
   	 		elem: '#date'
  		});
})
</script>
</body>
</html>