<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
 <style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");</style>
   <script type="text/javascript" src="<%=path%>/js/tools.js"></script>
   <script type="text/javascript">
    function onNext1()
    { 
    	//alert("hello");
    	window.setTimeout("clearMsg()","5000");
    }
    function clearMsg()
    {
    	//ert("clear......");
    	document.getElementById("msg").innerHTML="";
    }
  </script>
  <script type="text/javascript">
  function is_number(e){
		//IE 中 Event 对象使用 keyCode 获得键入字符的 Unicode 编码
		//DOM 中 Event 对象 使用 charCode 获得键入字符的 Unicode 编码
		var char_code = e.charCode ? e.charCode : e.keyCode;
		//Unicode 编码中， 0~9 的编码的十进制 是 48~57 之间 ， 0为 48， 9 为57
		if(char_code<48 || char_code >57){
			alert("只允许输入数字");	
			return false;
		}
		else{
			return true;	
		}
	}
	
  </script>
</head>
<body onload="onNext1()">
<div id="msg" class="msg">
  
 ${msg }
    
</div>
  
<form method="post">   
 <div class="edit"> 
 <br><br>
  <table >    

       <caption>
                        录入体检记录
       </caption>
    
       <tr>
       <td>用户编号</td>
       <td>
          
          <input type="text" name="adduid"  placeholder="用户账号" onkeypress="return is_number(event)">
       </td>
      
       <td>姓名</td>
       <td>
          <e:text name="addusername"  />
       </td>
       </tr>
       
     
        
       <tr>
       <td>血压</td>
       <td>
       <input type="text" name="addblood"  onkeypress="return is_number(event)">
       </td>
      
       <td>身高</td>
       <td>
         <input type="text" name="addheight"  onkeypress="return is_number(event)">
       </td>
       </tr>
       
       <tr>
       <td>体重</td>
       <td>
         <input type="text" name="addweight"  onkeypress="return is_number(event)">
       </td>
       
       <td>肺活量</td>
       <td>
         <input type="text" name="addairs"  onkeypress="return is_number(event)">
       </td>
       </tr>
       
       <tr>
       <td>脉搏</td>
       <td>
         <input type="text" name="addpulse"  onkeypress="return is_number(event)">
       </td>
       <td></td>
       <td></td>
       </tr>
       
  </table>  
 </div>  
 <div class="edit">
   <table  align="center">
     <tr align="center">
       <td>
        <input type="submit" value="添加" formaction="<%=path%>/b1090.htm">
        <input type="submit" value="返回" formaction="<%=path%>/b1090.htm">
       </td>
     </tr>
   </table>
 </div>  
</form> 
</body>
</html>