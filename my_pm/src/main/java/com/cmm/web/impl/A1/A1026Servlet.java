package com.cmm.web.impl.A1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1020ServicesImpl;
import com.cmm.web.support.BaseServlet;

/**
 * FileName:      A1021Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        Ǯ��ͬ
 *
 * Description:  ɾ��ҽ��
 *
 */
@WebServlet("/a1026.htm")
public class A1026Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		A1020ServicesImpl services=new A1020ServicesImpl(this.parseRequest(request));
		int result=services.batchDelete();
		String msg=null;
		if(result!=3)
		{
			msg=result==1?"ɾ���ɹ�":"û��ɾ��Ȩ��";
		}
		else
		{
			msg="��ѡ��ɾ������";
		}
		request.setAttribute("msg", msg);
	
		//ɾ�����ٽ���һ�β�ѯ����ʾԭ����
		List<Map<String,String>> rows=services.querydoc();
		if(rows.size()>0)
		{
			//����ѯ������浽request��
			request.setAttribute("rows",rows);
			//��ȡ��ҳ������
			String pageController=services.getPageController("/A1026.htm");
			request.setAttribute("pageController", pageController);			
		}
		
		
		return "/a1021.htm";
	}

}
