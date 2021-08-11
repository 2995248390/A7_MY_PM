/**
 * FileName:      A1080ServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021年07月27日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   安全中心（修改邮箱或者密码）
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
	 * 返回当前邮箱与手机号
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
	 * 验证验证码，然后修改邮箱
	 * @return 1--修改成功，2--修改失败，3--验证码错误
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
			//定义SQL语句，修改邮箱
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
