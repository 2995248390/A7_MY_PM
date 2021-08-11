	package com.cmm.web.impl.C1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.C1020ServiceImpl;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      C1021Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��07��31��
 *
 * Author:        �޺�
 *
 * Description:   ���ҽ��.ҽ����ϸҳ�������
 *
 */
@WebServlet("/c1021.htm")
public class C1021Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		C1020ServiceImpl service = new C1020ServiceImpl(this.parseRequest(request));
		Map<String,String> doc = service.getDocById();
		List<Map<String,String>> appraiseList = service.getDocAppraise();
		if(doc!=null) {
			appraiseList = service.dealName(appraiseList);
			request.setAttribute("doc", doc);
			request.setAttribute("appraiseList", appraiseList);
		}else {
			request.setAttribute("msg", "�������");
		}
		return "C1/C1022.jsp";
		
	}

}
