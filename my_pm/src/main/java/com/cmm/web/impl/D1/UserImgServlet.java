package com.cmm.web.impl.D1;

import com.cmm.services.impl.D1010ServiceImpl;
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
 * FileName:      UserImgServlet
 *
 * FileType:      Servlet
 *
 * Date:          2021年08月16日
 *
 * Author:        罗航
 *
 * Description:  	用户照片
 *
 */
@WebServlet("/userimg.htm")
public class UserImgServlet extends BaseServlet {

	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		D1010ServiceImpl services = new D1010ServiceImpl(this.parseRequest(request));
		Map<String,String> userinfo = (Map<String, String>) request.getSession().getAttribute("userinfo");
		String uid  = userinfo.get("uid");
		InputStream userimg = services.getUserimg(uid);
		if(userimg!=null) {
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[1024];
			int len = userimg.read(b);
			while(len!=-1) {
				os.write(b,0,len);
				os.flush();
				len=userimg.read(b);	
			}
		}
		return "";
	}
	

}
