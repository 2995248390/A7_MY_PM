package com.cmm.web.impl.A1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1040ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * Servlet implementation class A1042Servlet
 */
/**
 * FileName:      A1040Servlet
 *
 * FileType:      java
 *
 * Date:          2021年07月27日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   管理员删除体检信息（批量）
 *
 */
@WebServlet("/a1042.htm")
public class A1042Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

   

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, String> dto=this.parseRequest(request);
		A1040ServicesImpl services=new A1040ServicesImpl(dto);
		String msg=services.DelleteById();
		request.setAttribute("msg", msg);
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		
		List<Map<String, String>>  rows=services.queryAi();
		//把查询结果保存到request中
		request.setAttribute("rows", rows);
		//分页控制器
		String pageController=services.getPageController("/a1041.htm");
		request.setAttribute("pageController", pageController);
		return "a1040.htm";
	}

}
