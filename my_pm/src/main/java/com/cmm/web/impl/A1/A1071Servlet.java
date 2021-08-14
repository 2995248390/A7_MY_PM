package com.cmm.web.impl.A1;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cmm.services.impl.A1070ServiceImpl;
import com.cmm.services.impl.D1010ServiceImpl;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      A1071Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年07月29日
 *
 * Author:        罗航
 *
 * Description:   个人信息修改
 *
 */
@WebServlet("/a1071.htm")
public class A1071Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		A1070ServiceImpl services = new A1070ServiceImpl(this.parseRequest(request));
		Map<String, String>	uerinfo = (Map<String, String>) request.getSession().getAttribute("userinfo");
		//根据uid去修改
		if(services.updatePerson(uerinfo.get("uid"))) {
			request.setAttribute("msg", "修改成功");
			//修改成功将数据再次存储在session覆盖掉之前的userinfo,方法复用的是D1010ServiceImpl的登录方法
			D1010ServiceImpl servicelogin = new D1010ServiceImpl(this.parseRequest(request));
			Map<String, String> userinfo = servicelogin.loginCheck();
			String systype = userinfo.get("systype");
			//如果是医生再次补充医生信息
			if(systype.equals("3")) {
				userinfo.putAll(servicelogin.getDocMsg(userinfo.get("uid")));
				}
			request.getSession().setAttribute("userinfo", userinfo);
			//回到查看信息页面可以看到更新后的数据
			return "A1/A1070.jsp";
		}else {
			request.setAttribute("msg", "修改失败");
			//修改失败回到编辑页面,
			return "A1/A1070.jsp?type=1";
		}
	}

}
