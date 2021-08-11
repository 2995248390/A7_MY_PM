package com.cmm.web.impl.A1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * Servlet implementation class A1040Servlet
 */
/**
 * FileName:      A1040Servlet
 *
 * FileType:      java
 *
 * Date:          2021��07��27��
 *
 * Author:        �³���
 * 
 * Email:         814461932@qq.com
 *
 * Description:   ��ѯ�����Ϣҳ���ʼ��������������
 *
 */
@WebServlet("/a1040.htm")
public class A1040Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

  
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
        request.setAttribute("ocnation", Tools.getOptions("nation"));
		
		
		return "/A1/A1040.jsp";
	}

	

}
