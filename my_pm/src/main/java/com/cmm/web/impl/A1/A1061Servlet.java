package com.cmm.web.impl.A1;

import com.cmm.services.impl.A1060ServicesImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A1061Servlet
 */
/**
 * FileName:     A1061Servlet
 *
 * FileType:      java
 *
 * Date:          2021��07��28��
 *
 * Author:        �³���
 * 
 * Email:         814461932@qq.com
 *
 * Description:   ������Ѷ
 *
 */
@WebServlet("/a1061.htm")
public class A1061Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> dto=this.parseRequest(request);
		A1060ServicesImpl services=new A1060ServicesImpl(dto);
		int m=services.addinf();
		String msg=null;
		if (m==3) {
			msg="�������������������";
		}
		else if (m==2) {
			msg="�������";
		}
		else {
			msg="��ӳɹ�";
		}
		request.setAttribute("msg", msg);
		return "A1/A1061.jsp";
	}

    
    
}
