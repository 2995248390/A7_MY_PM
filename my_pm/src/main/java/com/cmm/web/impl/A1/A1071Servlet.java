package com.cmm.web.impl.A1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cmm.services.impl.A1070ServiceImpl;
import com.cmm.services.impl.D1010ServiceImpl;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      A1071Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��07��29��
 *
 * Author:        �޺�
 *
 * Description:   ������Ϣ�޸�
 *
 */
@WebServlet("/a1071.htm")
public class A1071Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		A1070ServiceImpl services = new A1070ServiceImpl(this.parseRequest(request));
		Map<String, String>	uerinfo = (Map<String, String>) request.getSession().getAttribute("userinfo");
		//����uidȥ�޸�
		if(services.updatePerson(uerinfo.get("uid"))) {
			request.setAttribute("msg", "�޸ĳɹ�");
			//�޸ĳɹ��������ٴδ洢��session���ǵ�֮ǰ��userinfo,�������õ���D1010ServiceImpl�ĵ�¼����
			D1010ServiceImpl servicelogin = new D1010ServiceImpl(this.parseRequest(request));
			Map<String, String> userinfo = servicelogin.loginCheck();
			String systype = userinfo.get("systype");
			//�����ҽ���ٴβ���ҽ����Ϣ
			if(systype.equals("3")) {
				userinfo.putAll(servicelogin.getDocMsg(userinfo.get("uid")));
				}
			request.getSession().setAttribute("userinfo", userinfo);
			//�ص��鿴��Ϣҳ����Կ������º������
			return "A1/A1070.jsp";
		}else {
			request.setAttribute("msg", "�޸�ʧ��");
			//�޸�ʧ�ܻص��༭ҳ��,
			return "A1/A1070.jsp?type=1";
		}
	}

}
