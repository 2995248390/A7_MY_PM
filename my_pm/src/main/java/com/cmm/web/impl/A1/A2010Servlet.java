package com.cmm.web.impl.A1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1012ServicesImpl;
import com.cmm.services.impl.A2010ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

@WebServlet("/a2010.htm")
public class A2010Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> docInfo = (Map<String, String>) request.getSession().getAttribute("userinfo");
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		A2010ServicesImpl services=new A2010ServicesImpl(docInfo);
		Map<String, String> ins = services.querDoc(); 
		request.setAttribute("ins",ins);	
		return "A1/A2010.jsp";
	}

}
