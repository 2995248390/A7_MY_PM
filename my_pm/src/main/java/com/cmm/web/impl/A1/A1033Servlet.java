/**
 * FileName:      A1033Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��07��29��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ����Աɾ��ҽ�Ƽ�¼
 *
 */
package com.cmm.web.impl.A1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1030ServicesImpl;
import com.cmm.web.support.BaseServlet;

@WebServlet("/a1033.htm")
public class A1033Servlet extends BaseServlet
{
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		A1030ServicesImpl services=new A1030ServicesImpl(this.parseRequest(request));
		int result=services.batchDeleteRecord();
		String msg=null;
		if(result!=3)
		{
			msg=result==1?"ɾ���ɹ�":"û��ɾ��Ȩ��";
		}
		else
		{
			msg="��ѡ��ɾ������";
		}
		request.setAttribute("msg", msg);
		//ɾ�����ٽ���һ�β�ѯ����ʾԭ����
		List<Map<String,String>> rows=services.queryRecord();
		if(rows.size()>0)
		{
			//����ѯ������浽request��
			request.setAttribute("rows",rows);
			//��ȡ��ҳ������
			String pageController=services.getPageController("/a1031.htm");
			request.setAttribute("pageController", pageController);
		}
		
		
		return "/A1/A1030.jsp";
	}
}
