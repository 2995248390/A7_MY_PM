package com.cmm.web.impl.B1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName:      B1060Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        Ǯ��ͬ
 *
 * Description:  ��ʼ����ʷ����ҳ��
 *
 */
@WebServlet("/b1060.htm")
public class B1060Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		System.out.println((Map)request.getSession().getAttribute("userinfo"));
		System.out.println(this.parseRequest(request));
//		A1021ServicesImpl services=new A1021ServicesImpl(this.parseRequest(request));
//		List<Map<String,String>> rows=services.querydoc();
//		if(rows.size()>0)
//		{
//			//����ѯ��������request��
//			request.setAttribute("rows",rows);
//			//��ȡ��ҳ������
//			String pageController=services.getPageController("/A1021.htm");
//			request.setAttribute("pageController", pageController);
//		}
//		else
//		{
//			request.setAttribute("msg", "û�з�������������!");
//		}
		return "/B1/B1060.jsp";	
		

}
}
