package com.cmm.web.impl.A1;

import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1020ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName:      A1025Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  初始化修改医生信息界面
 *
 */
@WebServlet("/a1024.htm")
public class A1024Servlet extends BaseServlet 
{
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("oclevel", Tools.getOptions("level"));
		A1020ServicesImpl services=new A1020ServicesImpl(this.parseRequest(request));
		Map<String,String> ins=services.findById();
		if(ins!=null)
		{
			System.out.println(ins);
			//System.out.println(Tools.MD5Encode(Tools.MD5Encode((ins.get("upass")))));						
			request.setAttribute("ins", ins);
			
		}
		return "/A1/A1022.jsp";
	}

}
