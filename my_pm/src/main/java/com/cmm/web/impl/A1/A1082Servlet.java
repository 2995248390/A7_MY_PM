/**
 * FileName:      A1081Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��08��3��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ��ȫ����ҳ���幦����ת
 *
 */
package com.cmm.web.impl.A1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1080ServicesImpl;
import com.cmm.web.support.BaseServlet;
import com.cmm.system.tools.Tools;
@WebServlet("/a1082.htm")
public class A1082Servlet extends BaseServlet
{
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{			
		//��sessionȡ��syscode������֤��Ͷ�����֤�룬����request
		String syscode1 = (String) request.getSession().getAttribute("syscode");
		

		//��һ�еò������ڶ��еõ�
		System.out.println("syscode:"+request.getAttribute("syscode"));  //
		
		//��session��ȥsyscode�Ͷ�����֤��		
		
		//request.getSession().removeAttribute("syscode");
		
		A1080ServicesImpl services=new A1080ServicesImpl(this.parseRequest(request));

		int choice=Integer.parseInt(request.getParameter("thepath"));
		switch(choice)
		{
			//������֤��
			case 1:
				String syscode=Tools.sendEmail(request.getParameter("mail"));
				request.getSession().setAttribute("syscode",syscode );
				System.out.println("syscode:"+request.getSession().getAttribute("syscode")+"  syscode--"+syscode);
				request.setAttribute("msg1","�ѷ�����֤��" );
				
				request.getSession().getAttribute("userinfo");
				Map<String,String> ins=services.querySafe();
				if(ins!=null)
				{
					request.setAttribute("ins", ins);
				}
				break;
			//�޸�����
			case 2:
				int result=services.updateEmail(syscode1);
				if(result==1)
					request.setAttribute("msg1", "�޸ĳɹ�");
				else if(result==2)
					request.setAttribute("msg1", "�����쳣");
				else
					request.setAttribute("msg1", "��֤�����");
				break;
			//�޸�����
			case 3:
				String msg=services.updatePassword()==1?"�޸ĳɹ�":"��������ȷ����";
				request.setAttribute("msg", msg);				
				break;
			default :
	            System.out.println(false);
		}
		
		return "/A1/A1080.jsp";
	}
}