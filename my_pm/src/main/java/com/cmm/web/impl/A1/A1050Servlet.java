/**
 * FileName:      A1050Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��08��3��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ����Ա���۹���ҳ���ʼ��
 *
 */
package com.cmm.web.impl.A1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

public class A1050Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("ocaab11", Tools.getOptions("aab11"));

		
		String baseName="0";
		String path=request.getParameter("path"); //����A1030.jsp 135�У�����Ҳ�У����ڻ�ȡ��תҳ��
		if(path!=null && !path.equals(""))
		{
			baseName=path;
		}		
		
		return "/A1/A105"+baseName+".jsp";
	}
}
