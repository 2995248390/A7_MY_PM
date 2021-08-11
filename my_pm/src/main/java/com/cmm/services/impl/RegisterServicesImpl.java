/**
 * FileName:      RegisterServicesImpl
 *
 * FileType:      Services
 *
 * Date:          2021年08月3日
 *
 * Author:        张文江
 * 
 * Email:         845278422@qq.com
 *
 * Description:   用户注册账号
 *
 */
package com.cmm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;
public class RegisterServicesImpl extends JdbcServicesSupport
{
	
	public RegisterServicesImpl(Map<String, String> dto)
	{
		super(dto);
		// TODO Auto-generated constructor stub
	}
	
	 public int register()throws Exception
	 {
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
					this.getString("account"),
					Tools.getMd5(this.getString("upass")),
					this.getString("truename"),
					this.getString("idcard"),
					"2",
					//第二行
					this.getString("sex"),
					this.getString("age"),
					this.getString("nation"),
					this.getString("community"),
					this.getString("birthday"),
					//第三行
					this.getString("phonenumber"),
					this.getString("address"),
					"1",
					this.getString("memo"),
					//第四行
					this.getString("mail"),	
			};
			return this.executeUpdate(sql.toString(), params);
		}
}
