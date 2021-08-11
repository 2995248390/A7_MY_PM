	package com.cmm.web.impl.A1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: A1010Servlet
 * 
 * Date: 2021年07月27号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 页面跳转，初始化数据	
 *
 */

@WebServlet("/a1010.htm")
public class A1010Servlet extends BaseServlet
{
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String baseName="0";
		String path=request.getParameter("path");
		if(path!=null && !path.equals(""))
		{
			baseName=path;
		}
		
		System.out.println(1);
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		
		
		return "/A1/A101"+baseName+".jsp";
	}
	
}
