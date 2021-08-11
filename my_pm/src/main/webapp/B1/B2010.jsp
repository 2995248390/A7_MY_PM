<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://org.wangxg/jsp/extl" prefix="e"%>
<%String path=request.getContextPath(); %>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
@IMPORT url("<%=path%>/css/wangcss/style.css");
</style>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
<style type="text/css">
#pageController {
	width: 75px;
}
</style>
<script type="text/javascript">
    let onEdit=function(vrid){
    	let currForm=document.getElementById("myform");
    	currForm.action="<%=path%>/b2011.htm?rid="+vrid;
    	//alert(currForm.action);
    	currForm.submit();
    }
   </script>
</head>
<body>
	${msg}
	<br>
	<br>
	<form id="myform" action="" method="post">
		<!-- ��ѯ���� -->
		<div class="query">
			<table>
				<caption>
					ҽ�Ƽ�¼����
					<hr>
				</caption>
				<tr class="title">
					<td colspan="8">��ѯ����</td>
				</tr>
				<!-- 
             ��ѯ�����Ŀؼ�����:
       ������������: b+�ֶ���  ����ʼ����   e+�ֶ���  ��������
       ���ڷ������ѯ���� :  q+�ֶ���   
     -->
				<tr>
					<td>����</td>
					<td><e:text name="qtruename" /></td>
					<td>���֤��</td>
					<td><e:text name="qidcard" /></td>
					<td>�Ա�</td>
					<td><e:radio name="qsex" value="��:1,Ů:2,����:''" defval="" /></td>
					<td>����</td>
					<td><e:select value="ocnation" name="qnation" header="true" />
					</td>
				</tr>
				<tr>
					<td>����</td>
					<td><e:text name="qage" /></td>
					<td>����</td>
					<td><e:select value="occommunity" name="qcommunity"
							header="true" /></td>
					<!--    <td>��������[B]</td>
       <td>
         <e:number step="0.01" name="bsal"/>
       </td>
       <td>��������[E]</td>
       <td>
         <e:number step="0.01" name="esal"/>
       </td>
        -->
					<td>¼��ʱ��</td>
					<td><e:date name="qbegintime" /></td>
					<td></td>
					<td></td>

				</tr>
			</table>
		</div>
		<!-- ��ѯ���-->
		<div class="data">
			<table id="dataTable">
				<tr class="title">
					<td></td>
					<td>���</td>
					<td>���֤</td>
					<td>�˺�</td>
					<td>����</td>
					<td>�Ա�</td>
					<td>ҽ������</td>
					<td>��ҩ��Ϣ</td>
					<td></td>
				</tr>
				<!-- �ж����ٶ����¶� -->
				<c:choose>
					<c:when test="${rows!=null }">
						<!-- if -->
						<c:forEach items="${rows }" var="ins" varStatus="vs">
							<tr>
								<td></td>
								<td>${vs.count}</td>
								<td>${ins.idcard }</td>
								<td><a href="javascript:onEdit('${ins.rid}')"> <img
										alt="" src="<%=path%>/img/edit.png"> ${ins.account }
								</a></td>
								<td>${ins.truename }</td>
								<td>${ins.cnsex }</td>
								<td>${ins.docsuggestion }</td>
								<td>${ins.drugmsg }</td>
								<td></td>
							</tr>
						</c:forEach>
						<script>
		    newRows(10-${fn:length(rows)},9);
		 </script>

					</c:when>
					<c:otherwise>
						<!-- else -->
						<script>
		      newRows(10,9);
		    </script>
					</c:otherwise>
				</c:choose>

			</table>
			${pageController }
		</div>

		<!-- ���ܰ�ť -->
		<div class="button">
			<table>
				<tr>
					<td><input type="submit" name="next" value="��ѯ"
						formaction="<%=path%>/b2010.htm"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>