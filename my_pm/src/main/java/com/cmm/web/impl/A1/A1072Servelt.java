package com.cmm.web.impl.A1;

import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FileName:      A1072Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��08��17��
 *
 * Author:        �޺�
 *
 * Description:   ����ͷ��
 *
 */
@WebServlet("/a1072.htm")
public class A1072Servelt extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getWriter().write("chenggong");
		return "";
	}
	
}
