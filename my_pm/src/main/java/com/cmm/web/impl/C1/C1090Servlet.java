package com.cmm.web.impl.C1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		String path = this.getServletContext().getRealPath("python/getAddress.py");
		System.out.println("path="+path);
		C1090ServicesImpl services=new C1090ServicesImpl(this.parseRequest(request));
		//1.��ȡ�Һŵ�,�õ��û���ס��ַ����������ַ
		Map<String,String> userinfo=new HashMap<>();
		userinfo=(Map)request.getSession().getAttribute("userinfo");
		String uid=userinfo.get("uid");
		Map<String,String> addressMap=services.getAddress(uid);
		//2.��ȡ��ַ�м����꣬��Ϊ��ͼ����
		
		//3.����ѯ������浽request��
		if(addressMap.size()==0)
		{
			
			request.setAttribute("addressMap", addressMap);
		}
		int choice=Integer.parseInt(request.getParameter("path"));
		if(choice==1)
		{
			
		}
		else
		{
			
		}
		System.out.println(services.getLocation(path));
		return null;
	}
}
