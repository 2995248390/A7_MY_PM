<%@ page language="java"  pageEncoding="GBK"%>
<%String path = request.getContextPath();%>
<html>
<head>
<!-- 医生添加相关照片 -->
<script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
</head>
<body>
	<section>
	<div class="title"><h2>选择医生个人照片</h2></div>
	<div class="main">
			<!-- 上传图片 -->
			<div class="layui-upload">
				  <button type="button" class="layui-btn" id="test1">上传图片</button>
				  <div class="layui-upload-list">
				    <img class="layui-upload-img" id="demo1">
				    <p id="demoText"></p>
				  </div>
				  <div style="width: 95px;">
				    <div class="layui-progress layui-progress-big" lay-showpercent="yes" lay-filter="demo">
				      <div class="layui-progress-bar" lay-percent=""></div>
				    </div>
				  </div>
			</div>   
			<a name="list-progress"> </a>
	</div>
	</section>
	<section>
	<div class="title"><h2>选择诊所照片</h2></div>
	<div class="main">
			<!-- 上传图片 -->
			<div class="layui-upload">
				  <button type="button" class="layui-btn" id="test2">上传图片</button>
				  <div class="layui-upload-list">
				    <img class="layui-upload-img" id="demo2">
				    <p id="demoText"></p>
				  </div>
				  <div style="width: 95px;">
				    <div class="layui-progress layui-progress-big" lay-showpercent="yes" lay-filter="demo">
				      <div class="layui-progress-bar" lay-percent=""></div>
				    </div>
				  </div>
			</div>   
			<a name="list-progress"> </a>
	</div>
	</section>
	<button type="button" class="layui-btn layui-btn-lg layui-btn-normal" onclick="fh()">返回</button>
<script type="text/javascript">
	function fh(){
		window.open("<%=path%>/main.jsp","_parent")
	}
	layui.use(['upload', 'element', 'layer'], function(){
	  var $ = layui.jquery
	  ,upload = layui.upload
	  ,element = layui.element
	  ,layer = layui.layer;
	//常规使用 - 普通图片上传
	  var uploadInst = upload.render({
	    elem: '#test1'
	    ,url: '<%=path%>/s1001.htm?did=${userinfo.did}' //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
	    ,field:'docimg'
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	    	  $('#demo1').css({
		    		'width':'200px',
		    		'height':'200px'
		    	})
	        $('#demo1').attr('src', result); //图片链接（base64）
	      });
	      
	      element.progress('demo', '0%'); //进度条复位
	      layer.msg('上传中', {icon: 16, time: 0});
	    }
	    ,done: function(data){
	      //如果上传失败
	      if(data.code > 0){
	        return layer.msg('上传失败');
	      }
	      layer.open({
	    	  content:'修改成功'
	      });
	      
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
	  var uploadInst = upload.render({
		    elem: '#test2'
		    ,url: '<%=path%>/s1001.htm?did=${userinfo.did}' //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
		    ,field:'clinicimg'
		    ,before: function(obj){
		      //预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		    	  $('#demo2').css({
			    		'width':'200px',
			    		'height':'200px'
			    	})
		        $('#demo2').attr('src', result); //图片链接（base64）
		      });
		      
		      element.progress('demo', '0%'); //进度条复位
		      layer.msg('上传中', {icon: 16, time: 0});
		    }
		    ,done: function(data){
		      //如果上传失败
		      if(data.code > 0){
		        return layer.msg('上传失败');
		      }
		      layer.open({
		    	  content:'修改成功'
		      });
		      
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
	  
})
</script>
</body>
</html>