package com.cmm.web.impl.A1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1040ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

import java.util.List;
import java.util.Map;

/**
 * FileName:      A1041Servlet
 *
 * FileType:      java
 *
 * Date:          2021年07月27日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   管理员查询体检信息（不定条件）
 *
 */
@WebServlet("/a1041.htm")
public class A1041Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	protected String execute(HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		//读取1040页面的所有控件
		Map<String,String> dto=this.parseRequest(request);
		A1040ServicesImpl services=new A1040ServicesImpl(dto);
		List<Map<String, String>>  rows=services.queryAi();
		//request.setAttribute("ocnation", Tools.getOptions("nation"));
		if(rows.size()>0)
		{
			//把查询结果保存到request中
			request.setAttribute("rows", rows);
			//分页控制器
			String pageController=services.getPageController("/a1041.htm");
			request.setAttribute("pageController", pageController);
			request.setAttribute("msg", "查询成功");
		}
		else 
		{
			request.setAttribute("msg", "没有符合条件的数据");
		}
		
		return "a1040.htm";
	   
	}
	
}
