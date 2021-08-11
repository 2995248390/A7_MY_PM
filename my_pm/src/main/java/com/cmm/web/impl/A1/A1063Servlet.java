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
 * Servlet implementation class A1063Servlet
 */
/**
 * FileName:     A1063Servlet
 *
 * FileType:      java
 *
 * Date:          2021年07月29日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   修改资讯的页面初始化
 *
 */
@WebServlet("/a1063.htm")
public class A1063Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, String> dto=this.parseRequest(request);
		if(request.getAttribute("iid")!=null)
		{
			dto.put("rsnolist", request.getAttribute("iid").toString());
		}
		A1060ServicesImpl services= new A1060ServicesImpl(dto);
		String backpath=null;
		String msg=null;
		if(dto.get("rsnolist")!=null) 
		{
			Map<String, String> rows=services.queryForUpdate();
			if(rows!=null)
			{
				request.setAttribute("rows", rows);
				msg="来到修改页面，您现在可以进行修改";
				backpath="/A1/A1063.jsp";
			}
			else {
				msg="该资讯不存在";
				backpath="/A1/A1060.jsp";
				
			}
		}
		else
		{
			msg="请选中修改项";
			backpath="/A1/A1060.jsp";
			List<Map<String, String>> rows=services.queryForInf();
			request.setAttribute("rows", rows);
			//分页控制器
			String pageController=services.getPageController("/a1060.htm");
			request.setAttribute("pageController", pageController);
		}
		
		
		request.setAttribute("msg", msg);
		return backpath;
	}

}
