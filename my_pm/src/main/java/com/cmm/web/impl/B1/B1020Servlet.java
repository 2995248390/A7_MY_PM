package com.cmm.web.impl.B1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1010ServicesImpl;
import com.cmm.services.impl.B1020ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: B1020Servlet
 * 
 * Date: 2021年07月30号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 查看诊所信息
 *
 */

@WebServlet("/b1020.htm")
public class B1020Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> docInfo = (Map<String, String>) request.getSession().getAttribute("userinfo");
		B1020ServicesImpl services=new B1020ServicesImpl(docInfo);
		Map<String, String> ins = services.querClin(); 
		request.setAttribute("ins",ins);	
		return "B1/B1020.jsp";
	}

}
