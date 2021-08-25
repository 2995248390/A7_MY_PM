<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<td width="35%"><input type = "text" name="mtruename"
							value="${ins.truename }" readonly/></td>
					<td width="15%">���֤</td>
					<td width="35%"><input type = "text" name="midcard" value="${ins.idcard }" readonly/>
					</td>
				</tr>
				<tr>
					<td>�Ա�</td>
					<td>
						<c:choose>
							<c:when test = "${ins.msex == '1' }">
								<input type = "radio" name="msex" value="1" checked="checked"/>��
								<input type = "radio" name="msex" value="2" />Ů
							</c:when>
							<c:otherwise>
								<input type = "radio" name="msex" value="1" />��
								<input type = "radio" name="msex" value="2" checked="checked" />Ů
							</c:otherwise>
						</c:choose>		
					</td>
					<td>����</td>
					<td><input type = "text" name="mage" value="${ins.age }" readonly/></td>
				</tr>
				<tr>
					<td>����</td>
					<td>
						<select name="mnation">
							<option value="">==����==</option>
							<c:forEach var = "nation" items = "${ocnation }" >
								<c:choose>
									<c:when test = "${ins.cnnation == nation.name }">
										<option value="${nation.value}" selected="selected">${nation.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${nation.value}">${nation.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<td>¼��ʱ��</td>
					<td><input type = "text" name="mbegintime" value="${ins.begintime }" readonly/></td>
				</tr>
				<tr>
					<td>ԤԼ��</td>
					<td><input type = "text" name="monum" value="${ins.onum }" readonly/></td>
					<td>�ֻ���</td>
					<td><input type = "text" name="mphonenumber" value="${ins.phonenumber }" readonly/>
					</td>
				</tr>
				<tr>
					<td>ҽ������</td>
					<td colspan="3"><textarea rows="3" cols="122"
							name="mdocsuggestion" readonly>${ins.docsuggestion }</textarea></td>
				</tr>
				<tr>
					<td>��ҩ��Ϣ</td>
					<td colspan="3"><textarea rows="5" cols="122"
							name="mdrugmsg" readonly>${ins.drugmsg }</textarea></td>
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="����"
						formaction="<%=path%>/b2010.htm"></td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="rid" value="${param.rid }">
		<input type = "hidden" name = "qtruename" value = "${param.qtruename }" >
		<input type = "hidden" name = "qidcard" value = "${param.qidcard }" >
		<input type = "hidden" name = "qsex" value = "${param.qsex }" >
		<input type = "hidden" name = "qnation" value = "${param.qnation }" >
		<input type = "hidden" name = "qage" value = "${param.qage }" >
		<input type = "hidden" name = "qcommunity" value = "${param.qcommunity }" >
		<input type = "hidden" name = "qbegintime" value = "${param.begintime }" >
	</form>
</body>