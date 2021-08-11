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
 * FileName:      A1023Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  添加医生
 *
 */
@WebServlet("/a1023.htm")
public class A1023Servlet extends BaseServlet {
	@SuppressWarnings("finally")
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("oclevel", Tools.getOptions("level"));
		
		A1022ServicesImpl services=new A1022ServicesImpl(this.parseRequest(request));
		String msg = null;		
			msg=services.adddoc()?"添加成功":"添加失败";
			request.setAttribute("msg",msg );
			return "A1/A1020.jsp";

	}

}
