package com.cmm.web.impl.D1;

import com.cmm.services.impl.D1010ServiceImpl;
import com.cmm.services.impl.LoginServiceImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FileName:      MainServlet
 *
 * FileType:      Action
 *
 * Date:          2021年08月13日
 *
 * Author:        罗航
 *
 * Description:   主页面初始化
 *
 */
@WebServlet("/main.htm")
public class MainServlet extends BaseServlet {
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		D1010ServiceImpl services = new D1010ServiceImpl(this.parseRequest(request));
		 String sysmenu = services.getMenuTree("2");
		 request.getSession().setAttribute("sysmenu", sysmenu);
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(sysmenu);
		 return "";
	}
}
