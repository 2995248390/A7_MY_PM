/**
 * FileName:      C1070Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��08��3��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   �û���ʼ���Һŵ�
 *
 */
package com.cmm.web.impl.C1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.C1070ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;
@WebServlet("/c1070.htm")
public class C1070Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		request.setAttribute("qfinishappraise", Tools.getOptions("finishappraise"));
		Map<String,String> userinfo=new HashMap<>();
		userinfo=(Map)request.getSession().getAttribute("userinfo");		
		//System.out.println("userinfo="+userinfo);		
		C1070ServicesImpl services=new C1070ServicesImpl(this.parseRequest(request));		
		String uid=userinfo.get("uid");
		//System.out.println("uid:"+uid);
		List<Map<String,String>> rows=services.findOrder(uid);
		if(rows.size()>0)
		{
			//����ѯ������浽request��
			request.setAttribute("rows", rows);
			//��ȡ��ҳ������
			String pageController=services.getPageController("/c1070.htm");
			request.setAttribute("pageController", pageController);
		}
		return "C1/C1070.jsp";
	}
	
}
