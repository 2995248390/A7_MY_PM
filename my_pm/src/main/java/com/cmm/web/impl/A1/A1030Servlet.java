/**
 * FileName:      A1030Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��07��27��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ����Ա��ѯҽ�Ƽ�¼,��������jsp�������ת
 *
 */
package com.cmm.web.impl.A1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

@WebServlet("/A1030.htm")
public class A1030Servlet extends BaseServlet
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
		
		return "/A1/A103"+baseName+".jsp";
	}
}
