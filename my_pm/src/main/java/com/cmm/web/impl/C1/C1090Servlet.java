package com.cmm.web.impl.C1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmm.web.support.BaseServlet;

@WebServlet("/c1090.htm")
public class C1090Servlet extends BaseServlet
{
	
	@Override
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String path = this.getServletContext().getRealPath("python/getAddress.py");
		System.out.println(path);
		//转入python后用该参数判断要执行的方法
		String funcName="getLongitudeandLatitude";
		//执行方法中需要用到的参数，如果有多个，就写多个
		String param="重庆市南区重庆邮电大学27栋宿舍";

        try {        		
	        	String[] args1 = new String[] { "C:/ProgramData/Anaconda3/python.exe",path,funcName, param };
	        	Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
	            //用输入输出流来截取结果
	            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
	            String line = null;
	            //获取python文件执行结果
	            while ((line = in.readLine()) != null) {
	                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
		return null;
	}
}
