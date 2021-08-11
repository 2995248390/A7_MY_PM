package com.cmm.web.impl.C1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.C1020ServiceImpl;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      C1030Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��08��03��
 *
 * Author:        �޺�
 *
 * Description:   �Һ�ҳ���ʼ��
 *
 */
@WebServlet("/c1022.htm")
public class C1022Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getParameter("path");
		C1020ServiceImpl service = new C1020ServiceImpl(this.parseRequest(request));
		List timeList = service.getTimeList();
		request.setAttribute("timeList", timeList);
		if(path!=null && path.equals(1)) {
			request.setAttribute("msg", "�Һ�ʧ��,��ѡ������ʱ��");
		}
		return "C1/C1023.jsp";
	}


}
