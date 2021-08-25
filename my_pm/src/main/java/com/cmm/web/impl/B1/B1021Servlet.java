package com.cmm.web.impl.B1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1011ServicesImpl;
import com.cmm.services.impl.B1021ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: B1020Servlet
 * 
 * Date: 2021��07��31��
 * 
 * @author �����
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: �޸�������Ϣ
 *
 */

@WebServlet("/b1021.htm")
public class B1021Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		B1021ServicesImpl services=new B1021ServicesImpl(this.parseRequest(request));
		Map<String,String> dto = (Map<String, String>) request.getSession().getAttribute("userinfo");
		String uid = dto.get("uid");
		String msg = services.modifyCli(uid)?"�޸ĳɹ�":"�޸�ʧ��";
		request.setAttribute("msg", msg);
		request.setAttribute("oclevel", Tools.getOptions("level"));
		return "B1/B1021.jsp";
	}

}
