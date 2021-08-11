package com.cmm.web.impl.A1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1012ServicesImpl;
import com.cmm.services.impl.A2011ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;


@WebServlet("/a2011.htm")
public class A2011Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		Map<String,String> dto = (Map<String, String>) request.getSession().getAttribute("userinfo");
		String uid = dto.get("uid");
		A2011ServicesImpl services=new A2011ServicesImpl(this.parseRequest(request));
		String msg = services.modifyDoc(uid)?"修改成功":"修改失败";
		request.setAttribute("msg", msg);
		return "A1/A2011.jsp";
	}

}
