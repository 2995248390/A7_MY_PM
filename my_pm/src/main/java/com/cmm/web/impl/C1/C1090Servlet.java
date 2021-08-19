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
		String KEY="701ea0663a8a11bddf52141b03f45691";
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
		if(addressMap.size()!=0)
		{
			request.setAttribute("addressMap", addressMap);
			request.setAttribute("KEY", KEY);
		}
		int choice=0;
		if(request.getParameter("path")!=null)
			choice=Integer.parseInt(request.getParameter("path"));
		//����·��
		if(choice==1)
		{
			Map<String,String> location=services.getCenter(addressMap, path);
			request.setAttribute("location", location);
			System.out.println("addressMap:"+addressMap);
			System.out.println("location:"+location);
			return "C1/C1091.jsp";
		}
		//����·��
		else if(choice==2)
		{
			Map<String,String> location=services.getCenter(addressMap, path);
			request.setAttribute("location", location);
			return "C1/C1090.jsp";
		}
		//�û�Ԥ��
		else
		{
			Map<String,String> location=services.getCenter(addressMap, path);
			request.setAttribute("location", location);
			return "C1/C1091.jsp";
		}
	}
}
