package com.cmm.web.impl.A1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1021ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;


/**
 * FileName:      A1021Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        Ǯ��ͬ
 *
 * Description:  ��ѯҽ��
 *
 */
@WebServlet("/a1021.htm")
public class A1021Servlet extends BaseServlet {



	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("oclevel", Tools.getOptions("level"));
		A1021ServicesImpl services=new A1021ServicesImpl(this.parseRequest(request));
		List<Map<String,String>> rows=services.querydoc();
		if(rows.size()>0)
		{
			//����ѯ��������request��
			request.setAttribute("rows",rows);
			//��ȡ��ҳ������
			String pageController=services.getPageController("/a1021.htm");
			request.setAttribute("pageController", pageController);
		}
		else
		{
			request.setAttribute("msg", "û�з�������������!");
		}
		return "/A1/A1020.jsp";	
		

}
}
