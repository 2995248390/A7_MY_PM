/**
 * FileName:      A1081Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月3日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   安全中心页具体功能跳转
 *
 */
package com.cmm.web.impl.A1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1080ServicesImpl;
import com.cmm.web.support.BaseServlet;
import com.cmm.system.tools.Tools;
@WebServlet("/a1082.htm")
public class A1082Servlet extends BaseServlet
{
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{			
		//从session取出syscode邮箱验证码和短信验证码，放入request
		String syscode1 = (String) request.getSession().getAttribute("syscode");
		

		//第一行得不到，第二行得到
		System.out.println("syscode:"+request.getAttribute("syscode"));  //
		
		//从session除去syscode和短信验证码		
		
		//request.getSession().removeAttribute("syscode");
		
		A1080ServicesImpl services=new A1080ServicesImpl(this.parseRequest(request));

		int choice=Integer.parseInt(request.getParameter("thepath"));
		switch(choice)
		{
			//发送验证码
			case 1:
				String syscode=Tools.sendEmail(request.getParameter("mail"));
				request.getSession().setAttribute("syscode",syscode );
				System.out.println("syscode:"+request.getSession().getAttribute("syscode")+"  syscode--"+syscode);
				request.setAttribute("msg1","已发送验证码" );
				
				request.getSession().getAttribute("userinfo");
				Map<String,String> ins=services.querySafe();
				if(ins!=null)
				{
					request.setAttribute("ins", ins);
				}
				break;
			//修改邮箱
			case 2:
				int result=services.updateEmail(syscode1);
				if(result==1)
					request.setAttribute("msg1", "修改成功");
				else if(result==2)
					request.setAttribute("msg1", "网络异常");
				else
					request.setAttribute("msg1", "验证码错误");
				break;
			//修改密码
			case 3:
				String msg=services.updatePassword()==1?"修改成功":"请输入正确密码";
				request.setAttribute("msg", msg);				
				break;
			default :
	            System.out.println(false);
		}
		
		return "/A1/A1080.jsp";
	}
}