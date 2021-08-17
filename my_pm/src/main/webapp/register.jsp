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
  <legend>�û�ע��</legend>
</fieldset>
<form class="layui-form" action="" method="post" enctype="multipart/form-data"> 
	<!-- �˺������ -->
	<div class="layui-form-item">
	   		<label class="layui-form-label">�˺�</label>
	    <div class="layui-input-block">
	      	<input type="text" name="username" lay-verify="required" lay-reqtext="�˺��Ǳ��������Ϊ�գ�" placeholder="�������˺�" autocomplete="off" class="layui-input">
	    </div>
  	</div>
    <!-- ��������� -->
   	<div class="layui-form-item">
	   		<label class="layui-form-label">����</label>
	    <div class="layui-input-block">
	      	<input type="password" name="username" lay-verify="required" lay-reqtext="�����Ǳ��������Ϊ�գ�" placeholder="����������" autocomplete="off" class="layui-input">
	    </div>
  	</div>       	
    <!-- ���֤������� -->
	<div class="layui-form-item">
    <label class="layui-form-label">���֤:</label>
    <div class="layui-input-block">
      <input type="text" name="idcard" lay-verify="identity" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>
    <!-- �ֻ��ź����� -->
    <div class="layui-form-item">
	   <div class="layui-inline">
	      <label class="layui-form-label">�ֻ���</label>
	   <div class="layui-input-inline">
	       <input type="tel" name="phonenum" lay-verify="required|phone" autocomplete="off" class="layui-input">
	   </div>
	   </div>
	   <div class="layui-inline">
      	   <label class="layui-form-label">����:</label>
       <div class="layui-input-inline">
           <input type="text" name="mail" lay-verify="email" autocomplete="off" class="layui-input">
       </div>
       </div>
  	</div>
	<!-- ��Ů��ѡ�������ѡ��-->
	 <div class="layui-form-item" pane="">
	 	<div class="layui-inline">
		    <label class="layui-form-label">�Ա�:</label>
			    <div class="layui-input-block">
			      <input type="radio" name="sex" value="��" title="��" checked="">
			      <input type="radio" name="sex" value="Ů" title="Ů">
			    </div>
		</div>
		<div class="layui-inline">
     		 	<label class="layui-form-label">����:</label>
     		<div class="layui-input-inline">
        		<input type="text" name="birthday" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
     		</div>
    	</div>
 	 </div>
 	 <!-- ���������б� -->
	 <div class="layui-form-item">
	    	<label class="layui-form-label">����:</label>
	    <div class="layui-input-block">
	      <select name="nation" lay-filter="aihao">
	        	<option value=""></option>
	       	<c:forEach var="nation" items="${nationlist}">
				<option value="${nation.value}">${nation.name}</option>
			</c:forEach>
	      </select>
	    </div>
	  </div>
   	 <!-- ���������б� -->
   	 <div class="layui-form-item">
	    	<label class="layui-form-label">����:</label>
	    <div class="layui-input-block">
	      <select name="community" lay-filter="aihao">
	        		<option value=""></option>
	        	<c:forEach var="community" items="${communitylist}">
					<option value="${community.value}">${community.name}</option>
				</c:forEach>
	      </select>
	    </div>
	  </div>
 	 <!-- �û���ע -->
 	<div class="layui-form-item layui-form-text">
	    	<label class="layui-form-label">����ǩ��:</label>
	    <div class="layui-input-block">
	     	 <textarea placeholder="����������"  name="memo" class="layui-textarea"></textarea>
	    </div>
  	</div>
  	<!-- ��ť -->
  	<div class="layui-form-item">
	    <div class="layui-input-block">
	      <button type="submit" class="layui-btn" lay-submit="register.htm" lay-filter="demo1">�����ύ</button>
	      <button type="reset" class="layui-btn layui-btn-primary">����</button>
	      <button type="button" class="layui-btn" onclick="returnLogin()" lay-filter="demo1">����</button>
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
	  //�ϴ�ͼƬ�Ĳ���
	  var uploadInst = upload.render({
		    elem: '#test1'
		    ,url: 'uploadimg.htm' //�˴��õ��ǵ������� http ������ʾ��ʵ��ʹ��ʱ�ĳ����Լ����ϴ��ӿڼ��ɡ�
		    ,before: function(obj){
		      //Ԥ�������ļ�ʾ������֧��ie8
		      obj.preview(function(index, file, result){
		        $('#demo1').attr('src', result); //ͼƬ���ӣ�base64��
		      });
		      
		      element.progress('demo', '0%'); //��������λ
		      layer.msg('�ϴ���', {icon: 16, time: 0});
		    }
		    ,done: function(res){
		      //����ϴ�ʧ��
		      if(res.code > 0){
		        return layer.msg('�ϴ�ʧ��');
		      }
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
	  	//��Ⱦʱ���	
		laydate.render({
   	 		elem: '#date'
  		});
})
</script>
</body>
</html>