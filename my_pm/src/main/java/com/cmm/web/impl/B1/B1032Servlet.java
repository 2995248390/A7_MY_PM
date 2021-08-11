/**
 * FileName:      B1032Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月3日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   查询医疗记录
 *
 */
package com.cmm.web.impl.B1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1030ServicesImpl;
import com.cmm.web.support.BaseServlet;
@WebServlet("/b1032.htm")
public class B1032Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		B1030ServicesImpl services=new B1030ServicesImpl(this.parseRequest(request));
		List<Map<String,String>> rows=services.queryRecord();
		if(rows.size()>0)
		{
			//将查询结果保存到request中
			request.setAttribute("rows", rows);
			//获取分页控制器
			String pageController=services.getPageController("/b1031.htm");
			request.setAttribute("pageController", pageController);
		}
		else
		{
			request.setAttribute("msg", "没有符合条件的数据!");
		}
		return "/B1/B1031.jsp";
	}	
}
