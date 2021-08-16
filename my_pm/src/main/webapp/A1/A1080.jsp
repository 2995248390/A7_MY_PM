<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String path=request.getContextPath(); %>
<html>
<head>
<style type="text/css">
table {
	border: 2px solid RGB(193,210,240);
	width: 70%;
	border-collapse: collapse;
	margin: 10px 0;
}

td {
	text-align: center;
	font-size: 15px;
	color: #666;
	height: 40px;
}

table tr:nth-child(odd) {
	background: #fff;
}

table tr:nth-child(even) {
	background: #F5FAFA;
}
</style>
</head>
<body>
<form action="" method="post">
 <div align="center">
 <br>
 ${msg}
 ${msg1}
   <table align="center">
	<caption>
             安全中心
       <hr>       
    </caption>  
    <tr>
    	
    	<td>
    		请输入验证码：
    		<input type="text" name="mailcode"/>
    	</td>
    	<td>
    	<input type="submit" name="next" value="获取验证码" formaction="<%=path%>/a1082.htm?thepath=1">
    	</td>    	
    	<td>
    		请输入新邮箱：
    		<input type="text" name="newmail"/>
    	</td>
    	<td>
    	<input type="submit" name="next" value="更换邮箱" formaction="<%=path%>/a1082.htm?thepath=2">
    	</td>
    </tr>
    <tr>
    	
    	<td>
    	请输入原密码：<input type="password" name="oldupass">
    	</td>
    	<td></td>
    	<td>
    	请输入新密码：<input type="password" name="newupass">
    	</td>
    	<td>
    	<input type="submit" name="next" value="修改密码" formaction="<%=path%>/a1082.htm?thepath=3">   	
    	</td>
    </tr>
	<div align="center">
	<tr class="edit_button">
		
	       <td colspan="4">
	               <input type="submit" name="next" value="返回"  
	               		formnovalidate="formnovalidate"
	               		formaction="<%=path %>/information.jsp" >
	       </td>	 	
     </tr>
	</div>
     <input type="hidden" name="mail" value="${ins.mail }">
     <input type="hidden" name="uid" value="${ins.uid }">
   </table>
 </div>
</form>
</body>
</html>