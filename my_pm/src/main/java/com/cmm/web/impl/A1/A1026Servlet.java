package com.cmm.web.impl.A1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1020ServicesImpl;
import com.cmm.web.support.BaseServlet;

/**
 * FileName:      A1021Servlet
 *
 * FileType:      Servlet
 *
 * Date:          
 *
 * Author:        钱昱同
 *
 * Description:  删除医生
 *
 */
@WebServlet("/a1026.htm")
public class A1026Servlet extends BaseServlet {
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		A1020ServicesImpl services=new A1020ServicesImpl(this.parseRequest(request));
		int result=services.batchDelete();
		String msg=null;
		if(result!=3)
		{
			msg=result==1?"删除成功":"没有删除权限";
		}
		else
		{
			msg="请选择删除对象";
		}
		request.setAttribute("msg", msg);
	
		//删除后，再进行一次查询，显示原数据
		List<Map<String,String>> rows=services.querydoc();
		if(rows.size()>0)
		{
			//将查询结果保存到request中
			request.setAttribute("rows",rows);
			//获取分页控制器
			String pageController=services.getPageController("/A1026.htm");
			request.setAttribute("pageController", pageController);			
		}
		
		
		return "/a1021.htm";
	}

}
