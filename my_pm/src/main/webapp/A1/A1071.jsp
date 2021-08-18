<%@ page language="java"   pageEncoding="GBK"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
<script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
<link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
<style>
.main{
margin:0px auto;
}
</style>
<script type="text/javascript">
	function fh(){
		location.href="<%=path%>/a1070.htm"
	}
</script>
</head>
<body>
	<div class="main">
	<!-- �ϴ�ͼƬ -->
	<div class="layui-upload">
		  <button type="button" class="layui-btn" id="test1">�ϴ�ͼƬ</button>
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
	  <button type="button" class="layui-btn layui-btn-lg layui-btn-normal" onclick="fh()">����</button>
	</div>
<script type="text/javascript">
layui.use(['upload', 'element', 'layer'], function(){
	  var $ = layui.jquery
	  ,upload = layui.upload
	  ,element = layui.element
	  ,layer = layui.layer;
	//����ʹ�� - ��ͨͼƬ�ϴ�
	  var uploadInst = upload.render({
	    elem: '#test1'
	    ,url: '<%=path%>/a1072.htm?uid=${userinfo.uid}' //�˴��õ��ǵ������� http ������ʾ��ʵ��ʹ��ʱ�ĳ����Լ����ϴ��ӿڼ��ɡ�
	    ,field:'userimg'
	    ,before: function(obj){
	      //Ԥ�������ļ�ʾ������֧��ie8
	      obj.preview(function(index, file, result){
	        $('#demo1').attr('src', result); //ͼƬ���ӣ�base64��
	      });
	      
	      element.progress('demo', '0%'); //��������λ
	      layer.msg('�ϴ���', {icon: 16, time: 0});
	    }
	    ,done: function(data){
	      //����ϴ�ʧ��
	      if(data.code > 0){
	        return layer.msg('�ϴ�ʧ��');
	      }
	      layer.open({
	    	  content:'�޸ĳɹ�'
	      });
	      
	      //�ϴ��ɹ���һЩ����
	      //����
	      $('#demoText').html(''); //�ÿ��ϴ�ʧ�ܵ�״̬
	    }
	    ,error: function(){
	      //��ʾʧ��״̬����ʵ���ش�
	      var demoText = $('#demoText');
	      demoText.html('<span style="color: #FF5722;">�ϴ�ʧ��</span> <a class="layui-btn layui-btn-xs demo-reload">����</a>');
	      demoText.find('.demo-reload').on('click', function(){
	        uploadInst.upload();
	      });
	    }
	    //������
	    ,progress: function(n, elem, e){
	      element.progress('demo', n + '%'); //����� layui ������Ԫ��ʹ��
	      if(n == 100){
	        layer.msg('�ϴ����', {icon: 1});
	      }
	    }
	  });
	  
})
</script>
</body>
</html>