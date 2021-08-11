package com.cmm.web.impl.A1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;


@WebServlet("/a2012.htm")
public class A2012Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String baseName="0";
		String path=request.getParameter("path");
		
		if(path!=null && !path.equals("")){
			baseName=path;
		}
		
		
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		
		
		return "/A1/A201"+baseName+".jsp";
	}

}
