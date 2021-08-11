package com.cmm.web.impl.A1;

import com.cmm.services.impl.A1040ServicesImpl;
import com.cmm.services.impl.A1060ServicesImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet implementation class A1043Servlet
 */
/**
 * FileName:      A1060Servlet
 *
 * FileType:      java
 *
 * Date:          2021年07月28日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   查询资讯信息页面（不定条件）
 *
 */
@WebServlet("/a1060.htm")
public class A1060Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		Map<String, String>  dto =this.parseRequest(request);
		A1060ServicesImpl services=new A1060ServicesImpl(dto);
		List<Map<String, String>> rows=services.queryForInf();
		if(rows.size()>0)
		{
			//把查询结果保存到request中
			request.setAttribute("rows", rows);
			//分页控制器
			String pageController=services.getPageController("/a1060.htm");
			request.setAttribute("pageController", pageController);
			request.setAttribute("msg", "查询成功");
		}
		else 
		{
			request.setAttribute("msg", "没有符合条件的数据");
		}
		return "/A1/A1060.jsp";
		
		
		
	}

	
	
	

	
}
