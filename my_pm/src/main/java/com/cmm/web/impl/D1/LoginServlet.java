package com.cmm.web.impl.D1;

import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.D1010ServiceImpl;
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
		D1010ServiceImpl services = new D1010ServiceImpl(this.parseRequest(req));
		Map<String, String> userinfo = null;
		//检查账号密码
		try {
			//如果是登录就会查找到内容,如果是退出就没有接受到参数,所以userinfo为null进入else,情况为未找到和退出,
			userinfo = services.loginCheckByMd5();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//有就存值
		if(userinfo!=null){
			String systype = (String) userinfo.get("systype");
			if(systype.equals("3")) {
				Map<String,String> docinfo = services.getDocMsg((String)userinfo.get("uid"));
				if(docinfo!=null) {
				userinfo.putAll(docinfo);
				}
			}
			 req.getSession().setAttribute("userinfo",userinfo);
			 String sysmenu = services.getMenuTree(systype);
			 req.setAttribute("sysmenu", sysmenu);
			 return "main.jsp";
		}else {
			//如果是用户登录出错来到这就有flag=8,退出来到这,flag=0;
			String path = req.getParameter("path");
			//path为1则是退出
			if(path!=null && path.equals("1")) {
				return "main.jsp";
			}
			//没有path就为账户密码错误,回到登录页面,携带flag提示
			return "login.jsp?flag=8";
		}
	}
}
