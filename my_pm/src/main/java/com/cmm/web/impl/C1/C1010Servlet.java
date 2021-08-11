package com.cmm.web.impl.C1;

import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1020ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * Servlet implementation class C1010Servlet
 */
@WebServlet("/C1010.htm")
public class C1010Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
//		A1020ServicesImpl services=new A1020ServicesImpl(this.parseRequest(request));
//		Map<String,String> ins=services.findById();
//		if(ins!=null)
//		{
//			request.setAttribute("ins", ins);
//		}
		return "/C1/C1010.jsp";
	}
}
