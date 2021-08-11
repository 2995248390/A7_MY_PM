/**
 * FileName:      A1051Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年07月29日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   管理员查看用户评价
 *
 */
package com.cmm.web.impl.A1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1030ServicesImpl;
import com.cmm.services.impl.A1050ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;
@WebServlet("/a1051.htm")
public class A1051Servlet extends BaseServlet
{
	@Override	
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("occommunity", Tools.getOptions("community"));
		A1050ServicesImpl services=new A1050ServicesImpl(this.parseRequest(request));
		List<Map<String,String>> rows=services.queryAppraise();
		if(rows.size()>0)
		{
			//将查询结果保存到request中
			request.setAttribute("rows",rows);
			//获取分页控制器
			String pageController=services.getPageController("/a1051.htm");
			request.setAttribute("pageController", pageController);
		}
		else
		{
			request.setAttribute("msg", "没有符合条件的数据!");
		}
		return "/A1/A1050.jsp";
	}
}
