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
 * FileName:      C1023Servlet
 *
 * FileType:      Action
 *
 * Date:          2021年08月03日
 *
 * Author:        罗航
 *
 * Description:  	用户挂号
 *
 */
@WebServlet("/c1023.htm")
public class C1023Servlet extends BaseServlet {
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		C1020ServiceImpl service = new C1020ServiceImpl(this.parseRequest(request));
		List<Map<String,String>> orderList = service.insertOrder();
		if(orderList!=null) {
			request.setAttribute("orderList", orderList);
			return "C1/C1024.jsp";
		}else {
			request.setAttribute("msg", "挂号失败,请选择合理的时间");
			return "c1022.htm";
		}
	}

}
