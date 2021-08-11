	package com.cmm.web.impl.A1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1011ServicesImpl;
import com.cmm.services.impl.A1012ServicesImpl;
import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: A1014Servlet
 * 
 * Date: 2021年07月29号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 管理员查询用户数据	
 *
 */

@WebServlet("/a1014.htm")
public class A1014Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		
		A1012ServicesImpl services=new A1012ServicesImpl(this.parseRequest(request));
		String msg = null;
		try {
			msg = services.modifyUser()?"修改成功":"修改失败";
		}catch(Exception ex) {
			msg = "请输入正确条件";
			ex.printStackTrace();
		}
		finally {
			request.setAttribute("msg", msg);
			return "/A1/A1011.jsp";
		}
	}

}
