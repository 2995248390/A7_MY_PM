package com.cmm.system.tools;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class CheckFilter extends HttpFilter{
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		 String path = req.getServletPath();
		 if(path.endsWith(".html")
		            ||path.endsWith(".jpg")
		            ||path.endsWith(".png")
		            ||path.endsWith(".gif")
		            ||path.endsWith(".css")
		            ||path.endsWith(".js")
		            ||path.endsWith(".gif")
		            ||path.endsWith(".eot")
		            ||path.endsWith(".ttf")
		            ||path.endsWith(".woff")
		            ||path.endsWith("login.jsp")
		            ||path.endsWith("login.htm")
		            ||path.endsWith("register.htm")
		            ||path.endsWith("next.jsp")
		            ||path.endsWith("main.jsp")
		            ||path.endsWith("register.jsp")
		            ||path.endsWith("main.htm")
		            ||path.endsWith("information.jsp")
		            ||path.endsWith("errorpage.jsp")
		            ||path.endsWith("c1020.htm")
		            ||path.endsWith("c1021.htm")
		            ||path.endsWith("c1022.htm")
		            ||path.endsWith("c1023.htm")
		            ||path.endsWith("c1024.htm")
		            ||path.endsWith("c1060.htm")
		            ||path.endsWith("c1070.htm")
		            ||path.endsWith("c1071.htm")
		            ||path.endsWith("c1080.htm")
		            ||path.endsWith("C1020.jsp")
		            ||path.endsWith("C1022.jsp")
		            ||path.endsWith("C1024.jsp")
		            ||path.endsWith("C1040.jsp")
		            ||path.endsWith("C1060.jsp")
		            ||path.endsWith("C1070.jsp")
		            ||path.endsWith("C1071.jsp")
		            ||path.endsWith("C1072.jsp")
		            ||path.endsWith("C1073.jsp")
		            ||path.endsWith("C1080.jsp")
		            ||path.endsWith("C1090.jsp")
		            ||path.endsWith("C1091.jsp")
		            ||path.endsWith("C1092.jsp")
		        ){
		            //不需要认证，直接放行
		            chain.doFilter(req,res);
		            return;
		        }
		 	Map<String,String> userinfo = (Map<String, String>) req.getSession().getAttribute("userinfo");
		 	if(userinfo==null) {
		 		req.setAttribute("msg","登录已失效");
		 		req.getRequestDispatcher("errorpage.jsp").forward(req, res);
		 	}else {
	            chain.doFilter(req,res);
	        }
	}

}
