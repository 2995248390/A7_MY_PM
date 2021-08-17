package com.cmm.web.impl.D1;

import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.D1010ServiceImpl;
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
		D1010ServiceImpl services = new D1010ServiceImpl(this.parseRequest(req));
		Map<String, String> userinfo = null;
		//����˺�����
		try {
			//����ǵ�¼�ͻ���ҵ�����,������˳���û�н��ܵ�����,����userinfoΪnull����else,���Ϊδ�ҵ����˳�,
			userinfo = services.loginCheckByMd5();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//�оʹ�ֵ
		if(userinfo!=null){
			String systype = (String) userinfo.get("systype");
			if(systype.equals("3")) {
				Map<String,String> docinfo = services.getDocMsg((String)userinfo.get("uid"));
				if(docinfo!=null) {
				userinfo.putAll(docinfo);
				}
			}
			 req.getSession().setAttribute("userinfo",userinfo);
			 String sysmenu = services.getMenuTree(systype);
			 req.setAttribute("sysmenu", sysmenu);
			 return "main.jsp";
		}else {
			//������û���¼�������������flag=8,�˳�������,flag=0;
			String path = req.getParameter("path");
			//pathΪ1�����˳�
			if(path!=null && path.equals("1")) {
				return "main.jsp";
			}
			//û��path��Ϊ�˻��������,�ص���¼ҳ��,Я��flag��ʾ
			return "login.jsp?flag=8";
		}
	}
}
