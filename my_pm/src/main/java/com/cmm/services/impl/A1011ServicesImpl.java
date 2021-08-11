package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;

/**
 * FileName: A1011ServicesImpl
 * 
 * Date: 2021年07月28号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 管理员添加用户	
 *
 */

public class A1011ServicesImpl extends JdbcServicesSupport {

	public A1011ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean addUser()throws Exception{
		StringBuilder sql=new StringBuilder()
				.append("insert into user(account,upass,truename,idcard,systype,")	
				.append("				  sex,age,nation,community,birthday, ")	          
				.append("				  phonenumber,begintime,address,userstate,memo,")	             
				.append("				  mail)")	
				.append("		   values(?,?, ?, ?, ?,")	 
				.append("				  ?, ?, ?, ?, str_to_date(?, '%Y-%m-%d'),")	
				.append("				  ?, current_timestamp, ?, ?, ?,")	 
				.append("				  ?)")	
				;
		Object params[] = {
				//第一行
				this.getString("maccount"),
				Tools.getMd5(this.getString("mpass")),
				this.getString("mtruename"),
				this.getString("midcard"),
				"2",
				//第二行
				this.getString("msex"),
				this.getString("mage"),
				this.getString("mnation"),
				this.getString("mcommunity"),
				this.getString("mbirthday"),
				//第三行
				this.getString("mphonenumber"),
				this.getString("maddress"),
				"1",
				this.getString("mmemo"),
				//第四行
				this.getString("mmail"),	
		};
		
		return this.executeUpdate(sql.toString(), params) > 0;
	}
	

}
