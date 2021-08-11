package com.cmm.web.impl.B1;



import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1070ServicesImpl;
import com.cmm.services.impl.B1080ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      B1070Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  查询挂号单详细信息
 *
 */
@WebServlet("/b1070.htm")
public class B1070Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		B1070ServicesImpl services=new B1070ServicesImpl(this.parseRequest(request));
		Map<String,String> ins=services.findByOid();
		if(ins!=null)
		{
			request.setAttribute("ins", ins);
		}
		
		Map<String,String> ins2=services.getDocname();
		if(ins2!=null)
		{
			request.setAttribute("ins2", ins2);
		}
		return "/B1/B1070.jsp";	
		

}

}
