/**
 * FileName:      B1041Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月3日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   完成就诊，填写挂号单
 *
 */
package com.cmm.web.impl.B1;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.B1040ServicesImpl;
import com.cmm.web.support.BaseServlet;
@WebServlet("/b1041.htm")
public class B1041Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		B1040ServicesImpl services=new B1040ServicesImpl(this.parseRequest(request));
		String thepath=(String) request.getParameter("thepath");
		System.out.println("thepath:"+thepath);
		String msg=null;
		//Map<String,String> ins=null;
		if(thepath.equals("1"))
		{
			request.setAttribute("onum", request.getParameter("onum"));
		}
		else
		{
			msg=services.insertRecord()==1?"添加医疗记录成功":"添加失败/网络故障";
			request.setAttribute("msg",msg);
			return "/b1031.htm";
		}
		return "/B1/B1040.jsp";
	}	
}