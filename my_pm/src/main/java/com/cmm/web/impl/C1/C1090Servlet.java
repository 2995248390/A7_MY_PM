package com.cmm.web.impl.C1;
/**
 * FileName:      C1090Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月19日
 *
 * Author:        张文江
 *
 * Description:   获取用户与医生地址
 */
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.web.support.BaseServlet;
import com.cmm.services.impl.C1090ServicesImpl;
@WebServlet("/c1090.htm")
public class C1090Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String KEY="701ea0663a8a11bddf52141b03f45691";
		String path = this.getServletContext().getRealPath("python/getAddress.py");
		System.out.println("path="+path);
		C1090ServicesImpl services=new C1090ServicesImpl(this.parseRequest(request));
		//1.获取挂号单,得到用户居住地址，与诊所地址
		Map<String,String> userinfo=new HashMap<>();
		userinfo=(Map)request.getSession().getAttribute("userinfo");
		System.out.println("userinfo:"+userinfo);
		String uid=userinfo.get("uid");
		System.out.println("uid:"+uid);
		Map<String,String> addressMap=services.getAddress(uid);
		System.out.println("addressMap1:"+addressMap);
		
		//3.将查询结果保存到request中
		if(addressMap!=null)
		{
			request.setAttribute("addressMap", addressMap);
			request.setAttribute("KEY", KEY);
		}
		else
		{
			//没有查询到数据 location.centerAddress
			Map<String,String> location=new HashMap<>();
			Map<String,String> address=services.getLocation(userinfo.get("address"), path);
			location.put("centerAddress", address.get("address"));
			request.setAttribute("location", location);
			request.setAttribute("KEY", KEY);
			return "C1/C1091.jsp";
		}
		int choice=0;
		if(request.getParameter("path")!=null)
			choice=Integer.parseInt(request.getParameter("path"));
		//步行路线
		if(choice==1)
		{
			Map<String,String> location=services.getCenter(addressMap, path);
			request.setAttribute("location", location);
			System.out.println("addressMap:"+addressMap);
			System.out.println("location:"+location);
			return "C1/C1091.jsp";
		}
		//公交路线
		else if(choice==2)
		{
			Map<String,String> location=services.getCenter(addressMap, path);
			request.setAttribute("location", location);
			return "C1/C1090.jsp";
		}
		//用户预览
		else
		{
			Map<String,String> location=services.getCenter(addressMap, path);
			request.setAttribute("location", location);
			return "C1/C1091.jsp";
		}
	}
}
