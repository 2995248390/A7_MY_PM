package com.cmm.web.support;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class BaseServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path="";
		try
		{
			path=this.execute(request, response);
			if(path==null) {
				path = "";
			}
			
		}
		catch(Exception ex)
		{
			request.setAttribute("msg", "网络故障!");
			ex.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	/**
	 * 子类的流程调度方法
	 */
	protected abstract String execute(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
	
	protected final Map<String,String> parseRequest(HttpServletRequest request)
	{
		/**
		 * 将页面所有控件一次获取,形成Map对象,key为控件名称,value为字符串数组
		 * 数组的内容按如下规律填充:
		 * 如果控件提交一个值,该值一定位于数组下标0的位置,此时数组长度为1
		 * 如果控件提供一批值(checkbox),按页面checkbox的编写顺序,填充数组,
		 *   checkbox被选中几项,就提交几个值,没有被选中的checkbox不会被提交
		 */
		Map<String,String[]> tem=request.getParameterMap();
		//计算键值对的个数
		int size=tem.size();
		//计算安全的初始容量
		int initSize=((int)(size/0.75))+1;
		//创建DTO容器对象
		Map<String,String> dto=new HashMap<>(initSize);
		//解析页面数据,生成DTO对象
		tem.forEach((k,v)->{ 
			dto.put(k, v.length==1?v[0]:joinArray(v)); 
		});

		//补充当前工程的名称
		dto.put("classpath", request.getContextPath());
		//获取用户登录的数据
		Map<String,String> userinfo=(Map)request.getSession().getAttribute("userinfo");
		if(userinfo!=null)  //已经登录了系统
		{
			dto.put("userid", userinfo.get("uid"));
		}
		else
		{
			dto.put("userid","未登录");
		}
		System.out.println(dto);
		return dto;
	}
	/**
	 * 将数组拼接为字符串
	 * @param array
	 * @return
	 */
	private String joinArray(String...array)
	{
		//1.实例化StringBuilder 对象
		StringBuilder content=new StringBuilder(array[0]);
		int len=array.length;
		for(int i=1;i<len;i++)
		{
			content.append(",").append(array[i]);
		}
		return content.toString();
	}

}
