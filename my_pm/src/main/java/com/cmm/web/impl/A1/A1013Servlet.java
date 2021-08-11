	package com.cmm.web.impl.A1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1010ServicesImpl;
import com.cmm.services.impl.A1011ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: A1013Servlet
 * 
 * Date: 2021��07��28��
 * 
 * @author �����
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: ����Ա����û�����	
 *
 */
@WebServlet("/a1013.htm")
public class A1013Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		A1011ServicesImpl services=new A1011ServicesImpl(this.parseRequest(request));
		String msg = null;
		try {
			msg = services.addUser()?"��ӳɹ�":"���ʧ��";
		}catch(Exception ex) {
			msg = "��������ȷ����";
			ex.printStackTrace();
		}
		finally {
			request.setAttribute("msg", msg);
			return "/A1/A1011.jsp";
		}
		
	}

}
