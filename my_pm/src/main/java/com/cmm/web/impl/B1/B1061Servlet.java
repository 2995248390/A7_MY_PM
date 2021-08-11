package com.cmm.web.impl.B1;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1060ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName:      B1061Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  查询历史患者
 *
 */
@WebServlet("/b1061.htm")
public class B1061Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		B1060ServicesImpl services=new B1060ServicesImpl(this.parseRequest(request));
		
		
		Map<String,String> userinfo=(Map<String, String>) request.getSession().getAttribute("userinfo");	
		System.out.println(userinfo);
		System.out.println(this.parseRequest(request));
	    String  did = userinfo.get("did");
		List<Map<String,String>> rows=services.querypatient(did);
		if(rows.size()>0)
		{
			//将查询结果保存大request中
			request.setAttribute("rows",rows);
			System.out.println(rows.get(0));
			//获取分页控制器
		String pageController=services.getPageController("/b1061.htm");
		request.setAttribute("pageController", pageController);
		}
	else
		{
			request.setAttribute("msg", "没有符合条件的数据!");
		}
		return "/B1/B1060.jsp";	
		

}

}
