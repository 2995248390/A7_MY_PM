package com.cmm.web.impl.D1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.services.impl.S1000ServiceImpl;
import com.cmm.web.support.BaseServlet;

/**
 * FileName:      ClinicImgServlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月16日
 *
 * Author:        罗航
 *
 * Description:  	诊所照片
 *
 */
@WebServlet("/clinicimg.htm")
public class ClinicImgServlet extends BaseServlet {
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		S1000ServiceImpl services = new S1000ServiceImpl(this.parseRequest(request));
		String did = request.getParameter("did");
		InputStream clinicimg = services.getClinicImg(did);
		if(clinicimg!=null) {
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[1024];
			int len = clinicimg.read(b);
			while(len!=-1) {
				os.write(b,0,len);
				os.flush();
				len=clinicimg.read(b);	
			}
		}
		return "";
	}
}
