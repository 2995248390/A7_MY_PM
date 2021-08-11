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
	${msg }
	<br> ${ins }
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					�鿴������Ϣ
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">������Ϣ</td>
				</tr>
				<tr>
					<td width="15%">�����˺�</td>
					<td width="35%"><e:text name="maccount"
							defval="${ins.account }" /></td>
					<td width="15%">��������</td>
					<td width="35%"><e:text name="mupass" defval="${ins.upass }" />
					</td>
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
					<td><e:radio name="msex" value="��:1,Ů:2" defval="${ins.sex }" />
					</td>
					<td>����</td>
					<td><e:text name="mage" defval="${ins.age }" /></td>
				</tr>
				<tr>
					<td>����</td>
					<td><e:select value="ocnation" name="mnation"
							defval="${ins.nation }" /></td>
					<td>����</td>
					<td><e:select value="occommunity" name="mcommunity"
							defval="${ins.community }" /></td>
				</tr>
				<tr>
					<td>����</td>
					<td><e:date name="mbirthday" defval="${ins.birthday }" /></td>
					<td>�ֻ���</td>
					<td><e:text name="mphonenumber" defval="${ins.phonenumber }" />
					</td>
				</tr>
				<tr>
					<td>��ַ</td>
					<td><e:text name="maddress" defval="${ins.address }" /></td>
					<td>����</td>
					<td><e:text name="mmail" defval="${ins.mail }" /></td>
				</tr>
				<tr>
					<td>ҽ���ȼ�</td>
					<td><e:select value="һ��ҽʦ:1,����ҽʦ:2,����ҽʦ:3,����ҽʦ:4"
							name="mlevel" defval="${ins.level }" /></td>
					<td>��������</td>
					<td><e:text name="mclinicname" defval="${ins.clinicname }" />
					</td>
				</tr>
				<tr>
					<td>������ַ</td>
					<td><e:text name="mclinicaddress"
							defval="${ins.clinicaddress }" /></td>
					<td>��ҽ���</td>
					<td><e:text name="mworkyear" defval="${ins.workyear }" /></td>
				</tr>
				<tr>
					<td>ҽ��״̬</td>
					<td><e:radio name="mdocstate" value="����:1,�ر�:2"
							defval="${ins.docstate }" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>ҽ������</td>
					<td colspan="3"><e:textarea rows="3" cols="122"
							name="mdescription" defval="${ins.description }" /></td>
				</tr>
				<tr>
					<td>��ע</td>
					<td colspan="3"><e:textarea rows="5" cols="122" name="mmemo"
							defval="${ins.memo }" /></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="����"
						formaction="<%=path%>/a2011.htm"> <input type="submit"
						name="next" value="����" formnovalidate="formnovalidate"
						formaction="<%=path %>/a2010.htm">
					</td>
				</tr>
			</table>
		</div>

	</form>
</body>