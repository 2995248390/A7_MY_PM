	package com.cmm.web.impl.C1;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.C1020ServiceImpl;
import com.cmm.web.support.BaseServlet;
/**
 * FileName:      C1021Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年07月31日
 *
 * Author:        罗航
 *
 * Description:   浏览医生.医生详细页面加评论
 *
 */
@WebServlet("/c1021.htm")
public class C1021Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		C1020ServiceImpl service = new C1020ServiceImpl(this.parseRequest(request));
		Map<String,String> doc = service.getDocById();
		List<Map<String,String>> appraiseList = service.getDocAppraise();
		if(doc!=null) {
			appraiseList = service.dealName(appraiseList);
			request.setAttribute("doc", doc);
			request.setAttribute("appraiseList", appraiseList);
		}else {
			request.setAttribute("msg", "网络故障");
		}
		return "C1/C1022.jsp";
		
	}

}
