package com.cmm.services.impl;

import java.util.Map;

import com.cmm.services.support.JdbcServicesSupport;

/**
 * FileName: B1021ServicesImpl
 * 
 * Date: 2021年07月31号
 * 
 * @author 王科瀚
 * 
 * Email: 1132257589@qq.com
 * 
 * Description: 修改诊所信息
 *
 */

public class B1021ServicesImpl extends JdbcServicesSupport {

	public B1021ServicesImpl(Map<String, String> dto) {
		super(dto);
	}
	
	public boolean modifyCli(String uid) throws Exception{
		StringBuilder sql1 = new StringBuilder()
				.append("")
				.append("update user ")
				.append("	set truename= ?, sex= ?, age= ?")
				.append(" where uid = ?;")
				;
		Object params1[] = {
				this.getString("mtruename"),
				this.getString("msex"),
				this.getString("mage"),
				Integer.parseInt(uid),	
		};
		for(Object param:params1) {
			System.out.print(param+" ");
		}
		
		this.regSqlToTransaction(sql1.toString(), params1);
		
		StringBuilder sql2 = new StringBuilder()
				.append("update doc")
				.append("   set level = ?, clinicname= ?, clinicaddress= ?, workyear= ?, docstate= ?,")
				.append("	    clinicdes = ?, open1 = ?, close1 = ?, open2 = ?, close2 = ?,")
				.append("	    getnum1 = ?, getnum2 = ?, getday = ? ")
				.append(" where uid = ?;")
				;
		Object params2[] = {
			this.getString("mlevel"),
			this.getString("mclinicname"),
			this.getString("mclinicaddress"),
			this.getString("mworkyear"),
			this.getString("mdocstate"),
			this.getString("mclinicdes"),
			this.getString("mopen1"),
			this.getString("mclose1"),
			this.getString("mopen2"),
			this.getString("mclose2"),
			this.getString("mgetnum1"),
			this.getString("mgetnum2"),
			this.getString("mgetday"),
			Integer.parseInt(uid),
		};
		
		for(Object param:params2) {
			System.out.print(param+" ");
		}
		this.regSqlToTransaction(sql2.toString(), params2);
		return this.executeTrasaction();
	}

}
