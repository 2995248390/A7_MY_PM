package com.cmm.web.impl.A1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1040ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

import java.util.List;
import java.util.Map;

/**
 * FileName:      A1041Servlet
 *
 * FileType:      java
 *
 * Date:          2021��07��27��
 *
 * Author:        �³���
 * 
 * Email:         814461932@qq.com
 *
 * Description:   ����Ա��ѯ�����Ϣ������������
 *
 */
@WebServlet("/a1041.htm")
public class A1041Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	protected String execute(HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		//��ȡ1040ҳ������пؼ�
		Map<String,String> dto=this.parseRequest(request);
		A1040ServicesImpl services=new A1040ServicesImpl(dto);
		List<Map<String, String>>  rows=services.queryAi();
		//request.setAttribute("ocnation", Tools.getOptions("nation"));
		if(rows.size()>0)
		{
			//�Ѳ�ѯ������浽request��
			request.setAttribute("rows", rows);
			//��ҳ������
			String pageController=services.getPageController("/a1041.htm");
			request.setAttribute("pageController", pageController);
			request.setAttribute("msg", "��ѯ�ɹ�");
		}
		else 
		{
			request.setAttribute("msg", "û�з�������������");
		}
		
		return "a1040.htm";
	   
	}
	
}
