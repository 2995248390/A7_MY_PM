package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;
import com.cmm.system.tools.Tools;

/**
 * FileName: A1012ServiceImpl
 * 
 * Date: 2021年07月29号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 管理员修改用户数据	
 *
 */

public class A1012ServicesImpl extends JdbcServicesSupport {

	public A1012ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean modifyUser()throws Exception{
		StringBuilder sql = new StringBuilder()
				.append("UPDATE user")
				.append("		set account = ?, upass = ?, truename = ?, idcard = ?,")
				.append("			sex = ?, age = ?, nation = ?, community = ?, birthday = ?,")
				.append("			phonenumber = ?, address = ?, memo = ?,")
				.append("			mail = ?")
				.append("     where uid = ?")
				;
			Object params[] = {
				//第一行
				this.getString("maccount"),
				Tools.getMd5(this.getString("mpass")),
				this.getString("mtruename"),
				this.getString("midcard"),
				//第二行
				this.getString("msex"),
				this.getString("mage"),
				this.getString("mnation"),
				this.getString("mcommunity"),
				this.getString("mbirthday"),
				//第三行
				this.getString("mphonenumber"),
				this.getString("maddress"),
				this.getString("mmemo"),
				//第四行
				this.getString("mmail"),
				//第五行
				this.getString("uid"),
		};
			return this.executeUpdate(sql.toString(), params) > 0;
		
	}

}
