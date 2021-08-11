/**
 * FileName:      A1032Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��07��29��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ����Ա��ѯҽ�Ƽ�¼
 *
 */
package com.cmm.web.impl.A1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1030ServicesImpl;
import com.cmm.web.support.BaseServlet;

@WebServlet("/a1032.htm")
public class A1032Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{		
		A1030ServicesImpl services=new A1030ServicesImpl(this.parseRequest(request));		
		Map<String,String> ins=services.findById();
		if(ins!=null)
		{
			request.setAttribute("ins", ins);
		}
		return "/A1/A1031.jsp";
	}	
}
