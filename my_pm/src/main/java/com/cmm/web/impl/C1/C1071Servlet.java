/**
 * FileName:      C1071Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��08��3��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   �û�1.�鿴��ϸҽ�Ƽ�¼
 * 					  2.��ʼ�����۽���
 * 					  3.�û��������
 * 					  4.�û��鿴����	
 *
 */
package com.cmm.web.impl.C1;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.C1070ServicesImpl;
import com.cmm.web.support.BaseServlet;
@WebServlet("/c1071.htm")
public class C1071Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String path="c1070.htm";
		C1070ServicesImpl service=new C1070ServicesImpl(this.parseRequest(request));
		Map<String,String> ins=null;
		int choice=Integer.parseInt(request.getParameter("thepath"));
		System.out.println("choice:"+choice);
		switch(choice)
		{
			//�鿴��ϸҽ�Ƽ�¼
			case 1:
				ins=service.queryRecord();
				if(ins!=null)
				{
					request.setAttribute("ins", ins);
				}
				path="C1/C1071.jsp";
				break;
			//��ʼ�����۽���
			case 2:
				ins=service.findById();
				request.setAttribute("ins", ins);
				path="C1/C1072.jsp";
				break;
			//�û��������	
			case 3:
				String msg=service.insertAppraise()==1?"���۳ɹ�":"�޷�������";
				request.setAttribute("msg", msg);
				path="c1070.htm";
				break;
			//�û��鿴����
			case 4:				
				ins=service.queryAppraise();
				if(ins!=null)
				{
					request.setAttribute("ins", ins);
				}
				path="C1/C1073.jsp";
				break;
			default :
				System.out.println(false);
		}
		return path;
	}
	
}
