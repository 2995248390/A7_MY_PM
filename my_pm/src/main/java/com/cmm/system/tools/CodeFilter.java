package com.cmm.system.tools;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;

/**
 * Servlet Filter implementation class CodeFilter
 */
@WebFilter("/*")
public class CodeFilter extends HttpServlet implements Filter 
{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		request.setCharacterEncoding("GBK");  //告诉tomcat,按gbk解读报文体
		//将请求对象reuqest,向目标地址传递
		chain.doFilter(request, response);
	}

}
