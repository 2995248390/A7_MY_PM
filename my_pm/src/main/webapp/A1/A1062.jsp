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

</head>

<body>
 <form action="" id="myform" action="" method="post" >
   <div>
   <table>
   <br>
    <br>
      <caption>
           ��Ѷ�༭<hr>
      </caption>
   <tr class="title">
       <td colspan="4">�༭��</td>
    </tr>
   <!-- �༭Ҫ���ӵ����� -->
     <tr>
     <td align="center">���ݼ��</td>
     <td>
         <textarea rows=4 cols=160 name="addsyn" align=""></textarea>
         
     </td>
     </tr>
     <tr>
     <td align="center">
         ҳ������
     </td>
     <td>
      <textarea rows=4 cols=160 name="addurl" align=""></textarea>
     </td>
     </tr>
   </table>
  </div>
  <div class="button">
  <table>
    <tr>
      <td>
         
         <input type="submit" value="���" formaction="<%=path%>/a1061.htm?path=1">
         
      </td>
    </tr>
  </table>
</div> 
  
   </form>
 
</body>
</html>