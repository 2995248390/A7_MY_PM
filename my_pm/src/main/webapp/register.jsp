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
margin:30px 200px;
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
  <legend>?û?ע??</legend>
</fieldset>
<form class="layui-form" action="register.htm" method="post"> 
	<!-- ?˺??????? -->
	<div class="layui-form-item">
	   		<label class="layui-form-label">?˺?</label>
	    <div class="layui-input-block">
	      	<input type="text" name="account" lay-verify="required" lay-reqtext="?˺??Ǳ????????Ϊ?գ?" placeholder="???????˺?" autocomplete="off" class="layui-input">
	    </div>
  	</div>
    <!-- ?????????? -->
   	<div class="layui-form-item">
	   		<label class="layui-form-label">????</label>
	    <div class="layui-input-block">
	      	<input type="password" name="upass" lay-verify="required" lay-reqtext="?????Ǳ????????Ϊ?գ?" placeholder="??????????" autocomplete="off" class="layui-input">
	    </div>
  	</div>       	
    <!-- ????֤???????? -->
	<div class="layui-form-item">
    <label class="layui-form-label">????֤:</label>
    <div class="layui-input-block">
      <input type="text" name="idcard" lay-verify="identity" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>
  <!-- ?????????? -->
	<div class="layui-form-item">
	   		<label class="layui-form-label">????</label>
	    <div class="layui-input-block">
	      	<input type="text" name="truename" lay-verify="required" lay-reqtext="?????Ǳ????????Ϊ?գ?" placeholder="??????????" autocomplete="off" class="layui-input">
	    </div>
  	</div>
    <!-- ?ֻ??ź????? -->
    <div class="layui-form-item">
	   <div class="layui-inline">
	      <label class="layui-form-label">?ֻ???</label>
	   <div class="layui-input-inline">
	       <input type="tel" name="phonenumber" lay-verify="required|phone" autocomplete="off" class="layui-input">
	   </div>
	   </div>
	   <div class="layui-inline">
      	   <label class="layui-form-label">????:</label>
       <div class="layui-input-inline">
           <input type="text" name="mail" lay-verify="email" autocomplete="off" class="layui-input">
       </div>
       </div>
  	</div>
	<!-- ??Ů??ѡ????????ѡ??-->
	 <div class="layui-form-item" pane="">
	 	<div class="layui-inline">
		    <label class="layui-form-label">?Ա?:</label>
			    <div class="layui-input-block">
			      <input type="radio" name="sex" value="1" title="??" checked="">
			      <input type="radio" name="sex" value="2" title="Ů">
			    </div>
		</div>
		<div class="layui-inline">
     		 	<label class="layui-form-label">????:</label>
     		<div class="layui-input-inline">
        		<input type="text" name="birthday" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
     		</div>
    	</div>
 	 </div>
 	 <!-- ?????????б? -->
	 <div class="layui-form-item">
	    	<label class="layui-form-label">????:</label>
	    <div class="layui-input-block">
	      <select name="nation" lay-filter="aihao">
	        	<option value=""></option>
	       	<c:forEach var="nation" items="${nationlist}">
				<option value="${nation.value}">${nation.name}</option>
			</c:forEach>
	      </select>
	    </div>
	  </div>
   	 <!-- ?????????б? -->
   	 <div class="layui-form-item">
	    	<label class="layui-form-label">????:</label>
	    <div class="layui-input-block">
	      <select name="community" lay-filter="aihao">
	        		<option value=""></option>
	        	<c:forEach var="community" items="${communitylist}">
					<option value="${community.value}">${community.name}</option>
				</c:forEach>
	      </select>
	    </div>
	  </div>
 	 <!-- ?û???ע -->
 	<div class="layui-form-item layui-form-text">
	    	<label class="layui-form-label">????ǩ??:</label>
	    <div class="layui-input-block">
	     	 <textarea placeholder="??????????"  name="memo" class="layui-textarea"></textarea>
	    </div>
  	</div>
  	<!-- ??ť -->
  	<div class="layui-form-item">
	    <div class="layui-input-block">
	      <input type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" value="?????ύ">
	      <button type="reset" class="layui-btn layui-btn-primary">????</button>
	      <button type="button" class="layui-btn" onclick="returnLogin()" lay-filter="demo1">????</button>
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
	  	//??Ⱦʱ????	
		laydate.render({
   	 		elem: '#date'
  		});
})
</script>
</body>
</html>