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
		//ת��python���øò����ж�Ҫִ�еķ���
		String funcName="getLongitudeandLatitude";
		//ִ�з�������Ҫ�õ��Ĳ���������ж������д���
		String param="���������������ʵ��ѧ27������";

        try {        		
	        	String[] args1 = new String[] { "C:/ProgramData/Anaconda3/python.exe",path,funcName, param };
	        	Process proc = Runtime.getRuntime().exec(args1);// ִ��py�ļ�
	            //���������������ȡ���
	            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
	            String line = null;
	            //��ȡpython�ļ�ִ�н��
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
