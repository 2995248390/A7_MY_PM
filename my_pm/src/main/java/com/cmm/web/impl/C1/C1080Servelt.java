package com.cmm.web.impl.C1;



import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.C1080ServiceImpl;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      C1020Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月4日
 *
 * Author:        钱昱同
 *
 * Description:   用户浏览资讯
 *
 */
@WebServlet("/c1080.htm")
public class C1080Servelt extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		C1080ServiceImpl services = new C1080ServiceImpl(this.parseRequest(request));
		//得到资讯信息
		List<Map<String,String>> infoList = services.getInfomation();	
		if(infoList!=null){
		//保存资讯页面信息
		request.getSession().setAttribute("infoList", infoList);
		//返回信息浏览页面
		return "C1/C1080.jsp";
		}
		return "C1/C1080.jsp?msg=nomessage";
	}

}
