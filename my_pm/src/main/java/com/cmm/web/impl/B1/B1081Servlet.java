package com.cmm.web.impl.B1;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1080ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName:      B1081Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  查询体检记录详细信息
 *
 */
@WebServlet("/b1081.htm")
public class B1081Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		B1080ServicesImpl services=new B1080ServicesImpl(this.parseRequest(request));
		Map<String,String> ins=services.findByUid();
		if(ins!=null)
		{
			request.setAttribute("ins", ins);
		}
		
		
		
		return "/B1/B1081.jsp";	
		

}

}
