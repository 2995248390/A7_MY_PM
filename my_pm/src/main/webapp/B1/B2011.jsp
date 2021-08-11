<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
@IMPORT url("<%=path%>/css/wangcss/style.css");
</style>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
<script type="text/javascript">
    function onNext1()
    { 
    	//alert("hello");
    	window.setTimeout("clearMsg()","10000");
    }
    function clearMsg()
    {
    	//ert("clear......");
    	document.getElementById("msg").innerHTML="";
    }
  </script>
</head>
<body onload="onNext1()">
	<div id="msg" class="msg"></div>
	<br>
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					�鿴ҽ�Ƽ�¼
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">ҽ�Ƽ�¼</td>
				</tr>
				<tr>
					<td width="15%">����</td>
					<td width="35%"><e:text name="mtruename"
							defval="${ins.truename }" /></td>
					<td width="15%">���֤</td>
					<td width="35%"><e:text name="midcard" defval="${ins.idcard }" />
					</td>
				</tr>
				<tr>
					<td>�Ա�</td>
					<td><e:radio name="msex" value="��:1,Ů:2"
							defval="${ins.cnsex }" /></td>
					<td>����</td>
					<td><e:text name="mage" defval="${ins.age }" /></td>
				</tr>
				<tr>
					<td>����</td>
					<td><e:select value="ocnation" name="mnation"
							defval="${ins.cnnation }" /></td>
					<td>¼��ʱ��</td>
					<td><e:text name="mbegintime" defval="${ins.begintime }" /></td>
				</tr>
				<tr>
					<td>ԤԼ��</td>
					<td><e:text name="monum" defval="${ins.onum }" /></td>
					<td>�ֻ���</td>
					<td><e:text name="mphonenumber" defval="${ins.phonenumber }" />
					</td>
				</tr>
				<tr>
					<td>ҽ������</td>
					<td colspan="3"><e:textarea rows="3" cols="122"
							name="mdocsuggestion" defval="${ins.docsuggestion }" /></td>
				</tr>
				<tr>
					<td>��ҩ��Ϣ</td>
					<td colspan="3"><e:textarea rows="5" cols="122"
							name="mdrugmsg" defval="${ins.drugmsg }" /></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="����"
						formaction="<%=path%>/b2010.htm"></td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="eid" value="${param.rid }">
	</form>
</body>