package com.cmm.web.impl.B1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.system.tools.Tools;
import com.cmm.web.support.BaseServlet;

/**
 * FileName: B1012Servlet
 * 
 * Date: 2021年07月29号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 初始化医生个人信息界面
 *
 */

@WebServlet("/b1012.htm")
public class B1012Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String baseName="0";
		String path=request.getParameter("path");
		
		if(path!=null && !path.equals("")){
			baseName=path;
		}
		
		
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("oclevel", Tools.getOptions("level"));
		
		
		return "/B1/B101"+baseName+".jsp";
	}

}
