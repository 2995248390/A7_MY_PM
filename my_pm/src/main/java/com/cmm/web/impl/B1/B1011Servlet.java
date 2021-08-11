package com.cmm.web.impl.B1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1012ServicesImpl;
import com.cmm.services.impl.B1011ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: B1014Servlet
 * 
 * Date: 2021��07��29��
 * 
 * @author �����
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: ҽ��������Ϣ�޸�	
 *
 */

@WebServlet("/b1011.htm")
public class B1011Servlet extends BaseServlet {

	@SuppressWarnings("finally")
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		Map<String,String> dto = (Map<String, String>) request.getSession().getAttribute("userinfo");
		String uid = dto.get("uid");
		B1011ServicesImpl services=new B1011ServicesImpl(this.parseRequest(request));
		String msg = null;
		try {
			msg = services.modifyDoc(uid)?"�޸ĳɹ�":"��������ȷ����";
		}catch(Exception ex) {
			msg = "��������ȷ����";
			ex.printStackTrace();
		}
		finally {
			request.setAttribute("msg", msg);
			return "B1/B1011.jsp";
		}	
	}

}
