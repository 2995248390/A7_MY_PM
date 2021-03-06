/**
 * FileName:      A1050Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月3日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   管理员评价管理页面初始化
 *
 */
package com.cmm.web.impl.A1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

public class A1050Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("ocaab11", Tools.getOptions("aab11"));

		
		String baseName="0";
		String path=request.getParameter("path"); //来自A1030.jsp 135行，其它也有，用于获取跳转页面
		if(path!=null && !path.equals(""))
		{
			baseName=path;
		}		
		
		return "/A1/A105"+baseName+".jsp";
	}
}
