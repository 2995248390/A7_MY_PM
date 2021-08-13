/**
 * FileName:      RegisterServlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��08��3��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   �û�ע���˺�
 *
 */
package com.cmm.web.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.RegisterServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      RegisterServlet
 *
 * FileType:      Action
 *
 * Date:          2021��08��03��
 *
 * Author:        �޺�
 *
 * Description:  	�û�ע��
 *
 */
@WebServlet("/register.htm")
public class RegisterServlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//���path
		String path = request.getParameter("path");
		//�����path ��ʾʱע��ҳ���ʼ��
		if(path!=null && path.equals("1")) {
			request.setAttribute("nationlist", Tools.getOptions("nation"));
			request.setAttribute("communitylist", Tools.getOptions("community"));
			request.setAttribute("account", request.getParameter("newaccount"));
			request.setAttribute("upass", request.getParameter("newupass"));
			return "next.jsp";
		}else{
		//û��pathʱ���ע���û�
		RegisterServicesImpl services=new RegisterServicesImpl(this.parseRequest(request));
		String msg=services.register()==1?"ע��ɹ�":"ע��ʧ��,ע��һ����ֻ����һ�˻�,����������";
		request.setAttribute("msg", msg);
		return "login.jsp";
		}
	}
	
}
