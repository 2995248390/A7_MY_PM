package com.cmm.web.impl.A1;

import com.cmm.services.impl.A1060ServicesImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A1064
 */
/**
 * FileName:     A1064Servlet
 *
 * FileType:      java
 *
 * Date:          2021年07月30日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   修改资讯
 *
 */
@WebServlet("/a1064.htm")
public class A1064Servlet extends BaseServlet {
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		Map<String, String> dto= this.parseRequest(request);
		A1060ServicesImpl services=new A1060ServicesImpl(dto);
		String msg=services.update()==0?"网络故障":"修改成功";
		request.setAttribute("msg", msg);
		return "/A1/A1063.jsp";
		
	}

   

}
