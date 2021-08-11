package com.cmm.web.impl.A1;

import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1020ServicesImpl;
import com.cmm.services.impl.A1022ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;


/**
 * FileName:      A1025Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  修改医生
 *
 */
@WebServlet("/a1025.htm")
public class A1025Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("oclevel", Tools.getOptions("level"));
		A1022ServicesImpl services=new A1022ServicesImpl(this.parseRequest(request));
		String msg2 = services.modifyDoc()?"修改成功":"修改失败";
		request.setAttribute("msg2", msg2);
		return "/a1024.htm";
	}

}
