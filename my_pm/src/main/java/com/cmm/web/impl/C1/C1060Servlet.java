package com.cmm.web.impl.C1;

import com.cmm.services.impl.A1040ServicesImpl;
import com.cmm.services.impl.C1060ServicesImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class C1060Servlet
 */
/**
 * FileName:     C1060Servlet
 *
 * FileType:      java
 *
 * Date:          2021年08月2日
 *
 * Author:        温晨宏
 * 
 * Email:         814461932@qq.com
 *
 * Description:   修改资讯的页面初始化
 *
 */
@WebServlet("/c1060.htm")
public class C1060Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//读取1040页面的所有控件
		Map<String,String> dto=this.parseRequest(request);
		
		String uid=null;
		Map<String,String> userinfo=(Map)request.getSession().getAttribute("userinfo");
		if(userinfo!=null)
		{
			 uid=userinfo.get("uid");
			 dto.put("uid", uid);
				C1060ServicesImpl services=new C1060ServicesImpl(dto);
				List<Map<String, String>>  rows=services.queryBodymsg();
				//request.setAttribute("ocnation", Tools.getOptions("nation"));
				if(rows.size()>0)
				{
					//把查询结果保存到request中
					request.setAttribute("rows", rows);
					//分页控制器
					String pageController=services.getPageController("/c1060.htm");
					request.setAttribute("pageController", pageController);
					request.setAttribute("msg", "查询成功");
				}
				else 
				{
					request.setAttribute("msg", "没有符合条件的数据");
				}
		}
		else 
		{
			request.setAttribute("msg", "id信息缺失");
		}
		return "/C1/C1060.jsp";
		}

}
