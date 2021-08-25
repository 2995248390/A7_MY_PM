<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>paramert title here</title>
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
	<br> ${msg }
	<br>
	<form action="" method="post">
		<div class="edit">
			<table>
				<caption>
					�޸�������Ϣ
					<hr>
				</caption>
				<tr class="title">
					<td colspan="4">������Ϣ</td>
				</tr>
				<tr>
					<td width="15%">ҽ������</td>
					<td width="35%"><input type = "text" name="mtruename"
							value="${param.mtruename }" /></td>
					<td width="15%">��������</td>
					<td width="35%"><input type = "text" name="mclinicname"
							value="${param.mclinicname }" /></td>
				</tr>
				<tr>
					<td>����״̬</td>
					<td>
						<c:choose>
							<c:when test="${param.mdocstate == 1 }">
								<input type="radio" name="mdocstate" value="1" checked="checked" >����
								<input type="radio" name="mdocstate" value="2" readonly>�ر�
							</c:when>
							<c:otherwise>
								<input type="radio" name="mdocstate" value="1" readonly>����
								<input type="radio" name="mdocstate" value="2" checked="checked" >�ر�
							</c:otherwise>
						</c:choose>
					</td>
					<td width="15%">ҽ������</td>
					<td width="35%"><input type = "text" name="mage" value="${param.mage }" /></td>
				</tr>
				<tr>
					<td>ҽ���Ա�</td>
					<td>
						<c:choose>
							<c:when test = "${param.msex == '1' }">
								<input type = "radio" name="msex" value="1" checked="checked"/>��
								<input type = "radio" name="msex" value="2" />Ů
							</c:when>
							<c:otherwise>
								<input type = "radio" name="msex" value="1" />��
								<input type = "radio" name="msex" value="2" checked="checked" />Ů
							</c:otherwise>
						</c:choose>		
					</td>
					<td>ҽ���ȼ�</td>
					<td>
						<select name="mlevel">
							<c:forEach var="level" items="${oclevel }">
								<c:choose>
									<c:when test="${param.mlevel == level.value }">
										<option value="${level.value}" selected="selected">${level.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${level.value}">${level.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<!--  <option value = "1">һ��ҽʦ</option>
							<option value = "2">����ҽʦ</option>
							<option value = "3">����ҽʦ</option>
							<option value = "4">����ҽʦ</option>-->
					</select>
					</td>
				</tr>
				<tr>
					<td>�����ϰ�ʱ��</td>
					<td><input type="time" name="mopen1" value="${param.mopen1 }">
					</td>
					<td>�����°�ʱ��</td>
					<td><input type="time" name="mclose1" value="${param.mclose1 }">
					</td>
				</tr>
				<tr>
					<td>�����ϰ�ʱ��</td>
					<td><input type="time" name="mopen2" value="${param.mopen2 }">
					</td>
					<td>�����°�ʱ��</td>
					<td><input type="time" name="mclose2" value="${param.mclose2 }">
					</td>
				</tr>
				<tr>
					<td>����ԤԼ����</td>
					<td><input type = "text" name="mgetnum1" value="${param.mgetnum1 }" /></td>
					<td>����ԤԼ����</td>
					<td><input type = "text" name="mgetnum2" value="${param.mgetnum2 }" /></td>
				</tr>
				<tr>
					<td>ԤԼ����</td>
					<td><input type = "text" name="mgetday" value="${param.mgetday }" /></td>
					<td>������ַ</td>
					<td><input type = "text" name="mclinicaddress"
							value="${param.mclinicaddress }" /></td>
				</tr>
				<tr>
					<td>��ҽ���</td>
					<td><input type = "text" name="mworkyear" value="${param.mworkyear }" /></td>
					<td></td>
					<td></td>
				<tr>
					<td>��������</td>
					<td colspan="3">
						<textarea rows="5" cols="122" name="mclinicdes" >${param.mclinicdes }</textarea>
					</td>
				
				</tr>
				<tr class="edit_button">
					<td colspan="4"><input type="submit" name="next" value="����"
						formaction="<%=path%>/b1021.htm"> <input type="submit"
						name="next" value="����" formnovalidate="formnovalidate"
						formaction="<%=path %>/b1020.htm">
					</td>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>