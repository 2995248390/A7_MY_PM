package com.cmm.web.impl.C1;

import com.cmm.services.impl.C1020ServiceImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FileName:      C1024Servlet
 *
 * FileType:      Action
 *
 * Date:          2021年08月05日
 *
 * Author:        罗航
 *
 * Description:  	用户挂号单查看
 *
 */
@WebServlet("/c1024.htm")
public class C1024Servlet extends BaseServlet {
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		C1020ServiceImpl service = new C1020ServiceImpl(this.parseRequest(request));
		List<Map<String,String>> orderList = service.getOrderList();
		if(orderList!=null) {
		request.setAttribute("orderList", orderList);
		}else {
			request.setAttribute("msg", "没有订单");
		}
		return "C1/C1024.jsp";
	}

}
