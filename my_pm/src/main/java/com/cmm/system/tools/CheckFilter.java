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
		            ||path.endsWith(".css")
		            ||path.endsWith(".js")
		            ||path.endsWith(".gif")
		            || path.endsWith(".png")
		            ||path.endsWith("login.jsp")
		            ||path.endsWith("login.htm")
		            ||path.endsWith("register.htm")
		            ||path.endsWith("next.jsp")
		            ||path.endsWith("errorpage.jsp")
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
