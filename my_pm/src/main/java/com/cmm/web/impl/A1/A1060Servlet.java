package com.cmm.web.impl.A1;

import com.cmm.services.impl.A1040ServicesImpl;
import com.cmm.services.impl.A1060ServicesImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet implementation class A1043Servlet
 */
/**
 * FileName:      A1060Servlet
 *
 * FileType:      java
 *
 * Date:          2021��07��28��
 *
 * Author:        �³���
 * 
 * Email:         814461932@qq.com
 *
 * Description:   ��ѯ��Ѷ��Ϣҳ�棨����������
 *
 */
@WebServlet("/a1060.htm")
public class A1060Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		Map<String, String>  dto =this.parseRequest(request);
		A1060ServicesImpl services=new A1060ServicesImpl(dto);
		List<Map<String, String>> rows=services.queryForInf();
		if(rows.size()>0)
		{
			//�Ѳ�ѯ������浽request��
			request.setAttribute("rows", rows);
			//��ҳ������
			String pageController=services.getPageController("/a1060.htm");
			request.setAttribute("pageController", pageController);
			request.setAttribute("msg", "��ѯ�ɹ�");
		}
		else 
		{
			request.setAttribute("msg", "û�з�������������");
		}
		return "/A1/A1060.jsp";
		
		
		
	}

	
	
	

	
}
