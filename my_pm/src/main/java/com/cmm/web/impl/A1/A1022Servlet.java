package com.cmm.web.impl.A1;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1022ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      A1022Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  初始化医生添加界面
 *
 */
@WebServlet("/a1022.htm")
public class A1022Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("oclevel", Tools.getOptions("level"));
		
		A1022ServicesImpl services=new A1022ServicesImpl(this.parseRequest(request));
//		String msg=services.adddoc()?"添加成功":"添加失败";
//		System.out.println(msg);
//		List<Map<String,String>> rows=services.queryEmp();
		/*
		List<Map<String,String>> rows=services.queryUser();
		if(rows.size()>0)
		{
			//将查询结果保存大request中
			request.setAttribute("rows",rows);
			//获取分页控制器
			String pageController = services.getPageController("/A1022.htm");
			request.setAttribute("pageController", pageController);
		}
		else
		{
			request.setAttribute("msg", "没有符合条件的数据!");
		}	
		*/
		return "/A1/A1022.jsp";
	}
	
}
