	package com.cmm.web.impl.A1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1013ServicesImpl;
import com.cmm.web.support.BaseServlet;

@WebServlet("/a1015.htm")
public class A1015Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		A1013ServicesImpl services = new A1013ServicesImpl(this.parseRequest(request));
		String msg = services.deleteUser()?"É¾³ý³É¹¦":"É¾³ýÊ§°Ü";
		request.setAttribute("msg1", msg);
		return "a1011.htm";
	}

}
