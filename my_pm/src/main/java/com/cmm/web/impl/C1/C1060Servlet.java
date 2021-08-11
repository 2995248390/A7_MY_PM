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
 * Date:          2021��08��2��
 *
 * Author:        �³���
 * 
 * Email:         814461932@qq.com
 *
 * Description:   �޸���Ѷ��ҳ���ʼ��
 *
 */
@WebServlet("/c1060.htm")
public class C1060Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡ1040ҳ������пؼ�
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
					//�Ѳ�ѯ������浽request��
					request.setAttribute("rows", rows);
					//��ҳ������
					String pageController=services.getPageController("/c1060.htm");
					request.setAttribute("pageController", pageController);
					request.setAttribute("msg", "��ѯ�ɹ�");
				}
				else 
				{
					request.setAttribute("msg", "û�з�������������");
				}
		}
		else 
		{
			request.setAttribute("msg", "id��Ϣȱʧ");
		}
		return "/C1/C1060.jsp";
		}

}
