/**
 * FileName:      B1041Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��08��3��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ��ɾ����д�Һŵ�
 *
 */
package com.cmm.web.impl.B1;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1040ServicesImpl;
import com.cmm.web.support.BaseServlet;
@WebServlet("/b1041.htm")
public class B1041Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		B1040ServicesImpl services=new B1040ServicesImpl(this.parseRequest(request));
		String thepath=(String) request.getParameter("thepath");
		System.out.println("thepath:"+thepath);
		String msg=null;
		//Map<String,String> ins=null;
		if(thepath.equals("1"))
		{
			request.setAttribute("onum", request.getParameter("onum"));
		}
		else
		{
			msg=services.insertRecord()==1?"���ҽ�Ƽ�¼�ɹ�":"���ʧ��/�������";
			request.setAttribute("msg",msg);
			return "/b1031.htm";
		}
		return "/B1/B1040.jsp";
	}	
}