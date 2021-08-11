package com.cmm.web.impl.A1;


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
 * Servlet implementation class A1062Servlet
 */
/**
 * FileName:     A1062Servlet
 *
 * FileType:      java
 *
 * Date:          2021年07月28日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   删除资讯
 *
 */
@WebServlet("/a1062.htm")
public class A1062Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, String> dto=this.parseRequest(request);
		A1060ServicesImpl services=new A1060ServicesImpl(dto);
		String msg=services.DelleteById();
		request.setAttribute("msg", msg);
		
		List<Map<String, String>> rows=services.queryForInf();
		request.setAttribute("rows", rows);
		//分页控制器
		String pageController=services.getPageController("/a1060.htm");
		request.setAttribute("pageController", pageController);
		return "/A1/A1060.jsp";
		
	}

   
	
}
