/**
 * FileName:      C1071Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月3日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   用户1.查看详细医疗记录
 * 					  2.初始化评价界面
 * 					  3.用户添加评价
 * 					  4.用户查看评价	
 *
 */
package com.cmm.web.impl.C1;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.C1070ServicesImpl;
import com.cmm.web.support.BaseServlet;
@WebServlet("/c1071.htm")
public class C1071Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String path="c1070.htm";
		C1070ServicesImpl service=new C1070ServicesImpl(this.parseRequest(request));
		Map<String,String> ins=null;
		int choice=Integer.parseInt(request.getParameter("thepath"));
		System.out.println("choice:"+choice);
		switch(choice)
		{
			//查看详细医疗记录
			case 1:
				ins=service.queryRecord();
				if(ins!=null)
				{
					request.setAttribute("ins", ins);
				}
				path="C1/C1071.jsp";
				break;
			//初始化评价界面
			case 2:
				ins=service.findById();
				request.setAttribute("ins", ins);
				path="C1/C1072.jsp";
				break;
			//用户添加评价	
			case 3:
				String msg=service.insertAppraise()==1?"评价成功":"无法再评价";
				request.setAttribute("msg", msg);
				path="c1070.htm";
				break;
			//用户查看评价
			case 4:				
				ins=service.queryAppraise();
				if(ins!=null)
				{
					request.setAttribute("ins", ins);
				}
				path="C1/C1073.jsp";
				break;
			default :
				System.out.println(false);
		}
		return path;
	}
	
}
