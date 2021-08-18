package com.cmm.web.impl.A1;

import com.alibaba.fastjson.JSONObject;
import com.cmm.domain.ImgInfo;
import com.cmm.services.impl.A1070ServiceImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class A1072Servlet
 */
@WebServlet("/a1072.htm")
public class A1072ervlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("jj");
		A1070ServiceImpl services = new A1070ServiceImpl(this.parseRequest(request));
		String id = request.getParameter("uid");
		if(id==null) {
			id= request.getParameter("did");
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> list= upload.parseRequest(request);
		for(FileItem item:list) {
			if(!item.isFormField()) {
				//�ļ�����,����ʹ�õ���layui������Ѿ�ȷ����ͼƬ������ֱ�Ӵ洢������
				 InputStream img = item.getInputStream();
				 //�õ��ļ��������
				 String fn = item.getFieldName();
				 //��Ӧ�Ĵ洢
				 if(fn.equals("userimg")) {
					 services.saveUserImg(id,img);
				 }else if(fn.equals("docimg")){
					 services.saveDocImg(id,img);
				 }else if(fn.equals("clinicimg")){
					 services.saveClinicImg(id,img);
				 }
			}
		}
		ImgInfo imgInfo = new ImgInfo("0","�ϴ��ɹ�");
		JSONObject json = new JSONObject();
		json.put("data", imgInfo);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json.toString());
		return "";
	}
	
}
