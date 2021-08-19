package com.cmm.web.impl.A1;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.A1070ServiceImpl;
import com.cmm.web.support.BaseServlet;
import com.cmm.system.tools.Tools;
/**
 * FileName:      A2012Action
 *
 * FileType:      Action
 *
 * Date:          2021��07��29��
 *
 * Author:        �޺�
 *
 * Description:   ������Ϣ�޸�.���ݳ�ʼ����ʾ
 *
 */
@WebServlet("/a1070.htm")
public class A1070Servlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//������Ϊ�˻�ñ༭��Ҫ����������,��ѡ����
		request.setAttribute("ocnation", Tools.getOptions("nation"));
		request.setAttribute("occommunity", Tools.getOptions("community"));
		//���༭ҳ��
		return "A1/A1070.jsp?type=1";
	}

}
