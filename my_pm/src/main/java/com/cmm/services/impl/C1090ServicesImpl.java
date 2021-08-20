package com.cmm.services.impl;
/**
 * FileName:      C1090ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021��08��19��
 *
 * Author:        ���Ľ�
 *
 * Description:   ��ȡ�û���ҽ����ַ
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
	 * ��ȡ�û���ַ
	 * @return ���ؾ�ס��ַ
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
		//ƴ�Ӳ���
		String funcName="getLongitudeandLatitude";
		//��������
		Map<String,String> location=new HashMap<String,String>();			
		String line = null;		
        try 
        {        		
	        //��ȡ�û�����������
        	float userX=0,userY=0;
        	String[] args1 = new String[] { "C:/ProgramData/Anaconda3/python.exe",path,funcName, address.get("uaddress") };
        	Process proc1 = Runtime.getRuntime().exec(args1);// ִ��py�ļ�
            //���������������ȡ���
            BufferedReader uin = new BufferedReader(new InputStreamReader(proc1.getInputStream()));   
            //��ȡpython�ļ�ִ�н��
            while ((line = uin.readLine()) != null) {
            	String[] result1=line.split("'"); //   ('������', '106.606652,29.541387')
                location.put("ucity", result1[1]);
                location.put("uaddress",result1[3]);
                String[] xy=result1[3].split(",");
                userX=Float.parseFloat(xy[0]);
                userY=Float.parseFloat(xy[1]);
            	System.out.println("line:"+line);
            }
	        //��ȡҽ������������
            float docX=0,docY=0;
            String[] xy2=null;
        	String[] args2 = new String[] { "C:/ProgramData/Anaconda3/python.exe",path,funcName, address.get("daddress") };
        	Process proc2 = Runtime.getRuntime().exec(args2);// ִ��py�ļ�
            //���������������ȡ���
            BufferedReader din = new BufferedReader(new InputStreamReader(proc2.getInputStream()));   
            //��ȡpython�ļ�ִ�н��
            while ((line = din.readLine()) != null) {
            	String[] result2=line.split("'"); //   ('������', '106.606652,29.541387')
                location.put("dcity", result2[1]);
                location.put("daddress",result2[3]);
                //�����������
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
		
		//ת��python���øò����ж�Ҫִ�еķ���
		String funcName="getLongitudeandLatitude";
		//ִ�з�������Ҫ�õ��Ĳ���������ж������д���
		//String param=getUserAddress();
		String param="�������ϰ�������·22�Ÿ�7��";
		String line = null;
		Map<String,String> location=new HashMap<String,String>();
        try {        		
	        	String[] args1 = new String[] { "C:/ProgramData/Anaconda3/python.exe",path,funcName, param };
	        	Process proc = Runtime.getRuntime().exec(args1);// ִ��py�ļ�
	            //���������������ȡ���
	            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
	            
	            //��ȡpython�ļ�ִ�н��
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
