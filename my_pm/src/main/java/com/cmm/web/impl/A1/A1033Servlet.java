/**
 * FileName:      A1033Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年07月29日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   管理员删除医疗记录
 *
 */
package com.cmm.web.impl.A1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1030ServicesImpl;
import com.cmm.web.support.BaseServlet;

@WebServlet("/a1033.htm")
public class A1033Servlet extends BaseServlet
{
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		A1030ServicesImpl services=new A1030ServicesImpl(this.parseRequest(request));
		int result=services.batchDeleteRecord();
		String msg=null;
		if(result!=3)
		{
			msg=result==1?"删除成功":"没有删除权限";
		}
		else
		{
			msg="请选择删除对象";
		}
		request.setAttribute("msg", msg);
		//删除后，再进行一次查询，显示原数据
		List<Map<String,String>> rows=services.queryRecord();
		if(rows.size()>0)
		{
			//将查询结果保存到request中
			request.setAttribute("rows",rows);
			//获取分页控制器
			String pageController=services.getPageController("/a1031.htm");
			request.setAttribute("pageController", pageController);
		}
		
		
		return "/A1/A1030.jsp";
	}
}
