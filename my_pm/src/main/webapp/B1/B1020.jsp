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
	<!--  ${ins }-->
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
					<td width="15%">ҽ������</td>
					<td width="35%"><e:text name="mtruename"
							defval="${ins.truename }" /></td>
					<td width="15%">��������</td>
					<td width="35%"><e:text name="mclinicname"
							defval="${ins.clinicname }" /></td>
				</tr>
				<tr>
					<td>����״̬</td>
					<td><e:radio name="mdocstate" value="����:1,�ر�:2"
							defval="${ins.cndocstate }" /></td>
					<td width="15%">ҽ������</td>
					<td width="35%"><e:text name="mage" defval="${ins.age }" /></td>
				</tr>
				<tr>
					<td>ҽ���Ա�</td>
					<td><e:radio name="msex" value="��:1,Ů:2"
							defval="${ins.cnsex }" /></td>
					<td>ҽ���ȼ�</td>
					<td><e:select value="һ��ҽʦ:1,����ҽʦ:2,����ҽʦ:3,����ҽʦ:4"
							name="mlevel" defval="${ins.cnlevel }" /></td>
				</tr>
				<tr>
					<td>�����ϰ�ʱ��</td>
					<td><input type="time" name="mopen1" value="${ins.open1 }">
					</td>
					<td>�����°�ʱ��</td>
					<td><input type="time" name="mclose1" value="${ins.close1 }">
					</td>
				</tr>
				<tr>
					<td>�����ϰ�ʱ��</td>
					<td><input type="time" name="mopen2" value="${ins.open2 }">
					</td>
					<td>�����°�ʱ��</td>
					<td><input type="time" name="mclose2" value="${ins.close2 }">
					</td>
				</tr>
				<tr>
					<td>����ԤԼ����</td>
					<td><e:text name="mgetnum1" defval="${ins.getnum1 }" /></td>
					<td>����ԤԼ����</td>
					<td><e:text name="mgetnum2" defval="${ins.getnum2 }" /></td>
				</tr>
				<tr>
					<td>ԤԼ����</td>
					<td><e:text name="mgetday" defval="${ins.getday }" /></td>
					<td>������ַ</td>
					<td><e:text name="mclinicaddress"
							defval="${ins.clinicaddress }" /></td>
				</tr>
				<tr>
					<td>��ҽ���</td>
					<td><e:text name="mworkyear" defval="${ins.workyear }" /></td>
					<td>ע������</td>
					<td><e:text name="mbegintime" defval="${ins.begintime }" /></td>
				<tr>
					<td>��������</td>
					<td colspan="3"><e:textarea rows="5" cols="122"
							name="mclinicdes" defval="${ins.clinicdes }" /></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="�༭"
						formaction="<%=path%>/B1/B1021.jsp"></td>
				</tr>
			</table>
		</div>

	</form>
</body>