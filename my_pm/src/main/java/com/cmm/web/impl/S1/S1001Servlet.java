package com.cmm.web.impl.S1;

import com.alibaba.fastjson.JSONObject;
import com.cmm.domain.ImgInfo;
import com.cmm.services.impl.S1000ServiceImpl;
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
 * FileName:      S1001Servlet
 *
 * FileType:      Servlet
 *
 * Date:          2021��8��18��
 *
 * Author:        �޺�
 *
 * Description:   ����ͼƬ����(user,doc,clinic)
 *
 */
@WebServlet("/s1001.htm")
public class S1001Servlet extends BaseServlet {
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		S1000ServiceImpl services = new S1000ServiceImpl(this.parseRequest(request));
		String id = request.getParameter("uid");
		if(id==null) {
			id= request.getParameter("did");
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> list= upload.parseRequest(request);
		boolean f = false;
		for(FileItem item:list) {
			if(!item.isFormField()) {
				//�ļ�����,����ʹ�õ���layui������Ѿ�ȷ����ͼƬ������ֱ�Ӵ洢������
				 InputStream img = item.getInputStream();
				 //�õ��ļ��������
				 String fn = item.getFieldName();
				 //��Ӧ�Ĵ洢
				 if(fn.equals("userimg")) {
					 f = services.saveUserImg(id,img);
				 }else if(fn.equals("docimg")){
					 f = services.saveDocImg(id,img);
				 }else if(fn.equals("clinicimg")){
					 f = services.saveClinicImg(id,img);
				 }
			}
		}
		if(f) {
		ImgInfo imgInfo = new ImgInfo("0","�ϴ��ɹ�");
		JSONObject json = new JSONObject();
		json.put("data", imgInfo);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json.toString());
		}
		return "";
	}
}