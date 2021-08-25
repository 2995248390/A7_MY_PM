package com.cmm.web.impl.B1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1012ServicesImpl;
import com.cmm.services.impl.B1010ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: B1010Servlet
 * 
 * Date: 2021年07月28号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 显示医生个人信息	
 *
 */

@WebServlet("/b1010.htm")
public class B1010Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> docInfo = (Map<String, String>) request.getSession().getAttribute("userinfo");
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("oclevel", Tools.getOptions("level"));
		System.out.println(docInfo);
		B1010ServicesImpl services=new B1010ServicesImpl(docInfo);
		Map<String, String> ins = services.querDoc(); 
		request.setAttribute("ins",ins);	
		return "B1/B1010.jsp";
	}

}
