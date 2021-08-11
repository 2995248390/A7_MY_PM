/**
 * FileName:      A1030Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年07月27日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   管理员查询医疗记录,用于两个jsp界面的跳转
 *
 */
package com.cmm.web.impl.A1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

@WebServlet("/A1030.htm")
public class A1030Servlet extends BaseServlet
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
		
		return "/A1/A103"+baseName+".jsp";
	}
}
