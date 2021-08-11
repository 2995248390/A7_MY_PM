/**
 * FileName:      B1032Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��08��3��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ��ѯҽ�Ƽ�¼
 *
 */
package com.cmm.web.impl.B1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1030ServicesImpl;
import com.cmm.web.support.BaseServlet;
@WebServlet("/b1032.htm")
public class B1032Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		B1030ServicesImpl services=new B1030ServicesImpl(this.parseRequest(request));
		List<Map<String,String>> rows=services.queryRecord();
		if(rows.size()>0)
		{
			//����ѯ������浽request��
			request.setAttribute("rows", rows);
			//��ȡ��ҳ������
			String pageController=services.getPageController("/b1031.htm");
			request.setAttribute("pageController", pageController);
		}
		else
		{
			request.setAttribute("msg", "û�з�������������!");
		}
		return "/B1/B1031.jsp";
	}	
}
