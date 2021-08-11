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
	<!--${ins }  -->
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					ҽ����Ϣ
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">ҽ����Ϣ</td>
				</tr>
				<tr>
					<td width="15%">����</td>
					<td width="35%"><e:text name="mtruename"
							defval="${ins.truename }" readonly="true" /></td>
					<td width="15%">�ó�����</td>
					<td width="35%"><e:text name="mspecialty"
							defval="${ins.specialty }" readonly="true" /></td>
				</tr>
				<tr>
					<td>ҽ���ȼ�</td>
					<td><e:select value="һ��ҽʦ:1,����ҽʦ:2,����ҽʦ:3,����ҽʦ:4"
							name="mlevel" defval="${ins.cnlevel }" readonly="true" /></td>
					<td>��������</td>
					<td><e:text name="mclinicname" defval="${ins.clinicname }"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>������ַ</td>
					<td><e:text name="mclinicaddress"
							defval="${ins.clinicaddress }" readonly="true" /></td>
					<td>��ҽ���</td>
					<td><e:text name="mworkyear" defval="${ins.workyear }"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>ҽ��״̬</td>
					<td><e:radio name="mdocstate" value="����:1,�ر�:2"
							defval="${ins.cndocstate }" readonly="true" /></td>
					<td>ע������</td>
					<td><e:text name="mbegintime" defval="${ins.begintime }"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>����</td>
					<td colspan="3"><e:textarea rows="3" cols="122"
							name="mdescription" defval="${ins.description }" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>��������</td>
					<td colspan="3"><e:textarea rows="3" cols="122" name="mdocdes"
							defval="${ins.docdes }" readonly="true" /></td>
				</tr>
				<tr>
					<td>ѧϰ����</td>
					<td colspan="3"><e:textarea rows="3" cols="122"
							name="mlearndes" defval="${ins.learndes }" readonly="true" /></td>
				</tr>
				<tr>
					<td>��ע</td>
					<td colspan="3"><e:textarea rows="5" cols="122" name="mmemo"
							defval="${ins.memo }" readonly="true" /></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="�༭"
						formaction="<%=path%>/b1012.htm?path=1"></td>
				</tr>
			</table>
		</div>

	</form>
</body>