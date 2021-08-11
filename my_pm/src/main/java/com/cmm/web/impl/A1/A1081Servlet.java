/**
 * FileName:      A1081Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月3日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   安全中心页面初始化
 *
 */
package com.cmm.web.impl.A1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1080ServicesImpl;
import com.cmm.web.support.BaseServlet;
@WebServlet("/a1081.htm")
public class A1081Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		A1080ServicesImpl services=new A1080ServicesImpl((Map)request.getSession().getAttribute("userinfo"));
		Map<String,String> ins=services.querySafe();
		if(ins!=null)
		{
			request.setAttribute("ins", ins);
		}
		//request.getSession().getAttribute("userinfo");
		 
		return "/A1/A1080.jsp";
	}	
}
