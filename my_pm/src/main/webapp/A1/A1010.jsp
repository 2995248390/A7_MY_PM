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
    let onEdit=function(vuid){
    	let currForm=document.getElementById("myform");
    	currForm.action="<%=path%>/a1012.htm?uid="+vuid;
    	//alert(currForm.action);
    	currForm.submit();
    }
    
    function quanxuan(a)
	{
	    //�ҵ��������еĸ�ѡ��
	    var ck =document.getElementsByClassName("qx");
	    
	    //�������и�ѡ������ѡ��״̬��
	    for(var i=0;i<ck.length;i++)
	    {
	        if(a.checked)//�ж�ȫѡ��ť��״̬�ǲ���ѡ�е�
	        {
	            ck[i].setAttribute("checked","checked");//�����ѡ�еģ��������е�״̬Ϊѡ�С�
	        }
	        else
	        {
	            ck[i].removeAttribute("checked");//�������ѡ�еģ����Ƴ����е�״̬��checked��ѡ�
	        }
	    }
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
					�û��˺Ź������
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
					<td><e:text name="qname" /></td>
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
					<td>�˺�</td>
					<td><e:text name="qaccount" /></td>
					<td></td>
					<td></td>

				</tr>
			</table>
		</div>
		<!-- ��ѯ���-->
		<div class="data">
			<table id="dataTable">
				<tr class="title">
					<td><input type="checkbox" onclick="quanxuan(this)" /></td>
					<td>���</td>
					<td>���֤</td>
					<td>�˺�</td>
					<td>����</td>
					<td>�Ա�</td>
					<td>����</td>
					<td>����</td>
					<td>����</td>
					<td>״̬</td>
				</tr>
				<!-- �ж����ٶ����¶� -->
				<c:choose>
					<c:when test="${rows!=null }">
						<!-- if -->
						<c:forEach items="${rows }" var="ins" varStatus="vs">
							<tr>
								<td><input type="checkbox" class="qx" name="uid"
									value="${ins.uid }"></td>
								<td>${vs.count}</td>
								<td>${ins.idcard }</td>
								<td><a href="javascript:onEdit('${ins.uid}')"> <img
										alt="" src="<%=path%>/img/edit.png"> ${ins.account }
								</a></td>
								<td>${ins.truename }</td>
								<td>${ins.cnsex }</td>
								<td>${ins.cnnatino }</td>
								<td>${ins.cncommunity }</td>
								<td>${ins.age }</td>
								<td>${ins.cnstate }</td>
							</tr>
						</c:forEach>
						<script>
		    newRows(10-${fn:length(rows)},10);
		 </script>

					</c:when>
					<c:otherwise>
						<!-- else -->
						<script>
		      newRows(10,10);
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
						formaction="<%=path%>/a1011.htm"> <input type="submit"
						value="���" formaction="<%=path%>/a1010.htm?path=1"> <input
						type="submit" id="delButton" name="next" value="ɾ��"
						formaction="<%=path%>/a1015.htm"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>