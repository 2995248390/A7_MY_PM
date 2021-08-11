package com.cmm.web.impl.B1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1062ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      B1062Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  没在用的删除医疗记录
 *
 */
@WebServlet("/b1062.htm")
public class B1062Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		B1062ServicesImpl services=new B1062ServicesImpl(this.parseRequest(request));
		
		String msg = services.deleteRecord()?"删除成功":"删除失败";
		request.setAttribute("msg", msg);
		return "B1/B1080.jsp";
	}

}
