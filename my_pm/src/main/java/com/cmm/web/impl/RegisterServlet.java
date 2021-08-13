/**
 * FileName:      RegisterServlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月3日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   用户注册账号
 *
 */
package com.cmm.web.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.RegisterServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      RegisterServlet
 *
 * FileType:      Action
 *
 * Date:          2021年08月03日
 *
 * Author:        罗航
 *
 * Description:  	用户注册
 *
 */
@WebServlet("/register.htm")
public class RegisterServlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//获得path
		String path = request.getParameter("path");
		//如果有path 表示时注册页面初始化
		if(path!=null && path.equals("1")) {
			request.setAttribute("nationlist", Tools.getOptions("nation"));
			request.setAttribute("communitylist", Tools.getOptions("community"));
			request.setAttribute("account", request.getParameter("newaccount"));
			request.setAttribute("upass", request.getParameter("newupass"));
			return "next.jsp";
		}else{
		//没有path时添加注册用户
		RegisterServicesImpl services=new RegisterServicesImpl(this.parseRequest(request));
		String msg=services.register()==1?"注册成功":"注册失败,注意一个人只能有一账户,请重新输入";
		request.setAttribute("msg", msg);
		return "login.jsp";
		}
	}
	
}
