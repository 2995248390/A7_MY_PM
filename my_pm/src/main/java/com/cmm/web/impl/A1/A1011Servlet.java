	package com.cmm.web.impl.A1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1010ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: A1011Servlet
 * 
 * Date: 2021年07月28号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 管理员查询用户	
 *
 */

@WebServlet("/a1011.htm")
public class A1011Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		
		A1010ServicesImpl services=new A1010ServicesImpl(this.parseRequest(request));
//		List<Map<String,String>> rows=services.queryEmp();
		List<Map<String,String>> rows=services.queryUser();
		if(rows.size()>0)
		{
			//将查询结果保存大request中
			request.setAttribute("rows",rows);
			//获取分页控制器
			String pageController = services.getPageController("/a1011.htm");
			request.setAttribute("pageController", pageController);
		}
		else
		{
			request.setAttribute("msg", "没有符合条件的数据!");
		}	
		return "/A1/A1010.jsp";
	}
	
}
