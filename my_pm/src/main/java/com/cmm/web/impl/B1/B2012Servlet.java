package com.cmm.web.impl.B1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1011ServicesImpl;
import com.cmm.services.impl.B2011ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: B2012Servlet
 * 
 * Date: 2021年07月30号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 医生删除个人医疗记录
 *
 */

@WebServlet("/b2012.htm")
public class B2012Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		B2011ServicesImpl services=new B2011ServicesImpl(this.parseRequest(request));
		String msg = services.deleteRecord()?"删除成功":"删除失败";
		request.setAttribute("msg", msg);
		return "B1/B2011.jsp";
	}

}
