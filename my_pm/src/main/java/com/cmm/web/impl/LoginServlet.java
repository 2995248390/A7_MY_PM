package com.cmm.web.impl;

import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cmm.services.impl.LoginServiceImpl;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      A2012Action
 *
 * FileType:      Action
 *
 * Date:          2021年07月28日
 *
 * Author:        罗航
 *
 * Description:   登录.登录并存储登录者的相关信息
 *
 */
@WebServlet("/login.htm")
public class LoginServlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//进入到这个请求的有,登录,退出,异常页面请求重登
		req.getSession().removeAttribute("userinfo");
		LoginServiceImpl services = new LoginServiceImpl(this.parseRequest(req));
		Map<String, String> userinfo = null;
		//检查账号密码
		try {
			userinfo = services.loginCheckByMd5();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(userinfo);
		//有就存值
		if(userinfo!=null) 	{
			String systype = userinfo.get("systype");
			if(systype.equals("3")) {
				Map<String,String> docinfo = services.getDocMsg(userinfo.get("uid"));
				if(docinfo!=null) {
				userinfo.putAll(docinfo);
				}
			}
			 req.getSession().setAttribute("userinfo",userinfo);
			 String sysmenu = services.getMenuTree(systype);
			 req.getSession().setAttribute("sysmenu", sysmenu);
			 return "main.jsp";
		}else {
			//如果是用户登录出错来到这就有flag=8,退出来到这,flag=0;
			String flag = req.getParameter("flag");
			if(flag==null) {
			return "login.jsp?flag=8";
			}
			return "login.jsp";
			
		}
	}
}
