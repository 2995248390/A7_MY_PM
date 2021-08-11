/**
 * FileName:      A1052Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年07月29日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   管理员修改用户评价状态，让评价可以显示
 *
 */
package com.cmm.web.impl.A1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1050ServicesImpl;
import com.cmm.web.support.BaseServlet;
@WebServlet("/a1052.htm")
public class A1052Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		A1050ServicesImpl services=new A1050ServicesImpl(this.parseRequest(request));
		int result=services.batchShow();
		String msg=null;
		if(result!=3)
			msg=result==1?"该评论可以显示":"无权限进行此操作";
		else
			msg="请选择操作对象";
		//按照原查询条件显示结果
		List<Map<String,String>> rows=services.queryAppraise();
		if(rows.size()>0)
		{
			//将查询结果保存到request中
			request.setAttribute("rows",rows);
			//获取分页控制器
			String pageController=services.getPageController("/a1051.htm");
			request.setAttribute("pageController", pageController);
		}
		request.setAttribute("msg", msg);
		return "/A1/A1050.jsp";
	}
	
}
