package com.cmm.web.impl.B1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1010ServicesImpl;
import com.cmm.services.impl.B2010ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: B2010Servlet
 * 
 * Date: 2021��07��30��
 * 
 * @author �����
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: ҽ���鿴ҽ�Ƽ�¼
 *
 */

@WebServlet("/b2010.htm")
public class B2010Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		Map<String,String> docInfo = (Map<String, String>) request.getSession().getAttribute("userinfo");
		String did = docInfo.get("did");
		Map<String,String> doc = this.parseRequest(request);
		doc.put("did", did);
        B2010ServicesImpl services=new B2010ServicesImpl(doc);
        List<Map<String,String>> rows=services.queryDoc();
    	if(rows.size()>0)
		{
			//����ѯ��������request��
			request.setAttribute("rows",rows);
			//��ȡ��ҳ������
			String pageController = services.getPageController("/b2010.htm");
			request.setAttribute("pageController", pageController);
		}
		else
		{
			request.setAttribute("msg", "û�з�������������!");
		}	
		return "B1/B2010.jsp";
	}

}
