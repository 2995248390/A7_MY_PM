/**
 * FileName:      A1080ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021��07��27��
 *
 * Author:        ���Ľ�
 * 
 * Email:         845278422@qq.com
 *
 * Description:   ��ȫ���ģ��޸�����������룩
 *
 */
package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;

public class A1080ServicesImpl extends JdbcServicesSupport
{
	
	public A1080ServicesImpl(Map<String, String> dto)
	{
		super(dto);
	}
	
	
	public int updatePassword()throws Exception
	{
		
		String uid=this.getString("uid");
		String oldupass=Tools.getMd5(this.getString("oldupass"));
		System.out.println("oldupass:"+oldupass);
		String newupass=Tools.getMd5(this.getString("newupass"));
		System.out.println("newupass:"+newupass);
		
		String sql="update user set upass=? where upass=? and uid=?";
		List<Object> params=new ArrayList<>();
		params.add(newupass);
		params.add(oldupass);
		params.add(uid);
		return this.executeUpdate(sql, params.toArray());
	}
	
	
	/**
	 * ���ص�ǰ�������ֻ���
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> querySafe()throws Exception
	{
		Map<String,String> safe=new HashMap<>();
		safe.put("uid", this.getString("uid"));
		safe.put("phonenumber",this.getString("phonenumber"));
		safe.put("mail",this.getString("mail"));		
		System.out.println(safe);
		return safe;
	}
	
	/**
	 * ��֤��֤�룬Ȼ���޸�����
	 * @return 1--�޸ĳɹ���2--�޸�ʧ�ܣ�3--��֤�����
	 * @throws Exception
	 */
	public int updateEmail(String syscode)throws Exception
	{
		String newmail=this.getString("newmail");
		System.out.println("newmail:"+newmail);
		String mailcode=this.getString("mailcode");
	
		System.out.println("mailcode:"+mailcode+" syscode:"+syscode);	
		Integer uid=this.getInteger("uid");
		System.out.println(uid);
		if(mailcode.equals(syscode))
		{
			//����SQL��䣬�޸�����
			String sql="update user set user.mail=? where uid=?";
			List<Object> params=new ArrayList<>();	
			params.add(newmail);
			params.add(uid);
			return this.executeUpdate(sql, params.toArray())==1?1:2;
		}
		else
			return 3;		
	}	
}
