package com.cmm.web.impl.A1;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1070ServiceImpl;
import com.cmm.web.support.BaseServlet;
import com.cmm.system.tools.Tools;
/**
 * FileName:      A2012Action
 *
 * FileType:      Action
 *
 * Date:          2021年07月29日
 *
 * Author:        罗航
 *
 * Description:   编辑页面.获得编辑需要的默认数据
 *
 */
@WebServlet("/a1070.htm")
public class A1070Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//此请求为了获得编辑需要的下拉数据,单选数据
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		request.setAttribute("ocsex", Tools.getOptions("sex"));
		//到编辑页面
		return "A1/A1070.jsp?type=1";
	}

}
