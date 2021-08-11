package com.cmm.web.impl.A1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1010ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: A1012Servlet
 * 
 * Date: 2021年07月28号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 管理员查询用户数据	
 *
 */

@WebServlet("/a1012.htm")
public class A1012Servlet extends BaseServlet
{
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		
		A1010ServicesImpl services=new A1010ServicesImpl(this.parseRequest(request));
		Map<String,String> ins=services.findById();
		if(ins!=null)
		{
			request.setAttribute("ins", ins);
		}
		return "/A1/A1011.jsp";
	}
}
