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
		//IE �� Event ����ʹ�� keyCode ��ü����ַ��� Unicode ����
		//DOM �� Event ���� ʹ�� charCode ��ü����ַ��� Unicode ����
		var char_code = e.charCode ? e.charCode : e.keyCode;
		//Unicode �����У� 0~9 �ı����ʮ���� �� 48~57 ֮�� �� 0Ϊ 48�� 9 Ϊ57
		if(char_code<48 || char_code >57){
			alert("ֻ������������");	
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
                        ¼������¼
       </caption>
    
       <tr>
       <td>�û����</td>
       <td>
          
          <input type="text" name="adduid"  placeholder="�û��˺�" onkeypress="return is_number(event)">
       </td>
      
       <td>����</td>
       <td>
          <e:text name="addusername"  />
       </td>
       </tr>
       
     
        
       <tr>
       <td>Ѫѹ</td>
       <td>
       <input type="text" name="addblood"  onkeypress="return is_number(event)">
       </td>
      
       <td>���</td>
       <td>
         <input type="text" name="addheight"  onkeypress="return is_number(event)">
       </td>
       </tr>
       
       <tr>
       <td>����</td>
       <td>
         <input type="text" name="addweight"  onkeypress="return is_number(event)">
       </td>
       
       <td>�λ���</td>
       <td>
         <input type="text" name="addairs"  onkeypress="return is_number(event)">
       </td>
       </tr>
       
       <tr>
       <td>����</td>
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
        <input type="submit" value="���" formaction="<%=path%>/b1090.htm">
        <input type="submit" value="����" formaction="<%=path%>/b1090.htm">
       </td>
     </tr>
   </table>
 </div>  
</form> 
</body>
</html>