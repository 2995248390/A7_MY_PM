package com.cmm.web.impl.S1;

import com.cmm.services.impl.D1010ServiceImpl;
import com.cmm.services.impl.S1000ServiceImpl;
import com.cmm.web.support.BaseServlet;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * FileName:      DocImgServlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月18日
 *
 * Author:        罗航
 *
 * Description:  	医生照片读取
 *
 */
@WebServlet("/docimg.htm")
public class DocImgServlet extends BaseServlet {
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		S1000ServiceImpl services = new S1000ServiceImpl(this.parseRequest(request));
		String did = request.getParameter("did");
		InputStream docimg = services.getDocImg(did);
		if(docimg!=null) {
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[1024];
			int len = docimg.read(b);
			while(len!=-1) {
				os.write(b,0,len);
				os.flush();
				len=docimg.read(b);	
			}
		}
		return "";
	}
}