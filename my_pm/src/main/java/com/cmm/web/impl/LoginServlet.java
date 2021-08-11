package com.cmm.web.impl;

import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cmm.services.impl.LoginServiceImpl;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      A2012Action
 *
 * FileType:      Action
 *
 * Date:          2021��07��28��
 *
 * Author:        �޺�
 *
 * Description:   ��¼.��¼���洢��¼�ߵ������Ϣ
 *
 */
@WebServlet("/login.htm")
public class LoginServlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//���뵽����������,��¼,�˳�,�쳣ҳ�������ص�
		req.getSession().removeAttribute("userinfo");
		LoginServiceImpl services = new LoginServiceImpl(this.parseRequest(req));
		Map<String, String> userinfo = null;
		//����˺�����
		try {
			userinfo = services.loginCheckByMd5();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(userinfo);
		//�оʹ�ֵ
		if(userinfo!=null) 	{
			String systype = userinfo.get("systype");
			if(systype.equals("3")) {
				Map<String,String> docinfo = services.getDocMsg(userinfo.get("uid"));
				if(docinfo!=null) {
				userinfo.putAll(docinfo);
				}
			}
			 req.getSession().setAttribute("userinfo",userinfo);
			 String sysmenu = services.getMenuTree(systype);
			 req.getSession().setAttribute("sysmenu", sysmenu);
			 return "main.jsp";
		}else {
			//������û���¼�������������flag=8,�˳�������,flag=0;
			String flag = req.getParameter("flag");
			if(flag==null) {
			return "login.jsp?flag=8";
			}
			return "login.jsp";
			
		}
	}
}
