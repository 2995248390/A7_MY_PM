/**
 * FileName:      A1052Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��07��29��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ����Ա�޸��û�����״̬�������ۿ�����ʾ
 *
 */
package com.cmm.web.impl.A1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1050ServicesImpl;
import com.cmm.web.support.BaseServlet;
@WebServlet("/a1052.htm")
public class A1052Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		A1050ServicesImpl services=new A1050ServicesImpl(this.parseRequest(request));
		int result=services.batchShow();
		String msg=null;
		if(result!=3)
			msg=result==1?"�����ۿ�����ʾ":"��Ȩ�޽��д˲���";
		else
			msg="��ѡ���������";
		//����ԭ��ѯ������ʾ���
		List<Map<String,String>> rows=services.queryAppraise();
		if(rows.size()>0)
		{
			//����ѯ������浽request��
			request.setAttribute("rows",rows);
			//��ȡ��ҳ������
			String pageController=services.getPageController("/a1051.htm");
			request.setAttribute("pageController", pageController);
		}
		request.setAttribute("msg", msg);
		return "/A1/A1050.jsp";
	}
	
}
