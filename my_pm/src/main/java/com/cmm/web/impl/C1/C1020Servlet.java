package com.cmm.web.impl.C1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.C1020ServiceImpl;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      C1020Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��07��30��
 *
 * Author:        �޺�
 *
 * Description:   ���ҽ��.ҽ�����ҳ��
 *
 */
@WebServlet("/c1020.htm")
public class C1020Servlet extends BaseServlet{

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		C1020ServiceImpl services = new C1020ServiceImpl(this.parseRequest(request));
		//�õ�ҽ����Ϣ
		List<Map<String,String>> docList = services.getDocsMsg();	
		if(docList!=null){
		//����ҽ��ҳ����Ϣ
		request.getSession().setAttribute("docList", docList);
		//�������ҽ��ҳ��
		return "C1/C1020.jsp";
		}
		return "C1/C1020.jsp?msg=nomessage";
	}
}