<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e" %>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">@IMPORT url("<%=path%>/css/wangcss/style.css");</style>


 <script type="text/javascript" src="<%=path%>/js/tools.js"></script>

</head>
<body>
<br>
 ${msg }
<br>
<form action="" height=""  width="" method="post">
<div>
 <table  >
      <caption>
                    ��Ѷ�޸�<hr>
      </caption>
    <tr class="title" align="center">
       <td colspan="4">��Ѷ��</td>
    </tr>
   <!-- �༭Ҫ���ӵ����� -->
    <tr  width="50%">
     <td>��Ѷ���</td>
     <td >
       <input type="text" name="upiid"  id="upiid" value="${rows.iid }">
     </td>
    </tr>
   
    <tr  width="50%">
     <td align="center">���ݼ��</td>
     <td >
         <textarea rows="3"  cols="80" name="uptext"  id="uptext">${rows.text}</textarea> 
     </td>
    </tr>
    
    <tr>
     <td align="center">
                ҳ������
     </td>
     <td>
       <textarea rows="3"  cols="80" name="upurl"  id="upurl">${rows.url }</textarea>
     </td>
    </tr>
    
    <tr>
     <td>��ע</td>
     <td>
       <textarea rows="3"  cols="80" name="upmemo"  id="upmemo">${rows.memo }</textarea>
     </td>
    </tr>
     
    <tr>
     <td>״̬</td>
      <td>
        <input type="radio" name="upstate"  id="upstate" value="1" checked="checked">�ɼ�<input type="radio" name="upstate"  id="upstate" value="2">${rows.state }
     </td>
    </tr>
  </table>
</div>
<div class="button">
  <table>
    <tr>
      <td>
         
         <input type="submit" value="�ύ" formaction="<%=path%>/a1064.htm">
         <input type="submit" value="����" formaction="<%=path%>/a1060.htm">
      </td>
    </tr>
  </table>
</div> 
</form>
</body>
</html>