package com.cmm.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

public class C1090ServicesImpl extends JdbcServicesSupport
{
	
	public C1090ServicesImpl(Map<String, String> dto)
	{
		super(dto);
	}
	

	/**
	 * 获取用户地址
	 * @return 返回居住地址
	 * @throws Exception
	 */
	public Map<String,String> getAddress(String uid)throws Exception
	{
		StringBuilder sql=new StringBuilder()
				.append("select a.address uaddress,b.clinicaddress daddress")
				.append("  from user a,doc b,orderlist c ")
				.append(" where a.uid=? and c.orderliststate=2")
				.append("	 and b.did=c.did and c.begintime<=CURRENT_TIMESTAMP")
				.append("	 and c.appointment>=CURRENT_TIMESTAMP limit 1")					 
					 ;	
		//System.out.println(this.getDto());		
		return this.queryForMap(sql.toString(),uid);
	}
	
	public Map<String,String> getCenter(Map<String,String> address,String path)throws Exception
	{
		//拼接参数
		String funcName="getLongitudeandLatitude";
		String udAddress=address.get("uaddress")+"|"+address.get("daddress");

		String line = null;
		Map<String,String> location=new HashMap<String,String>();
        try {        		
	        	String[] args1 = new String[] { "C:/ProgramData/Anaconda3/python.exe",path,funcName, udAddress };
	        	Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
	            //用输入输出流来截取结果
	            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
	            
	            //获取python文件执行结果
	            while ((line = in.readLine()) != null) {
	                location.put("address", line);
	            	System.out.println("line:"+line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
		return location;
	}
	
	public Map<String,String> getLocation(String path)throws Exception
	{	
		
		//转入python后用该参数判断要执行的方法
		String funcName="getLongitudeandLatitude";
		//执行方法中需要用到的参数，如果有多个，就写多个
		//String param=getUserAddress();
		String param="重庆市南岸区崇文路22号附7号";
		String line = null;
		Map<String,String> location=new HashMap<String,String>();
        try {        		
	        	String[] args1 = new String[] { "C:/ProgramData/Anaconda3/python.exe",path,funcName, param };
	        	Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
	            //用输入输出流来截取结果
	            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
	            
	            //获取python文件执行结果
	            while ((line = in.readLine()) != null) {
	                location.put("address", line);
	            	System.out.println("line:"+line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
		return location;
	}
	
}
