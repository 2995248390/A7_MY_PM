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
			request.setAttribute("msg", "�������!");
			ex.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	/**
	 * ��������̵��ȷ���
	 */
	protected abstract String execute(HttpServletRequest request, HttpServletResponse response)throws Exception;
	
	protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
	
	protected final Map<String,String> parseRequest(HttpServletRequest request)
	{
		/**
		 * ��ҳ�����пؼ�һ�λ�ȡ,�γ�Map����,keyΪ�ؼ�����,valueΪ�ַ�������
		 * ��������ݰ����¹������:
		 * ����ؼ��ύһ��ֵ,��ֵһ��λ�������±�0��λ��,��ʱ���鳤��Ϊ1
		 * ����ؼ��ṩһ��ֵ(checkbox),��ҳ��checkbox�ı�д˳��,�������,
		 *   checkbox��ѡ�м���,���ύ����ֵ,û�б�ѡ�е�checkbox���ᱻ�ύ
		 */
		Map<String,String[]> tem=request.getParameterMap();
		//�����ֵ�Եĸ���
		int size=tem.size();
		//���㰲ȫ�ĳ�ʼ����
		int initSize=((int)(size/0.75))+1;
		//����DTO��������
		Map<String,String> dto=new HashMap<>(initSize);
		//����ҳ������,����DTO����
		tem.forEach((k,v)->{ 
			dto.put(k, v.length==1?v[0]:joinArray(v)); 
		});

		//���䵱ǰ���̵�����
		dto.put("classpath", request.getContextPath());
		//��ȡ�û���¼������
		Map<String,String> userinfo=(Map)request.getSession().getAttribute("userinfo");
		if(userinfo!=null)  //�Ѿ���¼��ϵͳ
		{
			dto.put("userid", userinfo.get("uid"));
		}
		else
		{
			dto.put("userid","δ��¼");
		}
		System.out.println(dto);
		return dto;
	}
	/**
	 * ������ƴ��Ϊ�ַ���
	 * @param array
	 * @return
	 */
	private String joinArray(String...array)
	{
		//1.ʵ����StringBuilder ����
		StringBuilder content=new StringBuilder(array[0]);
		int len=array.length;
		for(int i=1;i<len;i++)
		{
			content.append(",").append(array[i]);
		}
		return content.toString();
	}

}
