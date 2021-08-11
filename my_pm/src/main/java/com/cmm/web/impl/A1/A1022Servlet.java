package com.cmm.web.impl.A1;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1022ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      A1022Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        Ǯ��ͬ
 *
 * Description:  ��ʼ��ҽ����ӽ���
 *
 */
@WebServlet("/a1022.htm")
public class A1022Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("oclevel", Tools.getOptions("level"));
		
		A1022ServicesImpl services=new A1022ServicesImpl(this.parseRequest(request));
//		String msg=services.adddoc()?"��ӳɹ�":"���ʧ��";
//		System.out.println(msg);
//		List<Map<String,String>> rows=services.queryEmp();
		/*
		List<Map<String,String>> rows=services.queryUser();
		if(rows.size()>0)
		{
			//����ѯ��������request��
			request.setAttribute("rows",rows);
			//��ȡ��ҳ������
			String pageController = services.getPageController("/A1022.htm");
			request.setAttribute("pageController", pageController);
		}
		else
		{
			request.setAttribute("msg", "û�з�������������!");
		}	
		*/
		return "/A1/A1022.jsp";
	}
	
}
