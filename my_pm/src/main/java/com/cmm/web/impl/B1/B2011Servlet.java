package com.cmm.web.impl.B1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B2010ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: B2011Servlet
 * 
 * Date: 2021年07月30号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 医生查询个人医疗记录
 *
 */

@WebServlet("/b2011.htm")
public class B2011Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		B2010ServicesImpl services = new B2010ServicesImpl(this.parseRequest(request));
		Map<String,String> ins = services.findByRid();
		System.out.println(ins);
		if(ins!=null)
		{
			request.setAttribute("ins", ins);
		}
		return "B1/B2011.jsp";
	}

}
