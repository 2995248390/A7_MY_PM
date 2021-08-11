/**
 * FileName:      A1031Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年07月27日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   管理员查询医疗记录
 *
 */
package com.cmm.web.impl.A1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1030ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;
@WebServlet("/a1031.htm")
public class A1031Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("occommunity", Tools.getOptions("community"));
		A1030ServicesImpl services=new A1030ServicesImpl(this.parseRequest(request));
		List<Map<String,String>> rows=services.queryRecord();
		if(rows.size()>0)
		{
			//将查询结果保存到request中
			request.setAttribute("rows",rows);
			//获取分页控制器
			String pageController=services.getPageController("/a1031.htm");
			request.setAttribute("pageController", pageController);
		}
		else
		{
			request.setAttribute("msg", "没有符合条件的数据!");
		}
		return "/A1/A1030.jsp";
	}
	
}
