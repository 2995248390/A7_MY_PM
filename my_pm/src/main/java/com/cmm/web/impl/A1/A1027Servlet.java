package com.cmm.web.impl.A1;



import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1022ServicesImpl;
import com.cmm.web.support.BaseServlet;

/**
 * FileName:      A1027Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  没有在用
 *
 */
@WebServlet("/a1027.htm")
public class A1027Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		A1022ServicesImpl services=new A1022ServicesImpl(this.parseRequest(request));
		Map<String,String> ins=this.parseRequest(request);
		request.setAttribute("ins", ins);
		
		
		return "/A1023.jsp";
	}

}
