package com.cmm.services.impl;
/**
 * FileName:      C1090ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021年08月19日
 *
 * Author:        张文江
 *
 * Description:   获取用户与医生地址
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		String did=this.getString("did");
		if(did==null)
		{
			System.out.println("no did");
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
		else
		{
			System.out.println("have did:"+did);
			String sql="select a.address uaddress,b.clinicaddress daddress from user a,doc b where a.uid=? and b.did=?";
			List<Object> params=new ArrayList<>();
			params.add(uid);
			params.add(did);
			return this.queryForMap(sql.toString(),params.toArray());
		}
	}
	
	public Map<String,String> getCenter(Map<String,String> address,String path)throws Exception
	{
		//拼接参数
		String funcName="getLongitudeandLatitude";
		//定义结果集
		Map<String,String> location=new HashMap<String,String>();			
		String line = null;		
        try 
        {        		
	        //获取用户城市与坐标
        	float userX=0,userY=0;
        	String[] args1 = new String[] { "C:/ProgramData/Anaconda3/python.exe",path,funcName, address.get("uaddress") };
        	Process proc1 = Runtime.getRuntime().exec(args1);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader uin = new BufferedReader(new InputStreamReader(proc1.getInputStream()));   
            //获取python文件执行结果
            while ((line = uin.readLine()) != null) {
            	String[] result1=line.split("'"); //   ('重庆市', '106.606652,29.541387')
                location.put("ucity", result1[1]);
                location.put("uaddress",result1[3]);
                String[] xy=result1[3].split(",");
                userX=Float.parseFloat(xy[0]);
                userY=Float.parseFloat(xy[1]);
            	System.out.println("line:"+line);
            }
	        //获取医生城市与坐标
            float docX=0,docY=0;
            String[] xy2=null;
        	String[] args2 = new String[] { "C:/ProgramData/Anaconda3/python.exe",path,funcName, address.get("daddress") };
        	Process proc2 = Runtime.getRuntime().exec(args2);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader din = new BufferedReader(new InputStreamReader(proc2.getInputStream()));   
            //获取python文件执行结果
            while ((line = din.readLine()) != null) {
            	String[] result2=line.split("'"); //   ('重庆市', '106.606652,29.541387')
                location.put("dcity", result2[1]);
                location.put("daddress",result2[3]);
                //拆分两个坐标
                String[] xy=result2[3].split(",");
                docX=Float.parseFloat(xy[0]);
                docY=Float.parseFloat(xy[1]);
            	System.out.println("line:"+line);
            	
            }
            String centerAddress=Float.toString((userX+docX)/2)+","+Float.toString((userY+docY)/2);
            location.put("centerAddress", centerAddress);
            din.close();
            proc2.waitFor();
            uin.close();
            proc1.waitFor();
        } 
        catch (IOException e) 
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
