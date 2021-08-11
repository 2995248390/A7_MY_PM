package com.cmm.web.impl.B1;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: B2013Servlet
 * 
 * Date: 2021��07��30��
 * 
 * @author �����
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: ��ʼ����ѯ��¼ҳ��
 *
 */

@WebServlet("/b2013.htm")
public class B2013Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		return "B1/B2010.jsp";
	}

}
