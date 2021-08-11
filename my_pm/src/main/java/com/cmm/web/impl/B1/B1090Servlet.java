package com.cmm.web.impl.B1;

import com.cmm.services.impl.B1090ServicesImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class B1090Servlet
 */
/**
 * FileName:     B1090Servlet
 *
 * FileType:      java
 *
 * Date:          2021年07月31日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   修改资讯的页面初始化
 *
 */
@WebServlet("/b1090.htm")
public class B1090Servlet extends BaseServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, String> dto= this.parseRequest(request);
		B1090ServicesImpl services=new B1090ServicesImpl(dto);
		String msg=services.addBodymsg();
		request.setAttribute("msg", msg);
		
		
		return "/B1/B1090.jsp";
	}

    

}
