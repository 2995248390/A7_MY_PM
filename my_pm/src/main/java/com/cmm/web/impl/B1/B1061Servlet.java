package com.cmm.web.impl.B1;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1060ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName:      B1061Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        Ǯ��ͬ
 *
 * Description:  ��ѯ��ʷ����
 *
 */
@WebServlet("/b1061.htm")
public class B1061Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		B1060ServicesImpl services=new B1060ServicesImpl(this.parseRequest(request));
		
		
		Map<String,String> userinfo=(Map<String, String>) request.getSession().getAttribute("userinfo");	
		System.out.println(userinfo);
		System.out.println(this.parseRequest(request));
	    String  did = userinfo.get("did");
		List<Map<String,String>> rows=services.querypatient(did);
		if(rows.size()>0)
		{
			//����ѯ��������request��
			request.setAttribute("rows",rows);
			System.out.println(rows.get(0));
			//��ȡ��ҳ������
		String pageController=services.getPageController("/b1061.htm");
		request.setAttribute("pageController", pageController);
		}
	else
		{
			request.setAttribute("msg", "û�з�������������!");
		}
		return "/B1/B1060.jsp";	
		

}

}
