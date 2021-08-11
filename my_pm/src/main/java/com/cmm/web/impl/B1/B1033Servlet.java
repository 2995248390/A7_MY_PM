/**
 * FileName:      B1033Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月3日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   查询体检记录
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
@WebServlet("/b1033.htm")
public class B1033Servlet extends BaseServlet
{	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		B1030ServicesImpl services=new B1030ServicesImpl(this.parseRequest(request));
		Map<String,String> ins=services.queryBodymsg();
		if(ins!=null)
		{
			//将查询结果保存到requsest中
			request.setAttribute("ins", ins);
		}
		else
		{
			String msg="没有有效记录，建议用户近期进行体检";
			request.setAttribute("msg", msg);
		}
		return "/B1/B1032.jsp";
	}	
}
